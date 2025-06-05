package ticket.booking.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Train {

    private String trainId;
    private String trainNo;
    private List<List<Integer>> seats;
    private HashMap<String, String> stationTimes;
    private List<String> stations;


    public Train() {}

    public Train(String trainId, String trainNo) {
        this.trainId = trainId;
        this.trainNo = trainNo;
        this.seats = new ArrayList<List<Integer>>();
        this.stationTimes = new HashMap<String, String>();
        this.stations = new ArrayList<String>();
    }

    public String getTrainId() {
        return trainId;
    }
    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }
    public String getTrainNo() {
        return trainNo;
    }
    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }

    public List<List<Integer>> getSeats() {
        return seats;
    }
    public void setSeats(List<List<Integer>> seats) {
                this.seats = seats;
    }
    public HashMap<String, String> getStationTimes() {
        return stationTimes;
    }
    public void setStationTimes(HashMap<String, String> stationTimes) {
        this.stationTimes = stationTimes;
    }
    public List<String> getStations() {
        return  stations;
    }
    public void setStations(List<String> stations) {
        this.stations = stations;
    }

    public String getTrainInfo() {
        return String.format("Train ID:  %s Train No:  %s", trainId, trainNo);
    }




}
