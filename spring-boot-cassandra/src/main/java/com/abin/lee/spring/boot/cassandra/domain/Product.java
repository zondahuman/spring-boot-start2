package com.abin.lee.spring.boot.cassandra.domain;

import com.datastax.driver.core.DataType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;



/**
 * Created by jt on 1/10/17.
 */
@Setter
@Getter
@ToString
@Table("products")
public class Product implements Serializable{

    @PrimaryKey
    @CassandraType(type = DataType.Name.UUID)
    private UUID id;
    private String description;
    private BigDecimal price;
    private String imageUrl;
    private boolean flag;
    private Date createTime;
    private Date updateTime;


}
