package com.abin.lee.spring.boot.cassandra.test;

import com.abin.lee.spring.boot.common.HttpClientUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by abin on 2018/1/15 11:36.
 * spring-boot-start2
 * com.abin.lee.spring.boot.mybatis.test
 */
public class AnnotationAddTest {

    private static final String httpURL = "http://localhost:8002/cassandra/add";

    @Test
    public void testAnnotationAdd() {
        try {
            CloseableHttpClient httpClient = HttpClientUtil.getHttpClient();
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            int random = (int)(Math.random()*100);
            nvps.add(new BasicNameValuePair("id", UUID.randomUUID().toString()));
            nvps.add(new BasicNameValuePair("description", RandomStringUtils.randomAlphabetic(5)));
            nvps.add(new BasicNameValuePair("price", BigDecimal.valueOf(RandomUtils.nextDouble(0.0, 10000.0)) +""));
            nvps.add(new BasicNameValuePair("imageUrl", "http://an-imageurl.com/image"+ RandomUtils.nextInt()+".jpg"));
            nvps.add(new BasicNameValuePair("flag", Boolean.TRUE + ""));
            HttpPost httpPost = new HttpPost(httpURL);
//            httpPost.setHeader("Cookie", getCookie());
//            httpPost.setHeader("Cookie", "JSESSIONID=7588C522A6900BFD581AA18FDA64D347");

            httpPost.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));
            System.out.println("Executing request: " + httpPost.getRequestLine());
            HttpResponse response = httpClient.execute(httpPost);
            System.out.println("----------------------------------------");
            System.out.println(response.getStatusLine());
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }



}
