public class Charizard
{
  private int cLevel;
  private double cHealth;
  private int cDefense;
  private double cAttack;
  final private int dRage = 40;
  private int p; //defense of other pokemon
  

  public Charizard (int l, double h, int d, double a)
  {
    cLevel = l;
    cHealth = h;
    cDefense = d;
    cAttack = a;
  }

  public Charizard(double h)
  {
    cHealth = h;
  }
  
  public Charizard()
  {
  }

  public int cLvl()
  {
    return cLevel;
  }
  
  public double cHP()
  {
    return cHealth;
  }

  public int cDef()
  {
    return cDefense;
  }
  
  public double cAtk()
  {
    return cAttack;
  }

  public boolean cAlive()
  {
    if (cHP() > 0)
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  
  public int flamethower()
  {
    return ((int)(((((2 * cLvl() / 5 + 2) * 90 * cAtk() / p/50)+2)*random()*1.5)));
  }

  public int earthquake()
  {
    return ((int)(((((2 * cLvl() / 5 + 2) * 100 * cAtk() / p/50)+2)*random())));
  }

  public int dragonRage()
  {
    return ((int)(((((2 * cLvl() / 5 + 2) * dRage * cAtk() / p/50)+2)*random())));
  }

  public int crunch()
  {
    return ((int)(((((2 * cLvl() / 5 + 2) * 80 * cAtk() / p/50)+2)*random())));
  }

  public int struggle() //1/2 damage dealt as recoil
  {
    return (int) ((int)(((((2 * cLvl() / 5 + 2) * 50 * cAtk() / p / 50)+2)*random())));
  }

  public void setCHP(double a)
  {
    cHealth -= a;
  }

  public int z(int a)
  {
    p = a;
    return p;
  }

  public void potion()
  {
    cHealth += 20;
  }
  
  public String toString()
  {
    return("Charizard stats: \nLevel: " + cLevel + "\nHealth: " + cHealth + "\nAttack: " + cAttack + "\nDefense: " + cDefense + "\n");
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