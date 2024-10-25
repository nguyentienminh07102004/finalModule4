package com.ptitB22DCCN539.finalModule4.Controller;

import com.ptitB22DCCN539.finalModule4.Model.OrderResponse;
import com.ptitB22DCCN539.finalModule4.Service.Order.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/orders")
public class OrderController {
    private final IOrderService orderService;
    @GetMapping(value = "/list")
    public ModelAndView listOrder(@RequestParam(value = "dateStart", required = false) String dateStart,
                                  @RequestParam(value = "dateEnd", required = false) String dateEnd,
                                  @RequestParam(value = "orderMax", required = false) Long orderMax) {
        ModelAndView mav = new ModelAndView("/list");
        List<OrderResponse> list = orderService.getAllOrders(dateStart, dateEnd, orderMax);
        mav.addObject("listOrders", list);
        return mav;
    }
}
