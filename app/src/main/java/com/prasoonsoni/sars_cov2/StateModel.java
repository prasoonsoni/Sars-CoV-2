package com.prasoonsoni.sars_cov2;

public class StateModel {
    private String state, active, confirmed, death, recovered, lastUpdated;


    public StateModel(String state, String active, String confirmed, String death, String recovered, String lastUpdated) {
        this.state = state;
        this.active = active;
        this.confirmed = confirmed;
        this.death = death;
        this.recovered = recovered;
        this.lastUpdated = lastUpdated;
    }

    public String getState() {
        return state;
    }

    public String getActive() {
        return active;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public String getDeath() {
        return death;
    }

    public String getRecovered() {
        return recovered;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public void setDeath(String death) {
        this.death = death;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
