/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kthp;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Bai37 {
    
    public static int FailureFunction(int j, String P)
    {
        String[] TienTo = new String[10];
        String[] HauTo = new String[10];
        TienTo[0] ="";
        HauTo[0] ="";
//        HauTo[1] = "";
        if(j==0) {return -1;}
        else {
            for(int i=1;i<=j;i++)
            {
                TienTo[i] = "" + TienTo[i-1] + P.charAt(i-1);
                HauTo[i] = "" + P.charAt(j-i+1) + HauTo[i-1];
                if(i==1) HauTo[i] = "";
//                System.out.println("i: " + i +" "+TienTo[i] +" j "+ j +" " + HauTo[i]);
            }
            int count = 0 ;
            for(int i=1;i<=j;i++)
            {
                for(int k=1;k<=j;k++)
                {
                    if(TienTo[i].equalsIgnoreCase(HauTo[k])) count++;
                }
            }
            return count;
            
        }
//        return -1;
    }
    
    public static int KMP(String T, String P)
    {
        int j=0;
        int i=0;
        int count=0;
        while(true)
        {
//            System.out.println("i+j "+ tong  + " "+ j + " " + T.charAt(i+j) + " " + P.charAt(j));
            if(T.charAt(i+j)!=P.charAt(j))
            {
                i = i + j - FailureFunction(j, P);
                j = FailureFunction(j, P);
                if(j==-1) j=0;
                count = 0;
            }
            else {
                j++;
                count++;
            }
//            System.out.println("count " +count);
            if(count==P.length()) return i;
        }
    }
    
    public static void In()
    {
        Scanner input = new Scanner(System.in);
        while(true)
        {
            System.out.println("Nhap S2: ");
            String a = input.nextLine();
            System.out.println("Nhap S1: ");
            String b = input.nextLine();
            if(b.length()>a.length()) System.out.println("Ham P > T -> Huy");
            else { System.out.println("Vi tri: "+ KMP(a, b)); break;}
        }
    }
    
}
