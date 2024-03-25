package com.enterprise.YogaStudio.controller;


import com.enterprise.YogaStudio.service.WaitingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/waitinglist")
@CrossOrigin(origins = "http://localhost:3000")
public class WaitingListController {
    @Autowired
    private WaitingListService waitingListService;
    @GetMapping("/getwaitinglist")
    public ResponseEntity<List<?>> getAllWaitingLists() {
        List<?> dataToSend = waitingListService.getCustomData();
        return ResponseEntity.ok(dataToSend);
    }
    @GetMapping("/getwaitingliststats/{yogaSessionId}")
    public ResponseEntity<?> getWaitingListStats(@PathVariable Integer yogaSessionId) {
        return ResponseEntity.ok(waitingListService.getWaitingListStats(yogaSessionId));
    }
    @DeleteMapping("/removewaitinglist/{waitingListID}")
    public ResponseEntity<?> removeWaitingList(@PathVariable Integer waitingListID) {
        waitingListService.removeWaitingList(waitingListID);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/approvewaitinglist/{waitingListID}")
    public ResponseEntity<?> approveWaitingList(@PathVariable Integer waitingListID) {
        waitingListService.approveWaitingList(waitingListID);
        return ResponseEntity.ok().build();
    }
}
