package com.edu.springboard.client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.edu.springboard.domain.Gallery;

//겔러리와 관련된 모든 요청을 처리하는 하위 컨트롤러 
@Controller
public class GalleryController {
	private Logger logger=LoggerFactory.getLogger(this.getClass().getName());
	
	@GetMapping("/gallery/registform")
	public ModelAndView registForm() {
		return new ModelAndView("gallery/regist");
	}
	
	//겔러리 업로드 요청처리 
	@PostMapping("/gallery/regist")
	public ModelAndView regist(Gallery gallery) {
		MultipartFile photo=gallery.getPhoto();
		
		logger.info("업로드된 파일은 "+photo.getOriginalFilename());
		
		return null;
	}
	
}





