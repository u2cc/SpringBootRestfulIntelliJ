package org.u2cc.jpa.sybase.entities;

import org.u2cc.util.Utilities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "SpringBootOrders", schema = "dbo")
public class SpringBootOrderSybase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "customer_id")
    private long customerId;

    @Column(name = "order_date")
    private Timestamp orderDate;

    protected SpringBootOrderSybase() {
    }

    public SpringBootOrderSybase(long customerId, Timestamp orderDate) {
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
        return "SpringBootOrderSybase{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", orderDate=" + Utilities.formatTimestamp(orderDate) +
                '}';
    }
}
