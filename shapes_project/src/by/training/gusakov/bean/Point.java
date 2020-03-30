package by.training.gusakov.bean;

public class Point {

    private double x;
    private double y;
    private double z;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {

        return z;
    }

    public double[] getCoordinates() {

        return new double[] {getX(), getY(), getZ()};
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object object) {

        if (object == this) {
            return true;
        }
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }
        Point point = (Point) object;
        if (point.x == x && point.y == y && point.z == z) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 17;
        int result = 1;
        result = prime * result + ((x == 0) ? 0 : Double.valueOf(x).hashCode());
        result = prime * result + ((y == 0) ? 0 : Double.valueOf(y).hashCode());
        result = prime * result + ((z == 0) ? 0 : Double.valueOf(z).hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("{" + "x=" + " " + x + ", y=" + " " + y + ", z=" + " " + z + "}");
        return str.toString();
    }

}
