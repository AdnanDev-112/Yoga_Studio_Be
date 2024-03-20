package com.enterprise.YogaStudio.service;

import com.enterprise.YogaStudio.model.Pricing;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public interface PricingService {

    public Pricing addPricingDetails(Pricing pricingModel);

    public Pricing getPricingById(Integer pricingID);

    public List<Pricing> getPricingDetails();


    public Pricing validateAmountExists(BigDecimal amount);
}
