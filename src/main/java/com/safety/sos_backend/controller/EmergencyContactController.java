package com.safety.sos_backend.controller;

import com.safety.sos_backend.entity.EmergencyContact;
import com.safety.sos_backend.repo.EmergencyContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
@CrossOrigin("*")
public class EmergencyContactController {

    @Autowired
    private EmergencyContactRepository repo;

    // GET  /api/contacts
    @GetMapping
    public List<EmergencyContact> getAllContacts() {
        return repo.findAll();
    }

    // POST /api/contacts
    @PostMapping
    public EmergencyContact addContact(@RequestBody EmergencyContact contact) {
        return repo.save(contact);
    }

    // DELETE /api/contacts/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        if (!repo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
