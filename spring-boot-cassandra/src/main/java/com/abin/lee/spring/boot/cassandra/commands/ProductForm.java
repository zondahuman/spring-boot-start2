package com.abin.lee.spring.boot.cassandra.commands;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

/**
 * Created by jt on 1/10/17.
 */
@Setter
@Getter
@ToString
public class ProductForm {
    private UUID id;
    private String description;
    private BigDecimal price;
    private String imageUrl;
    private boolean flag;
    private Date createTime;
    private Date updateTime;


}
