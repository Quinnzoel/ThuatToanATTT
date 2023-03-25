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
public class Bai2 {
    
    public static boolean CheckNguyenTo(long n)
    {
        if(n==0 || n==1) return false;
        for(int i=2;i<n;i++)
        {
            if(n%i==0) return false;
        }
            return true;
    }
    
    public static boolean KiemTraChuSo(long n, int k)
    {
        int dem=0;
        while(true)
        {
            n/=10;
            dem++;
            if(n<=0) break;
        }
        if(dem==k) return true;
        else return false;
    }
    
    public static void Nchusonguyento(int n)
    {
        long[] l = new long[5000];
        long f=1;
        int i=0;
        while(true)
        {
            if(KiemTraChuSo(f, n)==true) break;
            f*=10;
        }
        while(true)
        {
            if(KiemTraChuSo(f, n)==false) break;
            if(CheckNguyenTo(f)==true) System.out.print(f + " ");;
            f++;
        }
    }
    
    public static void In()
    {
        System.out.println("Nhap n: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Nchusonguyento(n);
    }
    
}
