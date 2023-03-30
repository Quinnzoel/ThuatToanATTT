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
public class Bai3 {
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
    
    public static int timq(long n)
    {
        int q=0;
        for(long i=n;i>=2;i--)
        {
            if(Bai2.CheckNguyenTo(i)==false) continue;
            
            if(n%i==0) q+=i;
        }
        return q;
    }
    
    public static int timp(long n)
    {
        int p=0;
        for(long i=n;i>=1;i--)
        {
            
            if(n%i==0) p+=i;
        }
        return p;
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
        System.out.println("Nhap N: ");
        Scanner input = new Scanner(System.in);
        long n = input.nextLong();
        long N = n + timp(n) + tims(n) - timq(n) -timk(n);
        System.out.println(N);
    }
    
}
