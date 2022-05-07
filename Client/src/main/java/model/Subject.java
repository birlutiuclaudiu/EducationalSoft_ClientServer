package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

    private List<Observer> observerList = new ArrayList<>();

    public void attach(Observer observer) {
        this.observerList.add(observer);
    }

    public void detach(Observer observer) {
        this.observerList.remove(observer);
    }

    public abstract void notifyObserver(String operation);

    public List<Observer> getObserverList() {
        return this.observerList;
    }

    public void setObserverList(List<Observer> observerList) {
        this.observerList = observerList;
    }
}
