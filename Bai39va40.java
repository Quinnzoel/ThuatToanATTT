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
public class Bai39va40 {
    
    public static void In()
    {
        Scanner input = new Scanner(System.in);
        long[] a = new long[1000];
        System.out.println("So luong so trong mang: ");
        long n = input.nextLong();
        System.out.println("Nhap mang A: ");
        for(int i=0;i<n;i++)
        {
            System.out.print("A["+i+"]: ");
            a[i] = input.nextLong();
        }
        
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(Bai2.CheckNguyenTo(Bai20.UCLN(a[i], a[j]))==true) System.out.println(a[i] + " " +a[j]);
            }
        }
    }
    
}