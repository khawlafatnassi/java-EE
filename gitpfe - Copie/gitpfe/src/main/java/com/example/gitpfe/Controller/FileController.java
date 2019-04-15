package com.example.gitpfe.Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.example.gitpfe.exception.ResourceNotFoundException;
import com.example.gitpfe.model.File;
import com.example.gitpfe.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@RestController
@Transactional
@RequestMapping("/api")
@CrossOrigin(origins = "localhost", maxAge = 3600)

public class FileController {

    @Autowired
    FileRepository fileRepository;

    // Get All Files
@GetMapping("/file")
public List<File> getFiles() {
    return (List<File>) fileRepository.findAll();
}
// Create a new File
@PostMapping("/files")
public File createFile(@Valid @RequestBody File file) {
    return fileRepository.save(file);
}

// Get a Single File
@GetMapping("/files/{id}")
public File getFileById(@PathVariable(value = "id") Long fileId) {
    return fileRepository.findById(fileId)
            .orElseThrow(() -> new ResourceNotFoundException("File", "id", fileId));
}
    // Update a File

// Delete a File
@DeleteMapping("/files/{id}")
public ResponseEntity<?> deleteFile(@PathVariable(value = "id") Long fileId) {
    File file = fileRepository.findById(fileId)
            .orElseThrow(() -> new ResourceNotFoundException("File", "id", fileId));

    fileRepository.delete(file);

    return ResponseEntity.ok().build();
}
}