package pingball;

public class Absorber implements Gadget {
    
    private final String name;
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    
    private Ball[] absorbed = new Ball[1];
    
    /**
     * width and height must be positive integers <= 20
     * @param name
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public Absorber(String name, int x, int y, int width, int height) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public String getName() {
        return name;
    }
    
    public String getType() {
        return "absorber";
    }

    public double getTimeToCollision(Ball ball) {
        // TODO Auto-generated method stub
        return 0;
    }

    public void getAction() {
        // TODO Auto-generated method stub
    }

    public double getCoefficient() {
        // TODO Auto-generated method stub
        return 0;
    }

   
    public void reflectBall(Ball ball) {
        // doesn't reflectBall. ball is captured

    }

    public void trigger() {
        action();        
    }
    
    public void action(){
        if (absorbed.length == 1){
            //shoot ball straight upwards at 50 L/sec
        } else {
            //store ball in bottom right hand corner -> .25L from bottom and .25L from right is where ball center is
        }
    }

}
