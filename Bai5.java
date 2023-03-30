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
public class Bai5 {
    
    public static void In()
    {
        Scanner input = new Scanner(System.in);
        long A,B;
        while(true)
        {
        System.out.println("Nhap A: ");
         A = input.nextLong();
        System.out.println("Nhap B: ");
         B = input.nextLong();
        if(A>0 && B>0) break;
        }
        long s=0;
        for(long i=B;i>=A;i--)
        {
            if(Bai2.CheckNguyenTo(i)==true) s+=i;
        }
        System.out.println("Tong: "+s);
    }
    
}
