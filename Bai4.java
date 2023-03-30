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
public class Bai4 {
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
        int dem=0;
        for(long i=A;i<=B;i++)
        {
            if(Bai2.CheckNguyenTo(i)==true) dem++;
        }
        System.out.println(dem);
    }
}
