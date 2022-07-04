package com.asm.service.Impl;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.asm.model.CartItem;
import com.asm.model.Motobike;
import com.asm.service.MotobikeService;
import com.asm.service.ShoppingCartService;

@Service
@SessionScope
public class ShoppingCartServiceImpl implements ShoppingCartService {
	private Map<Integer, CartItem> map = new HashMap<Integer, CartItem>();

	@Autowired
	private MotobikeService motoService;

	@Override
	public void addToCart(CartItem item) {
		Motobike motobike = motoService.getOneMotobikeById(item.getMotobikeId());
		CartItem existedItem = map.get(item.getMotobikeId());
		if (existedItem != null) {
			if (existedItem.getQuantity() < motobike.getQuantity()) {
				existedItem.setQuantity(item.getQuantity() + existedItem.getQuantity());
			}
		} else {
			map.put(item.getMotobikeId(), item);
		}
	}

	@Override
	public void removeToCart(int motobikeId) {
		map.remove(motobikeId);
	}

	@Override
	public Collection<CartItem> getCartItems() {
		return map.values();
	}

	@Override
	public void clearToCart() {
		map.clear();
	}

	@Override
	public void updateToCart(int motobikeId, int quantity) {
		Motobike motobike = motoService.getOneMotobikeById(motobikeId);
		CartItem item = map.get(motobikeId);
		if (motobike.getQuantity() < item.getQuantity()) {
			item.setQuantity(motobike.getQuantity());
		}
		System.out.println(motobikeId);
		item.setPrice(motobike.getPrice());
		item.setQuantity(quantity);
		if (item.getQuantity() <= 0) {
			map.remove(motobikeId);
		}
		
	}
	
	@Override
	public void updatePrice(int motobikeId) {
		Motobike motobike = motoService.getOneMotobikeById(motobikeId);
		CartItem item = map.get(motobikeId);
		item.setPrice(motobike.getPrice());
	}
	
	@Override
	public int getCount() {
		if (map.isEmpty()) {
			return 0;
		}
		return map.values().size();
	}

	@Override
	public BigDecimal getAmout() {
		BigDecimal cartTotal = BigDecimal.ZERO;
		for (Map.Entry<Integer, CartItem> itemCart : map.entrySet()) {
			cartTotal = cartTotal
					.add(itemCart.getValue().getPrice().multiply(new BigDecimal(itemCart.getValue().getQuantity())));
		}
		return cartTotal;
	}
	
	@Override
	public CartItem getOneCart(int motobikeId) {
		return map.get(motobikeId);
	}

}
