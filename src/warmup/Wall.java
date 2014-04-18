package warmup;

public class Wall {
    private double x;
    private double y;
    
    public Wall(double x,double y){
        this.setX(x);
        this.setY(y);
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }
}
