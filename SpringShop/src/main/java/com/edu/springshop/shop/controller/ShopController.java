package com.edu.springshop.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edu.springshop.model.category.CategoryService;
import com.edu.springshop.model.product.ProductService;

//상품 리스트부터 구매단계까지의 쇼핑 전반적인 요청을 처리할 하위 컨트롤러
@Controller
public class ShopController {

	
	@Autowired
	private ProductService productService;
	
	
	//상품 리스트 페이지 요청 처리 
	@GetMapping("/shop/list")
	public ModelAndView getList() {
		//3단계
		List productList=productService.selectAll();
		
		//4단계 
		ModelAndView mav = new ModelAndView();
		mav.addObject("productList", productList);
		mav.setViewName("shop/shop");
		return mav;
	}
	
}








