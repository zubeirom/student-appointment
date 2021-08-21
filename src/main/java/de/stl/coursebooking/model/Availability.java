package de.stl.coursebooking.model;

import de.stl.coursebooking.enums.Weekday;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "availabilities")
public class Availability {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String lecturer;
    private Weekday weekday;
    private Date startsAt;
    private Date endsAt;
    private Date createdAt;

    public Availability() {}

    public Availability(String lecturer, Weekday weekday, Date startsAt, Date endsAt) {
        this.lecturer = lecturer;
        this.weekday = weekday;
        this.startsAt = startsAt;
        this.endsAt = endsAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public Weekday getWeekday() {
        return weekday;
    }

    public void setWeekday(Weekday weekday) {
        this.weekday = weekday;
    }

    public Date getStartsAt() {
        return startsAt;
    }

    public void setStartsAt(Date startsAt) {
        this.startsAt = startsAt;
    }

    public Date getEndsAt() {
        return endsAt;
    }

    public void setEndsAt(Date endsAt) {
        this.endsAt = endsAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Availability{" +
                "id=" + id +
                ", lecturer='" + lecturer + '\'' +
                ", weekday=" + weekday +
                ", startsAt=" + startsAt +
                ", endsAt=" + endsAt +
                ", createdAt=" + createdAt +
                '}';
    }
}
