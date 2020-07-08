package Chap01.code;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex1219 {
    public class Transaction {
        String who;
        Date when;
        double amount;

        public Transaction(String transaction) throws ParseException {
            String[] fields = transaction.split("/");
            who = fields[0];
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            when = format.parse(fields[1]);
            amount = Double.parseDouble(fields[2]);
        }
    }
}
