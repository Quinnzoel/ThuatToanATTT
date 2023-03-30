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
public class Bai21 {
    
    public static int soluong(long a,long b)
    {
        int dem=0;
        for(long i=a;i<=b;i++)
        {
            long count=0;
            long[] l = Bai12.SoNguyenTo(i-1);
            for(int j=0;j<l.length;j++)
            {
                if(l[j]==0) break;
                count++;
            }
            if(Bai2.CheckNguyenTo(count)==true) {
                dem++;
//                System.out.println(i);
            }
        }
        return dem;
    }
    
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
        System.out.println(soluong(a, b));
    }
    
}
