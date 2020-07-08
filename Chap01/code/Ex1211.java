package Chap01.code;

import java.util.Calendar;
import java.util.Date;

public class Ex1211 {
    public class SmartDate {
        private final int month;
        private final int day;
        private final int year;

        public SmartDate(int m, int d, int y) throws IllegalArgumentException {
            validateDate(m, d, y);
            month = m;
            day = d;
            year = y;
        }

        public int month() {
            return month;
        }

        public int day() {
            return day;
        }

        public int year() {
            return year;
        }

        public String toString() {
            return month() + "/" + day() + "/" + year();
        }

        boolean isLeapYear(int year) {
            return year%4 == 0 && (year%100 != 0 || year%400 == 0);
        }

        private void validateDate(int m, int d, int y) throws IllegalArgumentException {
            if (m > 12 || m < 1) {
                throw new IllegalArgumentException("Invalid Month");
            }
            if (d > 31 || d < 1) {
                throw new IllegalArgumentException("Invalid Day");
            }
            if (isLeapYear(y) && m == 2 && d > 29) {
                throw new IllegalArgumentException("Invalid Day");
            }
        }
    }
}
