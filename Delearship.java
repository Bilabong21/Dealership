/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package delearship;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author USER
 */
public class Delearship {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
         Scanner bn = new Scanner(System.in);
       String[] Months ={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug"};
       double[] Delear1 ={22000.00,3300000.00,44000.00,89000.00,150000.00,250000.00,31000.00,84000.00};
       double[] Delear2 ={65000.00,95000.00,88000.99,53000.55,31000.00,65500.00,98000.00,74000.00};
       double[] Delear3 ={55000.00,15000.00,96000.00,98000.00,88000.00,85000.00,65000.00,44000.00};
       int[] Customers ={0,0,0,0,0,0,0,0};
       double[] TotalSales ={0,0,0,0,0,0,0,0};
       populateCustomers(Customers);
       int option = getUserOption();
       while (option!=3)
       {
           switch (option)
           {
               case 1:

                   System.out.println(displayDelearDetails(Delear1,Delear2,Delear3,Customers,Months, TotalSales,determineDelearTotals(Delear1),determineDelearTotals(Delear2),determineDelearTotals(Delear3),determineTotalCust(Totalcust),determineDelearTotals(TotalSales)));
               break;

               case 2:
                   System.out.println("Enter a month you want to check highest sales for 1-6 :");
                   int months = bn.nextInt();
                   System.out.println(determineHigestDealerSales(Delear1,Delear2,Delear3,Months));
                break;

               case 3:
                   System.out.println("Good bye!!");
                break;

               default:
                   System.out.println("Invalid option");



           }
           option = getUserOption();
       }
    }
    public static void populateCustomers(int[] p_Customers )
    {
        Random ran = new Random();
       for (int b=0; b<p_Customers.length;b++)
       {
           p_Customers[b] = ran.nextInt(3000)+20;

       }
    }
    public static int getUserOption()
    {
        Scanner bn = new Scanner(System.in);
        System.out.println("1 - to display all dealerships.\n2 - to Determine and dispaly the delearship with highest sales.\n3 - to exit");
        int option = bn.nextInt();

        return option;
    }
    public static double determineDelearTotals(double[] DelearType)
    {
        double DelearTotals = 0.00;
       for (int i=0;i<DelearType.length;i++)
       {
           DelearTotals+=DelearType[i];
       }
       return DelearTotals;
    }
   public static int determineTotalCust(int[] p_Customers )
    {
       int Totalcust = 0;
       for (int i=0 ; i < p_Customers.length;i++)
          {
              Totalcust+=p_Customers[i];
          }
       return Totalcust;
    }
    public static void calcTotalSales(double[] p_Delear1,double[] p_Delear2,double[] p_Delear3,double[] p_TotalSales)
    {
       for (int i=0;i<p_TotalSales.length;i++)
       {
           p_TotalSales[i]=p_Delear1[i]+p_Delear2[i]+p_Delear3[i];
       }
    }
 public static String determineHigestDealerSales(double[] p_Delear1, double[] p_Delear2, double[] p_Delear3, String[] p_Months)
    {
        double highest=p_Delear1[p_Months];
        String data="Best sales for month "+(p_Months )+": V contract ("+highest+")";

        if(highest<p_Delear2[p_Months] )
        {
            highest=p_Delear2[p_Months ];
            data="Best sales for month "+(p_Months )+": M contract ("+highest+")";
        }
        if(highest<p_Delear3[p_Months ])
        {
            highest=p_Delear3[p_Months];
            data="Best sales for month "+(p_Months)+": C contract ("+highest+")";
        }

        return data;
    }
    public static void displayDelearDetails(double[] p_Delear1,double[] p_Delear2,double[] p_Delear3,int[] p_Customers,String[] p_Months,double[] p_TotalSales,double Delear1Total,double Delear2Total,double Delear3Total,int Totalcust,double TotalSales)
    {
        System.out.println("Months\tDelear1\tDelear2\tDelear3\tCustomers\tTotal Sales");
        for (int i = 0; i < p_Delear1.length; i++) {
            System.out.println(p_Months[i]+"\t"+p_Delear1[i]+" \t"+p_Delear2[i]+"\t"+p_Delear3[i]+"\t "+p_Customers[i]+"\t "+p_TotalSales[i]);
        }
        System.out.println("==================================================================================================================================\n"
                + "\t"+Delear1Total+"\t"+Delear2Total+"\t"+Delear3Total+"\t"+Totalcust+"\t"+TotalSales);
    }
    
}
 