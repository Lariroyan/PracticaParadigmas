package portfolio6;

import java.util.List;

public abstract class Accountable {
    public abstract int balance() ;
    //public String report(){ return report( "" ); }
  //  public abstract String report( String prefix );
    public abstract List<Account> accounts();

    public abstract void reportOn(Report report);
}
