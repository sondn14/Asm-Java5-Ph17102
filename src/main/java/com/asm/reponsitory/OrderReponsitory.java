package com.asm.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.asm.model.Order;
import com.asm.model.User;

public interface OrderReponsitory extends JpaRepository<Order, Integer> {
	@Query("select u from Order u where u.user = ?1")
	List<Order> findByUser(User user);
}
