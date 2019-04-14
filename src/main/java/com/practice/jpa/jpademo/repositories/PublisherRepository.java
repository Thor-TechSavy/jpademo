package com.practice.jpa.jpademo.repositories;

import com.practice.jpa.jpademo.model.Publisher;
import org.springframework.data.repository.CrudRepository;
/**
 * created by techSavyThor on 3/31/2019
 */
public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
