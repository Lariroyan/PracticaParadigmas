package portfolio;

import java.util.List;

public interface Accountable {

  public int balance();
  public String report();
  public String report( String prefix );
  public List<Account> accounts();
  
}
