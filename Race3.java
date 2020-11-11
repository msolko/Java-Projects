/**************************************************************************
  *                           Polymorphism Race                             *
  *                                                                         *
  *   Programmed by Maxwell Solko (10-27-2017)                              *
  *   Class:  CS200                                                         *
  *   Instructor:  Chris Harris                                             *
  *                                                                         *
  *   Description:  This is an implementation of all the different animals  *
  *                 to do a race. The animals are a dog, hare, giant frog,  *
  *                 hedgehog, and (generic animal) tortoise. This also has  *
  *                 unique interactions like fatigue, the frog can squish   *
  *                 other animals, and everyone finished for the race to    *
  *                 finish.                                                 *
  *                                                                         *
  **************************************************************************/
import java.util.Random;
public class Race3
{
  public static void main(String[] args)
  {
    //Array that stores new animals for the race. currently hardcoded entries.
    Animal[] racers = new Animal[7];
    racers[0] = new Animal("Speedy", "Tortoise", 4.5, 0, 0);
    racers[1] = new Hare("Thumper", "Hare", 11.1, 0, 0,
                         40, 20, false);
    racers[2] = new Dog("Dug", "Dog", 7.8, 0, 0,
                        0, false);
    racers[3] = new GiantFrog("Roger", "Frog", 150, 0, 0,
                              10);
    racers[4] = new Hedgehog("SANIC", "Hedgehog", 1, 0, 0,
                             1.05);
    racers[5] = new Animal("Billy", "Ostrich", 15, 0, 0);
    racers[6] = new Hedgehog("Shadow", "Hedgehog", 0.5, 0, 0,
                             1.06);
    //If there are no racers, the race won't happen
    if(racers.length==0)
    {
      System.out.print("Nobody showed up to the race, so it won't happen.");
      return;
    }
    //warning if race is big
    if(racers.length>7)
    {
      System.out.print("While this large of a race is possible, the output for the racers might not look correct! ");
    }
    double raceDistance = 1000;
    boolean everyoneDone = false;
    int time = 0;
    Random rand = new Random();
    int rain = rand.nextInt(100);
    if(rain<10)
    {
      System.out.println("It's raining, so some animals will go slower"); //won't affect tortoises or frogs
      for(int i = 0; i<racers.length; i++)
      {
        if(racers[i].getSpecies() != "Frog")
        {
          racers[i].setSpeed(racers[i].getSpeed()*.9);
          racers[i].setCurrentSpeed(racers[i].getSpeed());
        }
      }
    }
    System.out.println("Based on the the animals: this race will take place.");
    System.out.println("---------------------------------------------------------------------------------");
    System.out.print("          ");//space for time
    for(int i=0; i<racers.length; i++) // printing name of each racer
    { System.out.printf("%-22s",racers[i].getName()); }
    System.out.println();//new line for position and times
    System.out.print("time      ");//space for time
    for(int i=0; i<racers.length; i++) //printing position and speed for each racer
    { System.out.print("position    speed     "); }
    System.out.println("comment");
    while(everyoneDone==false)
    {
      String comment = "";
      for(int i = 0; i<racers.length; i++)
      {
        if(racers[i].getFinishTime()==0)
        {
          racers[i].updatePosition();
//........................USE OF POLYMORPHISM..........................................
          //adds comments if the species and situation is correct
          if(racers[i] instanceof Hare)
          {
            Hare temp = (Hare) racers[i];
            if(temp.getNapping()==true)
            { comment+= racers[i].getName() + " is napping. "; }
          }
          if(racers[i] instanceof Dog)
          {
            Dog temp = (Dog) racers[i];
            if(temp.getSquirrel()==true)
            { comment+= racers[i].getName() + " is chasing a squirrel. "; }
          }
          //the racer stops running if they pass the finish line
          if(racers[i].getCurrentPosition()>=raceDistance)
          {
            racers[i].setFinishTime(racers[i].getCurrentTime());
            racers[i].setCurrentSpeed(0);
            comment+= racers[i].getName() + " finished the race. ";
          }
        }
      }
      //checks for squashed characters AFTER they have all moved
      for(int i=0; i<racers.length; i++)
      {
        //if the racer is a frog (and moving), it checks if it squished any other (non-frog) racers
        if(racers[i].getSpecies() == "Frog" && racers[i].getCurrentSpeed()!=0)
        {
          for(int j = 0; j<racers.length; j++)
          {
            //making sure frogs can't squash themselves
            if(racers[j].getSpecies() != "Frog")
            {
              //if they are in range (and not already done), they get squashed
              if(Math.abs(racers[j].getCurrentPosition()-racers[i].getCurrentPosition())<5.0 && racers[j].getFinishTime()==0)
              {
                racers[j].setFinishTime(racers[j].getCurrentTime());
                racers[j].setCurrentSpeed(0);
                comment+= racers[j].getName() + " got squashed. ";
              }
            }
          }
        }
      }
      everyoneDone = true; //temporary statement, will revert if at least one person isn't done
      for(int i = 0; i<racers.length; i++)
      {
        if(racers[i].getFinishTime()!=0){}
        else
        {
          everyoneDone = false; //found someone who isn't done-reverts to false.
          break;
        }
      }
      time++;
      System.out.printf("%-10s",time);
      for(int i=0; i<racers.length; i++)
      { 
        racers[i].printStatus();
      }
      System.out.printf("%-30s\n",comment);
    }
    
    System.out.println("The results of the race:");
    System.out.printf("%-10s%-10s%-10s\n","Name","Time","Distance");
    for(int i=0; i<racers.length; i++)
    {
      System.out.printf("%-10s%-10s%-10s\n",racers[i].getName(),racers[i].getFinishTime(),
                        racers[i].getCurrentPosition());
    }
  }
}








