package com.mywork.service;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface OrderSeviceModel {
	@PostMapping("/order/hello")
	String hello(@RequestBody String name);

}
