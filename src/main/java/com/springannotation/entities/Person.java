package com.springannotation.entities;

import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

/**
 * @author lijichen
 * @date 2020/11/26 - 18:37
 */
public class Person {

    @Value("#{10 - 3}")
    private int id;
    @Value("张三--nickName:${person.nickName}")
    private String pname;
    private Date birth;

    public Person() {
    }

    public Person(int id, String pname, Date birth) {
        this.id = id;
        this.pname = pname;
        this.birth = birth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", pname='" + pname + '\'' +
                ", birth=" + birth +
                '}';
    }
}
