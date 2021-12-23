package com.example.final2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.example.final2.Main;
import com.example.final2.entity.Customer;

public class CustomerDao {
    public List<Customer> findAll() {
        EntityManager entity = Main.getEntityManager();
        String sql = "SELECT customer FROM Customer customer";
        TypedQuery<Customer> query = entity.createQuery(sql, Customer.class);
        return query.getResultList();
    }

    public List<Customer> find(String name) {
        EntityManager entity = Main.getEntityManager();
        String sql = "SELECT customer FROM Customer customer WHERE customer.name like " + "'%" + name + "%'";
        TypedQuery<Customer> query = entity.createQuery(sql, Customer.class);
        return query.getResultList();
    }
}
