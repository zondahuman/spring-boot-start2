package com.abin.lee.spring.boot.cassandra.test;

import com.abin.lee.spring.boot.cassandra.domain.Product;
import com.abin.lee.spring.boot.cassandra.repository.ProductRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProductRepositoryTest {

    private static final BigDecimal BIG_DECIMAL_100 = BigDecimal.valueOf(RandomUtils.nextDouble(0.0, 10000.0));
    private static final String PRODUCT_DESCRIPTION = RandomStringUtils.randomAlphabetic(5);
    private static final String IMAGE_URL = "http://an-imageurl.com/image"+ RandomUtils.nextInt()+".jpg";

    @Autowired
    private ProductRepository productRepository;

    @Before
    public void setUp() throws Exception {
        RandomUtils.nextDouble();
    }

    @Test
    public void testPersistence() {
        //given
        Product product = new Product();
        product.setDescription(PRODUCT_DESCRIPTION);
        product.setImageUrl(IMAGE_URL);
        product.setPrice(BIG_DECIMAL_100);
        product.setCreateTime(new Date());
        product.setUpdateTime(new Date());
        product.setFlag(Boolean.TRUE);
        //when
        productRepository.save(product);

        //then
        Assert.assertNotNull(product.getId());
        Product newProduct = productRepository.findById(product.getId()).orElse(null);
        Assert.assertEquals(PRODUCT_DESCRIPTION, newProduct.getDescription());
        Assert.assertEquals(BIG_DECIMAL_100.compareTo(newProduct.getPrice()), 0);
        Assert.assertEquals(IMAGE_URL, newProduct.getImageUrl());
    }
}