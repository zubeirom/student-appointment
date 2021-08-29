package de.stl.coursebooking.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String student;
    private String lecturer;
    @ElementCollection
    private List<String> participants;
    private String description;
    private boolean cancelled;
    private String cancellationReason;
    private boolean confirmed;
    private Date startsAt;
    private Date endsAt;
    @CreationTimestamp
    private Timestamp createdAt;

    public Appointment() {}

    public Appointment(String student, String lecturer, List<String> participants, String description, Date startsAt, Date endsAt) {
        this.student = student;
        this.lecturer = lecturer;
        this.participants = participants;
        this.description = description;
        this.startsAt = startsAt;
        this.endsAt = endsAt;
    }
}
