/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pagodalabs.springhibernate.dao;

import com.pagodalabs.springhibernate.entity.Employee;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface EmployeeDAO {
    
    public int insertOrUpdate(Employee employee);
    public Employee getById(int id);
    public List<Employee> showAll();
    public Employee getByName(String name);
}
