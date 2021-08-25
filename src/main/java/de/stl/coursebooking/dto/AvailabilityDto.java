package de.stl.coursebooking.dto;

import de.stl.coursebooking.enums.Weekday;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

public class AvailabilityDto {

    private Weekday weekday;
    private String startsAt;
    private String endsAt;

    public AvailabilityDto() {}

    public AvailabilityDto(Weekday weekday, String startsAt, String endsAt) {
        this.weekday = weekday;
        this.startsAt = startsAt;
        this.endsAt = endsAt;
    }

    public Weekday getWeekday() {
        return weekday;
    }

    public void setWeekday(Weekday weekday) {
        this.weekday = weekday;
    }

    public String getStartsAt() {
        return startsAt;
    }

    public void setStartsAt(String startsAt) {
        this.startsAt = startsAt;
    }

    public String getEndsAt() {
        return endsAt;
    }

    public void setEndsAt(String endsAt) {
        this.endsAt = endsAt;
    }

    @Override
    public String toString() {
        return "AvailabilityDto{" +
                "weekday=" + weekday +
                ", startsAt=" + startsAt +
                ", endsAt=" + endsAt +
                '}';
    }
}
