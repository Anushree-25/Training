package com.lti.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CaptchaServlet
 */
@WebServlet("/captcha.jpg")		//	url pattern of this servlet
public class CaptchaServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		
		String captcha = "";
		
		for (int i = 0; i < 5; i++) {
			int rno = (int) Math.floor(Math.random() * str.length());		//	Math.random() returns number between 0.0 to 1.0, hence multiply by strlength
			captcha += str.charAt(rno);
		}
		
		response.setContentType("image/jpeg");
		ServletOutputStream out = response.getOutputStream();
		
		BufferedImage img = new BufferedImage(120, 50, BufferedImage.TYPE_INT_RGB);
		java.awt.Graphics g = img.getGraphics();
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 120, 50);
		g.setColor(Color.YELLOW);
		g.setFont(new Font("Harrington", Font.BOLD, 26));
		g.drawString(captcha, 20, 30);
		
		ImageIO.write(img, "jpeg", out);
		
		System.out.println();
	}

}
