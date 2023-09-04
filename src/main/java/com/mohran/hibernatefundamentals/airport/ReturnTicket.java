package com.mohran.hibernatefundamentals.airport;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("R")
public class ReturnTicket extends Ticket {

    private LocalDate latestReturnDate;

    public LocalDate getLatestReturnDate() {
        return latestReturnDate;
    }

    public void setLatestReturnDate(LocalDate latestReturnDate) {
        this.latestReturnDate = latestReturnDate;
    }
}
