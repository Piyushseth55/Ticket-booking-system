package ticket.booking.entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;


@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ticket {
    private String ticketId;
    private String userId;
    private String source;
    private String destination;
    private String dateOfTravel;
    private Train train;

    public Ticket() {
    }

    public Ticket(String ticketId, String userId, String source, String destination, Train train, String dateofTravel) {
        this.ticketId = ticketId;
        this.userId = userId;
        this.source = source;
        this.destination = destination;
        this.train = train;
        this.dateOfTravel = dateofTravel;
    }

    public String getTicketInfo() {
        return String.format("Ticket Id: %s belongs to User %s from %s to %s on %s", ticketId, userId, source, destination, train, dateOfTravel);
    }

    public String getUserId() {
        return userId;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public String getDateofTravel() {
        return dateOfTravel;
    }

    public Train getTrain() {
        return train;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDateofTravel(String dateofTravel) {
        this.dateOfTravel = dateofTravel;
    }
    public void setTrain(Train train) {
        this.train = train;
    }


}