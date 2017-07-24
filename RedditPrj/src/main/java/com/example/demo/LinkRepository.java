package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by student on 6/22/17.
 */
public interface LinkRepository extends CrudRepository< Link, Integer>{

    @Query(value = "select * from link order by time", nativeQuery = true)
    public List<Link> findAllOrderedByTime();

    public List<Link> findAllByUser(String user);

}