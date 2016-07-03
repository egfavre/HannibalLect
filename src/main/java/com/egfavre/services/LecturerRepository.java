package com.egfavre.services;

import com.egfavre.entitites.Lecturer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by user on 7/1/16.
 */
public interface LecturerRepository extends CrudRepository<Lecturer, Integer> {
}
