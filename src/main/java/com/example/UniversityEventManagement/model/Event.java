package com.example.UniversityEventManagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Entity
@Data
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventId;
    private String eventName;
    private String locationOfEvent;
    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    private Date date;
    @DateTimeFormat(pattern = "HH:mm:ss")
    @Pattern(regexp = "^([01]\\d|2[0-3]):([0-5]\\d):([0-5]\\d)$", message = "Invalid time format. Use HH:mm:ss")
    private Date startTime;
    @DateTimeFormat(pattern = "HH:mm:ss")
    @Pattern(regexp = "^([01]\\d|2[0-3]):([0-5]\\d):([0-5]\\d)$", message = "Invalid time format. Use HH:mm:ss")
    private Date endTime;
}
