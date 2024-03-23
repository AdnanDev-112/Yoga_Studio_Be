package com.enterprise.YogaStudio.controller;

import com.enterprise.YogaStudio.model.PendingList;
import com.enterprise.YogaStudio.service.PendingListService;
import com.enterprise.YogaStudio.service.WaitingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pendinglist")
@CrossOrigin(origins = "http://localhost:3000")
public class PenidngListController {
    @Autowired
    private PendingListService pendingListService;
    @Autowired
    private WaitingListService waitingListService;



    @GetMapping("/getbyclientid/{clientId}")
    public List<PendingList> getPendingListByClientId(@PathVariable Integer clientId) {
        return pendingListService.getPendingListByClientId(clientId);
    }

    @PutMapping("/cancelbooking/{id}")
    public void cancelBooking(@PathVariable Integer id) {
        waitingListService.moveFirstout(id);
    }
}


//getPendingListByClientId