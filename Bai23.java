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
public class Bai23 {
    
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
        long tong =0;
        long[] l = Bai12.SoNguyenTo(b);
        for(int i=0;i<l.length;i++)
        {
            if(l[i]<a) continue;
            if(l[i]>b || l[i]==0) break;
            tong+=l[i];
            System.out.print(l[i] + " ");
        }
        System.out.println("");
        System.out.println(tong);
        if(Bai2.CheckNguyenTo(tong)==true) System.out.println("YES");
        else System.out.println("NO");
    }
    
}
