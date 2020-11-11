/**************************************************************************
*                                  Hare                                   *
*                                                                         *
*   Programmed by Maxwell Solko (10-27-2017)                              *
*   Class:  CS200                                                         *
*   Instructor:  Chris Harris                                             *
*                                                                         *
*   Description:  This is a specific class of animal, the hare.           *
*                 It's trait is that it stops and takes a nap when racing.*
*                                                                         *
**************************************************************************/
public final class Hare extends Animal
{
  // Unique Attributes
  private int napStart;
  private int napDuration;
  private boolean napping;
  
  //Constructor
  public Hare(String n, String spe, double spd, double cP, int cT, 
              int nS, int nD, boolean nap)
  {
    super(n, spe, spd, cP, cT);
    this.napStart = nS;
    this.napDuration = nD;
    this.napping = nap;
  }
  
  //Methods for the Hare
  //getters
  public int getNapStart()
  { return this.napStart; }
  public int getNapDuration()
  { return this.napDuration; }
  public boolean getNapping()
  { return this.napping; }
  
  //Replacing updatePosition
  public void updatePosition()
  {
    if(this.napping==true)
    {
      this.currentSpeed = 0.0;
      if(this.napStart+this.napDuration==currentTime)
      {
        this.napping = false;
      }
    }
    else
    {
      this.currentSpeed = this.speed;
      this.currentPosition+=this.speed;
      if(this.napStart==currentTime)
      {
        this.napping = true;
      }
    }
    this.currentTime++;
  }
  
}