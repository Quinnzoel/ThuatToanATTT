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
public class Bai12 {
    
    public static long[] SoNguyenTo(long n)
    {
        long[] l = new long[5000];
        int j=0;
        for(int i=2;i<=n;i++)
        {
            if(Bai2.CheckNguyenTo(i)==true) l[j++] = i;
        }
        return l;
    }
    
    public static int Vitri(long n,int k)
    {
        long[] l = SoNguyenTo(n);
        int j = 0;
        for(int i=0;i<=l.length;i++)
        {
            if(l[i]==0) {
                j=i;
                break;
            }
        }
        int i=0;
        while(i+k<j)
        {
            long s=0;
            for(int t=i;t<i+k;t++)
            {
                s+=l[t];
            }
            if(Bai2.CheckNguyenTo(s)==true && s<=n) return i;
            else {
            i++;
            }
        }
        return -1;
    }
    
    public static void In()
    {
        System.out.println("Nhap n: ");
        Scanner input = new Scanner(System.in);
        long n = input.nextLong();
        System.out.println("Nhap k: ");
        int k = input.nextInt();
        int j = Vitri(n, k);
        long[] l = SoNguyenTo(n);
        for(int i=j;i<j+k;i++)
        {
            System.out.println(l[i]);
        }
    }
}
