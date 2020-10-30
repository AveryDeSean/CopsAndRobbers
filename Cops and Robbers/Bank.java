import java.awt.Graphics;
public class Bank extends Sprite
{
    public Bank()
    {
        super("bank.png");
        //set bank at (300,300)
        super.setX(300);
        super.setY(300);
    }

    public void updateImage(Graphics g)
    {
        super.update(g);
    }
}