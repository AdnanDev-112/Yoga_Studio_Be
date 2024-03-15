//package com.enterprise.YogaStudio.controller;
//
//import com.enterprise.YogaStudio.service.StudioService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/studio")
//public class StudioController {
//
//    @Autowired
//    private StudioService studioService;
//
//    @GetMapping("/getstudiodetails")
//    public List<Studio> getStudioDetails(){
//        return studioService.getStudioDetails();
//    }
//
//    @GetMapping("/getid/{studioID}")
//    public Studio getStudioIDDetails(@PathVariable Integer studioID){
//        return studioService.getStudioIDDetails(studioID);
//    }
//
//    @PostMapping("/addDetails")
//    public Studio saveStudioDetails(@RequestBody Studio studioModel){
//        return studioService.addStudioDetails(studioModel);
//    }
//
//    @PutMapping("/update/{studioID}")
//    public ResponseEntity<Void> updateStudioAndManager(@PathVariable Integer studioID, @RequestBody UpdateStudioDetails updateStudioDetails){
//        studioService.updateStudioAndManager(studioID, updateStudioDetails);
//        return ResponseEntity.noContent().build();
//    }
//
//    @DeleteMapping("/delete/{studioID}")
//    public ResponseEntity<Void> deleteStudioId(@PathVariable Integer studioID){
//        studioService.deleteStudioId(studioID);
//        return ResponseEntity.noContent().build();
//    }
//
//
////@PutMapping("/update/{studioID}")
////public ResponseEntity<Void> updateStudio(@PathVariable Integer studioID, @RequestBody UpdateStudioRequest updateRequest) {
////    studioService.updateStudioAndManager(studioID, updateRequest.getStudio(), updateRequest.getManager());
////    return ResponseEntity.noContent().build();
////}
//
//}
//
//
//
//
