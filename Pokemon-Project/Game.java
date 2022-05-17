import java.util.*;

public class Game
{
  private static int dragonRagePP = 10; //10
  private static int cEarthquakePP = 10; //10
  private static int flamethowerPP = 15; //15
  private static int crunchPP = 15; //15
  
  private static int psychicPP = 10;
  private static int splashPP = 40;
  private static int auraspherePP = 20;
  private static int shadowballPP = 15;
  
  private static int sheercoldPP = 5;
  private static int dragonpulsePP = 5; 
  private static int thunderboltPP = 15;
  private static int blizzardPP = 5;

  private static int hydropumpPP = 5;
  private static int bEarthquakePP = 10;
  private static int icebeamPP = 10;
  private static int surfPP = 15;

  private static int numPotions = 10; 
  private static double damage;

  private static double cH; //78 + (int) (2.84 * level)
  private static int cD; //78 + (int) (2.11 * level)
  private static double cA; //84 + (int) (2.11 * level)

  private static double mH; //106 + (int) (3.13 * level)
  private static int mD; //90 + (int) (2.18 * level)
  private static int mA; //110 + (int) (2.42 * level)

  private static double bH; //79 + (int) (2.85 * level)
  private static int bD; //83 + (int) (2.1 * level)
  private static double bA; //100 + (int) (2.3 * level)

  private static double lH; //130 + (int) (3.37 * level)
  private static int lD; //80 + (int) (2.06 * level)
  private static int lA; //85 + (int) (2.12 * level)

  private static int turn = 0;
  private static int lvl;
  private static int x = 1; //the pokemon in the battle
  private static int y = 1; //the pokemon in the battle
  private static int statsA = 1;
  private static int statsB = 1;

  private static Charizard c = new Charizard();
  private static Mewtwo m = new Mewtwo();
  private static Lapras l = new Lapras();
  private static Blastoise b = new Blastoise();
  String cDealt = "Charizard dealt ";
  String bDealt = "Blastoise dealt ";

  public void battle1()
  { 
    if(turn == 0)
    {
      System.out.println();
      lvl = Main.level();
      stats();
      c = new Charizard (lvl, cH, cD, cA);
      m = new Mewtwo (lvl, mH, mD, mA);
      b = new Blastoise (lvl, bH, bD, bA);
      l = new Lapras (lvl, lH, lD, lA);
      turn +=1;
      statsA = 1;
      statsB = 1;
      y = 1;
      x = 1;
    }
    if (l.lHP() <= 0 && m.mHP() > 0)
    {
      y = 2;
      statsA -= 1;
    }
    if (c.cHP() <= 0 && b.bHP() > 0)
    {
      x = 2;
      statsB -= 1;
    }
    if (b.bHP() <= 0 && c.cHP() > 0)
    {
      x = 1;
      statsB += 1;
    }
    if(statsA == 1)
    {
      System.out.println();
      System.out.println(l.toString());
      statsA = 3;
    }
    if(statsA == 2)
    {
      System.out.println();
      System.out.println(m.toString());
      statsA = 0;
    }
    if(statsB == 1)
    {
      System.out.println();
      System.out.println(c.toString());
      statsB = 3;
    }
    else if(statsB == 2)
    {
      System.out.println();
      System.out.println(b.toString());
      statsB = 0;
    }
    if (y == 1)
    {
      System.out.println("Lapras health: " + l.lHP());
      c.z(lD);
      b.z(lD);
    }
    else if (y == 2)
    {
      System.out.println("Mewtwo health: " + m.mHP());
      c.z(mD);
      b.z(mD);
    }
    if (x == 1)
    {
      System.out.println("Charizard health: " + c.cHP() +"\n");
      m.z(cD);
      l.z(cD);
    }
    else if (x == 2)
    {
      System.out.println("Blastoise health: " + b.bHP() +"\n");
      m.z(bD);
      l.z(bD);
    }
    if(turn == 1)
    {
      System.out.println("[Fight]      [Items] \n[Pokemon]      [Run] \n");
      player();
    }
    else if(turn == 2)
    {
      cpu();
    }
    if (!c.cAlive() && !b.bAlive())
    {
      dragonRagePP = 10;
      cEarthquakePP = 10;
      flamethowerPP = 15;
      crunchPP = 15;
      psychicPP = 10;
      splashPP = 40;
      auraspherePP = 20;
      shadowballPP = 15;
      sheercoldPP = 5;
      dragonpulsePP = 10; 
      thunderboltPP = 15;
      blizzardPP = 5;
      hydropumpPP = 5;
      bEarthquakePP = 10;
      icebeamPP = 10;
      surfPP = 15;
      numPotions = 10;
      turn = 0;
      Retry.Retry();
    }
    else if (!m.mAlive() && !l.lAlive())
    {
      System.out.println("\nYou beat your rival and won the battle! Congratulations.");
      System.exit(1);
    }
    else 
    {
      battle1();
    }
  }

  public void player()
  {
    Scanner scanner = new Scanner(System.in);
    String player = scanner.nextLine();
    System.out.println();
    if(x == 1)
    {
      if (player.equalsIgnoreCase("Fight"))
      {
        if(flamethowerPP == 0 && cEarthquakePP == 0 && crunchPP == 0 && dragonRagePP == 0)
        {
            damage = (int) c.struggle();
            System.out.println("Charizard used struggle since you have no PP left. \n");
            cDealt += damage + " damage.";
            System.out.println(cDealt); 
            if (y == 2)
            {
             m.setMHP(damage);
            }
            else 
            {
             l.setLHP(damage);
            }
            System.out.println("Charizard was hit with recoil and did " + (((int)(damage/2))) + " damage to itself. \n");
            c.setCHP(((int)(damage/2)));
            cDealt = "Charizard dealt ";
        }
        else
        {
          System.out.println("[Flamethower " + flamethowerPP + " PP]      [Dragonrage " + dragonRagePP + " PP] \n[Earthquake "+cEarthquakePP + " PP]      [Crunch " + crunchPP + " PP] \n[Back] \n");
          player = scanner.nextLine();
          if (player.equalsIgnoreCase("flamethower"))
          {
            if(flamethowerPP > 0)
            {
              damage = c.flamethower();
              cDealt += damage + " damage.";
              System.out.println(cDealt); 
              flamethowerPP -= 1;
              if (y == 2)
              {
                m.setMHP(damage);
              }
              else if (y == 1)
              {
                l.setLHP(damage);
              }
              cDealt = "Charizard dealt ";
            }
            else
            {
              System.out.println("You have no more PP for flamethower \nUse another move.");
              battle1();
            }
          }
          else if (player.equalsIgnoreCase("earthquake"))
          {
            if (cEarthquakePP > 0)
            {
            damage = c.earthquake();
            cDealt += damage + " damage.";
            System.out.println(cDealt); 
            cEarthquakePP -= 1;
            if (y == 2)
            {
              m.setMHP(damage);
            }
            else if (y == 1)
            {
              l.setLHP(damage);
            }
            cDealt = "Charizard dealt ";
            }
            else
            {
              System.out.println("You have no more PP for earthquake \nUse another move.");
              battle1();
            }
          }
          else if (player.equalsIgnoreCase("dragonrage"))
          {
            if (dragonRagePP > 0)
            {
            damage = c.dragonRage();
            cDealt += damage + " damage";
            System.out.println(cDealt); 
            dragonRagePP -= 1;
            if (y == 2)
            {
              m.setMHP(damage);
            }
            else 
            {
              l.setLHP(damage);
            }
            cDealt = "Charizard dealt ";
            }
            else
            {
              System.out.println("You have no more PP for dragonrage \nUse another move.");
              battle1();
            }
          }
          else if (player.equalsIgnoreCase("crunch"))
          {
            if(crunchPP > 0)
            {
            damage = c.crunch();
            cDealt += damage + " damage.";
            System.out.println(cDealt); 
            crunchPP -= 1;
            if (y == 2)
            {
              m.setMHP(damage);
            }
            else 
            {
              l.setLHP(damage);
            }
            cDealt = "Charizard dealt ";
            }
            else
            {
              System.out.println("You have no more PP for crunch \nUse another move.");
              battle1();
            }
          }
          else if(player.equalsIgnoreCase("back"))
          {
            battle1();
          }
          else
          {
            System.out.println("Enter a valid input.");
            battle1();
          }
        }
      }
        else if (player.equalsIgnoreCase("Items"))
        {
          if (numPotions > 0)
          {
          System.out.println("You have " + numPotions + " potions left \nWould you like to use one(y/n)");
          }
          else
          {
            System.out.println("You have 0 potions left.");
            battle1();
          }
          player = scanner.nextLine();
          if (player.equalsIgnoreCase("y"))
          {
            c.potion();
            numPotions -= 1;
            System.out.println("You healed 20 hp");
          }
          else if (player.equalsIgnoreCase("n"))
          {
            battle1();
          }
          else
          {
            System.out.println("Enter a valid input next time.");
            battle1();
          }
        }
        else if (player.equalsIgnoreCase("Pokemon"))
        {
          if(b.bHP() > 0)
          {
            System.out.println("Would you like to switch to Blastoise(y/n)?");
            player = scanner.nextLine();
            if (player.equalsIgnoreCase("y"))
            {
              x = 2;
              statsB = 2;
            }
            else if (player.equalsIgnoreCase("n"))
            {
              battle1();
            }
            else
            {
              System.out.println("Enter a valid input next time.");
              battle1();
            }
          }
          else 
          {
            System.out.println("You can't swap to Blastoise as it has fainted.");
            battle1();
          }
        }
        else if (player.equalsIgnoreCase("Run"))
        {
          System.out.println("You can't run from this battle.");
          battle1();
        }
        else 
        {
          System.out.println("Enter a valid action.");
          battle1();
        }
      }
    else if(x == 2)
    {
      if (player.equalsIgnoreCase("Fight"))
      {
        if(hydropumpPP == 0 && icebeamPP == 0 && bEarthquakePP == 0 && surfPP == 0)
        {
            damage = (int) b.struggle();
            System.out.println("Blastoise used struggle since you have no PP left. \n");
            bDealt += damage + " damage.";
            System.out.println(bDealt); 
            if (y == 2)
            {
             m.setMHP(damage);
            }
            else 
            {
             l.setLHP(damage);
            }
            System.out.println("Blastoise was hit with recoil and did " + (((int)(damage/2))) + "damage to itself.\n");
            b.setBHP(((int)(damage/2)));
            bDealt = "Blastoise dealt ";
        }
        else
        {
          System.out.println("[Icebeam " + icebeamPP + " PP]      [Hydropump " + hydropumpPP + " PP] \n[Earthquake "+bEarthquakePP + " PP]      [Surf " + surfPP + " PP] \n[Back] \n");
          player = scanner.nextLine();
          if (player.equalsIgnoreCase("Icebeam"))
          {
            if(icebeamPP > 0)
            {
              damage = b.icebeam();
              bDealt += damage + " damage.";
              System.out.println(bDealt); 
              icebeamPP -= 1;
              if (y == 2)
              {
              m.setMHP(damage);
              }
              else 
              {
              l.setLHP(damage);
              }
              bDealt = "Blastoise dealt ";
            }
            else
            {
              System.out.println("You have no more PP for icebeam \nUse another move.");
              battle1();
            }
          }
          else if (player.equalsIgnoreCase("earthquake"))
          {
            if (bEarthquakePP > 0)
            {
              damage = b.earthquake();
              bDealt += damage + " damage.";
              System.out.println(bDealt); 
              bEarthquakePP -= 1;
              if (y == 2)
              {
              m.setMHP(damage);
              }
              else 
              {
              l.setLHP(damage);
              }
              bDealt = "Blastoise dealt ";
            }
            else
            {
              System.out.println("You have no more PP for earthquake \nUse another move.");
              battle1();
            }
          }
          else if (player.equalsIgnoreCase("hydropump"))
          {
            if (hydropumpPP > 0)
            {
              damage = b.hydropump();
              bDealt += damage + " damage.";
              System.out.println(bDealt); 
              hydropumpPP -= 1;
              if (y == 2)
              {
              m.setMHP(damage);
              }
              else 
              {
              l.setLHP(damage);
              }
              bDealt = "Blastoise dealt ";
            }
            else
            {
              System.out.println("You have no more PP for hydropump \nUse another move.");
              battle1();
            }
          }
          else if (player.equalsIgnoreCase("surf"))
          {
            if(surfPP > 0)
            {
              damage = b.surf();
              bDealt += damage + " damage.";
              System.out.println(bDealt); 
              surfPP -= 1;
              if (y == 2)
              {
              m.setMHP(damage);
              }
              else 
              {
              l.setLHP(damage);
              }
              bDealt = "Blastoise dealt ";
            }
            else
            {
              System.out.println("You have no more PP for surf \nUse another move.");
              battle1();
            }
          }
          else if(player.equalsIgnoreCase("back"))
          {
            battle1();
          }
          else
          {
            System.out.println("Enter a valid input.");
            battle1();
          }
        }
      }
        else if (player.equalsIgnoreCase("Items"))
        {
          if (numPotions > 0)
          {
          System.out.println("You have " + numPotions + " potions left \nWould you like to use one(y/n)");
          }
          else
          {
            System.out.println("You have 0 potions left.");
            battle1();
          }
          player = scanner.nextLine();
          if (player.equalsIgnoreCase("y"))
          {
            if(x == 1)
            {
              c.potion();
            }
            else 
            {
              b.potion();
            }
            numPotions -= 1;
            System.out.println("You healed 20 hp");
          }
          else if (player.equalsIgnoreCase("n"))
          {
            battle1();
          }
          else
          {
            System.out.println("Enter a valid input next time.");
            battle1();
          }
        }
        else if (player.equalsIgnoreCase("Pokemon"))
        {
          if(c.cHP() > 0)
          {
            System.out.println("Would you like to switch to Charizard(y/n)?");
            player = scanner.nextLine();
            if (player.equalsIgnoreCase("y"))
            {
              x = 1;
              statsB = 1;
            }
            else if (player.equalsIgnoreCase("n"))
            {
              battle1();
            }
            else
            {
              System.out.println("Enter a valid input next time.");
              battle1();
            }
          }
          else 
          {
            System.out.println("You can't swap to Charizard as it has fainted.");
            battle1();
          }
        }
        else if (player.equalsIgnoreCase("Run"))
        {
          System.out.println("You can't run from this battle.");
          battle1();
        }
        else 
        {
          System.out.println("Enter a valid action.");
          battle1();
        }
      }
    turn += 1;
  }

  public void cpu()
  {
    System.out.println();
    int random = (int) (Math.random() * 4);
    if(y == 2)
    {
      if (auraspherePP <= 0 && psychicPP <= 0 && splashPP <= 0 && shadowballPP <= 0)
      {
        System.out.println("Mewtwo ran out of PP and used Struggle.");
        damage = (int) m.struggle();
        if (x == 1)
        {
          c.setCHP(damage);
        }
        else
        {
          b.setBHP(damage);
        }
        System.out.println("Mewtwo was hit with recoil and did " + ((int)(damage/2)) + " damage to itself.");
        m.setMHP((int)(damage/2));
      }
      else
      {
        if (random == 0 && auraspherePP >= 1)
        {
          damage = m.aurasphere();
          if (x == 1)
          {
            c.setCHP(damage);
          }
          else
          {
            b.setBHP(damage);
          }
          System.out.println("Mewtwo used aurasphere and dealt " + damage + " damage.");
          auraspherePP -= 1;
        }
        else if (random == 1 && psychicPP >= 1)
        {
          damage = m.psychic();
          if (x == 1)
          {
            c.setCHP(damage);
          }
          else
          {
            b.setBHP(damage);
          }
          System.out.println("Mewtwo used psychic and dealt " + damage + " damage.");
          psychicPP -= 1;
        }
        else if (random == 2 && splashPP >= 1)
        {
          System.out.println("Mewtwo used splash and dealt " + m.splash() + " damage.");
          splashPP -= 1;
        }
        else if (random == 3 && shadowballPP >= 1)
        {
          damage = m.shadowball();
          if (x == 1)
          {
            c.setCHP(damage);
          }
          else
          {
            b.setBHP(damage);
          }
          System.out.println("Mewtwo used shadowball and dealt " + damage + " damage.");
          shadowballPP -= 1;
        }
      }
    }
    else if (y == 1)
    {
      if (sheercoldPP <= 0 && dragonpulsePP <= 0 && blizzardPP <= 0 && thunderboltPP <= 0)
      {
        System.out.println("Lapras ran out of PP and used Struggle.");
        damage = (int) l.struggle();
        if (x == 1)
        {
          c.setCHP(damage);
        }
        else
        {
          b.setBHP(damage);
        }
        System.out.println("Lapras was hit with recoil and did " + ((int)(damage/2)) + " damage to itself.");
        l.setLHP((int)(damage/2));
      }
      else
      {
        if (random == 0 && sheercoldPP >= 1)
        {
          damage = l.sheercold();
          if (x == 1)
          {
            c.setCHP(damage);
          }
          else
          {
            b.setBHP(damage);
          }
          if(damage == 0)
          {
            System.out.println("Lapras used Sheercold but missed. \n");
          }
          else
          {
          System.out.println("Lapras used Sheercold. \nIt's a one hit KO");
          }
          sheercoldPP -= 1;
        }
        else if (random == 1 && dragonpulsePP >= 1)
        {
          damage = l.dragonpulse();
          System.out.println("Lapras used thunderbolt and dealt " + damage + " damage.");
          if (x == 1)
          {
            c.setCHP(damage);
          }
          else
          {
            b.setBHP(damage);
          }
          dragonpulsePP -= 1;
        }
        else if (random == 2 && blizzardPP >= 1)
        {
          damage = l.blizzard();
          if (x == 1)
          {
            c.setCHP(damage);
          }
          else
          {
            b.setBHP(damage);
          }
          if(damage == 0)
          {
            System.out.println("Lapras used blizzard but missed. \n");
          }
          else
          {
          System.out.println("Lapras used blizzard and dealt " + damage + " damage.");
          }
          blizzardPP -= 1;
        }
        else if (random == 3 && thunderboltPP >= 1)
        {
          damage = l.thunderbolt();
          System.out.println("Lapras used thunderbolt and dealt " + damage + " damage.");
          if (x == 1)
          {
            c.setCHP(damage);
          }
          else
          {
            b.setBHP(damage);
          }
          thunderboltPP -= 1;
        }
      }
    }
    turn -= 1;
  }

  public void stats()
  {
    cH = 78 + ((int) (2.84 * lvl));
    cD = 78 + ((int) (2.11 * lvl));
    cA = 84 + ((int) (2.11 * lvl));

    mH = 106 + ((int) (3.13 * lvl));
    mD = 90 + ((int) (2.18 * lvl));
    mA = 110 + ((int) (2.42 * lvl));

    bH = 79 + ((int) (2.85 * lvl));
    bD = 83 + ((int) (2.1 * lvl));
    bA = 100 + ((int) (2.3 * lvl));

    lH = 130 + ((int) (3.37 * lvl));
    lD = 80 + ((int) (2.06 * lvl));
    lA = 85 + ((int) (2.12 * lvl));
  }
}