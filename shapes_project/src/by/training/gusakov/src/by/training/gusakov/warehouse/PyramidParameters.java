package by.training.gusakov.warehouse;

public class PyramidParameters {
    private String id;
    private double square;
    private double volume;

    public PyramidParameters(double square, double volume) {
        this.square = square;
        this.volume = volume;
    }

    public PyramidParameters() {
    }

    public double getSquare() {
        return square;
    }

    public double getVolume() {
        return volume;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}
