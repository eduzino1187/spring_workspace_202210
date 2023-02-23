package com.edu.springshop.admin.controller;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.edu.springshop.domain.Product;
import com.edu.springshop.util.Message;

//상품과 관련된 요청을 처리하는 하위 컨트롤러 

@RestController
@RequestMapping("/rest")
public class RestProductController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	//상품 등록 요청 처리
	@RequestMapping(value="/product", method=RequestMethod.POST)
	public Message regist(Product product, HttpServletRequest request) {
		
		//웹환경과 관련된 코드 이므로, 컨트롤러의 책임이다!!
		//왜?? 모델은 중립적이니깐...관심도없다
		ServletContext application=request.getSession().getServletContext();
		String path=application.getRealPath("/resources/data/");\
		logger.info("저장될 실제 경로는 "+path);
		
		MultipartFile[] photoList=product.getPhoto();
		logger.info("photo 배열은 "+photoList);
		
		for(MultipartFile photo : photoList) {
			//photo.transferTo(new File("경로"));
		}
		
		
		//3단계
		
		return null;
	}
	
}










