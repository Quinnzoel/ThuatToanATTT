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
public class Bai41 {
    
    public static void In()
    {
        Scanner input = new Scanner(System.in);
        long a,k,n;
        while(true)
        {
        System.out.println("Nhap a: ");
         a = input.nextLong();
        System.out.println("Nhap k: ");
         k = input.nextLong();
        System.out.println("Nhap n: ");
         n = input.nextLong();
        if(a>0 &&k>0 && n>0) break;
        }
        
        if(Bai2.CheckNguyenTo(Cau34.NhanBinhPhuongCoLap(n, a, k))==true) System.out.println("Co " + Cau34.NhanBinhPhuongCoLap(n, a, k));
        else System.out.println("Khong");
        
    }
    
}
