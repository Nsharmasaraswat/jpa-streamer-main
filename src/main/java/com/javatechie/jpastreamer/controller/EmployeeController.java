package com.javatechie.jpastreamer.controller;

import com.javatechie.jpastreamer.entity.Employee;
import com.javatechie.jpastreamer.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public List<Employee> saveEmployees(@RequestBody List<Employee> employees){
        return service.saveEmployees(employees);
    }

    @GetMapping("/getEmployees")
    public List<Employee> getEmployees(@RequestParam(value = "offset", defaultValue = "0") int offset,
                                       @RequestParam(value = "limit",defaultValue = "10") int limit) {
        return service.getEmployees(offset,limit);
    }

    @GetMapping("/dept")
    public List<Employee> getEmployeesByDept(
            @RequestParam(value = "department", defaultValue = "DEV") String dept) {
        return service.getEmployeesByDept(dept);
    }

    @GetMapping("/fetch")
    public List<Employee> getEmployeesByDeptAndSalary(@RequestParam(value = "department", defaultValue = "DEV") String dept,
                                                      @RequestParam(value = "salary", defaultValue = "1") double salary) {
        return service.getEmployeesByDeptAndSalary(dept,salary);
    }

    @GetMapping("/range")
    public List<Employee> getEmployeesBySalaryRange(@RequestParam(value = "sal1", defaultValue = "1")
                                                        double sal1,
                                                    @RequestParam(value = "sal2", defaultValue = "1") double sal2) {
        return service.getEmployeeBySalaryRange(sal1, sal2);
    }

    @GetMapping("/min")
    public Employee getLessPaidEmployee(){
        return service.minPaidEmp();
    }

    @PostMapping("/ids")
    public  List<Employee> getEmployeesByIds(@RequestBody List<UUID> ids){
        return service.getEmployeesByIds(ids);
    }

    @GetMapping("/groupByDept")
    public Map<String, List<Employee>> getEmployeeGroupByDept(){
        return service.getEmployeeGroupByDept();
    }

}
