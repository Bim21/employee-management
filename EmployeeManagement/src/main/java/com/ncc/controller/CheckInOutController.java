package com.ncc.controller;

import com.ncc.dto.CheckInOutDTO;
import com.ncc.dto.CheckInOutRequest;
import com.ncc.service.CheckInOutService;
import com.ncc.service.ICheckInOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/checkin")
public class CheckInOutController {

    private final CheckInOutService checkInOutService;

    @Autowired
    public CheckInOutController(CheckInOutService checkInOutService) {
        this.checkInOutService = checkInOutService;
    }

    @PostMapping("/{checkInCode}/checkin")
    public CheckInOutDTO checkin(@PathVariable String checkInCode){
        return checkInOutService.checkIn(checkInCode);
    }
    @PostMapping("/{checkInCode}/checkout")
    public CheckInOutDTO checkout(@PathVariable String checkInCode){
        return checkInOutService.checkOut(checkInCode);
    }
}
