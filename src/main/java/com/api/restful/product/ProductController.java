package com.api.restful.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

	@GetMapping({"/", "/index"})
	public String product() {
		return "index.html";
	}
}
