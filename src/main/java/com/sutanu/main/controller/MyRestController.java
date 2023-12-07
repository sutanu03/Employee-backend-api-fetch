package com.sutanu.main.controller;

import com.sutanu.main.model.Employee;
import com.sutanu.main.repository.EmployeeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class MyRestController {

 @Autowired
 private EmployeeRepo employeeRepository;

 @PostMapping("/add")
 public Employee createEmployee(@RequestBody Employee employee) {
     return employeeRepository.save(employee);
 }

 @GetMapping("/viewAll")
 public List<Employee> getAllEmployees() {
     return employeeRepository.findAll();
 }

 @GetMapping("/view/{id}")
 public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
     Optional<Employee> optionalEmployee = employeeRepository.findById(id);
     return optionalEmployee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
 }

 @PutMapping("/update/{id}")
 public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
     Optional<Employee> optionalEmployee = employeeRepository.findById(id);
     if (optionalEmployee.isPresent()) {
         Employee existingEmployee = optionalEmployee.get();
         existingEmployee.setFirstName(updatedEmployee.getFirstName());
         existingEmployee.setCity(updatedEmployee.getCity());
         employeeRepository.save(existingEmployee);
         return ResponseEntity.ok(existingEmployee);
     } else {
         return ResponseEntity.notFound().build();
     }
 }

 @DeleteMapping("/delete/{id}")
 public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
     Optional<Employee> optionalEmployee = employeeRepository.findById(id);
     if (optionalEmployee.isPresent()) {
         employeeRepository.deleteById(id);
         return ResponseEntity.noContent().build();
     } else {
         return ResponseEntity.notFound().build();
     }
 }
}
