package com.asm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.asm.model.Order;
import com.asm.model.OrderDetail;
import com.asm.reponsitory.IOrderDetailReponsitory;
import com.asm.service.MotobikeService;

@Controller
public class OrderDetailController {

	@Autowired
	private IOrderDetailReponsitory detailReponsitory;
	
	@Autowired
	private MotobikeService motobikeService;
	
	@GetMapping("/list-order-detail/{orderId}")
	public String list(Model model,@PathVariable(value="orderId") Integer orderId) {
		Order orders = new Order();
		List<OrderDetail> resulPage = null;
		if(orders != null) {
			resulPage = detailReponsitory.findByOrder(orders);
		}
		model.addAttribute("listdt",resulPage);
		return "/orderDetailList";
	}
}
