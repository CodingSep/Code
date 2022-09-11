package com.jpmc.theater.repository;

import com.jpmc.theater.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieJPA extends JpaRepository<Movie,Long>{

}
