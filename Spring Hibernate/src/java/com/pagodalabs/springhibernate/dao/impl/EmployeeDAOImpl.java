/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pagodalabs.springhibernate.dao.impl;

import com.pagodalabs.springhibernate.dao.EmployeeDAO;
import com.pagodalabs.springhibernate.entity.Employee;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Dell
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    @Autowired
    private SessionFactory sessionFactory;

    public EmployeeDAOImpl() {
    }

    @Override
    public int insertOrUpdate(Employee employee) {
        Session session = sessionFactory.openSession();
        Transaction transcation = session.beginTransaction();
        session.saveOrUpdate(employee); //Or session.persist(employee);
        transcation.commit();
        return 1;
    }

    @Override
    public List<Employee> showAll() {
        Session session = sessionFactory.openSession();
        return session.createQuery("SELECT e FROM Employee e").list();
    }

    @Override
    public Employee getById(int id) {
        Session session = sessionFactory.openSession();
        return (Employee)session.get(Employee.class, id);
    }
    
    @Override
    public Employee getByName(String name){
        Session session = sessionFactory.openSession();
        return (Employee) session.createQuery("SELECT e FROM Employee e WHERE e.name = :name")
                .setParameter("name", name).uniqueResult();
    }
    
}
