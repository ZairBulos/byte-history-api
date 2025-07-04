package com.bytehistory.services;

import com.bytehistory.api.dtos.TechMilestoneResponse;
import com.bytehistory.data.entities.TechMilestone;
import com.bytehistory.data.repositories.TechMilestoneRepository;
import com.bytehistory.services.exceptions.NotFoundException;
import com.bytehistory.utils.DateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TechMilestoneService {
    private final TechMilestoneRepository repository;

    public TechMilestoneResponse get() {
        TechMilestone milestone = repository
                .findTodayMilestone()
                .orElseThrow(NotFoundException::new);

        return new TechMilestoneResponse(
                milestone.getMilestone(),
                milestone.getAiModel(),
                DateUtils.getCurrentDate()
        );
    }
}
