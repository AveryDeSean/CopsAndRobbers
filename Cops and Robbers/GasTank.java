public class GasTank
{

    private int capacity;
    private double level;

    public GasTank(int cap)
    {
        if(cap < 0)
        capacity = 0;
        else
        capacity = cap;
    }

    //Get functions
    public int getCapacity()
    {
        return capacity;
    }

    public double getLevel()
    {
        return level;
    }

    //Set functions
    public void setLevel(double levelIn)
    {
        if(levelIn < 0)
        level = 0;
        else if(levelIn > capacity)
        level = capacity;
        else
        level = levelIn;
    }

}