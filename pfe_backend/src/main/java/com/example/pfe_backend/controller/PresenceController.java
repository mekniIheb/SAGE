package com.example.pfe_backend.controller;

import com.example.pfe_backend.serviceImpl.PresenceServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/api/presences")
public class PresenceController {
    @Autowired
    private  PresenceServiceImpl presenceService;
    @PostMapping("/upload-presences-data")
    public ResponseEntity<?> uploadPresencesData(@RequestParam("file") MultipartFile file) {
        try {
            presenceService.savePresencesToDatabase(file);
            return ResponseEntity.ok(Map.of("Message", "Presences data uploaded and saved to database successfully"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("Error", e.getMessage()));
        }
    }

}
