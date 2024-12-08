package portfolio6;

import java.util.ArrayList;
import java.util.List;

public class Report {
    String prefix = "";
    List<String> report = new ArrayList();

    public static String report( Accountable anAccountable){
        Report report = new Report();
        return report.list(anAccountable);

    }

    private String list(Accountable target) {
        target.reportOn(this);
        return String.join("\n", report);

    }

//    public static String report(Account account) { //es static porque es mensaje de clase
//
//
//            report.add( prefix + "Cuenta:" );
//            account.transactions.forEach( (transaction) -> {
//                report.add( prefix + "  " + transaction.reportDetail() );
//            });
//
//            report.add( prefix + "Balance: " + account.balance() );
//
//            return String.join("\n", report);
//    }

//    public static String report(Portfolio portfolio) {
//        String prefix = "";
//            List<String> report = new ArrayList();
//
//            report.add( prefix + "Portfolio:" );
//            portfolio.accounts.forEach( (accountable) -> {
//                report.add( accountable.report( prefix + "  ") );
//            });
//
//            return String.join("\n", report);
//    }

    public void reportAccount(Account account) {
        report.add( prefix + "Cuenta:" );
        account.transactions.forEach( (transaction) -> {
            report.add( prefix + "  " + transaction.reportDetail() );
        });

        report.add( prefix + "Balance: " + account.balance() );

    }

    public void reportPortfolio(Portfolio target) {
        report.add( prefix + "Portfolio:" );
        target.accounts.forEach( (accountable) -> {
            String oldPrefix = prefix;
            prefix = prefix + "  ";
            accountable.reportOn(this);
            prefix= oldPrefix;
        });
    }
}
