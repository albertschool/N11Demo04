package com.example.n11demo04.Models;

public class State {
    private String stateName, stateCapital;
    private int stateImageId;

    public State(String stateName, String stateCapital, int stateImageId) {
        this.stateName = stateName;
        this.stateCapital = stateCapital;
        this.stateImageId = stateImageId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateCapital() {
        return stateCapital;
    }

    public void setStateCapital(String stateCapitl) {
        this.stateCapital = stateCapital;
    }

    public int getStateImageId() {
        return stateImageId;
    }

    public void setStateImageId(int stateImageId) {
        this.stateImageId = stateImageId;
    }

    @Override
    public String toString() {
        return "State{" +
                "stateName='" + stateName + '\'' +
                ", stateCapitl='" + stateCapital + '\'' +
                ", stateImageId=" + stateImageId +
                '}';
    }
}
