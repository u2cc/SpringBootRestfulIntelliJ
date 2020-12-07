package org.u2cc.jpa.sybase.entities;

import javax.persistence.*;

@Entity
@Table(name = "SpringBootCustomers", schema = "dbo")
public class SpringBootCustomerSybase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    protected SpringBootCustomerSybase() {
    }

    public SpringBootCustomerSybase(String name, String description) {
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
        return "SpringBootCustomerSybase{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
