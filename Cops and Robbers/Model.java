import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


class Model
{
   // private Sprite sprite;
   //Take in an array of sprites
   private CopCar copcar;
   private RobberCar robbercar;
    private ArrayList<Sprite>  arraySprites;
    private int count = 0;
    private static int i = 0;
    
    
    Model() throws IOException {
    arraySprites = new ArrayList<Sprite>();
    //sprite = new Sprite("red-car.jpg");
    //Car car = new Car("Big", 10, null, "red-car.jpg");
      
      arraySprites.add(new Bank());


     /* int x = 0;
      int y = 0;
      for(int i=0;i<3;i++)
      {
      //Sprite sprite2 = new Sprite("smiley.jpg");
  		sprite = new Sprite("smiley.jpg");
    	x = x+100;
    	y = y+100;
    	sprite.setX(x);
    	sprite.setY(y);
    	arraySprites.add(sprite);
      }*/
      //arraySprites.add(copcar);
    }


    public void update(Graphics g) {
      
    	for(Sprite sprite : arraySprites)
    	{
		  sprite.updateImage(g);
    	}
    }
    public void updateScene(int value1, int value2)
    {
      synchronized(arraySprites)
    	{
	    	Iterator<Sprite> iterator = arraySprites.iterator();
	    	
	    	while(iterator.hasNext())
	    	{
	    		Sprite s = iterator.next();
	    		if (s instanceof RobberCar)
	    		{
	    			if (((RobberCar)s).hasEscaped() == false)
	    			{
	    				i++;
	    				System.out.println("I'M FREE!  # = " + i);
	    				iterator.remove();
	    			}
	    		}
	    		
	    	}
      for(Sprite sprite : arraySprites)
      {
        sprite.updateState(); 
      }
      for (int i = 0; i < arraySprites.size(); i++)
      {
        if (arraySprites.get(i)  instanceof CopCar)
        {	
          for (int m = 0; m < arraySprites.size(); m++)
          {
            if ((arraySprites.get(m) instanceof RobberCar) && (arraySprites.get(m).overlaps(arraySprites.get(i))))
              {
                ((RobberCar)arraySprites.get(m)).captured();
                
              }
            }
          }
        }
      }
    }
    

    public void specificSprite(int x, int y)
    {
      if(count%2==0)
      {
      robbercar = new RobberCar();
      robbercar.setX(300);
      robbercar.setY(300);
      arraySprites.add(robbercar);
      }
      else
      {
      copcar = new CopCar();
      copcar.setX(x);
      copcar.setY(y);
      arraySprites.add(copcar);
      }
      count++;
    }

    public ArrayList<Sprite> getSprite()
    {
      return arraySprites;
    }
    public void initialize()
    {
      arraySprites = new ArrayList<Sprite>();
      arraySprites.add(new Bank());
      count=0;
    }
}
