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
        System.out.println("Nhap A: ");
        long A= input.nextLong();
        System.out.println("Nhap B: ");
        long B = input.nextLong();
        int dem=0;
        for(long i=A;i<=B;i++)
        {
            if(Bai2.CheckNguyenTo(i)==true) dem++;
        }
        System.out.println(dem);
    }
}
