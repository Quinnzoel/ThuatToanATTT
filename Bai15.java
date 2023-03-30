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
public class Bai15 {
    
    public static void In()
    {
        long n;
        while(true)
        {
            System.out.println("Nhap n: ");
        Scanner input = new Scanner(System.in);
        n = input.nextLong();
        if (n>0) break;
        }
        long[] l = Bai12.SoNguyenTo(n);
        for(int i=0;i<l.length;i++)
        {
            if(l[i+1]==0) break;
            if(l[i+1]-l[i]==2) System.out.println(l[i]+" "+l[i+1]);
        }
    }
    
}
