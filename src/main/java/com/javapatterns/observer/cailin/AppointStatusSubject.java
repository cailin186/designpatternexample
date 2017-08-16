package com.javapatterns.observer.cailin;

public class AppointStatusSubject extends AbstractSubject{
    
    private String state;
    
    public String getState() {
        return state;
    }

    public void publish(String stateData){
        this.nodifyObservers(stateData);
    }
}