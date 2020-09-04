package com.example.dsz.ssh_cmd_java;


import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/8/11 14:00
 * @Description: https://blog.csdn.net/chuanxincui/article/details/80916205
 */
@Slf4j
public class ConnectLinuxCommand {

    private static String DEFAULTCHARTSET = "UTF-8";
    private static Connection conn;

    public static Boolean loginByFileKey(RemoteConnect remoteConnect, File keyFile, String keyfilePass) {
        boolean flag = false;
        // 输入密钥所在路径
        // File keyfile = new File("C:\\temp\\private");
        try {
            conn = new Connection(remoteConnect.getIp());
            conn.connect();
            // 登录认证
            flag = conn.authenticateWithPublicKey(remoteConnect.getUserName(), keyFile, keyfilePass);
            if (flag) {
                log.info("认证成功！");
            } else {
                log.info("认证失败！");
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     *
     * @Title: processStdout
     * @Description: 解析脚本执行的返回结果
     * @param in 输入流对象
     * @param charset 编码
     * @return String 以纯文本的格式返回
     * @throws
     */
    public static String processStdout(InputStream in, String charset){
        InputStream stdout = new StreamGobbler(in);
        StringBuffer buffer = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(stdout, charset));
            String line = null;
            while ((line = br.readLine()) != null) {
                buffer.append(line + "\n");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

    /**
     * 执行脚本
     */
    public static String doCmd(String cmd, File keyFile, String ip, String userName){
        String result = "";
        RemoteConnect connect = new RemoteConnect();
        connect.setIp(ip);
        connect.setUserName(userName);
        Boolean flag = loginByFileKey(connect,keyFile,null);
        log.info("连接服务器授权结果：" + (flag == true ? "授权成功" + flag : "授权失败" + flag));
        Session session = null;
        try {
            session = conn.openSession();
            session.execCommand(cmd);
            result = processStdout(session.getStdout(), DEFAULTCHARTSET);
            // 如果未得到标准输出为空，说明脚本执行出错了
            if (StringUtils.isEmpty(result)) {
                result = processStdout(session.getStderr(), DEFAULTCHARTSET);
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.error("shell命令[" + cmd + "]" + "执行异常");
        }finally {
            if(conn != null){
                conn.close();
            }
            if(session != null){
                session.close();
            }
        }
        return result;
    }

    public static Session getSession() throws IOException {
        String path = "C:\\Users\\dev\\Documents\\WeChat Files\\duanshouzhi516518\\FileStorage\\File\\2020-07\\aws-beijing.pem";
        File keyfile = new File(path);
        RemoteConnect connect = new RemoteConnect();
        connect.setIp("local.nvxclouds.net");
        connect.setUserName("ubuntu");
        loginByFileKey(connect,keyfile,null);
        return conn.openSession();
    }

    /**
     * https://blog.csdn.net/chuanxincui/article/details/80916205
     * https://vimsky.com/examples/detail/java-method-com.trilead.ssh2.Session.execCommand.html
     */
    public static void main(String[] args) throws IOException {
                String cmdCpu = "top -b -n 1 | grep %Cpu";
                String cmdMem = "free -m | grep Mem";
                String cmdPing = "ping $1 -c 3 | grep time=";
                String testCmd = "cd /home/ubuntu;ls";
                String lscpu = "lscpu";

                String cpuIdCMD = "sudo dmidecode -t processor | grep 'ID'";
                String mainboardNumberCMD  = "sudo dmidecode |grep 'Serial Number'";
                String macCMD   = "sudo cat /sys/class/net/eth0/address";
                /**
                 * 1、处理cpuid
                 */
                System.out.println("==============================处理CPU-ID===============================");
                String cpuIdString = doCMD(cpuIdCMD);
                System.out.println("cpuId数据如下======>>>>>>");
                System.out.println(cpuIdString);
                List<String> cpuIdList = new ArrayList<>();
                if(!StringUtils.isEmpty(cpuIdString)){
                    if(cpuIdString.contains("\n")){
                       String[] cpuIdStrings = cpuIdString.split("\n");
                       for (String cpuIdStr : cpuIdStrings){
                           if(cpuIdStr.contains("\tID: ")){
                               String realCpuId = cpuIdStr.replace("\tID: ","");
                               cpuIdList.add(realCpuId);
                               System.out.println(realCpuId);
                           }
                       }
                    }else {
                        //不含有“\n”符号 但是含有“ID: ”
                        if(cpuIdString.contains("\tID: ") ){
                            String realCpuId = cpuIdString.replace("\tID: ","");
                            cpuIdList.add(realCpuId);
                            System.out.println(realCpuId);
                        }
                    }
                }
                System.out.println(JSON.toJSONString(cpuIdList));
                /**
                 * 2、处理主板信息
                 */
                System.out.println("==============================处理主板序号===============================");
                String mainboardNumberString = doCMD(mainboardNumberCMD);
                System.out.println(mainboardNumberString);
                List<String> mainBoardList = new ArrayList<>();
                if(!StringUtils.isEmpty(mainboardNumberString)){
                    //如果主板信息不为空
                    if(mainboardNumberString.contains("\n")){
                        String[] mainBoards =  mainboardNumberString.split("\n");
                        for (String board : mainBoards){
                            mainBoardList.add(board.replace("\tSerial Number: ",""));
                        }
                    }
                }
                mainBoardList = mainBoardList.stream().filter(board -> !board.equals("Not Specified")).collect(Collectors.toList());
                System.out.println(JSON.toJSONString(mainBoardList));
                /**
                 * 3、处理mac地址
                 */
                System.out.println("==============================处理mac地址===============================");
                String macString = doCMD(macCMD);
                if(!StringUtils.isEmpty(macString)){
                    if(macString.contains("\n")){
                        macString = macString.replaceAll("\n","");
                    }
                }
                System.out.println(macString);





        }

        /**
         *  获取CPU_ID
         */
        public static String doCMD(String cmd) throws IOException {
            Session session = getSession();
            String result = "";
            session.execCommand(cmd);
            result = processStdout(session.getStdout(), DEFAULTCHARTSET);
            if (StringUtils.isEmpty(result)){result = processStdout(session.getStderr(), DEFAULTCHARTSET);}
            return result;
        }



}
