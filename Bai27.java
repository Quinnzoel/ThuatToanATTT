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
public class Bai27 {
    
    public static void In()
    {
        Scanner input = new Scanner(System.in);
        long a,b;
        while(true)
        {
        System.out.println("Nhap A: ");
         a = input.nextLong();
        System.out.println("Nhap B: ");
         b = input.nextLong();
        if(a>0 && b>0) break;
        }
        for(long i=a;i<b;i++)
        {
//            if(a==0) i=1;
            for(long j=i+1;j<=b;j++)
            {
                if(Bai2.CheckNguyenTo(Bai20.UCLN(i, j))==true) System.out.println(i+ " "+j);
            }
        }
    }
    
}
