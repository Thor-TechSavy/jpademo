package com.practice.jpa.jpademo.repositories;

import com.practice.jpa.jpademo.model.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * created by techSavyThor on 03/31/2019
 */
public interface AuthorRepository extends CrudRepository<Author,Long> {
}