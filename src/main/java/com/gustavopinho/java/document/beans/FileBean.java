package com.gustavopinho.java.document.beans;

import com.gustavopinho.java.document.services.MongoManager;

import javax.inject.Named;
import java.io.Serializable;

@Named("fileBean")
public class FileBean implements Serializable {

    private String hello = "Hello";

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    public void connectMongo() {
        MongoManager mm = new MongoManager("localhost", 27017, "test");
        System.out.println(mm.getDataBase().getName());
    }
}
