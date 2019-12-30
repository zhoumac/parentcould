package com.mywork.user.sevice.business;

import org.springframework.cloud.openfeign.FeignClient;

import com.mywork.service.OrderSeviceModel;

@FeignClient("order-service")
public interface OrderSevice extends OrderSeviceModel{
	

}
