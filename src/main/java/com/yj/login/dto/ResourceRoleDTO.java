package com.yj.login.dto;

import lombok.Data;

import java.util.List;

/**
 * 资源角色
 *
 * @author: kris
 * @version: 1.0
 * @create: 2022-07-05 15:26
 **/
@Data
public class ResourceRoleDTO {
    /**
     * 资源id
     */
    private Integer id;

    /**
     * 路径
     */
    private String url;

    /**
     * 请求方式
     */
    private String requestMethod;

    /**
     * 角色名
     */
    private List<String> roleList;
}

