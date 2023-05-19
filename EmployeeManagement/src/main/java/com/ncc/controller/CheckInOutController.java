package com.ncc.controller;

import com.ncc.dto.CheckInOutRequest;
import com.ncc.service.ICheckInOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class CheckInOutController {

    @Autowired
    private ICheckInOutService checkInOutService;

    @PostMapping("/checkin")
    public void checkIn(@RequestBody CheckInOutRequest request){
        checkInOutService.checkIn(request.getId());
    }
}
