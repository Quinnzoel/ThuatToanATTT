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
public class Bai9va11 {
    
    
    public static void In()
    {
        long n;
        while(true)
        {
            Scanner input = new Scanner(System.in);
            System.out.println("Nhap n: ");
            n = input.nextLong();
            if(n>0) break;
        }
        int dem=0;
        int s=0;
        for(int i=2;i<=n;i++)
        {
            if(Bai7.checknguyento(i)==true) {
//                System.out.print(i+" ");
                dem++;
                s=s+i;
            }
        }
        
        System.out.println("Bai 9: "+dem);
        
        System.out.println("Bai 11: "+s);
        
    }
    
}
