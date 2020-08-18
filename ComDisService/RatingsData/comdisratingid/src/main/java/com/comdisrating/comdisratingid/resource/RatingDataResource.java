package com.comdisrating.comdisratingid.resource;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import com.comdisrating.comdisratingid.models.Rating;
import com.comdisrating.comdisratingid.models.UserRating;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
public class RatingDataResource {
    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId){
        return new Rating(movieId,4);
    }

    @RequestMapping("/users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId){
        List <Rating> ratings = Arrays.asList(
         new Rating("1224", 4),
         new Rating("5567", 3)   
        );
        UserRating userRating = new UserRating();
        userRating.setUserRating(ratings);
        return userRating;
    }
}