package com.example.UniversityEventManagement.service;

import com.example.UniversityEventManagement.model.Event;
import com.example.UniversityEventManagement.repository.EventRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepo eventRepo;

    public ResponseEntity<String> saveEvent(Event event) {
        eventRepo.save(event);
        return new ResponseEntity<>("event Saved Successfully", HttpStatus.CREATED);
    }

    public ResponseEntity<Event> updateEvent(Event eventNew, int eventId) {
        Event event = eventRepo.findById(eventId).get();
        event.setEventName(eventNew.getEventName());
        event.setLocationOfEvent(eventNew.getLocationOfEvent());
        event.setStartTime(eventNew.getStartTime());
        event.setEndTime(eventNew.getEndTime());
        eventRepo.save(event);
        return new ResponseEntity<>(event, HttpStatus.ACCEPTED);
    }

    public ResponseEntity<List<Event>> getEventByDate(String date) throws ParseException {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Date Date = (java.sql.Date) format.parse(date);
        List<Event> Events = eventRepo.findAllByDate(Date);
        return new ResponseEntity<>(Events, HttpStatus.OK);
    }

    public ResponseEntity<String> deleteEvent(int eventId) {
        if (eventRepo.existsById(eventId)) {
            eventRepo.deleteById(eventId);
            return new ResponseEntity<>("Event is deleted Successfully", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("Event with the followig if Not found", HttpStatus.NOT_FOUND);
    }
}
