package com.enterprise.YogaStudio.service.impl;

import com.enterprise.YogaStudio.model.Pricing;
import com.enterprise.YogaStudio.repository.PriceRepository;
import com.enterprise.YogaStudio.service.PricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PricingServiceImpl implements PricingService {
    @Autowired
    private PriceRepository pricingRepository;
    @Override
    public Pricing addPricingDetails(Pricing pricingModel) {
        return pricingRepository.save(pricingModel);
    }
    public Pricing getPricingById(Integer pricingID) {
        return pricingRepository.findById(pricingID).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pricing ID not found. " + pricingID));
    }
    @Override
    public List<Pricing> getPricingDetails() {
        return pricingRepository.findAll();
    }
    public Pricing validateAmountExists(BigDecimal amount) {
        List<Pricing> pricingList = pricingRepository.findAll();

        Pricing newPricing = null;
        for (Pricing pricing : pricingList) {
            if (pricing.getAmount().compareTo(amount) == 0) {
                newPricing = pricing;
            }
        }
        if(newPricing == null){
            newPricing = new Pricing();
            newPricing.setAmount(amount);
            newPricing = addPricingDetails(newPricing);
        }
        return  newPricing;
    }
}
