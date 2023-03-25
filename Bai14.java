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
public class Bai14 {
    
    public static int SoChuSo(long n)
    {
        int dem=0;
        while(true)
        {
            n/=10;
            dem++;
            if(n<=0) break;
        }
        return dem;
    }
    
    public static long DaoNguoc(long n)
    {
        int dem = SoChuSo(n);
        long m=0;
        for(int i=dem-1;i>=0;i--)
        {
            m+=  (n%10)*(int)Math.pow(10, i);
//            System.out.println(m);
            n=n/10;
//            System.out.println(n);
        }
        return m;
    }
    
    public static boolean CheckLapPhuong(long n)
    {
        for(long i=1;i<=Math.sqrt(n);i++)
        {
            if(n==i*i*i) return true;
        }
        return false;
    }
    
    public static void In()
    {
        for(int i=100;i<=999;i++)
        {
            if(Bai2.CheckNguyenTo(i) == true && CheckLapPhuong(DaoNguoc(i))==true) System.out.print(i+" ");
        }
    }
    
}
