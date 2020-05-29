package com.d7kj.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "t_order")	// 跟关键字冲突了，所以要改名
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long 	id;

	String 	name;
	Date	createDate;
}
