package ticket.booking.service;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ticket.booking.entities.Ticket;
import ticket.booking.entities.Train;
import ticket.booking.entities.User;
import ticket.booking.util.UserServiceUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


public class UserBookingService {
    private User user;
    private List<User> usersList;
    private static final String USERS_PATH = "E:/Ticket-booking-system/lib/src/main/java/ticket/booking/localDb/users.json";
    private static final ObjectMapper mapper = new ObjectMapper();
    public UserBookingService(User user1) throws IOException {
        this.user = user1;
        loadUsers();
    }

    public UserBookingService() throws IOException {
        loadUsers();
    }

    public void loadUsers() throws IOException {
        File users = new  File(USERS_PATH);
        usersList = mapper.readValue(users, new TypeReference<List<User>>() {});
    }

    public Boolean loginUser(String username, String password) {
        Optional<User> foundUser = usersList.stream().filter(user1 -> {
            return user1.getName().equalsIgnoreCase(username) && UserServiceUtil.checkPassword(password, user1.getHashedPassword());
        }).findFirst();
        if(foundUser.isPresent()) {
            user = foundUser.get();
            return Boolean.TRUE;
        } else {
            System.out.println("User not found !!");
            return Boolean.FALSE;
        }
    }

    public Boolean signup(User user1) {
        try {
            usersList.add(user1);
            saveUserListToFile();
            return Boolean.TRUE;
        } catch (IOException ex) {
            return Boolean.FALSE;
        }
    }

    public void saveUserListToFile() throws IOException {
        File usersFile = new File(USERS_PATH);
        mapper.writeValue(usersFile, usersList);
    }

    public void fetchBooking() {
        if(user == null) {
            System.out.println("First login or signup !! ");
            return;
        }
        if(user.getTicketsbooked() == null || user.getTicketsbooked().isEmpty()) {
            System.out.println("No booking found !!");
            return;
        }
        user.printTickets();
    }

    public Boolean cancleBooking(String ticketId) {
        if(ticketId.length() == 0 || ticketId == null) {
            System.out.println("Ticket Id is empty !! ");
            return Boolean.FALSE;
        }
        return user.getTicketsbooked().removeIf(ticket -> ticket.getTicketId().equals(ticketId));
    }

    public Boolean bookTicket(String src, String dest, String trainId, String dateOfTravel) throws IOException {
        TrainService trainService = new TrainService();
        List<Train> trains = trainService.getTrainsList();
        for(Train train : trains) {
            if(trainId.equals(train.getTrainId())) {
                List<List<Integer>> seats = train.getSeats();
                for(List<Integer> rows : seats) {
                    for(int i  = 0; i <  rows.size(); i++) {
                        if(rows.get(i) == 0) {
                            rows.set(i, 1);
                            String ticketId = UUID.randomUUID().toString();
                            String userId = user.getUserId();
                            Ticket ticket = new Ticket(ticketId, userId, src, dest, train, dateOfTravel);
                            if(user.getTicketsbooked() == null) {
                                List<Ticket> tickets = new ArrayList<>();
                                tickets.add(ticket);
                                user.setTicketsbooked(tickets);
                            } else {
                                user.getTicketsbooked().add(ticket);
                            }
                            return Boolean.TRUE;
                        }
                    }
                }
            }
        }
        System.out.println("Wrong Train Id !!!");
        return Boolean.FALSE;
    }
    public List<User> getUsersList() {
            return usersList;
    }
}
