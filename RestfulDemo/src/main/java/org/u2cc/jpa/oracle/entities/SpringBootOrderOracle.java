package org.u2cc.jpa.oracle.entities;

import org.u2cc.util.Utilities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "SPRINGBOOTORDERS", schema = "CompanyDB")
public class SpringBootOrderOracle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "customer_id")
    long customerId;

    @Column(name = "order_date")
    private Timestamp orderDate;

    protected SpringBootOrderOracle() {
    }

    public SpringBootOrderOracle(long customerId, Timestamp orderDate) {
        this.customerId = customerId;
        this.orderDate = orderDate;
    }

    public long getId() {
        return id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    @Override
    public String toString() {
        return "SpringBootOrderOracle{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", orderDate=" + Utilities.formatTimestamp(orderDate) +
                '}';
    }
}
