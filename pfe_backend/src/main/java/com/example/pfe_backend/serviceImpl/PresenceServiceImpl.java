package com.example.pfe_backend.serviceImpl;

import com.example.pfe_backend.model.Presence;
import com.example.pfe_backend.repository.PresenceRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class PresenceServiceImpl {
    @Autowired
    private PresenceRepo presenceRepo;

    public void savePresencesToDatabase(MultipartFile file) {
        if (ExcelUploadService.isValidExcelFile(file)) {
            try {
                List<Presence> presences = ExcelUploadService.getPresencesDataFromExcel(file.getInputStream());
                if (presences != null && !presences.isEmpty()) {
                    presenceRepo.saveAll(presences); // Save the data to the database
                    System.out.println("Data saved to database successfully.");
                } else {
                    System.out.println("No valid data found to save.");
                }
            } catch (IOException e) {
                throw new IllegalArgumentException("The file is not a valid excel file", e);
            }
        } else {
            throw new IllegalArgumentException("Invalid file type. Please upload an Excel file.");
        }
    }

    public List<Presence> getAllPresences() {
        return presenceRepo.findAll();
    }
}
