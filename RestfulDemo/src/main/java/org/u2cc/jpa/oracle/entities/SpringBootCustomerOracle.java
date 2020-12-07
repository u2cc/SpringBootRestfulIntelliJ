package org.u2cc.jpa.oracle.entities;

import javax.persistence.*;

@Entity
@Table(name = "SPRINGBOOTCUSTOMERS", schema = "CompanyDB")
public class SpringBootCustomerOracle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    protected SpringBootCustomerOracle() {
    }

    public SpringBootCustomerOracle(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "SpringBootCustomerOracle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
