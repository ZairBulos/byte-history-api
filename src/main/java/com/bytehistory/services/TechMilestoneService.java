package com.bytehistory.services;

import com.bytehistory.api.dtos.TechMilestoneResponse;
import com.bytehistory.data.repositories.TechMilestoneRepository;
import com.bytehistory.services.exceptions.NotFoundException;
import com.bytehistory.utils.DateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TechMilestoneService {
    private final TechMilestoneRepository repository;

    @Transactional(readOnly = true)
    public TechMilestoneResponse get() {
        var milestone = repository.findTodayMilestone().orElseThrow(NotFoundException::new);
        return new TechMilestoneResponse(milestone.getMilestone(), milestone.getAiModel(), DateUtils.getCurrentDate());
    }
}
