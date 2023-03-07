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
    
    public static int[] PhepCong(int p,int W, int[] a, int[] b)
    {
        int[] c = new int[10];
        int e;
        int t = Timt(p, W);
        int temp = a[0]+b[0];
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
       System.out.println("("+e+", ("+c[3] + ", "+ c[2]+ ", "+ c[1]+ ", "+ c[0]+"))");
        c[t]=e;
        return c;
    }
 
    public static int[] PhepTru(int p, int W, int[] a, int[] b)
    {
        int[] c = new int[10];
        int e;
        int t = Timt(p, W);
        int ptemp;
        int temp = a[0]-b[0];
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
        System.out.println("("+e+", ("+c[3] + ", "+ c[2]+ ", "+ c[1]+ ", "+ c[0]+"))");
        return c;
    }
 
    public static int[] PhepCongTrenFp(int p, int W, int[] a, int[] b)
    {
        int[] c = PhepCong(p,W,a,b);
        int t = Timt(p, W);
        if(c[t] == 0) {return c;}
        else {
            c = PhepTru(p,W,c, HamChuyenDoi.DangMang(p, p, W));
        }
        return c;
    }
 
    public static int[] PhepTruTrenFp(int p, int W, int[] a, int[] b)
    {
        int[] c = PhepTru(p,W,a,b);
        int t = Timt(p, W);
        if(c[t] == 0) {return c;}
        else {
            c = PhepCong(p,W,c, HamChuyenDoi.DangMang(p, p, W));
        }
        return c;
    }
 
    public static int[] PhepNhan(int p, int W, int[] a, int[] b)
    {
        int U,V = 0;
        int UV = 0;
        int[] c = new int [10];
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
    
    public static int NghichDaoFp(int a, int p)
    {
        int u=a;
        int v=p;
        int x1=1;
        int x2=0;
        int q,r,x;
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
    
    public static int NhanBinhPhuongCoLap(int n,int a, int k)
    {
        int[] c = new int[16];
        int temp = k;
        // Doi Thanh so nhi phan
        for(int i=0;k>0;i++)
        {
            c[i] = k%2;
            k=k/2;
        }
        c = HamChuyenDoi.CatMang(c);
        int b=1;
        if(temp==0) return b;
        int A=a;
       if(c[0] == 1) b=a;
        for(int i=1;i<c.length;i++)
        {
            A=((int)pow(A,2))%n;
            if(c[i]==1) b=(A*b)%n;
        }
        
        System.out.println(b);
        return b;
    }
    
}
