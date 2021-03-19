package com.example.dsz.model;


import com.example.dsz.mybatis.type_handler.UserStatus;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class DszTest2 {
    private Integer id;
    private String name;
    private Integer age;
    private String addr;
    private String tes;
    private UserStatus status;
    private School2 school;

 /*   public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getTes() {
        return tes;
    }

    public void setTes(String tes) {
        this.tes = tes;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public School2 getSchool() {
        return school;
    }

    public void setSchool(School2 school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "DszTest2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", addr='" + addr + '\'' +
                ", tes='" + tes + '\'' +
                ", status=" + status +
                ", school=" + school +
                '}';
    }*/
}