class Solution {
    public int daysBetweenDates(String date1, String date2) {
        int d1 = countDays(date1);
        int d2 = countDays(date2);

        return Math.abs(d1 - d2);
    }

    public int countDays(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));

        int[] days = {31, 28, 31, 30, 31, 30,
                      31, 31, 30, 31, 30, 31};

        int total = 0;

        // Add days of previous years
        for (int y = 1971; y < year; y++) {
            if (isLeap(y))
                total += 366;
            else
                total += 365;
        }

        // Add days of previous months
        for (int m = 1; m < month; m++) {
            total += days[m - 1];

            if (m == 2 && isLeap(year))
                total++;
        }

        // Add current day
        total += day;

        return total;
    }

    public boolean isLeap(int year) {
        return (year % 400 == 0) ||
               (year % 4 == 0 && year % 100 != 0);
    }
}
