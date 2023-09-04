package com.mohran.hibernatefundamentals.airport;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "RETURN_TICKETS")
public class ReturnTicket extends Ticket {

    private LocalDate latestReturnDate;

    public LocalDate getLatestReturnDate() {
        return latestReturnDate;
    }

    public void setLatestReturnDate(LocalDate latestReturnDate) {
        this.latestReturnDate = latestReturnDate;
    }
}
