package portfolio6;

import java.util.ArrayList;
import java.util.List;

public class Portfolio extends Accountable {

    public List<Accountable> accounts = new ArrayList();

    public int balance() {
        return accounts.stream()
                .map( (account) -> account.balance() )
                .reduce(0, (a, b) -> a + b);
    }

    public Portfolio addAccount( Accountable anAccount ) {
        if ( contains( anAccount ) ) throw new RuntimeException();

        accounts.add( anAccount );
        return this;
    }

    public boolean contains( Accountable anAccount ) {
        List  reminder = accounts();
        reminder.retainAll( anAccount.accounts() );
        return !reminder.isEmpty();
    }

    public List<Account> accounts() {
        return accounts.stream().map( (accountable) -> accountable.accounts() )
                .reduce( new ArrayList(), (a, b) -> { a.addAll( b ); return a; } );
    }

    @Override
    public void reportOn(Report report) {
        report.reportPortfolio(this);
    }

//    public String report( String prefix ) {
//        List<String> report = new ArrayList();
//
//        report.add( prefix + "Portfolio:" );
//        accounts.forEach( (accountable) -> {
//            report.add( accountable.report( prefix + "  ") );
//        });
//
//        return String.join("\n", report);
//    }

}

