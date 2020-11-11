/**************************************************************************
*                               Hedgehog                                  *
*                                                                         *
*   Programmed by Maxwell Solko (10-27-2017)                              *
*   Class:  CS200                                                         *
*   Instructor:  Chris Harris                                             *
*                                                                         *
*   Description:  This is a specific class of animal, the hedgehog.       *
*                 It's trait is that it accelerates exponentially.        *
*                                                                         *
**************************************************************************/
public final class Hedgehog extends Animal
{
  
  // Unique Attributes
  private double speedMultiplier;
  
  //Constructor
  public Hedgehog(String n, String spe, double spd, double cP, int cT,
                   double speedMultiplier)
  {
    super(n, spe, spd, cP, cT);
    this.speedMultiplier = speedMultiplier;
  }
  
  //Methods for the Hedgehog
  //getter
  public double getspeedMultiplier()
  { return this.speedMultiplier; }
  
  //GOTTAGOFAST.  The hedgehog can multiply his speed exponentially.
  public void gottaGoFast()
  {
    this.speed = this.speed*this.speedMultiplier;
    this.currentSpeed = this.speed;
  }
  
  //redefine updatePosition
  public void updatePosition()
  {
    this.currentPosition+= this.speed;
    this.gottaGoFast();
    currentTime++;
  }
  
}