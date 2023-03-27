package com.example.adorablepet;

import com.example.adorablepet.repository.PetRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class OldDataCleanupTask {

    private final PetRepository petRepository;

    public OldDataCleanupTask(PetRepository petRepository) {
        this.petRepository = petRepository;
    }


    @Scheduled(cron = "0 0 0 * * *")
    public void cleanupOldData() {
        LocalDate thresholdDate = LocalDate.now().minusMonths(3);
        petRepository.deleteByDateBefore(thresholdDate);
    }
}
