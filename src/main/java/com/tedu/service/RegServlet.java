package com.tedu.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import com.tedu.core.HttpServlet;
import com.tedu.http.HttpRequest;
import com.tedu.http.HttpResponse;

/**
 * ��������û�ע�Ṧ��
 * @author adminitartor
 *
 */
public class RegServlet extends HttpServlet{
	
	
	public void service(HttpRequest request,HttpResponse response){
		System.out.println("��ʼ����ע��!");
		/*
		 * ���û���ע����Ϣ����д�뵽
		 * userinfo.txt�ļ��С�
		 * ÿ��Ϊһ���û�����Ϣ����ʽ:
		 * username,password,nickname
		 * ����:
		 * fanchuanqi,123456,fanfan
		 * liucangsong,223344,cangcang
		 * 
		 * userinfo.txt����webappĿ¼��
		 * 
		 * 1:��ȡ����ע����Ϣ
		 * 2:���������
		 * 3:������д��
		 */
		//��ȡ�û���
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(
				new FileOutputStream(
					"webapp"+File.separator+
					"userinfo.txt",true
				)	
			);
			pw.println(username+","+password+","+nickname);
			pw.flush();
			System.out.println("ע��ɹ�!");
			/*
			 * ��Ӧע��ɹ���ҳ����ͻ���
			 */	
			forward("/reg_ok.html", response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(pw!=null){
				pw.close();
			}
		}		
	}
	
	
}



