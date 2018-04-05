package com.d7kj.controller.form;

import java.util.List;

import com.d7kj.entity.Order;
import com.d7kj.entity.OrderDetail;

import lombok.Data;

@Data
public class OrderPostForm {

	private Order order;
	private List<OrderDetail> details;
}
