package com.example.dsz.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/11/13 16:54
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("/command")
public class CommandTestController {

    @GetMapping("/run")
    public Object runCommand() throws IOException {
        String[] cmdCpu = {"bash","test.sh"};
        ProcessBuilder builderCpu = new ProcessBuilder(cmdCpu);
        builderCpu.redirectErrorStream(true);
        Process processCpu = builderCpu.start();
        InputStream isCpu = processCpu.getInputStream();
        BufferedReader readerCpu = new BufferedReader(new InputStreamReader(isCpu));
        String date = readerCpu.readLine();
        log.info("command执行返回结果：{}",date);
        return date;
    }




}
