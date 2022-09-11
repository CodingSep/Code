package com.jpmc.theater.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "customers")
public class Customer {
    @Column(name = "name")
    private String name;
    @Id
    private Long id;

    public Customer(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name) &&
                Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return "name='" + name + "id= " + id;
    }
}
