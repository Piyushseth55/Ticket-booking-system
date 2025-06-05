package ticket.booking.service;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ticket.booking.entities.Train;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;



public class TrainService {
    private List<Train> trainsList;
    private static final String TRAIN_DB_PATH = "E:/Ticket-booking-system/lib/src/main/java/ticket/booking/localDb/trains.json";
    private static final ObjectMapper mapper = new ObjectMapper();


    public TrainService() throws IOException {
        loadTrains();
    }

    public void loadTrains() throws IOException {
        File file = new File(TRAIN_DB_PATH);
        trainsList = mapper.readValue(file, new TypeReference<List<Train>>() {});
    }

    public List<Train> searchTrains(String source, String destination) {
        List<Train> result = new ArrayList<Train>();
        for(Train train : trainsList) {
            String sourceTime = train.getStationTimes().get(source);
            String destinationTime = train.getStationTimes().get(destination);
            if(sourceTime == null || destinationTime == null) {
                return result;
            }
            if(!LocalTime.parse(sourceTime).isAfter(LocalTime.parse(destinationTime))) {
                result.add(train);
            }
        }
        return result;
    }

    public List<Train> getTrainsList() {
        return trainsList;
    }



}
