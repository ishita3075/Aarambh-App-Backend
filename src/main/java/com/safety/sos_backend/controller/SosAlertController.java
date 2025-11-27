package com.safety.sos_backend.controller;

import com.safety.sos_backend.entity.SosAlert;
import com.safety.sos_backend.repo.SosAlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/sos")
@CrossOrigin("*")
public class SosAlertController {

    @Autowired
    private SosAlertRepository repo;
    @PostMapping("/trigger")
    public SosAlert triggerSOS(@RequestBody SosAlert alert) {
        return repo.save(alert);
    }

    // Update location periodically
    @PostMapping("/update-location")
    public SosAlert updateLocation(@RequestBody SosAlert updatedAlert) {
        Optional<SosAlert> optionalAlert = repo.findById(updatedAlert.getId());

        if (optionalAlert.isPresent()) {
            SosAlert existing = optionalAlert.get();
            existing.setLatitude(updatedAlert.getLatitude());
            existing.setLongitude(updatedAlert.getLongitude());
            existing.setTimestamp(updatedAlert.getTimestamp());
            return repo.save(existing);
        }
        return repo.save(updatedAlert);
    }

    @GetMapping("/all")
    public java.util.List<SosAlert> getAllAlerts() {
        return repo.findAll();
    }
}
