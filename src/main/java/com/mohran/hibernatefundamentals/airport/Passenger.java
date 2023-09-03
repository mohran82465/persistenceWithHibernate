package com.mohran.hibernatefundamentals.airport;


import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "PASSENGERS")
public class Passenger {
    @Id
    @GeneratedValue
    private int id ;
    private String name ;
    @ElementCollection
    @CollectionTable(name = "PASSENGER_TICKETS",joinColumns = {
            @JoinColumn(name = "PASSENGER_ID",referencedColumnName = "ID")
    })
    private List<Ticket> tickets= new ArrayList<Ticket>();
    @ElementCollection
    @MapKeyColumn(name = "ATTRIBUTE_NAME")
    @Column(name = "ATTRIBUTE_VALUE")
    @CollectionTable(name = "PASSENGER_ATTRIBUTES",joinColumns = {
            @JoinColumn(name = "PASSENGER_ID",referencedColumnName = "ID ")
    })
    private Map<String, String> attributes = new HashMap<>();
    public Passenger() {
    }

    public Passenger( String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public java.util.List<Ticket> getTickets() {
        return Collections.unmodifiableList(tickets);
    }
    public void addTicket(Ticket ticket)
    {
        tickets.add(ticket);
    }

    public Map<String, String> getAttributes() {
        return Collections.unmodifiableMap(attributes);
    }

    public void addAttribute (String key , String Value)
    {
        attributes.put(key, Value) ;
    }
}
