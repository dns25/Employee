package com.example.employee.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;


@Controller
public class EmployeeController {

	@Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listEmployee(Model model) {
    	return "redirect:/employees";
    }


     @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String listEmployees(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("listEmployees", this.employeeService.listEmployees());
       
        return "employee";
    }

   

    @RequestMapping(value= "/employee/add", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute("employee") Employee e){

        if(e.getId() == null){
               this.employeeService.addEmployee(e);
        }else{
                this.employeeService.updateEmployee(e);
        }

        return "redirect:/employees";

    }
    @RequestMapping("/removeEmployee/{id}")
    public String removeEmployee(@PathVariable("id") Long id){

        this.employeeService.removeEmployee(id);
        return "redirect:/employees";
    }

    @RequestMapping("/editEmployee/{id}")
    public String editEmployee(@PathVariable("id") Long id, Model model){
    
        model.addAttribute("employee", this.employeeService.getEmployeeById(id));
        model.addAttribute("listEmployees", this.employeeService.listEmployees());
        
        return "employee";
    }
}
