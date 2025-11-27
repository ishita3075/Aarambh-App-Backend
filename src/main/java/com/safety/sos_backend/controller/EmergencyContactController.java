package com.safety.sos_backend.controller;

import com.safety.sos_backend.entity.EmergencyContact;
import com.safety.sos_backend.repo.EmergencyContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")              // 👈 base path is now /api
@CrossOrigin("*")
public class EmergencyContactController {

    @Autowired
    private EmergencyContactRepository repo;

    // GET  /api/contacts
    @GetMapping("/contacts")
    public List<EmergencyContact> getAllContacts() {
        return repo.findAll();
    }

    // POST /api/contacts
    @PostMapping("/contacts")
    public EmergencyContact addContact(@RequestBody EmergencyContact contact) {
        return repo.save(contact);
    }
}
