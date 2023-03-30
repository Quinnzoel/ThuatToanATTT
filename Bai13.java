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
public class Bai13 {
    public static void In()
    {
        long n;
        while (true)
        {
           Scanner input = new Scanner(System.in);
        System.out.println("Nhap n: ");
        n = input.nextLong(); 
        if(n>0) break;
        }
        long[] l = Bai12.SoNguyenTo(n);
        for(int i=0;i<l.length;i++)
        {
            if(l[i]==0) break;
            if(Bai2.CheckNguyenTo(l[i])==false) continue;
            for(int j=i;j<l.length;j++)
            {
                if(l[j]==0) break;
                if(Bai2.CheckNguyenTo(l[j])==false) continue;
                if(Bai2.CheckNguyenTo(l[i]+l[j])==true && Bai2.CheckNguyenTo(l[j]-l[i])==true) {
                    System.out.println(l[i]+ " va " + l[j]);
                    
                }
            }
        }
    }
    
}
