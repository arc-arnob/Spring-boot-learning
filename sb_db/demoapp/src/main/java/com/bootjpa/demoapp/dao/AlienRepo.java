package com.bootjpa.demoapp.dao;
import com.bootjpa.demoapp.model.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlienRepo extends JpaRepository<Alien, Integer>{

    List<Alien> findByAtech(String atech);
    List<Alien> findByAidGreaterThan(int aid);

    @Query("from Alien where atech=?1 order by aname")
    List<Alien> findByAtechSorted(String aname);
}