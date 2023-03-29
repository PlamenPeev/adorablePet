package com.example.adorablepet;

import com.example.adorablepet.repository.PetRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Component
@Transactional
public class OldDataCleanupTask {

    private final PetRepository petRepository;

    public OldDataCleanupTask(PetRepository petRepository) {
        this.petRepository = petRepository;
    }


    @Scheduled(cron = "0 0 0 * * *")
    public void cleanupOldData() {
        LocalDate thresholdDate = LocalDate.now();
        petRepository.deleteByDateBefore(thresholdDate);
    }
}
