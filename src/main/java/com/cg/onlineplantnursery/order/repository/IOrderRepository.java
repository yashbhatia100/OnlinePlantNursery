package com.cg.onlineplantnursery.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineplantnursery.order.entity.Order;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Integer>  {
	

}
