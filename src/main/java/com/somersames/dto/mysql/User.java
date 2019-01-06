package com.somersames.dto.mysql;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author szh
 * @create 2019-01-05 20:05
 **/
@Data
@Table(name = "user")
public class User {
    @Column(name = "user_id")
    private String userId;

    @Column(name = "u_name")
    private String uName;

    @Column(name="u_pasword")
    private String uPassword;
}
