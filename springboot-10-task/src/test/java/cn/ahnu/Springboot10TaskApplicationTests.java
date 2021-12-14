package cn.ahnu;

import cn.ahnu.service.ScheduleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboot10TaskApplicationTests {
    @Autowired
    JavaMailSenderImpl javaMailSender;

//    普通的邮件发送
    @Test
    void contextLoads() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
//        设置主题
        mailMessage.setSubject("Hello Java");
//        设置文本内容
        mailMessage.setText("体验SpringBoot的邮件发送任务！！");

        mailMessage.setTo("jianghaoran88@gmail.com");
        mailMessage.setFrom("505171123@qq.com");
        javaMailSender.send(mailMessage);

    }

    @Test
    void contextLoads2() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);

//        正文，文本
        messageHelper.setSubject("Hello Java-plus");
//        添加html代码，显示相应的属性内容
        messageHelper.setText("<h2 style='color:red'>体验SpringBoot复杂的邮件发送任务！！</h2>",true);
//        附件,文件操作
        messageHelper.addAttachment("1.jpg",new File("/Users/jhr/Pictures/Windows-壁纸/海报壁纸/t0130e251b7b521aa73.jpg"));
        messageHelper.addAttachment("2.jpg",new File("/Users/jhr/Pictures/Windows-壁纸/海报壁纸/t0164ad645de39dbd13.jpg"));

//        发送与接收者
        messageHelper.setTo("jiangkong505@icloud.com");
        messageHelper.setFrom("505171123@qq.com");
//        复杂文件发送
        javaMailSender.send(mimeMessage);
    }



}
