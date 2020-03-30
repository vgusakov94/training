package by.training.gusakov.bean;

import java.util.Objects;

import by.training.gusakov.generator.IdGenerator;

public class Pyramid {

    private String pointID;
    private Point sideA;
    private double sideB;
    private double sideC;
    private double sideD;
    private Point[] points;

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

}
