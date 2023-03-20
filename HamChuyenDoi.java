/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btvn;

import static btvn.BTVN.Timt;
import static java.lang.Math.pow;
import java.util.Arrays;

/**
 *
 * @author Admin
 */
public class HamChuyenDoi {
    
    
    public static long[] CatMang(long[] a)
    {
        int b = 0;
        for(int i=a.length-1;i>=0;i--)
        {
            if(a[i]==1) {b=i+1; break; }
        }
        long[] d = Arrays.copyOfRange(a, 0, b);
        
//        for(int i=0;i<d.length;i++)
//        {
//            if(d[i]==1) {b=i; break;}
//        }
//        long[] e = Arrays.copyOfRange(d, b, d.length);
        return d;
    }
    
    public static long[] NhiPhan(long a)
    {
        int c=15;
        long[] b = new long[30];
        while(a>0) 
        {
            b[c--] = a%2;
            a=a/2;
        }
//        for(int i=b.length-1;i>=0;i--)
//        {
//            if(b[i]==1) {c=i+1; break; }
//        }
//        long[] d = Arrays.copyOfRange(b, 0, c);
//        for(int i=0;i<d.length;i++)
//        {
//            if(d[i]==1) {c=i; break; }
//        }
//        d = Arrays.copyOfRange(b, c, d.length);
        return b;
    }
 
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
 
    public static long[] DangMang(long a,long p, int W) {
        int t = Timt(p, W);
        long[] arr = new long[t];
        int temp = (int)Math.pow(2, (t-1)*W);
        arr[t-1] = a/temp;
        for(int i=t-2;i>=0;i--)
        {
            long s = a;
            for(int j=t-1;j>i;j--)
            {
                temp = (int)Math.pow(2, j*W);
                s = s-arr[j]*temp;
            }
            temp = (int)Math.pow(2, i*W);
            arr[i]=s/temp;
        }
        return arr;
    }
 
    public static long GiaTriMang(long p, int W, long[] arr)
    {
        int t = Timt(p, W);
        long s=0;
        for(int i=t-1;i>=0;i--)
        {
            s+=arr[i]*Math.pow(2, i*W);
            System.out.println(s);
        }
        return s;
    }
    
    
    
}
