package com.api.restful.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

	@GetMapping("/")
	public String list() {
		return "/restful/src/main/resources/templates/product.html";
	}
}
