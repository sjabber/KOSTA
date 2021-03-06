package week4;

import java.util.ArrayList;

public class Calendar {

    static ArrayList<String> list = new ArrayList<String>();

    // 숫자체크 여부
    public static boolean isNumber(String str) {
        boolean result = false;
        try {
            Double.parseDouble(str);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return result;
    }

    static String test = "";

    // 달력의 타이틀과 바디
    static void printCalender(int year, int month) {
        printMonthTitle(year, month);
        printMonthBody(year, month);
    }

    static String printCalender2(int year, int month) {
        String str = "";
        str = printMonthTitle2(year, month) + printMonthBody2(year, month);

        return str;
    }

    // 해당 년도가 윤년인지 판별
    public static boolean isLeapYear(int year) {
        return (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0));
    }

    // 달력 바디 출력
    private static void printMonthBody(int year, int month) {
        int count = 0;

        for (int i = 1; i <= getNumberOfDaysInMonth(year, month); i++) {
            if (i < 2) {
                for (int y = 1; y <= getStartDay(year, month); y++) {
//                    System.out.print("\t ");

                    test += "\t ";

                    count += 1;
                }
            }
            test += "\t " + i;
//            System.out.printf("\t %2d", i);
            count += 1;
            if (count == 7) {
//                test += "\n";
//                System.out.println();
                count = 0;
            }
        }
    }

    // 달력 바디 출력
    private static String printMonthBody2 (int year, int month) {
        int count = 0;

        String str = "";

        for (int i = 1; i <= getNumberOfDaysInMonth(year, month); i++) {
            if (i < 2) {
                for (int y = 1; y <= getStartDay(year, month); y++) {
//                    System.out.print("\t ");

                    str += "\t ";

                    count += 1;
                }
            }
            str += "\t " + i;
//            System.out.printf("\t %2d", i);
            count += 1;
            if (count == 7) {
                str += "\n";
//                System.out.println();
                count = 0;
            }
        }
        return str;
    }

    // 해당 달의 첫 요일을 구해서 돌려줌.
    private static int getStartDay(int year, int month) {
        int monthSum = 0;
        int leapYear = 0;
        int daySum = 1;

        for (int i = 1; i < year; i++) {
            monthSum += 365;
            if (isLeapYear(i) == true) {
                leapYear += 1;
            }
        }

        for (int j = 1; j < month; j++) {
            daySum += getNumberOfDaysInMonth(year, j);
        }

        return (monthSum + leapYear + daySum) % 7;

    }

    // 달의 마지막 일을 구함
    private static int getNumberOfDaysInMonth(int year, int month) {

        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else if (month == 2 && isLeapYear(year) == true) {
            return 29;
        } else if (month == 2 && isLeapYear(year) == false) {
            return 28;
        } else {
            return 31;
        }
    }

    // 달의 타이틀 부분 출력
    private static void printMonthTitle(int year, int month) {

        test += "\n";
        test += "\t" + year + "년\t\t\t\t\t\t" + getMonthName(month) + "\n";
        test += "\t===================================================\n";
        test += "\t일\t월\t화\t수\t목\t금\t토\n";
        test += "\t===================================================\n";

//        System.out.println();
//        System.out.println("\t" + year + "년\t\t\t\t\t\t" + getMonthName(month));
//        System.out.println("\t===================================================");
//        System.out.println("\t일\t월\t화\t수\t목\t금\t토");
//        System.out.println("\t===================================================");
    }

    private static String printMonthTitle2 (int year, int month) {

        String str = "";

        str += "\n";
        str += "\t" + year + "년\t\t\t\t\t\t" + getMonthName(month) + "\n";
        str += "\t===================================================\n";
        str += "\t일\t월\t화\t수\t목\t금\t토\n";
        str += "\t===================================================\n";

//        System.out.println();
//        System.out.println("\t" + year + "년\t\t\t\t\t\t" + getMonthName(month));
//        System.out.println("\t===================================================");
//        System.out.println("\t일\t월\t화\t수\t목\t금\t토");
//        System.out.println("\t===================================================");

        return str;
    }

    private static String getMonthName(int month) {
        String monthName = null;
        switch (month) {
            case 1:
                monthName = "1월";
                break;
            case 2:
                monthName = "2월";
                break;
            case 3:
                monthName = "3월";
                break;
            case 4:
                monthName = "4월";
                break;
            case 5:
                monthName = "5월";
                break;
            case 6:
                monthName = "6월";
                break;
            case 7:
                monthName = "7월";
                break;
            case 8:
                monthName = "8월";
                break;
            case 9:
                monthName = "9월";
                break;
            case 10:
                monthName = "10월";
                break;
            case 11:
                monthName = "11월";
                break;
            case 12:
                monthName = "12월";
                break;
        }
        return monthName;
    }
}
