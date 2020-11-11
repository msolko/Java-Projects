/**************************************************************************
*                               Giant Frog                                *
*                                                                         *
*   Programmed by Maxwell Solko (10-27-2017)                              *
*   Class:  CS200                                                         *
*   Instructor:  Chris Harris                                             *
*                                                                         *
*   Description:  This is a specific class of animal, the giant frog.     *
*                 It's trait is that it stays still for increments        *
*                 then jumps a long distance at once.                     *
*                                                                         *
**************************************************************************/
public final class GiantFrog extends Animal
{
  
  // Unique Attributes
  private int jumpTime;

  //Constructor
  public GiantFrog(String n, String spe, double spd, double cP, int cT,
                   int jumpTime)
  {
    super(n, spe, spd, cP, cT);
    this.jumpTime = jumpTime;
  }
  
  //Methods for the Frog
  //getter
  public int getJumpTime()
  { return this.jumpTime; }
  
  //redefine updatePosition
  public void updatePosition()
  {
    if(this.jumpTime-1==this.currentTime%this.jumpTime)//every 'jumpTime' seconds the frog does a big jump
    {
      this.currentSpeed = this.speed;
      this.currentPosition+= this.speed;
      this.currentTime++;
    }
    else
    {
      this.currentSpeed = 0.0;
      this.currentTime++;
    }
  }
  
}