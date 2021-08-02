package com.day.control;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;


public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MultipartRequest mr;
		String saveDirectory = "C:\\kosta_219\\myback\\upload";

		
		int maxPostSize = 1024;
		String encoding = "utf-8";
		FileRenamePolicy policy = new DefaultFileRenamePolicy();

		mr = new MultipartRequest(request, saveDirectory, maxPostSize, encoding, policy);
		String tValue = mr.getParameter("t");
		File file = mr.getFile("f");
		System.out.println(file.getName()); //파일 이름
		System.out.println(file.length()); //파일 크기

		
		File oldF = new File(saveDirectory, file.getName());
		File newF = new File(saveDirectory, "id1_" + file.getName());
		if(oldF.renameTo(newF)) {
			System.out.println(file.getName() + "->" + newF.getName());
		}
	}
}
