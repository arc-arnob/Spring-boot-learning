package com.comdis.catalogd.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.comdis.catalogd.models.*;
@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
    
    @Autowired
    public RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String id){

        // // Let this be dummy response
        // List <Rating> ratings = Arrays.asList(
        //  new Rating("1224", 4),
        //  new Rating("5567", 3)   
        // );
        UserRating ratings = restTemplate.getForObject("http://rating-resource-service/ratings/users/"+ id ,UserRating.class);

        return ratings.getUserRating().stream().map(rating -> {
            Movie movie = restTemplate.getForObject("http://movie-info-api/movies/"+rating.getMovieId(), Movie.class);
            return new CatalogItem(movie.getName(), "hardcoded", rating.getRating());
        }).collect(Collectors.toList());
    }
}