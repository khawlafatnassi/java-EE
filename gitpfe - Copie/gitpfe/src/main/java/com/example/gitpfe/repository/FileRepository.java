/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.gitpfe.repository;

import com.example.gitpfe.model.File;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author khali
 */
public interface FileRepository extends CrudRepository<File, Long> {
    
}
