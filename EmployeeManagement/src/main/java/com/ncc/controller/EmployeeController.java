package com.ncc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ncc.entity.Employee;
import com.ncc.form.EmployeeCreateForm;
import com.ncc.form.EmployeeUpdateForm;
import com.ncc.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

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
    public void createEmployee(@RequestBody EmployeeCreateForm form){
        employeeService.createEmployee(form);
    }

    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable("id") int id, @RequestBody EmployeeUpdateForm form){
        form.setId(id);
        employeeService.updateEmployee(form);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeById(@PathVariable int id){
        employeeService.deleteEmployeeById(id);
    }
}
