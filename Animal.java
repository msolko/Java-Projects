/**************************************************************************
*                               Animal                                    *
*                                                                         *
*   Programmed by Maxwell Solko (10-27-2017)                              *
*   Class:  CS200                                                         *
*   Instructor:  Chris Harris                                             *
*                                                                         *
*   Description:  This is the abstract class of animal. it has the common *
*                 qualities every animal has, like name, species, speed,  *
*                 etc.  This is the superclass that other classes call to.*
*                                                                         *
**************************************************************************/
public class Animal {
    // Attributes
    protected String name;   // common attribute for all subclasses
    protected String species;
    protected double speed;
    protected double currentPosition;
    protected int currentTime;
    protected double currentSpeed;
    protected int finishTime;
    
    public Animal(String n, String spe, double spd, double cP, int cT)
    {
      name = n;
      species = spe;
      speed = spd;
      currentPosition = cP;
      currentTime = cT;
      currentSpeed = spd;
      finishTime = 0;
    }

    // Get Methods
    public String getName()           
    { return name; }                  
    public String getSpecies()
    { return species; }
    public double getSpeed()
    { return speed;}
    public double getCurrentPosition()
    { return currentPosition; }
    public int getCurrentTime()
    { return currentTime; }
    public double getCurrentSpeed()
    { return currentSpeed; }
    public int getFinishTime()
    { return finishTime; }
    
    //Set Methods
    public void setSpeed(double spd)
    { speed = spd; }
    public void setCurrentSpeed(double cSpd)
    { currentSpeed = cSpd; }
    public void setCurrentPosition(double cP)
    { currentPosition = cP; }
    public void setFinishTime(int fT)
    { finishTime = fT; }
    
    //Print Status
    //this method is used in races to print the location and speed of the racer.
    public void printStatus()
    {
      System.out.printf("%-12s%-10s", Math.round(currentPosition*100.0)/100.0, 
                        Math.round(currentSpeed*100.0)/100.0);
    }
    
    //Update position
    public void updatePosition()
    {
      currentPosition+= speed;
      currentTime++;
    }
} 
