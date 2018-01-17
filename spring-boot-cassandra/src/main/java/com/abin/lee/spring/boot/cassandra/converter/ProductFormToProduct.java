package com.abin.lee.spring.boot.cassandra.converter;

import com.abin.lee.spring.boot.cassandra.commands.ProductForm;
import com.abin.lee.spring.boot.cassandra.domain.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by jt on 1/10/17.
 */
@Component
public class ProductFormToProduct implements Converter<ProductForm, Product> {

    @Override
    public Product convert(ProductForm productForm) {
        Product product = new Product();
        if (productForm.getId() != null  && !StringUtils.isEmpty(productForm.getId())) {
            product.setId(productForm.getId());
        }
        product.setDescription(productForm.getDescription());
        product.setPrice(productForm.getPrice());
        product.setImageUrl(productForm.getImageUrl());
        product.setCreateTime(productForm.getCreateTime());
        product.setUpdateTime(productForm.getUpdateTime());
        product.setFlag(productForm.isFlag());
        return product;
    }
}
