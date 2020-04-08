package by.training.gusakov.entity;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;
import java.util.Objects;

import by.training.gusakov.generator.IdGenerator;
import by.training.gusakov.observer.Observable;
import by.training.gusakov.observer.Observer;
import by.training.gusakov.observer.PyramidEvent;

public class Pyramid implements Observable {
    private String pointID;
    private Point sideA;
    private double sideB;
    private double sideC;
    private double sideD;
    private Point[] points;
    private List<Observer<EventObject>> observers = new ArrayList<>();

    public Pyramid(String pointID) {

        this.pointID = IdGenerator.generatorID();
    }

    public Pyramid(double sideB, double sideC, double sideD) {
        this.sideB = sideB;
        this.sideC = sideC;
        this.sideD = sideD;
    }

    public Pyramid(Point sideA, Point[] points) {
        this.sideA = sideA;
        this.points = points;
    }

    public Pyramid(Point sideA, double sideB, double sideC, double sideD, String pointID) {
    }

    public Pyramid() {
    }

    public String getPointID() {
        return pointID;
    }

    public void setPointID(String pointID) {
        this.pointID = pointID;
    }

    public Point getSideA() {
        return sideA;
    }

    public void setSideA(Point sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {

        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;

    }

    public double getSideD() {

        return sideD;
    }

    public void setSideD(double sideD) {

        this.sideD = sideD;
    }

    @Override
    public boolean equals(Object object) {

        if (object == this) {
            return true;
        }
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }
        Pyramid pyramid = (Pyramid) object;
        if (object.equals(pyramid.sideA) && object.equals(pyramid.sideB) && object.equals(pyramid.sideC)
                && object.equals(pyramid.sideD)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sideA, sideB, sideC, sideD);
    }

    @Override
    public String toString() {
        return "Pyramid: { id=" + pointID + "," + "side A: " + sideA + "," + " " + "side B: " + sideB
                + "side C : " + sideC + "side D: " + sideD + "}";
    }

    public void setPoints(Point[] points) {                  // для проверки, лежит ли основание на одной из координатных плоскостей
        this.points = points;
    }

    public Point[] getPoints() {
        return points;
    }

    @Override
    public void addObserver(Observer observer) {

        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {

    }

    @Override
    public void notifyObserver() {
        for (Observer<EventObject> observer : observers) {
            observer.update(new PyramidEvent(this));
        }
    }
}
