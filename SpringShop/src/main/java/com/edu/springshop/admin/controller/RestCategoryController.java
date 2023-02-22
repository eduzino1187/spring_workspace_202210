package com.edu.springshop.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.springshop.domain.Category;
import com.edu.springshop.exception.CategoryException;
import com.edu.springshop.model.category.CategoryService;
import com.edu.springshop.util.Message;

@RestController
@RequestMapping("/rest")
public class RestCategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/category")
	public Message regist(Category category) {
		//3단계:
		categoryService.insert(category);
		Message message = new Message();
		message.setMsg("카테고리 등록 성공");
		return message;
	}

	@ExceptionHandler(CategoryException.class)
	public Message handle(CategoryException e) {
		Message message = new Message();		
		message.setMsg(e.getMessage());
		return message;
	}
}









