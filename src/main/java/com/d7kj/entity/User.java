package com.d7kj.entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.springframework.data.jpa.domain.AbstractAuditable;

//@Table(name = "user")
@Entity
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "department_id")
    private Integer departmentId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    /**
     * 名称
     */
    @Column(name = "name")
    private String name;

    public User(){
        // JPA 要求实体必须有一个空的构造函数
        super();
    }
}