package com.ptitB22DCCN539.finalModule4.Service.Order;

import com.ptitB22DCCN539.finalModule4.Model.OrderEntity;
import com.ptitB22DCCN539.finalModule4.Model.OrderResponse;
import com.ptitB22DCCN539.finalModule4.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService {
    private final OrderRepository orderRepository;

    @Override
    public List<OrderResponse> getAllOrders(String dateStart, String dateEnd, Long orderMax, Integer page, Integer limit) {
        try {
            Date startDate = null;
            Integer currentPage = page == null ? 1 : page;
            Integer pageSize = limit == null ? 3 : limit;
            Pageable pageable = PageRequest.of(currentPage, pageSize);
            Date endDate = null;
            if(dateStart != null && !dateStart.isEmpty()) {
                startDate = Date.valueOf(dateStart);
            }
            if(dateEnd != null && !dateEnd.isEmpty()) {
                endDate = Date.valueOf(dateEnd);
            }
            List<OrderEntity> orderEntities = orderRepository.find(startDate, endDate, pageable.getPageSize(), pageable.getOffset());
            List<OrderResponse> responses = orderEntities.stream()
                    .map(item -> OrderResponse.builder()
                            .id(item.getId())
                            .categoryName(item.getProduct().getCategory().getName())
                            .dateCreated(item.getDateCreated())
                            .quantity(item.getQuantity())
                            .productName(item.getProduct().getName())
                            .totalPrice(item.getProduct().getPrice() * item.getQuantity())
                            .unitPrice(item.getProduct().getPrice())
                            .build()).toList();
            if(orderMax != null) {
                responses = responses.stream()
                        .sorted(((o1, o2) -> o2.getTotalPrice().compareTo(o1.getTotalPrice())))
                        .limit(orderMax)
                        .toList();
            }
            return responses;
        } catch (Exception e) {
            return null;
        }
    }
}
