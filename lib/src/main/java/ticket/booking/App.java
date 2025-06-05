package ticket.booking;

import ticket.booking.entities.Train;
import ticket.booking.entities.User;
import ticket.booking.service.TrainService;
import ticket.booking.service.UserBookingService;
import ticket.booking.util.UserServiceUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class App {
    public static void main(String[] args) {
        System.out.println("Running Train Booking System....");
        Scanner sc = new Scanner(System.in);
        int option = 0;
        UserBookingService userBookingService;
        TrainService trainService;
        try {
            userBookingService = new UserBookingService();
            trainService = new TrainService();
        } catch (IOException ex) {
            System.out.println("There is something wrong !! " + ex);
            return;
        }

        while(option != 7) {
            System.out.println("Choose option : ");
            System.out.println("1. sing up");
            System.out.println("2. Login");
            System.out.println("3. Fetch Bookings");
            System.out.println("4. Search Trains");
            System.out.println("5. Book a seat");
            System.out.println("6. Cancel my Booking");
            System.out.println("7. Exit the app");
            option = sc.nextInt();
            switch(option) {
                case 1:
                    System.out.println("Enter Username : ");
                    String username = sc.next();
                    System.out.println("Enter Password : ");
                    String password = sc.next();
                    User usertosignup = new User(username, password, UserServiceUtil.hashPassword(password), new ArrayList<>(), UUID.randomUUID().toString());
                    userBookingService.signup(usertosignup);
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("Enter Username : ");
                    String username1 = sc.nextLine();
                    System.out.println("Enter Password : ");
                    String password1 = sc.next();
                    User usertoLogin = new User(username1, password1, UserServiceUtil.hashPassword(password1), new ArrayList<>(), UUID.randomUUID().toString());
                    if(userBookingService.loginUser(username1, password1)) {
                        System.out.println("Login Successful");
                    } else {
                        System.out.println("Login Failed");
                    }
                    break;
                case 3:
                    System.out.println("Fetch Bookings : ");
                    userBookingService.fetchBooking();
                    break;
                case 4:
                    System.out.println("Enter Source : ");
                    String source = sc.next();
                    System.out.println("Enter Destination : ");
                    String destination = sc.next();
                    List<Train> trains = trainService.searchTrains(source, destination);
                    int i = 0;
                    for(Train train : trains) {
                        System.out.println(String.format("Train %d : ", i++));
                        System.out.println("Train Id : " + train.getTrainId());
                        System.out.println("Train number : " + train.getTrainNo());
                        System.out.println("Stations : " + train.getStations());
                    }
                    break;
                case 5:
                    System.out.println("Enter Source : ");
                    String src = sc.next();
                    System.out.println("Enter Destination : ");
                    String dest = sc.next();
                    System.out.println("Enter Date Of Travel (YYYY-DD-MMTHH:MM:SS) : " );
                    String dateOftravel = sc.next();
                    trains = trainService.searchTrains(src, dest);
                    i = 0;
                    System.out.println("Available Trains : ");
                    for(Train train : trains) {
                        System.out.println(String.format("Train %d : ", i++));
                        System.out.println("Train Id : " + train.getTrainId());
                        System.out.println("Train number : " + train.getTrainNo());
                        System.out.println("Stations : " + train.getStations());
                    }
                    System.out.println("Enter train Id : ");
                    String trainNo = sc.next();
                    try {
                        if (userBookingService.bookTicket(src, dest, trainNo, dateOftravel)) {
                            System.out.println("Booking Successful");
                        } else {
                            System.out.println("Booking Failed");
                        }
                    } catch (Exception e) {
                        System.out.println("Booking Failed" + e);
                    }
                    break;
                case 6:
                    System.out.println("Enter Train Id : ");
                    String trainId = sc.next();
                    if(userBookingService.cancleBooking(trainId)) {
                        System.out.println("Cancle Booking Successful");
                    } else {
                        System.out.println("There is something wrong !!  Please try again later.");
                    }
                    break;
                default:
                    System.out.println("Invalid Option");
                    break;
            }
        }
    }
}
