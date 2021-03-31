package com.cg.onlineplantnursery.order.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineplantnursery.exceptions.OrderIdNotFoundException;
import com.cg.onlineplantnursery.exceptions.OrderUpdateException;
import com.cg.onlineplantnursery.order.entity.Order;
import com.cg.onlineplantnursery.order.repository.IOrderRepository;
import com.cg.onlineplantnursery.plant.entity.Plant;
import com.cg.onlineplantnursery.planter.entity.Planter;
import com.cg.onlineplantnursery.seed.entity.Seed;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderRepository repository;

    /**
     *
     */
    @Override
    public Order addOrder(Order order) {
        validateOrder(order);
        LocalDate currentDate = currentDate();
        order.setOrderDate(currentDate);
        Planter planter = order.getPlanter();
        if (planter.getPlant() != null) {
            Plant plant = planter.getPlant();
            int quantity = order.getQuantity();
            double totalCost = quantity * (planter.getPlanterCost() + plant.getPlantCost());
            order.setTotalCost(totalCost);
            order=repository.save(order);
            return order;
        }
        Seed seed = planter.getSeed();
        int quantity = order.getQuantity();
        double totalCost = quantity * (planter.getPlanterCost() + seed.getSeedsCost());
        order.setTotalCost(totalCost);
        order=repository.save(order);
        return order;

    }

    @Transactional
    @Override
    public Order updateOrder(Order order) {
        validateOrder(order);
        Integer id = order.getBookingOrderId();
        boolean exists = repository.existsById(id);
        if (!exists) {
            throw new OrderUpdateException("Order id is not found for " + id);
        }

        Order saved = repository.save(order);
        return saved;

    }

    @Transactional
    @Override
    public Order deleteOrder(Order order) {
        validateOrder(order);
        Integer id = order.getBookingOrderId();
        validateBookingId(id);
        boolean exists = repository.existsById(id);
        if (!exists) {
            throw new OrderUpdateException("Order id is not found for " + order.getBookingOrderId());
        }
        repository.delete(order);
        return order;
    }

    @Override
    public Order viewOrder(int orderId) {
        validateBookingId(orderId);
        Optional<Order> orderList = repository.findById(orderId);
        if (!orderList.isPresent()) {
            throw new OrderIdNotFoundException("Order is not found for this Id");

        }
        return orderList.get();
    }

    @Override
    public List<Order> viewAllOrders() {

        List<Order> orderList = repository.findAll();
        if (orderList.isEmpty()) {
            throw new OrderIdNotFoundException("Orders not found");
        }

        return orderList;
    }

    public LocalDate currentDate() {
        return LocalDate.now();
    }

    public void validateOrder(Order order) {
        if (order == null) {
            throw new OrderUpdateException("Order cannot be null");
        }
        validateTransactionMode(order.getTransactionMode());
        validateQuantity(order.getQuantity());


    }

    public void validateBookingId(Integer bookingid) {
        if (bookingid < 0) {
            throw new OrderIdNotFoundException("Invalid OrderBookingID");
        }

    }

    public void validateTransactionMode(String TransactionMode) {
        if (TransactionMode.equals("")) {
            throw new OrderIdNotFoundException("TransactionMode can't be null");
        }
    }

    public void validateQuantity(int Quantity) {
        if (Quantity < 0) {
            throw new OrderIdNotFoundException("Invalid Quantity");
        }

    }


}
