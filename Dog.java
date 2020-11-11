/**************************************************************************
*                                    Dog                                  *
*                                                                         *
*   Programmed by Maxwell Solko (10-27-2017)                              *
*   Class:  CS200                                                         *
*   Instructor:  Chris Harris                                             *
*                                                                         *
*   Description:  This is a specific class of animal, the dog.            *
*                 It's trait is that it gets distracted by squirrels      * 
*                 randomly when racing.                                   *
*                                                                         *
**************************************************************************/
import java.util.Random;
public final class Dog extends Animal
{
  
  // Unique Attributes
  private boolean squirrel;
  private int squirrelTime;
  
  
  //Constructor
  public Dog(String n, String spe, double spd, double cP, int cT, 
             int squirrelTime, boolean squirrel)
  {
    super(n, spe, spd, cP, cT);
    this.squirrelTime = squirrelTime;
    this.squirrel = squirrel;
  }
  
  //Methods for the Dog
  //getter
  public boolean getSquirrel()
  { return this.squirrel; }
  public int getSquirrelTime()
  { return this.squirrelTime; }
  
  //toggleSquirrel
  public void toggleSquirrel()
  {
    if(this.squirrel==false) this.squirrel=true;
    else this.squirrel=false;
  }
  
  //Increasing chance of toggleSquirrel occuring as the race goes on.
  public void squirrelChase()
  {
    Random rando = new Random();
    int m = rando.nextInt(1000);
    if(this.squirrel==false)
    { this.squirrelTime++; } //Increase the chance of finding a squirrel
    else
    { this.squirrelTime+= 10; } //greatly increase the chance of squirrel escape
    
    if(m<this.squirrelTime) 
    {
      this.toggleSquirrel();
      this.squirrelTime = 0;
    }
  }
  
  //redefine updatePosition
  public void updatePosition()
  {
    Random rando = new Random();
    this.squirrelChase(); //Sees if a squirrel comes or goes
    if(this.squirrel==true)
    {
      //random double multiplier for the speed
      double n;
      if(rando.nextBoolean()==true)
      {
        n = rando.nextDouble()-1;
      }
      else
      {
        n = rando.nextDouble();
      }
      this.currentSpeed = this.speed*n;
      this.currentPosition+= this.currentSpeed;
      this.currentTime++;
      
    }
    else
    {
      this.currentSpeed = this.speed;
      this.currentPosition+= this.speed;
      this.currentTime++;
    }
  }
  
}