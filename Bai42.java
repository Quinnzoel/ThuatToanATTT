/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kthp;

import static java.lang.Math.pow;
import java.util.Random;

/**
 *
 * @author Admin
 */
public class Bai42 {
    
    public static long ThapPhan(long[] a, int c, int d)
    {
        long b = 0;
        for(int i=d-c;i>=0;i--)
        {
            b += pow(2, i)*a[c];
            c++;
        }
        return b;
    }
    
    public static long SinhSoNguyenTo(int k)
    {
        while(true)
        {
        Random rand = new Random();
        long[] bit = new long[k+1];
        for(int i=0;i<k;i++)
        {
            bit[i] = rand.nextInt(2);
            System.out.print(bit[i]);
        }
        System.out.println(" ");
        long n = ThapPhan(bit, 0, bit.length-2);
        if (n==0) continue;
        if(Bai2.CheckNguyenTo(n)) return n;
        }
    }
    
    public static void In()
    {
        Random rand = new Random();
        int k = rand.nextInt(8)+2;
        System.out.println(k);
        long p = SinhSoNguyenTo(k);
        long q = SinhSoNguyenTo(k);
        System.out.println(p + " " + q);
        for(long i=1;i<100;i++)
        {
            if(Bai2.CheckNguyenTo(Cau34.NhanBinhPhuongCoLap(q, i, p))==true) System.out.print(i + " ");
        }
    }
    
}
