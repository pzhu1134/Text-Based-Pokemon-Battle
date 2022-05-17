public class Blastoise
{
  private int bLevel;
  private double bHealth;
  private int bDefense;
  private double bAttack;
  private int p; //defense of other pokemon
  

  public Blastoise (int l, double h, int d, double a)
  {
    bLevel = l;
    bHealth = h;
    bDefense = d;
    bAttack = a;
  }

  public Blastoise(double h)
  {
    bHealth = h;
  }
  
  public Blastoise()
  {
  }


  public int bLvl()
  {
    return bLevel;
  }
  
  public double bHP()
  {
    return bHealth;
  }

  public int bDef()
  {
    return bDefense;
  }
  
  public double bAtk()
  {
    return bAttack;
  }

  public int z(int a)
  {
    p = a;
    return p;
  }

  public boolean bAlive()
  {
    if (bHP() > 0)
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  
  public int hydropump()
  {
    int hydropumpHitChance = (int) (Math.random() * 101);
    if (hydropumpHitChance <= 80)
    {
      return ((int)(((((2 * bLvl() / 5 + 2) * 110 * bAtk() / p/50)+2)*random()*1.5)));
    }
    else
    {
      return (0);
    }
  }
  
  public int icebeam()
  {
    return ((int)(((((2 * bLvl() / 5 + 2) * 90 * bAtk() / p/50)+2)*random())));
  }

  public int earthquake()
  {
    return (int) ((int)(((((2 * bLvl() / 5 + 2) * 100 * bAtk() / p / 50)+2)*random())));
  }

  public int surf()
  {
    return (int) ((int)(((((2 * bLvl() / 5 + 2) * 90 * bAtk() / p / 50)+2)*random()*1.5)));
  }

  public int struggle() //1/2 damage dealt as recoil
  {
    return (int) ((int)(((((2 * bLvl() / 5 + 2) * 50 * bAtk() / p / 50)+2)*random())));
  }

  public void setBHP(double a)
  {
    bHealth -= a;
  }

  public void potion()
  {
    bHealth += 20;
  }
  
  public String toString()
  {
    return("Blastoise stats: \nLevel: " + bLevel + "\nHealth: " + bHealth + "\nAttack: " + bAttack + "\nDefense: " + bDefense + "\n");
  }
  
  public double random()
  {
    double random = Math.random();
    while (random < 0.84)
    {
      random = Math.random();
    }
    return random;
  }
}