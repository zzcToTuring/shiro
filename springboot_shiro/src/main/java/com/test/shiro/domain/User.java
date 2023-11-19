package com.test.shiro.domain;

import com.baomidou.mybatisplus.annotation.TableName;


/**
* 
* @TableName user
*/
@TableName("user")
public class User {

    private Integer id;
    private String name;
    private String pwd;
    private Integer rid;
    private String role;
    private String permission;

    public Integer getId() {
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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public User(Integer id, String name, String pwd, Integer rid, String role, String permission) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.rid = rid;
        this.role = role;
        this.permission = permission;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", rid=" + rid +
                ", role='" + role + '\'' +
                ", permission='" + permission + '\'' +
                '}';
    }
}
