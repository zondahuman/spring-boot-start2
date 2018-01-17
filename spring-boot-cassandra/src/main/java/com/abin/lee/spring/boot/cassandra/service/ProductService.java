package com.abin.lee.spring.boot.cassandra.service;


import com.abin.lee.spring.boot.cassandra.commands.ProductForm;
import com.abin.lee.spring.boot.cassandra.domain.Product;

import java.util.List;
import java.util.UUID;

/**
 * Created by jt on 1/10/17.
 */
public interface ProductService {

    List<Product> listAll();

    Product getById(UUID id);

    Product saveOrUpdate(Product product);

    void delete(UUID id);

    Product saveOrUpdateProductForm(ProductForm productForm);

    void update(UUID id);
}
