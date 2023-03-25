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
public class Bai6 {
    
    
    public static boolean UocSo(long n)
    {
        long[] u = new long [5000];
        
        int j=0;
        for(long i=1;i<n;i++)
        {
            if(n%i==0) u[j++] = i;
        }
        int s=0;
        for(int i=0;i<j;i++)
        {
            s+=u[i];
        }
//        System.out.println(s);
        if(s==n) return true;
        
        return false;
    }
    
    public static void In()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap n: ");
        long n = input.nextLong();
        for(int i=1;i<n;i++)
        {
            if(UocSo(i)==true) System.out.print(i + " ");
        }
        
    }
    
}
