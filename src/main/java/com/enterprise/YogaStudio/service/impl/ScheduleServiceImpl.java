package com.enterprise.YogaStudio.service.impl;

import com.enterprise.YogaStudio.model.Client;
import com.enterprise.YogaStudio.model.Discount;
import com.enterprise.YogaStudio.model.Schedule;
import com.enterprise.YogaStudio.repository.ClientRepository;
import com.enterprise.YogaStudio.repository.ScheduleRepository;
import com.enterprise.YogaStudio.service.DiscountCalculationService;
import com.enterprise.YogaStudio.service.DiscountService;
import com.enterprise.YogaStudio.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private DiscountService discountService;

    @Autowired
    private DiscountCalculationService discountCalculationService;


    // Calculate the discounted price

    public List<Schedule> getBookingsByCategoryType(String categoryType, String clientID) {
        List<Schedule> scheduleList = scheduleRepository.findByCategoryType(categoryType);

        Client client = clientRepository.findById(Integer.parseInt(clientID)).orElse(null);
        List<Discount> discounts = discountService.getDiscountList();

        LocalDate dob = client.getDob();

        int age = discountCalculationService.calculateAge(dob);
        System.out.println("Age is " + age);


        if (categoryType.equals("course")) {
            for (int i = 0; i < scheduleList.size(); i++) {
                Schedule oneSchedule = scheduleList.get(i);
                BigDecimal amount = oneSchedule.getCourse().getPricing().getAmount();

                Discount applicableDiscount = discountCalculationService.getApplicableDiscount(age, discounts);
                BigDecimal originalPrice = new BigDecimal(String.valueOf(amount));
                BigDecimal discountPercent = new BigDecimal(applicableDiscount.getDiscountValue());
                BigDecimal discountedPrice = discountCalculationService.calculateDiscountedPrice(originalPrice, discountPercent);
                oneSchedule.getCourse().getPricing().setDiscountAppliedPrice(discountedPrice);
                oneSchedule.getCourse().getPricing().setDiscountId(applicableDiscount.getId());


            }


        }
        ;


        return scheduleList;
    }

}

