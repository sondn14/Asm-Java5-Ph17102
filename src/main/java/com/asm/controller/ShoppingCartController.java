package com.asm.controller;

import java.util.Collection;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.asm.model.CartItem;
import com.asm.model.Motobike;
import com.asm.service.MotobikeService;
import com.asm.service.ShoppingCartService;

@Controller
public class ShoppingCartController {

	@Autowired
	private MotobikeService motoService;

	@Autowired
	private ShoppingCartService cartService;

	@GetMapping("cart")
	public String list(Model model) {
		Collection<CartItem> cartItems = cartService.getCartItems();
		model.addAttribute("cartItems", cartItems);
		model.addAttribute("total", cartService.getAmout());
		model.addAttribute("NoOfItems", cartService.getCount());
		return "cart";
	}

	@GetMapping("add-to-cart/{motobikeId}")
	public String addCart(@PathVariable("motobikeId") Integer motobikeId) {
		Motobike motobike = motoService.getOneMotobikeById(motobikeId);
		CartItem item = new CartItem();
		if (motobike != null) {
				BeanUtils.copyProperties(motobike, item);
				item.setQuantity(1);
				cartService.addToCart(item);
		}
		return "redirect:/cart";
	}

	@GetMapping("remove-to-cart/{motobikeId}")
	public String remove(@PathVariable("motobikeId") Integer motobikeId) {
		cartService.removeToCart(motobikeId);
		return "redirect:/cart";
	}

	@PostMapping("/update-to-cart")
	public String updateCart(@RequestParam("motobikeId") Integer motobikeId, @RequestParam("quantity") int quantity) {
		Motobike motobike = motoService.getOneMotobikeById(motobikeId);
		if (quantity > motobike.getQuantity()) {
			quantity = motobike.getQuantity();
		}
		cartService.updateToCart(motobikeId, quantity);
		return "redirect:/cart";
	}

	@GetMapping("clear-to-cart")
	public String clearCart(){
		return "redirect:/cart";
	}
}
