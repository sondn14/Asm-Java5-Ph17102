package com.asm.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.asm.model.Order;
import com.asm.model.OrderDetail;

public interface IOrderDetailReponsitory extends JpaRepository<OrderDetail, Integer>{
	@Query("select u from OrderDetail u where u.orders = ?1")
	List<OrderDetail> findByOrder(Order order);
}
