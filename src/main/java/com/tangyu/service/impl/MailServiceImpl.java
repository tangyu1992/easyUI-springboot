package com.tangyu.service.impl;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.tangyu.service.MailService;
@Service
public class MailServiceImpl implements MailService {
	
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void sengMail() {
		MimeMessage mimeMessage=mailSender.createMimeMessage();
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("18515239792@163.com");// 发送者.
		message.setTo("282412386@qq.com");// 接收者.
		message.setSubject("测试邮件（唐瑜）");// 邮件主题.
		message.setText("你好！这里是唐瑜的测试邮件发送内容！请忽略！");// 邮件内容.
		mailSender.send(message);// 发送邮件

	}

}
