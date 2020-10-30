public class Engine
{
    private String description;
    private int mpg;
    private int MaxSpeed;

    public Engine(String descrip, int milespg, int MaximumSpeed)
    {
        if (descrip.length() == 0) {
        description = "Generic engine";
        }
        else {
        description = descrip;
        }
        if (milespg < 0)
        mpg = 0;
        else
        mpg = milespg;
        if (MaximumSpeed < 0)
        MaxSpeed = 0;
        else
        MaxSpeed = MaximumSpeed;
    }

    //Get functions
    public String getDescription() //return description, mpg, and max speed
    {
        return (description + "(MPG:" + getMPG() +", Max speed:" + getMaxspeed() );
       
    }
    public int getMPG()
    {
        return mpg;
    }
    public int getMaxspeed()
    {
        return MaxSpeed;
    }

}