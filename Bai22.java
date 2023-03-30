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
public class Bai22 {
    
    public static long GiaTriF(long i)
    {
        long y=0;
        if(Bai2.CheckNguyenTo(i)==true) return i;
        return y;
    }
    
    public static void In()
    {
        Scanner input = new Scanner(System.in);
        long l,r;
        while(true)
        {
            System.out.println("Nhap L: ");
         l = input.nextLong();
        System.out.println("Nhap R: ");
         r = input.nextLong();
         if(l>0 && r>0) break;
        }
        long tong = 0;
        for(long i=l;i<r;i++)
        {
            for(long j=i+1;j<=r;j++)
            {
                tong += GiaTriF(i)*GiaTriF(j);
            }
        }
        System.out.println(tong);
    }
    
}
