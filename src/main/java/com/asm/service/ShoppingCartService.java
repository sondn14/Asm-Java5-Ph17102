package com.asm.service;

import java.math.BigDecimal;
import java.util.Collection;

import com.asm.model.CartItem;

public interface ShoppingCartService {

	int getCount();

	void updateToCart(int motobikeId, int quantity);

	void clearToCart();

	Collection<CartItem> getCartItems();

	void removeToCart(int motobikeId);

	void addToCart(CartItem item);

	BigDecimal getAmout();

	void updatePrice(int motobikeId);

	CartItem getOneCart(int motobikeId);

}
