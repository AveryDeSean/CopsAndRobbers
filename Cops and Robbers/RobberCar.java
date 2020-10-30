import java.awt.Graphics;
import java.util.Random;

public class RobberCar extends Car{

    private int xRatio, yRatio;
    private boolean captured;
    private boolean escaped;
    private static int numcaptured = 0;
    private static int numescaped = 0;
    


    public RobberCar(){
        super("BadGuy",5000,new Engine("GANGSTAengine",20,200),"red-car.jpg");
        Random r = new Random();
        xRatio = r.nextInt(11)-5;
        yRatio = r.nextInt(11)-5;
        super.fillUp();

    }
    /*public void update(Graphics g) {
      
        super.drive(40, xRatio, yRatio);
        //super.setX(super.getX() + xRatio);
        //super.setY(super.getY() + yRatio);
        super.update(g);
    }*/

    public void updateImage(Graphics g) {
      
        //super.drive(40, xRatio, yRatio);
        //super.setX(super.getX() + xRatio);
        //super.setY(super.getY() + yRatio);
        super.update(g);
    }

    public void updateState()
    {
        super.drive(4, xRatio, yRatio);
        if((super.getX() > 1000 || super.getX() < 0 || super.getY() > 700 || super.getY() < 0))
        {
            hasEscaped();
            numescaped = numescaped+1;
            System.out.println("Escaped cars =  " + numescaped);
            escaped = true;
        }
        
    }
    public boolean hasEscaped()
    {
        if(escaped == false)
        {
           // numescaped = numescaped+1;
           // System.out.println("Escaped cars =  " + numescaped);
            return true;
        }
        return false;
    }

    public void captured()
    {
        isCaptured();
        captured = true;
        super.setImage("jail.jpg");
        //final int x = super.getX();
        //final int y = super.getY();
        //System.out.println("1x = " + x + "    1y= " + y);
        super.empty();
        

    }
    
    public boolean isCaptured()
    {
        if(captured == false)
        {
            numcaptured++;
            System.out.println("Number of captured = " + numcaptured);
            return true;
        }
        else
        return false;
    }

    public int getCaptured()
    {
        return numcaptured;
    }
    public int getEscaped()
    {
        return numescaped;
    }
}