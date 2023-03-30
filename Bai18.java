/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kthp;

import static java.lang.Math.pow;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Bai18 {
    
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
//            System.out.println(s);
        }
        return s;
    }
    
    public static int Timt(long p, int W)
    {
        long m = Math.round(Math.log(p)/Math.log(2));
        int t = Math.round((float)m/W);
        return t;
    }
    
    public static long[] PhepCong(long p,int W, long[] a, long[] b)
    {
        long[] c = new long[10];
        int e;
        int t = Timt(p, W);
        long temp = a[0]+b[0];
        if(temp >=pow(2,W)) e=1;
        else e=0;
        c[0] = (int) ((temp)%(Math.pow(2, W)));
        for(int i=1;i<t;i++)
        {
            temp = a[i]+b[i]+e;
            c[i]=(int) ((temp)%(Math.pow(2, W)));
            if(temp >=pow(2,W)) e=1;
            else e=0;
        }
        c[t]=e;
        return c;
    }
    
    public static long[] PhepTru(long p, int W, long[] a, long[] b)
    {
        long[] c = new long[10];
        int e;
        int t = Timt(p, W);
        long ptemp;
        long temp = a[0]-b[0];
        if(temp < 0) ptemp = 256 + temp;
        else ptemp = temp;
        if(temp >=pow(2,W) || temp < 0) e=1;
        else e=0;
        c[0] = (int) ((ptemp)%(Math.pow(2, W)));
        for(int i=1;i<t;i++)
        {
            temp = a[i]-b[i]-e;
            if(temp < 0) ptemp = 256 + temp;
            else ptemp = temp;
            c[i]=(int) ((ptemp)%(Math.pow(2, W)));
            if(temp >=pow(2,W) || temp < 0) e=1;
            else e=0;
        }
        c[t]=e;
        return c;
    }
 
    public static long[] PhepCongTrenFp(long p, int W, long[] a, long[] b)
    {
        long[] c = PhepCong(p,W,a,b);
        int t = Timt(p, W);
        if(c[t] == 0) {return c;}
        else {
            c = PhepTru(p,W,c, DangMang(p, p, W));
        }
        return c;
    }
    
    public static void In()
    {
        Scanner input = new Scanner(System.in);
        long p = 2147483647;
        int w = 8;
        int t = Timt(p, w);
        long a,b;
        while(true)
        {
        System.out.println("Nhap A: ");
        a = input.nextLong();
        System.out.println("Nhap B: ");
        b = input.nextLong();
        if(a>0 && b>0) break;
        }
        long[] A = DangMang(a, p, w);
        long[] B = DangMang(b, p, w);
        long[] c = PhepCongTrenFp(p, w, A, B);
        System.out.print("("+c[t]+", (");
        for(int i=t-1;i>0;i--)
        {
            if(c[i]==0 && i!=3) break;
            System.out.print(c[i]+ ", ");
        }
        System.out.print(c[0]+")");
        System.out.println("");
        System.out.println(GiaTriMang(p, w, c));
    }
    
}
