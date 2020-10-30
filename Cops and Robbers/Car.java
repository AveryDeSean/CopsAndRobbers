import java.awt.Graphics;
public class Car extends Sprite
{
    private String cartype;
    // private int x = 0;
    //private int y = 0;
    private GasTank gas;
    private Engine motor;
    //private String description;

    

    public Car(String type, int fuel, Engine engine, String name)
    {
      //  gas = GasTank(fuel);
         super(name);
        
        if(type.length()== 0)
            cartype = "Generic car";
        else
            cartype = type;
            
        gas = new GasTank(fuel);
        
        if(engine == null)
            motor = new Engine("",0,0);
        else
            motor = engine;
        
    }
    public String getDescription() //return description of engine, fuel, capacity, and location
    {
    	//motor = new Engine("",0,0);
    	//gas = new GasTank(0);
        return (cartype + " (engine: " + motor.getDescription() + ")), fuel: " +gas.getLevel() + "/" + gas.getCapacity() + ", location: (" + getX() + "," + getY() + ")");
    
    }
  /*  public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }*/
    public double getFuelLevel()
    {
    	return gas.getLevel();
    }
    public int getMPG()
    {
    	return motor.getMPG();
    }
    public void fillUp()
    {
        gas.setLevel(gas.getCapacity());
    }  
    public void empty()
    {
        gas.setLevel(0);
    }
    public int getMaxSpeed()
    {
    	return motor.getMaxspeed();
    }
    
    
    
	public  double  drive (int distance, double xRatio, double yRatio)
	{

		
		double totaldistance = (double) distance / getMPG();
		double hypot  = Math.sqrt(Math.pow(xRatio, 2) + Math.pow(yRatio, 2));
	

		
		if(totaldistance > gas.getLevel())
		{
			distance = (int) (gas.getLevel() * motor.getMPG());
			//System.out.println("Ran out of gas after driving " + distance + " miles.");
			gas.setLevel(gas.getLevel() - totaldistance);
		}
		else
		{
			gas.setLevel(gas.getLevel() - totaldistance);
			
		}
        double ratio = distance/hypot; 
       
		super.setX((int) (super.getX()+(xRatio * ratio)));
		super.setY((int) (super.getY()+(yRatio * ratio)));
		
			return distance;
		
		
	
    }
   /*public void update(Graphics g) {
      
       // super.setX(super.getX() + 1);
       // super.setY(super.getY() + 1);
          super.update(g);
    }*/

    public void updateImage(Graphics g)
    {  
       // super.setX(super.getX() + 1);
       // super.setY(super.getY() + 1);
       super.update(g);
    }

}