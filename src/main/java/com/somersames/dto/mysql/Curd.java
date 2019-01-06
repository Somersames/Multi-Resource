package com.somersames.dto.mysql;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author szh
 * @create 2019-01-05 16:05
 **/
@Data
@Table(name = "curd")
public class Curd {
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
}
