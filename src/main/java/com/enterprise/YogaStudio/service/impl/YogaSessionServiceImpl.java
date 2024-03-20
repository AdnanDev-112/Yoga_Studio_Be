package com.enterprise.YogaStudio.service.impl;

import com.enterprise.YogaStudio.model.Instructor;
import com.enterprise.YogaStudio.model.Pricing;
import com.enterprise.YogaStudio.model.Studio;
import com.enterprise.YogaStudio.model.YogaSession;
import com.enterprise.YogaStudio.repository.YogaSessionRepository;
import com.enterprise.YogaStudio.service.InstructorService;
import com.enterprise.YogaStudio.service.PricingService;
import com.enterprise.YogaStudio.service.StudioService;
import com.enterprise.YogaStudio.service.YogaSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;

@Service
public class YogaSessionServiceImpl implements YogaSessionService {

    @Autowired
    private YogaSessionRepository yogaSessionRepository;


    @Autowired
    private StudioService studioService;


    @Autowired
    private InstructorService instructorService;


    @Autowired
    private PricingService pricingService;


    @Override
    public List<YogaSession> getYogaSession() {
        return yogaSessionRepository.findAll();
    }

    @Override
    public void addYogaSession(YogaSession yogaSession) {
        Studio studio = studioService.getStudioById(Integer.valueOf(yogaSession.getStudioId()));
        Instructor instructor = instructorService.getInstructorById(Integer.valueOf(yogaSession.getInstructorId()));

        String priceFromForm = yogaSession.getPrice();
        BigDecimal priceFromFormDecimal = new BigDecimal(priceFromForm);
        Pricing pricing =  pricingService.validateAmountExists(priceFromFormDecimal);

        yogaSession.setStudio(studio);
        yogaSession.setPricing(pricing);
        yogaSession.setInstructor(instructor);
        yogaSessionRepository.save(yogaSession);
    }

    private <T> T getEntityById(Object id, Function<Integer, T> fetchEntityFunction) {
    Integer entityId = null;
    if (id instanceof String) {
        entityId = Integer.valueOf((String) id);
    } else if (id instanceof Integer) {
        entityId = (Integer) id;
    }
    return entityId != null ? fetchEntityFunction.apply(entityId) : null;
}

    @Override
    public YogaSession getYogaSessionById(Integer id) {
        return yogaSessionRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteYogaSession(Integer id) {
        yogaSessionRepository.deleteById(id);
    }
    @Override
    public YogaSession updateYogaSession(Integer id, YogaSession yogaSessionDetails) {
        return yogaSessionRepository.findById(id).map(yogaSession -> {

            Studio studio = getEntityById(yogaSessionDetails.getStudioId(), studioService::getStudioById);
            Instructor instructor = getEntityById(yogaSessionDetails.getInstructorId(), instructorService::getInstructorById);


            String priceFromForm = yogaSessionDetails.getPrice();
            BigDecimal priceFromFormDecimal = new BigDecimal(priceFromForm);
            Pricing pricing =  pricingService.validateAmountExists(priceFromFormDecimal);

//                    FKS
            yogaSession.setInstructor(instructor);
            yogaSession.setStudio(studio);
            yogaSession.setPricing(pricing);
            yogaSession.setSessionName(yogaSessionDetails.getSessionName());

            yogaSession.setDuration(yogaSessionDetails.getDuration());
            yogaSession.setLevel(yogaSessionDetails.getLevel());
            yogaSession.setActivityType(yogaSessionDetails.getActivityType());

            return yogaSessionRepository.save(yogaSession);
        }).orElse(null);
    }
}


//
//
//@Override
//public YogaSession updateYogaSession(Integer id, YogaSession yogaSessionDetails) {
//    return yogaSessionRepository.findById(id)
//            .map(yogaSession -> {
//                // ... existing code ...
//
//                BigDecimal newPrice = new BigDecimal(yogaSessionDetails.getPrice());
//                Pricing existingPricing = pricingService.getPricingById(yogaSession.getPricing().getId());
//
//                if (existingPricing.getAmount().compareTo(newPrice) != 0) {
//                    Pricing newPricing = new Pricing();
//                    newPricing.setAmount(newPrice);
//                    newPricing.setLevel(yogaSessionDetails.getLevel());
//                    newPricing.setType("yoga_session");
//                    Pricing savedPrice = pricingService.addPricingDetails(newPricing);
//                    yogaSession.setPricing(savedPrice);
//                }
//
//                // ... existing code ...
//
//                return yogaSessionRepository.save(yogaSession);
//            })
//            .orElse(null);
//}
//
//@Override
//public void addYogaSession(YogaSession yogaSession) {
//    BigDecimal newPrice = new BigDecimal(yogaSession.getPrice());
//    Pricing existingPricing = pricingService.getPricingByAmount(newPrice);
//
//    if (existingPricing == null) {
//        Pricing pricing = new Pricing();
//        pricing.setAmount(newPrice);
//        pricing.setLevel(yogaSession.getLevel());
//        pricing.setType("yoga_session");
//        Pricing savedPrice = pricingService.addPricingDetails(pricing);
//        yogaSession.setPricing(savedPrice);
//    } else {
//        yogaSession.setPricing(existingPricing);
//    }
//
//    // ... existing code ...
//
//    yogaSessionRepository.save(yogaSession);
//}
