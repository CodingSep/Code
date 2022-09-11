package com.jpmc.theater.repository;

import com.jpmc.theater.model.Showing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowingJPA extends JpaRepository<Showing, Long> {
}
