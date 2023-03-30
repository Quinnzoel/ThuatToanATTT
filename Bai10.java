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
public class Bai10 {
    
    public static int timk(long n)
    {
        int k=0;
        for(long i=n;i>=2;i--)
        {
            if(Bai2.CheckNguyenTo(i)==false) continue;
            
            if(n%i==0) k++;
        }
        return k;
    }
    
    public static int tims(long n)
    {
        int s=0;
        for(long i=n;i>=1;i--)
        {   
            if(n%i==0) s++;
        }
        return s;
    }
    
    public static void In()
    {
        System.out.println("Nhap n: ");
        Scanner input = new Scanner(System.in);
        long n;
        while(true)
        {
        System.out.println("Nhap n: ");
         n = input.nextLong();
        if(n>0) break;
        }
        System.out.println("So uoc: "+ tims(n));
        System.out.println("So uoc nguyen to: "+timk(n));
    }
}
