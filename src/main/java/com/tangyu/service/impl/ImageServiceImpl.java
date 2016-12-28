package com.tangyu.service.impl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tangyu.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public String[] getCodes(String[] sourceCodes, int length) {
		if (sourceCodes != null && sourceCodes.length > 0) {
			final String[] result = new String[length];
			// 创建一个随机数生成器类
			final Random random = new Random();
			for (int i = 0; i < length; i++) {
				result[i] = sourceCodes[random.nextInt(sourceCodes.length)];
			}
			logger.info("create a code:{}", StringUtils.join(result));
			return result;
		}
		return null;
	}

	@Override
	public String getBase64ByCodes(String[] codes, int width, int height) {
		String result = "";
		if (codes != null && codes.length > 0) {
			int xx = 15;// 字符间距
			int fontHeight = 18;// 字体粗细
			int codeY = 23;// 偏移量
			// 定义图像buffer
			final BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			final Graphics gd = buffImg.getGraphics();
			// 创建一个随机数生成器类
			Random random = new Random();
			// 将图像填充为白色
			gd.setColor(Color.WHITE);
			gd.fillRect(0, 0, width, height);
			// 创建字体，字体的大小应该根据图片的高度来定。
			Font font = new Font("Arial", Font.ITALIC, fontHeight);
			// 设置字体
			gd.setFont(font);
			// 画边框
			gd.setColor(Color.white);
			gd.drawRect(0, 0, width - 1, height - 1);
			// 随机产生2条干扰线，使图象中的认证码不易被其它程序探测到
			gd.setColor(Color.BLACK);
			for (int i = 0; i < 2; i++) {
				int x = random.nextInt(width);
				int y = random.nextInt(height);
				int xl = random.nextInt(12);
				int yl = random.nextInt(12);
				gd.drawLine(x, y, x + xl, y + yl);
			}
			int red = 0, green = 0, blue = 0;
			for (int i = 0; i < codes.length; i++) {
				// 用随机产生的颜色将验证码绘制到图像中
				gd.setColor(new Color(red, green, blue));
				gd.drawString(codes[i], (i + 1) * xx, codeY);
			}
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			try {
				ImageIO.write(buffImg, "jpeg", baos);
				result = new String(Base64.encodeBase64(baos.toByteArray()));
				logger.info("create a base64code:{}", result.toString());
			} catch (IOException e) {
				logger.error("catch exception when try to create a base64 code string:{}",e);
			}
		}
		return result;
	}

}
