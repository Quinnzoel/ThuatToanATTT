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
public class Bai25 {
    
    public static void In()            
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap N: ");
        long n = input.nextLong();
        long[] l = Bai12.SoNguyenTo(n);
        for(int i=0;i<l.length;i++)
        {
            int f=0;
            if(l[i]==0) break;
            for(int j=i;j<l.length;j++)
            {
                if(l[j]==0) break;
                long c = n-l[i]-l[j];
                if(Bai2.CheckNguyenTo(c)==true && c>=2) {
                    System.out.println(l[i] +" "+ l[j] +" "+ c);
                    f=1;
                break;}
            }
            if(f==1) break;
        }
    }
    
}
