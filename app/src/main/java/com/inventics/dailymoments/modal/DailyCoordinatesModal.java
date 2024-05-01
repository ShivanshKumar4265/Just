package com.inventics.dailymoments.modal;

public class DailyCoordinatesModal {
    String momentName, date, source, destination, total_distance;

    public DailyCoordinatesModal() {

    }
    public DailyCoordinatesModal(String momentName, String date, String source, String destination, String total_distance) {
        this.momentName = momentName;
        this.date = date;
        this.source = source;
        this.destination = destination;
        this.total_distance = total_distance;
    }

    public String getMomentName() {
        return momentName;
    }

    public void setMomentName(String momentName) {
        this.momentName = momentName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTotal_distance() {
        return total_distance;
    }

    public void setTotal_distance(String total_distance) {
        this.total_distance = total_distance;
    }
}
