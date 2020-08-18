package com.comdisrating.comdisratingid.models;

import java.util.List;
import com.comdisrating.comdisratingid.models.Rating;
public class UserRating {
    private List<Rating> UserRating;

    public List<Rating> getUserRating() {
        return UserRating;
    }

    public void setUserRating(List<Rating> userRating) {
        this.UserRating = userRating;
    }
}