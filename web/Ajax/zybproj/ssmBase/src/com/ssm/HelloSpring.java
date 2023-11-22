package com.ssm;

public class HelloSpring {
    private String name;
    public void  setName(String name){
        this.name = name;
    }
    public void show(){
        System.out.println("Hi!"+name+":欢迎您来学习Spring 框架,这是你使用Spring的第一个程序！");
    }
}
