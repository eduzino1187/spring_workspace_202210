package com.edu.mvc2.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//게시판의 글쓰기 요청을 처리하는 하위 컨트롤러..
//2.x 방식
public class RegistController implements Controller{

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String title=request.getParameter("title");
		System.out.println("제목은 "+title);
		return null;
	}

}





