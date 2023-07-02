package com.example.UniversityEventManagement.repository;

import com.example.UniversityEventManagement.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface EventRepo extends JpaRepository<Event, Integer> {
    List<Event> findAllByDate(Date data);
}
