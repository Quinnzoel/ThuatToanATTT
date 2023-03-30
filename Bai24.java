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
public class Bai24 {
    
    public static long[] BinhPhuong()
    {
        long[] l = new long[5000];
        l[0] =1;
        for(int i=1;i<=1000;i++)
        {
            l[i]= i*i;
        }
        return l;
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
        long[] l = BinhPhuong();
        long[] nt=Bai12.SoNguyenTo(b);
        for(int i=0;i<l.length;i++)
        {
            if(l[i]==0 || l[i] > b) break;
            for(int j=i;j<l.length;j++)
            {
                if(l[j]==0 || l[i] > b) break;
                long tong = l[i] + l[j];
//                System.out.println(tong);
                for(int k=0;k<nt.length;k++)
                {
                    if(nt[k]<a) continue;
                    if(nt[k]>b || nt[k]==0) break;
                    if(nt[k]==tong) System.out.print(nt[k]+ " ");
                }
            }
        }
    }
}
