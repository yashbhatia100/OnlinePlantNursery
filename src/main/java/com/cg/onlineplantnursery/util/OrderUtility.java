package com.cg.onlineplantnursery.util;

import java.util.ArrayList;
import java.util.List;

import com.cg.onlineplantnursery.dto.OrderDetails;
import com.cg.onlineplantnursery.plant.entity.Plant;
import com.cg.onlineplantnursery.planter.entity.Planter;
import com.cg.onlineplantnursery.seed.entity.Seed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.onlineplantnursery.order.entity.Order;

@Component
public class OrderUtility {

    @Autowired
    private DateUtil dateUtil;

    public OrderDetails toDetails(Order order) {
        OrderDetails details = new OrderDetails();
        details.setBookingOrderId(order.getBookingOrderId());
        String dateText=dateUtil.toText(order.getOrderDate());
        details.setOrderDate(dateText);
        details.setQuantity(order.getQuantity());
        details.setTransactionMode(order.getTransactionMode());
        details.setTotalCost(order.getTotalCost());
        Planter planter = order.getPlanter();
        if (planter.getPlant() != null) {
            Plant plant = planter.getPlant();
            details.setPlantId(plant.getPlantId());
            details.setPlantCommonName(plant.getCommonName());
        } else {
            Seed seed = planter.getSeed();
            details.setSeedId(seed.getSeedId());
            details.setSeedCommonName(seed.getCommonName());
        }
        return details;
    }

    public List<OrderDetails> toDetailList(List<Order> orderList) {

        List<OrderDetails> desiredList = new ArrayList<>();
        for (Order order : orderList) {
            desiredList.add(toDetails(order));
        }
        return desiredList;
    }
}
