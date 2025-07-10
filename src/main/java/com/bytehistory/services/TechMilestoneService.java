package com.bytehistory.services;

import com.bytehistory.api.dtos.TechMilestoneResponse;
import com.bytehistory.data.repositories.TechMilestoneRepository;
import com.bytehistory.services.exceptions.NotFoundException;
import com.bytehistory.utils.DateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TechMilestoneService {
    private final TechMilestoneRepository repository;

    @Cacheable("techMilestone")
    @Transactional(readOnly = true)
    public TechMilestoneResponse get() {
        return repository.findTodayMilestone()
                .map(m -> new TechMilestoneResponse(m.getMilestone(), m.getAiModel(), DateUtils.getCurrentDate()))
                .orElseThrow(NotFoundException::new);
    }
}
