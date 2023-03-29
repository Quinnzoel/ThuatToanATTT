/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kthp;

import static java.lang.Math.pow;
import java.util.Scanner;
import static kthp.Cau34.ThuatToanFermat;

/**
 *
 * @author Admin
 */
public class Bai35 {
    
    public static boolean MillerRobin(long n)
    {
        long t = n-1;
        int s=0;
        while(true)
        {
            if(t>=2 && t%2==0) s++;
            else break;
            t/=2;
        }
        long r = (n-1)/(int)(pow(2, s));
        for(int i=1;i<=2;i++)
        {
            int a = Cau34.NgauNhien(n);
            long y = Cau34.NhanBinhPhuongCoLap(n, a, r);
            if(y!=1 && y != n-1)
            {
                int j=1;
                while(j <= s-1 && y!= n-1) 
                {
                    y = (y*y)%n;
                    if(y==1) return false;
                    j+=1;
                }
                if(y!=n-1) return false;
            }
        }
        return true;
    }
    
    public static void In()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap n: ");
        long n = input.nextLong();
        if(MillerRobin(n)==true) System.out.println("So Nguyen To");
        else System.out.println("Hop so");
    }
    
}
