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
public class Bai26 {
    
    public static void In()
    {
        Scanner input = new Scanner(System.in);
        long n;
        while(true)
        {
        System.out.println("Nhap N: ");
         n = input.nextLong();
        if(n>0) break;
        }
        long[] l = Bai12.SoNguyenTo(n);
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(l[j]==0) break;
                if(i%l[j]==0 && i%(l[j]*l[j])==0) System.out.print(i+ " ");
            }
        }
    }
    
}
