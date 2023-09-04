package com.mohran.hibernatefundamentals.airport;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
@Entity
 public class OneWayTicket extends Ticket{
    private LocalDate latestDepartureDate;

    public LocalDate getLatestDepartureDate() {
        return latestDepartureDate;
    }

    public void setLatestDepartureDate(LocalDate latestDepartureDate) {
        this.latestDepartureDate = latestDepartureDate;
    }
}
