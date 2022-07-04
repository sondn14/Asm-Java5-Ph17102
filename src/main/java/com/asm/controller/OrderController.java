package com.asm.controller;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asm.model.CartItem;
import com.asm.model.Motobike;
import com.asm.model.Order;
import com.asm.model.OrderDetail;
import com.asm.model.User;
import com.asm.reponsitory.IOrderDetailReponsitory;
import com.asm.reponsitory.OrderReponsitory;
import com.asm.service.MotobikeService;
import com.asm.service.ShoppingCartService;

@Controller
public class OrderController {

	@Autowired
	MotobikeService motoService;

	@Autowired
	ShoppingCartService cartService;

	@Autowired
	HttpSession session;

	@Autowired
	OrderReponsitory orderReponsitory;
	
	@Autowired
	IOrderDetailReponsitory iOrderDetailReponsitory;

	@RequestMapping("/add-order/{total}")
	public String addOrder(Model model, @PathVariable("total") BigDecimal total) {
		User users = new User();
		Order order = new Order();
		try {
			User user = (User) session.getAttribute("userSession");
			if (user != null) {
				Calendar cal = Calendar.getInstance();
				Date date = cal.getTime();
				order.setAmount(total);
				order.setOrderDate(date);
				order.setUser(user);

				orderReponsitory.save(order);
				session.setAttribute("order", order);
			}else {
				return "redirect:/login";
			}
			Collection<CartItem> lcartItem = cartService.getCartItems();
			for (CartItem cartItem : lcartItem) {
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setOrder(order);
				orderDetail.setMotobike(motoService.getOneMotobikeById(cartItem.getMotobikeId()));
				orderDetail.setUnitPrice(cartItem.getPrice());
				orderDetail.setQuantity(cartItem.getQuantity());
				
				iOrderDetailReponsitory.save(orderDetail);
				
				Motobike motobike =  motoService.getOneMotobikeById(cartItem.getMotobikeId());
				int qtM = motobike.getQuantity();
				int qtO = cartItem.getQuantity();
				int updateQuantity = qtM - qtO;
				motobike.setQuantity(updateQuantity);
				motoService.updateMotobike(motobike);
			}
			cartService.clearToCart();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/list-order";
	}
	
	@RequestMapping("/list-order")
	public String list(Model model) {
		User user = new User();
		user = (User) session.getAttribute("userSession");
		List<Order> resultPage = null;
		if(user != null) {
			resultPage = orderReponsitory.findByUser(user);
		}else {
			return "redirect:/login";
		}
		model.addAttribute("orders",resultPage);
		return "/orderList";
	}
	

}
