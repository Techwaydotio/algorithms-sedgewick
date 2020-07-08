package Chap01.code;

import java.util.Date;

public class Ex1213 {
    class Transaction implements Comparable<Transaction> {
        String who;
        Date when;
        double amount;

        Transaction(String who, Date when, double amount) {
            this.who = who;
            this.when = when;
            this.amount = amount;
        }

        String who() {
            return who;
        }

        Date when() {
            return when;
        }

        double getAmount() {
            return amount;
        }

        @Override
        public String toString() {
            StringBuilder s = new StringBuilder();
            s.append("<Transaction ");
            s.append("who=" + who);
            s.append(" when=" + when);
            s.append(" amount=" + amount);
            s.append(">");
            return s.toString();
        }

        @Override
        public boolean equals(Object that) {
            // If the object is compared with itself then return true
            if (that == this) {
                return true;
            }

            if (!(that instanceof Transaction)) {
                return false;
            }

            Transaction t = (Transaction) that;

            // Compare the data members and return accordingly
            return Double.compare(amount, t.getAmount()) == 0
                    && t.who == who && when == t.when;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + (int) amount;
            result = 31 * result + when.hashCode();
            result = 31 * result + who.hashCode();
            return result;
        }

        @Override
        public int compareTo(Transaction that) {
            if (when.compareTo(that.when) < 0)
                return -1;
            if (when.compareTo(that.when) > 0) {
                return 1;
            }
            // Transaction is identical: compare amount and who
            if (this.amount < that.amount) {
                return -1;
            } else if (this.amount > that.amount) {
                return 1;
            } else {
                return who.compareTo(that.who);
            }
        }
    }
}
