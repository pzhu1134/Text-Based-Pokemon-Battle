public class Mewtwo
{
  private int mLevel;
  private double mHealth;
  private int mDefense;
  private double mAttack;
  private int p;

  public Mewtwo (int l, double h, int d, double a)
  {
    mLevel = l;
    mHealth = h;
    mDefense = d;
    mAttack = a;
  }

  public Mewtwo()
  {
  }

  public Mewtwo(double h)
  {
    mHealth = h;
  }

  public int mLvl()
  {
    return mLevel;
  }

  public double mHP()
  {
    return mHealth;
  }

  public int mDef()
  {
    return mDefense;
  }

  public double mAtk()
  {
    return mAttack;
  }

  public int z(int a)
  {
    p = a;
    return p;
  }

  public boolean mAlive()
  {
    if (mHP() > 0)
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  public int splash()
  {
    return (0);
  }

  public int psychic()
  {
    return (int) ((int)(((((2 * mLvl() / 5 + 2) * 90 * mAtk() / p / 50)+2)*random())));
  }

  public int shadowball()
  {
    return (int) ((int)(((((2 * mLvl() / 5 + 2) * 80 * mAtk() / p / 50)+2)*random())));
  }

  public int aurasphere()
  {
    return (int) ((int)(((((2 * mLvl() / 5 + 2) * 80 * mAtk() / p / 50)+2)*random())));
  }

  public int struggle() //1/2 damage dealt as recoil
  {
    return (int) ((int)(((((2 * mLvl() / 5 + 2) * 50 * mAtk() / p / 50)+2)*random())));
  }

  public void setMHP(double a)
  {
    mHealth -= a;
  }

  public String toString()
  {
    return("Mewtwo stats: \nLevel: " + mLevel + "\nHealth: " + mHealth + "\nAttack: " + mAttack + "\nDefense: " + mDefense + "\n");
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
