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
public class Bai43 {
    
    public static void In()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap N: ");
        long n = input.nextLong();
        long p = Bai42.SinhSoNguyenTo(7);
        for(long i=1;i<100;i++)
        {
            if(Bai2.CheckNguyenTo(Cau34.NhanBinhPhuongCoLap(n, i, p))==true) System.out.print(i + " ");
        }
    }
    
}
