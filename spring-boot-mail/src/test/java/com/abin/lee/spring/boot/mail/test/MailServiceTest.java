package com.abin.lee.spring.boot.mail.test;

import com.abin.lee.spring.boot.mail.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * Created by summer on 2017/5/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {
    private static final String toMail = "zondahuman@gmail.com";


    @Autowired
    private MailService mailService;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testSimpleMail() throws Exception {
        mailService.sendSimpleMail(toMail,"test simple mail"," hello this is simple mail");
    }

    @Test
    public void testHtmlMail() throws Exception {
        String content="<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail(toMail,"test simple mail",content);
    }

    @Test
    public void sendAttachmentsMail() {
        String filePath="e:\\tomcat.keystore";
        mailService.sendAttachmentsMail(toMail, "主题：带附件的邮件", "有附件，请查收！", filePath);
    }


    @Test
    public void sendInlineResourceMail() {
        String rscId = "neo006";
        String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "E:\\timg.jpg";

        mailService.sendInlineResourceMail(toMail, "主题：这是有图片的邮件", content, imgPath, rscId);
    }


    @Test
    public void sendTemplateMail() {
        //创建邮件正文
        Context context = new Context();
        context.setVariable("id", "006");
        String emailContent = templateEngine.process("emailTemplate", context);

        mailService.sendHtmlMail(toMail, "主题：这是模板邮件", emailContent);
    }
}
