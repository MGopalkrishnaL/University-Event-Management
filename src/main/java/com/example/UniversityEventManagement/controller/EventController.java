package com.example.UniversityEventManagement.controller;

import com.example.UniversityEventManagement.model.Event;
import com.example.UniversityEventManagement.service.EventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @PostMapping("/add-event")
    public ResponseEntity<String> addEvent(@Valid @RequestBody Event event) {
        return eventService.saveEvent(event);
    }

    @PutMapping("/update-event")
    public ResponseEntity<Event> updateEvent(@Valid @RequestBody Event event, @RequestParam int eventId) {
        return eventService.updateEvent(event, eventId);
    }

    @GetMapping("/get-all-events-by-date")
    public ResponseEntity<List<Event>> getAllEventByDate(@RequestParam String date) throws ParseException {
        return eventService.getEventByDate(date);
    }

    @DeleteMapping("/delete-event")
    public ResponseEntity<String> deleteEvent(@RequestParam int eventId) {
        return eventService.deleteEvent(eventId);
    }

}
