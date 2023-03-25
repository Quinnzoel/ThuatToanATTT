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
public class Bai7 {
    
    public static boolean checknguyento(long n)
    {
        for(int i=2;i<n;i++)
        {
            if(n%i==0) return false; 
        }
        return true;
    }
    
    public static boolean CheckDaoNguoc(long n)
    {
        if(checknguyento(n)==false) return false; 
        long m=0;
        long temp=n;
        int dem=0;
        while(temp>0)
        {
            temp=temp/10;
            dem++;
        }
//        System.out.println(dem);
        for(int i=dem-1;i>=0;i--)
        {
            m+=  (n%10)*(int)Math.pow(10, i);
//            System.out.println(m);
            n=n/10;
//            System.out.println(n);
        }
        
//        System.out.println(m);
        
        if(checknguyento(m)==true) return true;
        
        return false;
    }
    
    public static void In()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap n: ");
        long n = input.nextLong();
        for(int i=10;i<=n;i++)
        {
            if(CheckDaoNguoc(i)==true) System.out.println(i + " ");
        }
        
    }
    
}
