package com.example.gitpfe.Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.example.gitpfe.exception.ResourceNotFoundException;
import com.example.gitpfe.model.Folder;
import com.example.gitpfe.repository.FolderRepository;
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

public class FolderController {

    @Autowired
    FolderRepository folderRepository;

    // Get All Folders
@GetMapping("/folder")
public List<Folder> getFolders() {
    return (List<Folder>) folderRepository.findAll();
}
// Create a new Folder
@PostMapping("/folders")
public Folder createFolder(@Valid @RequestBody Folder folder) {
    return folderRepository.save(folder);
}

// Get a Single Folder
@GetMapping("/folders/{id}")
public Folder getFolderById(@PathVariable(value = "id") Long folderId) {
    return folderRepository.findById(folderId)
            .orElseThrow(() -> new ResourceNotFoundException("Folder", "id", folderId));
}
    // Update a Folder

// Delete a Folder
@DeleteMapping("/folders/{id}")
public ResponseEntity<?> deleteFolder(@PathVariable(value = "id") Long folderId) {
    Folder folder = folderRepository.findById(folderId)
            .orElseThrow(() -> new ResourceNotFoundException("Folder", "id", folderId));

    folderRepository.delete(folder);

    return ResponseEntity.ok().build();
}
}