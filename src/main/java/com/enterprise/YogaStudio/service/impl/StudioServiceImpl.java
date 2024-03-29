//package com.enterprise.YogaStudio.service.impl;
//
//import com.enterprise.YogaStudio.repository.ManagerRepository;
//import com.enterprise.YogaStudio.repository.StudioRepository;
//import com.enterprise.YogaStudio.service.StudioService;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//import org.springframework.web.server.ResponseStatusException;
//import java.util.List;
//
//
//@Service
//@Transactional
//public class StudioServiceImpl implements StudioService {
//
//    @Autowired
//    private StudioRepository studioRepository;
//
//    @Autowired
//    private ManagerRepository managerRepository;
//
//    @Override
//    public Studio addStudioDetails(Studio studio) {
//        return studioRepository.save(studio);
//    }
//
//    @Override
//    public List<Studio> getStudioDetails() {
//        return studioRepository.findAll();
//    }
//
//    @Override
//    public Studio getStudioIDDetails(Integer studioID) {
//        Studio studio = studioRepository.findById(studioID).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Studio ID not found. " + studioID));
//        return studio;
//    }
//
////    @Override
////    public void updateStudioID(Integer studioID, Studio studio) {
////        Studio existingStudio = studioRepository.findById(studioID).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid studio ID." + studioID));
////        existingStudio.setAddress(studio.getAddress());
////        existingStudio.setTelnum(studio.getTelnum());
////        existingStudio.setManager(studio.getManager());
////        // Update any other fields as needed
////        studioRepository.save(existingStudio);
////    }
//
//    @Override
//    public void deleteStudioId(Integer studioID) {
//        Studio studio=  studioRepository.findById(studioID).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid studio ID." + studioID));
//        studioRepository.delete(studio);
//    }
//
//    @Override
//    public void updateStudioAndManager(Integer studioId, UpdateStudioDetails updateStudioDetails) {
//
////            // 1. Retrieve Studio (Handle potential null case)
////            Studio studio = studioRepository.findById(studioId)
////                    .orElseThrow(() -> new RuntimeException("Studio with ID: " + studioId + " not found"));
////
////            // 2. Check if retrieved studio is not null before updating properties
////            if (studio != null) {
////                studio.updateFrom(updateStudioDetails.getStudio());  // Assuming updateFrom method in Studio
////            }
////
////            // 3. Retrieve Manager (Handle potential null case using Optional)
////            Optional<Manager> optionalManager = managerRepository.findById(updateStudioDetails.getManager().getManagerId());
////
////            // Check if manager is present and handle the case if not found
////            if (optionalManager.isPresent()) {
////                Manager existingManager = optionalManager.get();
////                existingManager.updateFrom(updateStudioDetails.getManager());  // Assuming updateFrom method in Manager
////            } else {
////                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Manager not found");
////            }
////
////            // Save (merge) the updated entities within the transaction
////            studioRepository.save(studio);
////
////            // Only save manager if it was retrieved successfully
////            if (optionalManager.isPresent()) {
////                managerRepository.save(optionalManager.get());
////            }
//    }
//
//}