import java.awt.Graphics;
import java.util.Random;

public class CopCar extends Car{

    private static int xRatio, yRatio;
    //private static int xRationeg, yRationeg;
   // private int height = 500;
   // private int width = 500;

    public CopCar(){

        super("THE POPO",5000,new Engine("12engine",30,100),"cop-car.jpg");
        Random r = new Random();

        xRatio = r.nextInt(11)-5;
        yRatio = r.nextInt(11)-5;
        super.fillUp();
    }

    /*public void update(Graphics g) {
      
        super.drive(20, xRatio, yRatio);
        //super.setX(super.getX() + xRatio);
        //super.setY(super.getY() + yRatio);
        super.update(g);
    }*/

    public void updateImage(Graphics g)
    {
        //super.drive(20, xRatio, yRatio);
        //super.setX(super.getX() + xRatio);
        //super.setY(super.getY() + yRatio);
        super.update(g);
    }
    
    public void updateState()
    {
        super.drive(2, xRatio, yRatio);
        if ( super.getX() > 1000 || super.getX() < 0)
		{
            
            xRatio = -(xRatio);
            //super.drive(2, xRatio*(-1), yRatio);
		}
		if (super.getY() > 700 || super.getY() < 0)
		{
            yRatio = -(yRatio);
            //super.drive(2, xRatio, (-1)*yRatio);
		}
    }
}