package com.egfavre.controllers;

import com.egfavre.entitites.Lecturer;
import com.egfavre.entitites.Review;
import com.egfavre.services.LecturerRepository;
import com.egfavre.services.ReviewRepository;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 * Created by user on 7/1/16.
 */
@RestController
public class HannibalController {

    @Autowired
    LecturerRepository lecturers;

    @Autowired
    ReviewRepository reviews;

    @PostConstruct
    public void init() throws SQLException {
        Server.createWebServer().start();
    }

    @RequestMapping(path = "/lecturers", method = RequestMethod.GET)
    public Iterable<Lecturer> getLecturer(){
        return lecturers.findAll();
    }

    @RequestMapping(path="/lecturers", method = RequestMethod.POST)
    public void createLecturer (HttpSession session, String name, String topic, String image){
        Lecturer lecturer = new Lecturer(name, topic, image);
        lecturers.save(lecturer);
    }

    @RequestMapping (path = "/reviews?lecturerId=id", method = RequestMethod.GET)
    public Iterable<Review> reviews (HttpSession session, HttpServletRequest request){
        int id = Integer.valueOf(request.getParameter("id"));
        return reviews.findByLecturer(lecturers.findOne(id));
    }

    @RequestMapping(path = "/reviews", method = RequestMethod.POST)
    public void createReview (HttpSession session, String author, String text, Boolean isGood, int lecturerId){
        Review r = new Review(author, text, isGood, lecturers.findOne(lecturerId));
        reviews.save(r);
    }
}
