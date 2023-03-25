/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kthp;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Bai16 {

    public static void In()
    {
        System.out.println("Nhap n: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Random rand = new Random();
        long[] l = new long[n];
        for(int i=0;i<n;i++)
        {
            l[i] = rand.nextInt(1000000);
            if(Bai2.CheckNguyenTo(l[i]) ==true) System.out.print(l[i] + " ");
        }
    }
    
}
