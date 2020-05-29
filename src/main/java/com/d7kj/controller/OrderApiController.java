package com.d7kj.controller;

import com.d7kj.entity.Order;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class OrderApiController {
    @GetMapping("/order/{orderId}")
    public Order getOrder(@PathVariable String orderId){
        Order order = new Order();
        order.setId(Long.valueOf(orderId));
        return order;
    }

    @GetMapping("/order")
    public List<Order> getOrder(Integer offset){
        Order order = new Order();
        order.setId(1L + 1);
        List<Order> list = new ArrayList<Order>();
        list.add(order);
        return list;
    }

    @PostMapping("/order")
    public String addOrder(@RequestBody Order order){
        return "{\"success\":true,\"message\":\"添加成功\"}";
    }
    @PostMapping("/orders")
    public String batchAdd(@RequestBody List<Order> order) throws Exception{
        return "{success:true,message:\"批量添加成功\"}";
    }

    @PutMapping("/order")
    public String updateOrder(Order order) throws Exception{
        return "{\"success\":true,\"message\":\"更新成功\"}";
    }

    @DeleteMapping("/order/{orderId}")
    public String cancelOrder(@PathVariable() String orderId) throws Exception{
        return "{\"success\":true,\"message\":\"订单取消成功\"}";
    }
}
