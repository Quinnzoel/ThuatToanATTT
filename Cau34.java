/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kthp;

import static java.lang.Math.pow;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Cau34 {
    
    public static int NgauNhien(long n) 
    {
        while(true)
        {
           int a = new Random().nextInt(1000)+2;   
//           System.out.println("so  ngau nhien: " + a);
           if (a <= n-2 && a>=2) return a;
        }
    }
    
    public static long[] CatMang(long[] a)
    {
        int b = 0;
        for(int i=a.length-1;i>=0;i--)
        {
            if(a[i]==1) {b=i+1; break; }
        }
        long[] d = Arrays.copyOfRange(a, 0, b);
        
//        for(int i=0;i<d.length;i++)
//        {
//            if(d[i]==1) {b=i; break;}
//        }
//        long[] e = Arrays.copyOfRange(d, b, d.length);
        return d;
    }
    
    public static long NhanBinhPhuongCoLap(long n,long a, long k)
    {
        long[] c = new long[500000];
        long temp = k;
        // Doi Thanh so nhi phan
        for(int i=0;k>0;i++)
        {
            c[i] = k%2;
            k=k/2;
        }
        c = CatMang(c);
        long b=1;
        if(temp==0) return b;
        long A=a;
        if(c[0] == 1) b=a;
        for(int i=1;i<c.length;i++)
        {
            A=((int)pow(A,2))%n;
            if(c[i]==1) b=(A*b)%n;
        }
        
        return b;
    }
    
    public static boolean ThuatToanFermat(long n, int t)
    {
        for(int i=1;i<=t;i++)
        {
            int a = NgauNhien(n);
            long r = NhanBinhPhuongCoLap(n, a, n-1);
//            System.out.println(r);
            if (r!=1) return false;
        }
        return true;
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
        if(ThuatToanFermat(n, 2)==true) System.out.println("So Nguyen To");
        else System.out.println("Hop so");
    }
    
}
