package com.cg.onlineplantnursery.controller;

import java.util.List;

import com.cg.onlineplantnursery.dto.AddOrderRequest;
import com.cg.onlineplantnursery.dto.DeleteOrderRequest;
import com.cg.onlineplantnursery.dto.OrderDetails;
import com.cg.onlineplantnursery.dto.UpdateOrderQuantityRequest;
import com.cg.onlineplantnursery.dto.UpdateOrderTotalcostRequest;
import com.cg.onlineplantnursery.order.dto.*;
import com.cg.onlineplantnursery.plant.service.IPlantService;
import com.cg.onlineplantnursery.planter.entity.Planter;
import com.cg.onlineplantnursery.planter.service.IPlanterService;
import com.cg.onlineplantnursery.seed.service.ISeedService;
import com.cg.onlineplantnursery.util.OrderUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.cg.onlineplantnursery.order.entity.Order;
import com.cg.onlineplantnursery.order.service.IOrderService;

@RequestMapping("/orders")
@RestController
public class OrderRestController {
    @Autowired
    private IOrderService orderService;

    @Autowired
    private IPlanterService planterService;

    @Autowired
    private IPlantService plantService;

    @Autowired
    private ISeedService seedService;

    @Autowired
    private OrderUtility util;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public OrderDetails addPlanterOrder(@RequestBody AddOrderRequest requestData) {
        Planter planter=planterService.viewPlanter(requestData.getPlanterId());
        Order order = new Order();
        order.setQuantity(requestData.getQuantity());
        order.setTransactionMode(requestData.getTransactionMode());
        order.setPlanter(planter);
        Order saved = orderService.addOrder(order);
        OrderDetails details = util.toDetails(saved);
        return details;
    }

    @ResponseStatus(HttpStatus.GONE)
    @DeleteMapping("/deleteorder")
    public String deletePlant(@RequestBody DeleteOrderRequest requestBody) {

        Integer orderId = requestBody.getBookingOrderId();
        Order order = orderService.viewOrder(orderId);
        orderService.deleteOrder(order);
        return "Order with id " + orderId + " is deleted.";
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/updateorderquantity")
    public OrderDetails updateOrderQuantity(@RequestBody UpdateOrderQuantityRequest requestBody) {

        Integer orderId = requestBody.getBookingOrderId();
        Order order = orderService.viewOrder(orderId);
        order.setQuantity(requestBody.getQuantity());
        Order updated = orderService.updateOrder(order);
        OrderDetails details = util.toDetails(updated);
        return details;
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/updateordertotalcost")
    public OrderDetails updateOrderTotalcost(@RequestBody UpdateOrderTotalcostRequest requestBody) {

        Integer orderId = requestBody.getBookingOrderId();
        Order order = orderService.viewOrder(orderId);
        order.setTotalCost(requestBody.getTotalCost());
        Order updated = orderService.updateOrder(order);
        OrderDetails details = util.toDetails(updated);
        return details;
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/fetch/byid/{id}")
    public OrderDetails fetchById(@PathVariable("id") Integer orderId) {

        Order order = orderService.viewOrder(orderId);
        OrderDetails details = util.toDetails(order);
        return details;
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping
    public List<OrderDetails> fetchAll() {
        List<Order> orderList = orderService.viewAllOrders();
        List<OrderDetails> desiredList = util.toDetailList(orderList);
        return desiredList;
    }


}
