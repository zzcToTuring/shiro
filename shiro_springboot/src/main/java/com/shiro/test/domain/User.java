package com.shiro.test.domain;

import lombok.Data;

import java.io.Serializable;


/**
* 
* @TableName user
*/
@Data
public class User implements Serializable {

    private Integer id;
    private String name;
    private String pwd;
    private Integer rid;

}
