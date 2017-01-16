/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pagodalabs.springhibernate.controller;

import com.pagodalabs.springhibernate.dao.EmployeeDAO;
import com.pagodalabs.springhibernate.entity.Employee;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Dell
 */
@Controller
@RequestMapping("/")
public class DefaultController {
    
    @Autowired
    private EmployeeDAO employeeDAO;
    
    @RequestMapping(method = RequestMethod.GET)
    public String defaultPage(ModelMap map){
        employeeDAO.insertOrUpdate(new Employee(0, "Ajit"));
        map.addAttribute("employees", employeeDAO.showAll());
        map.addAttribute("employee", employeeDAO.getById(1));
        map.addAttribute("byName", employeeDAO.getByName("Ajit"));
        return "default";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String defaultPagePost(ModelMap map, HttpServletRequest request){
       String name=request.getParameter("name");
        map.addAttribute("byName", employeeDAO.getByName(name));
        return "default";
    }
    
}
