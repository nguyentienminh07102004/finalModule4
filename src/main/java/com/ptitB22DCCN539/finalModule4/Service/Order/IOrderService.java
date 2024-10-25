package com.ptitB22DCCN539.finalModule4.Service.Order;

import com.ptitB22DCCN539.finalModule4.Model.OrderResponse;

import java.util.List;

public interface IOrderService {
    List<OrderResponse> getAllOrders(String dateStart, String dateEnd, Long orderMax);
}
