/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btvn;

import static btvn.BTVN.Timt;
import static java.lang.Math.pow;

/**
 *
 * @author Admin
 */
public class CongTruNhanChia {
    
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
            c = PhepTru(p,W,c, HamChuyenDoi.DangMang(p, p, W));
        }
        return c;
    }
 
    public static long[] PhepTruTrenFp(long p, int W, long[] a, long[] b)
    {
        long[] c = PhepTru(p,W,a,b);
        int t = Timt(p, W);
        if(c[t] == 0) {return c;}
        else {
            c = PhepCong(p,W,c, HamChuyenDoi.DangMang(p, p, W));
        }
        return c;
    }
 
    public static long[] PhepNhan(long p, int W, long[] a, long[] b)
    {
        long U,V = 0;
        long UV = 0;
        long[] c = new long [30];
        int t = Timt(p, W);
        for(int i=0;i<t;i++)
        {
            U=0;
            for(int j=0;j<t;j++)
            {
                UV = c[i+j] + a[i]*b[j] + U;
                V = HamChuyenDoi.ThapPhan(HamChuyenDoi.NhiPhan(UV), 8, 15);
                U = HamChuyenDoi.ThapPhan(HamChuyenDoi.NhiPhan(UV), 0, 7);
                c[i+j] = V;
            }
            c[i+t] = U;
        }
        return c;
    }
    
    public static long NghichDaoFp(long a, long p)
    {
        long u=a;
        long v=p;
        long x1=1;
        long x2=0;
        long q,r,x;
        while(u!=1)
        {
            q=v/u;
            r=v-q*u;
            x=x2-q*x1;
 
            v=u;
            u=r;
            x2=x1;
            x1=x;
        }
 
        return x1%p;
    }
    
    public static long NhanBinhPhuongCoLap(long n,long a, long k)
    {
        long[] c = new long[5000];
        long temp = k;
        // Doi Thanh so nhi phan
        for(int i=0;k>0;i++)
        {
            c[i] = k%2;
            k=k/2;
        }
        c = HamChuyenDoi.CatMang(c);
        long b=1;
        if(temp==0) return b;
        long A=a;
        if(c[0] == 1) b=a;
        for(int i=1;i<c.length;i++)
        {
            A=((int)pow(A,2))%n;
            if(c[i]==1) b=(A*b)%n;
        }
        
        return b;
    }
    
}
