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
public class Bai20 {
    
    public static long UCLN(long a,long b)
    {
        if(a==b) return a;
        else if(a>b)
        {
            long s = a%b;
            if (s==0) return b;
            while(true)
            {
                long t = b%s;
                b=s;
                s=t;
                if(s==0) break;
            }
            return b;
        }
        else if(a<b)
        {
            long s = b%a;
            if (s==0) return a;
            while(true)
            {
                long t = a%s;
                a=s;
                s=t;
                if(s==0) break;
            }
            return a;
        }
        
        return 1;
    }
    
    public static void In()
    {
        Scanner input = new Scanner(System.in);
        long m,n,d;
        while(true)
        {
        System.out.println("Nhap M: ");
         m = input.nextLong();
        System.out.println("Nhap N: ");
         n = input.nextLong();
        System.out.println("Nhap D: ");
         d = input.nextLong();
        if(m>0 && n>0 && d>0) break;
        }
        
        for(long i=m+1;i<n;i++)
        {
            for(long j=i;j<n;j++)
            {
                if(UCLN(i, j)==d) {
                    System.out.println(i +" "+j);
                }
            }
        }
    }
    
}
