package com.ncc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ncc.dto.EmployeeDTO;
import com.ncc.entity.Employee;
<<<<<<< HEAD
=======
import com.ncc.form.EmployeeCreateForm;
import com.ncc.form.EmployeeUpdateForm;
>>>>>>> a6e0e48575538adf49a80e58ef09647b5a4b563b
import com.ncc.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final IEmployeeService employeeService;

    @Autowired
    public EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Autowired
    private MessageSource messageSource;

    @Value("${hrm.api.url}")
    private String hrmApiUrl;
    @GetMapping(value = "/employee")
    public ResponseEntity<?> getAndSaveListUser() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = hrmApiUrl;
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
        List<String> rs = Collections.singletonList(response.getBody());
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(response.getBody());
        JsonNode resultNode = rootNode.get("result");
        List<Employee> employees = mapper.readValue(resultNode.toString(), new TypeReference<List<Employee>>(){});
        for(Employee employee : employees){
            System.out.println(employee);
        }

        employeeService.saveUser(employees);

        String successMessage = messageSource.getMessage("save.success", null, Locale.getDefault());
        return new ResponseEntity<>(successMessage, HttpStatus.OK);
    }

    @PostMapping
<<<<<<< HEAD
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.createEmployee(employeeDTO);
    }


    @PutMapping("/{id}")
    public EmployeeDTO updateEmployee(@PathVariable("id") int id, @RequestBody EmployeeDTO employeeDTO){
        employeeDTO.setId(id);
        return employeeService.updateEmployee(employeeDTO);
=======
    public void createEmployee(@RequestBody EmployeeCreateForm form){
        employeeService.createEmployee(form);
    }

    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable("id") int id, @RequestBody EmployeeUpdateForm form){
        form.setId(id);
        employeeService.updateEmployee(form);
>>>>>>> a6e0e48575538adf49a80e58ef09647b5a4b563b
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeById(@PathVariable int id){
        employeeService.deleteEmployeeById(id);
    }
<<<<<<< HEAD

    @GetMapping("/search")
    public List<EmployeeDTO> searchEmployeesByName(@RequestParam("keyword") String keyword) {
        return employeeService.searchEmployeesByName(keyword);
    }

    @GetMapping("/checkin-records")
    public List<EmployeeDTO> getAllEmployeesWithCheckinCheckoutRecords(@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                                       @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return employeeService.getAllEmployeesWithCheckinCheckoutRecords(startDate, endDate);
    }

    @GetMapping("/checkin-errors")
    public List<EmployeeDTO> getEmployeesWithCheckinErrorsInMonth(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return employeeService.getEmployeesWithCheckinErrorsInMonth(date);
    }
=======
>>>>>>> a6e0e48575538adf49a80e58ef09647b5a4b563b
}
