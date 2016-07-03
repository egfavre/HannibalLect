package com.egfavre.services;

import com.egfavre.entitites.Lecturer;
import com.egfavre.entitites.Review;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by user on 7/1/16.
 */
public interface ReviewRepository extends CrudRepository<Review, Integer> {
    public Iterable<Review> findByLecturer(Lecturer lecturer);
}
