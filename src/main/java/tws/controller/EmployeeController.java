package tws.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tws.mapper.EmployeeMapper;
import tws.model.Employee;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
 @Autowired
 private EmployeeMapper employeeMapper;
 
 @PostMapping
 public void postEmployee(@RequestBody Employee employee ) {
  employeeMapper.insertEmployee(employee);
  
 }
 
 @GetMapping
 public List<Employee> selectEmployee(){
  return employeeMapper.selectEmployee();
 }
 
 @PutMapping()
 public int updateEmployee(@Param("id") int id,@RequestBody Employee employee ) {
	 return employeeMapper.updateEmployee(id, employee); 
 }
 
 @DeleteMapping
 public void deleteEmployee(@Param("id") int id) {
	 employeeMapper.deleteEmployee(id);
 }
}
