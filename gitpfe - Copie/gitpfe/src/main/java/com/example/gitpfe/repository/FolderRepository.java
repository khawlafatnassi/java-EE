/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.gitpfe.repository;

import com.example.gitpfe.model.Folder;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author khali
 */
public interface FolderRepository extends CrudRepository<Folder, Long> {
    
}
