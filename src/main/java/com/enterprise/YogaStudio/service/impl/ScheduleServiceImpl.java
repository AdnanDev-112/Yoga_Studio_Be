package com.enterprise.YogaStudio.service.impl;

import com.enterprise.YogaStudio.model.Client;
import com.enterprise.YogaStudio.model.Discount;
import com.enterprise.YogaStudio.model.Schedule;
import com.enterprise.YogaStudio.repository.ClientRepository;
import com.enterprise.YogaStudio.repository.ScheduleRepository;
import com.enterprise.YogaStudio.service.DiscountService;
import com.enterprise.YogaStudio.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private DiscountService discountService;


    // Calculate the discounted price
    public BigDecimal calculateDiscountedPrice(BigDecimal originalPrice, BigDecimal discountPercent) {
    return originalPrice.multiply(BigDecimal.ONE.subtract(discountPercent.divide(new BigDecimal("100"))));

}
    public List<Schedule> getBookingsByCategoryType(String categoryType , String clientID){
        List<Schedule> scheduleList =  scheduleRepository.findByCategoryType(categoryType);

        Client client = clientRepository.findById(Integer.parseInt(clientID)).orElse(null);
        List<Discount> discounts = discountService.getDiscountList();

        LocalDate dob = client.getDob();
        LocalDate today = LocalDate.now();


        int age = 0;
        if(dob != null  ){
            Period period = Period.between(dob, today);
            age = period.getYears();
            System.out.println("Age is " + age);
        }



        if(categoryType.equals("course")){
            for (int i = 0 ; i < scheduleList.size() ; i++){
                Schedule oneSchedule = scheduleList.get(i);
                BigDecimal amount =  oneSchedule.getCourse().getPricing().getAmount();

                for (Discount discount : discounts){
                    if(age >= discount.getMinAge() && age <= discount.getMaxAge()){
                        BigDecimal originalPrice = new BigDecimal(String.valueOf(amount)); // Replace with your original price
                        BigDecimal discountPercent = new BigDecimal(discount.getDiscountValue()); // Replace with your discount percentage
                        BigDecimal discountedPrice = calculateDiscountedPrice(originalPrice, discountPercent);
//                        System.out.println("Discounted price: " + discountedPrice);
                        oneSchedule.getCourse().getPricing().setDiscountAppliedPrice(discountedPrice);
                        oneSchedule.getCourse().getPricing().setDiscountId(discount.getId());
                    }
                }

            }


        };


        return scheduleList;
    }

}

