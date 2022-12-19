import java.text.DecimalFormat;
import java.util.Scanner;

/*
Andrea Rottman
Susan Wilson
Java
Decemeber 14, 2022

Gets input minutes for a rental and displays, hours, additional minutes, and rental cost
 */
public class Ch3Sunshine {
    //global variable
    static DecimalFormat dollarAmt;
    static Scanner inputDevice;
    static int hours, addMinutes;
    static Double rentalCost;
    static String oRentalCost;

    public static void main(String[] args) {
        init();
        int iMinutes = input();
        calcs(iMinutes);
        output();
    }

    public static void init() {
         inputDevice = new Scanner(System.in);
         dollarAmt = new DecimalFormat("$#,###.00");
    }

    private static int input() {
        int iMinutes;
        System.out.println("Enter minutes you are renting the equiptment for: ");
        String iData = inputDevice.nextLine();
        try{
            iMinutes=Integer.parseInt(iData);
        }
        catch(Exception e){
            System.out.println("Error in Minutes. must be  a WHOLE numeric value");
            System.out.println("Rate assigned to the value of sixty");
            iMinutes=60;
        }
        return iMinutes;

    }

    public static void calcs(int iMinutes) {
        hours = iMinutes/60;
        addMinutes=iMinutes%60;
        rentalCost=(40.00*hours)+(1.00*addMinutes);
    }

    private static void output() {
        oRentalCost=dollarAmt.format(rentalCost);
        CompanyMotto.getMotto();
        System.out.printf("%-5s%-5s%-18s%-5s%-11s%-5s\n", "Hours","", "Additional Minutes","","Rental Cost", "");
        System.out.printf("%1s%2s%16s%2s%6s%14s%5s", "",hours,"",addMinutes,"",oRentalCost,"");
    }
}
