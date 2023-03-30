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
public class Bai8 {
    
    public static long[] TPrime(long n)
{
    long[] l = new long[5000];
    
    for(long i=n;i>0;i--)
    {
        for(long j=i;j>0;j--)
        {
            if(i%j==0) l[(int)i]++;
        }
    }
    
    return l;
}

public static void In()
{
    Scanner input = new Scanner(System.in);
        long n;
        while(true)
        {
        System.out.println("Nhap N: ");
         n = input.nextLong();
        if(n>0) break;
        }
    long[] l = TPrime(n);
    for(int i=0;i<=n;i++)
    {
        if(l[i]==3) System.out.print(i+" ");
    }
}
    
}
