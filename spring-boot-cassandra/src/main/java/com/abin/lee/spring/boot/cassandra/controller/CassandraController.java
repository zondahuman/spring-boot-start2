package com.abin.lee.spring.boot.cassandra.controller;

import com.abin.lee.spring.boot.cassandra.commands.ProductForm;
import com.abin.lee.spring.boot.cassandra.converter.ProductToProductForm;
import com.abin.lee.spring.boot.cassandra.domain.Product;
import com.abin.lee.spring.boot.cassandra.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by jt on 1/10/17.
 */
@RestController
@RequestMapping("cassandra")
public class CassandraController {

    @Autowired
    ProductService productService;

    private ProductToProductForm productToProductForm;

    @Autowired
    public void setProductToProductForm(ProductToProductForm productToProductForm) {
        this.productToProductForm = productToProductForm;
    }

    @RequestMapping("add")
    public String add(String id, String description, BigDecimal price, String imageUrl, boolean flag){
        ProductForm productForm = new ProductForm();
        productForm.setId(UUID.fromString(id));
        productForm.setFlag(flag);
        productForm.setUpdateTime(new Date());
        productForm.setCreateTime(new Date());
        productForm.setDescription(description);
        productForm.setImageUrl(imageUrl);
        productForm.setPrice(price);
        productService.saveOrUpdateProductForm(productForm);
        return "SUCCESS";
    }

    @RequestMapping("findAll")
    public List<Product> findAll(Model model){
        List<Product> productList = productService.listAll();
        return productList;
    }

    @RequestMapping("/findById/{id}")
    public Product findById(@PathVariable String id){
        Product product = productService.getById(UUID.fromString(id));
        return product;
    }

    @RequestMapping("edit/{id}")
    public String edit(String id, String description, BigDecimal price, String imageUrl, boolean flag){
        ProductForm productForm = new ProductForm();
        productForm.setId(UUID.fromString(id));
        productForm.setFlag(flag);
        productForm.setUpdateTime(new Date());
        productForm.setCreateTime(new Date());
        productForm.setDescription(description);
        productForm.setImageUrl(imageUrl);
        productForm.setPrice(price);
        productService.saveOrUpdateProductForm(productForm);
        return "SUCCESS";
    }


    @RequestMapping("update/{id}")
    public String update(@PathVariable String id, String description, BigDecimal price, String imageUrl, boolean flag){
        ProductForm productForm = new ProductForm();
        productForm.setId(UUID.fromString(id));
        productForm.setFlag(flag);
        productForm.setUpdateTime(new Date());
        productForm.setCreateTime(new Date());
        productForm.setDescription(description);
        productForm.setImageUrl(imageUrl);
        productForm.setPrice(price);
        productService.saveOrUpdateProductForm(productForm);
        return "SUCCESS";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        String result = "FAILURE";
        try {
            productService.delete(UUID.fromString(id));
            result = "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
