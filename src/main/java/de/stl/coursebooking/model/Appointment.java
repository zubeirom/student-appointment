package de.stl.coursebooking.model;

import javax.persistence.*;
import java.sql.Date;
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
    private Date createdAt;
}
