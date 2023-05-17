package com.ncc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ncc.entity.User;
import com.ncc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "user")
    public ResponseEntity<?> getAndSaveListUser() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "http://stg-api-hrmv2.nccsoft.vn/api/services/app/CheckIn/GetUserForCheckIn";
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
        List<String> rs = Collections.singletonList(response.getBody());
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(response.getBody());
        JsonNode resultNode = rootNode.get("result");
        List<User> users = mapper.readValue(resultNode.toString(), new TypeReference<List<User>>(){});
        for(User user : users){
            System.out.println(user);
        }


        userService.saveUser(users);

        return new ResponseEntity<>("luu thanh cong", HttpStatus.OK);
    }
}
