public class Lapras
{
  private int lLevel;
  private double lHealth;
  private int lDefense;
  private double lAttack;
  private int p;
  

  public Lapras (int l, double h, int d, double a)
  {
    lLevel = l;
    lHealth = h;
    lDefense = d;
    lAttack = a;
  }

  public Lapras(double h)
  {
    lHealth = h;
  }
  
  public Lapras()
  {
  }

  public int lLvl()
  {
    return lLevel;
  }

  public double lHP()
  {
    return lHealth;
  }

  public int lDef()
  {
    return lDefense;
  }
  
  public double lAtk()
  {
    return lAttack;
  }

  public int z(int a)
  {
    p = a;
    return p;
  }

  public boolean lAlive()
  {
    if (lHP() > 0)
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  
  public int sheercold()
  {
    int sheercoldHitChance = (int) (Math.random() * 101);
    if (sheercoldHitChance <= 33)
    {
      return Integer.MAX_VALUE;
    }
    else
    {
      return (0);
    }
  }
  
  public int blizzard()
  {
    int blizzardHitChance = (int) (Math.random() * 101);
    if (blizzardHitChance <= 70)
    {
      return ((int)(((((2 * lLvl() / 5 + 2) * 110 * lAtk() / p/50)+2)*random())));
    }
    else
    {
      return (0);
    }
  }

  public int thunderbolt()
  {
    return ((int)(((((2 * lLvl() / 5 + 2) * 90 * lAtk() / p/50)+2)*random())));
  }

  public int dragonpulse()
  {
    return ((int)(((((2 * lLvl() / 5 + 2) * 85 * lAtk() / p/50)+2)*random())));
  }

  public int struggle() //1/2 damage dealt as recoil
  {
    return (int) ((int)(((((2 * lLvl() / 5 + 2) * 50 * lAtk() / p / 50)+2)*random())));
  }

  public void setLHP(double a)
  {
    lHealth -= a;
  }


  public void potion()
  {
    lHealth += 20;
  }
  
  public String toString()
  {
    return("Lapras stats: \nLevel: " + lLevel + "\nHealth: " + lHealth + "\nAttack: " + lAttack + "\nDefense: " + lDefense + "\n");
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