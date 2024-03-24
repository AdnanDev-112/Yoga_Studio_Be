package com.enterprise.YogaStudio.service.impl;

import com.enterprise.YogaStudio.dto.StudioInsightsDTO;
import com.enterprise.YogaStudio.model.Studio;
import com.enterprise.YogaStudio.repository.StudioRepository;
import com.enterprise.YogaStudio.service.StudioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;



@Service
@Transactional
public class StudioServiceImpl implements StudioService {

    @Autowired
    private StudioRepository studioRepository;

    public List<Studio> getStudioDetails() {
        return studioRepository.findAll();
    }

    @Override
    public Studio getStudioById(Integer id) {
        return studioRepository.findById(id).orElse(null);
    }

    @Override
    public StudioInsightsDTO getStudiodInsights(Integer id) {
        List<StudioInsightsDTO> hardcodedInsights = new ArrayList<>();
        hardcodedInsights.add(new StudioInsightsDTO(1, 4, 6, 10, 2000.0));
        hardcodedInsights.add(new StudioInsightsDTO(2, 9, 7, 17, 1500.0));
        hardcodedInsights.add(new StudioInsightsDTO(3, 30, 9, 20, 2500.0));
        hardcodedInsights.add(new StudioInsightsDTO(4, 25, 1, 19, 3000.0));
        hardcodedInsights.add(new StudioInsightsDTO(5, 60, 3, 25, 5000.0));
        hardcodedInsights.add(new StudioInsightsDTO(6, 59, 6, 35, 8000.0));
        hardcodedInsights.add(new StudioInsightsDTO(7, 29, 3, 51, 10000.0));
        hardcodedInsights.add(new StudioInsightsDTO(8, 33, 9, 89, 15000.0));
        hardcodedInsights.add(new StudioInsightsDTO(9, 54, 3, 54, 20000.0));
        hardcodedInsights.add(new StudioInsightsDTO(10, 79, 3, 32, 30000.0));
        for (StudioInsightsDTO insights : hardcodedInsights) {
            if (insights.getStudioId().equals(id)) {
                return convertToDto(insights);
            }
        }
        return null;
    }

    private StudioInsightsDTO convertToDto(StudioInsightsDTO insights) {
        StudioInsightsDTO dto = new StudioInsightsDTO();
        dto.setStudioId(insights.getStudioId());
        dto.setTotalClasses(insights.getTotalClasses());
        dto.setWaitingList(insights.getWaitingList());
        dto.setTotalBookings(insights.getTotalBookings());
        dto.setRevenue(insights.getRevenue());
        return dto;
    }

        }