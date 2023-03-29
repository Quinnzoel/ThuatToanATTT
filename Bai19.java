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
public class Bai19 {
    
    public static long GiaTriBieuThuc(long a,long b,long c,long n,long m)
    {
        long x=n;
        while(x<=m)
        {
            if(Bai2.CheckNguyenTo(a*x*x+b*x+c)==true) return x;
            else x++;
        }
        return -1;
    }
    
    public static void In()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap A: ");
        long a = input.nextLong();
        System.out.println("Nhap B: ");
        long b = input.nextLong();
        System.out.println("Nhap C: ");
        long c = input.nextLong();
        System.out.println("Nhap n: ");
        long n = input.nextLong();
        System.out.println("Nhap m: ");
        long m = input.nextLong();
        System.out.println(GiaTriBieuThuc(a, b, c,n,m));
    }
    
}
