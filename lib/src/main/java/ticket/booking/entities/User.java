package ticket.booking.entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;


@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private String name;
    private String password;
    private String hashedPassword;
    private List<Ticket> ticketsBooked;
    private String userId;

    public User(String name, String password, String hashpassword, List<Ticket> ticketbooked, String userId) {
        this.name = name;
        this.password = password;
        this.hashedPassword = hashpassword;
        this.ticketsBooked = ticketbooked;
        this.userId = userId;
    }
    public User() {}

    public String getName() {
        return this.name;
    }
    public String getPassword() {
        return password;
    }
    public String getHashedPassword() {
        return hashedPassword;
    }
    public List<Ticket> getTicketsbooked() {
        return ticketsBooked;
    }

    public void printTickets() {
        for(int i = 0; i<ticketsBooked.size(); i++) {
            System.out.println(ticketsBooked.get(i).getTicketInfo());
        }
    }

    public String getUserId() {
        return userId;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setHashedPassword(String hashpassword) {
        this.hashedPassword = hashpassword;
    }
    public void setTicketsbooked(List<Ticket> ticketbooked) {
        this.ticketsBooked = ticketbooked;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

}
