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
        System.out.println("Nhap A: ");
        int A= input.nextInt();
        System.out.println("Nhap B: ");
        int B = input.nextInt();
        int s=0;
        for(int i=B;i>=A;i--)
        {
            int f=0;
            for(int j=2;j<i;j++)
            {
                if(i%j==0) 
                {f=1;break;}
            }
            if(f==0) s+=i;
        }
        System.out.println("Tong: "+s);
    }
    
}
