/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btvn;

import static java.lang.Math.pow;
import java.util.Random;

/**
 *
 * @author Admin
 */
public class SoNguyenTo {
    
    public static int[] SoNguyenTo(int n)
    {
        int[] c = new int [500];
        if(n<=3) {
            for(int i=1;i<=n;i++)
            {
                c[i]=n;
            }
        }
        else {
            int p=0;
            for(int i=2;i<=n;i++)
            {
                int f = 0;
                for(int j=2;j<i;j++)
                {
                    if (i%j == 0) 
                    {
                        f=1; 
                    }
                }
                if(f == 0) c[p++] = i;
 
            }
        }
 
        for(int i=0;i<n;i++)
        {
            if(c[i] == 0) break;
            System.out.print(c[i] + " ");
        }
 
        return c;
    }
 
    public static int[]  EratosthenesNguyenThuy(int n)
    {
        int[] c = new int [500];
        if(n<=3) {
            for(int i=2;i<=n;i++)
            {
                c[i]=i;
            }
            for(int i=2;i<=n;i++)
        {
            if(c[i] == 0) break;
            System.out.print(c[i] + " ");
        }
            return c;
        }
        int p = 2;
        int j=0;
        int[] boi = new int[500];
        while(true)
        {
        for(int i=2;i<n;i++)
        {
            int temp = p*i;
            if(temp > n) break;
            boi[temp] = 1;
        }
        p++;
        if(boi[p]==1) p++;
        if(p*2 > n) break;
        }  
 
        for(int i=0; i<n;i++)
        {
            if(boi[i]==1) continue;
            c[j++] = i;
        }
 
        for(int i=2;i<=n;i++)
        {
            if(c[i] == 0) break;
            System.out.print(c[i] + " ");
        }
 
        return c;
    }
 
//    public static int[]  EratosthenesPhanDoan(int n)
//    {
//        int[] c = new int [100];
//        
//        return c;
//    }
 
    public static boolean KiemTraNguyenTo(int n)
    {
        for(int i=2;i<n;i++)
        {
            if(n%i==0) return false;
        }
        return true;
    }
 
    public static int PollardRho(int n)
    {
        int a=2;
        int b=2;
        int d;
        while(true)
        {
            a = (a*a + 1)%n;
            b = (b*b +1)%n;
            b = (b*b +1)%n;
            d = Euclide.ThuatToanEuclide(a-b, n);
            if(d>1 && d<n) return d;
            if(d==n) return 0;
        }
    }
    
    public static boolean ThuatToanFermat(int n, int t)
    {
        for(int i=1;i<=t;i++)
        {
            Random rand = new Random();
            int a = rand.nextInt(n-2)+2;
            int r = CongTruNhanChia.NhanBinhPhuongCoLap(n, a, n-1);
            if (r!=1) return false;
        }
        return true;
    }
    
    public static boolean MillerRobin(int n)
    {
        int t = n-1;
        int s=0;
        while(true)
        {
            if(t>=2 && t%2==0) s++;
            else break;
            t/=2;
        }
        int r = (n-1)/(int)(pow(2, s));
        for(int i=1;i<=2;i++)
        {
            Random rand = new Random();
            int a = rand.nextInt(n-2) + 2;
            int y = CongTruNhanChia.NhanBinhPhuongCoLap(n, a, r);
            if(y!=1 && y != n-1)
            {
                int j=1;
                while(j <= s-1 && y!= n-1) 
                {
                    y = (y*y)%n;
                    if(y==1) return false;
                    j+=1;
                }
                if(y!=n-1) return false;
            }
        }
        return true;
    }
    
    public static int SinhSoNguyenTo(int k, int t)
    {
        while(true)
        {
        Random rand = new Random();
        int[] bit = new int[k+1];
        for(int i=0;i<k;i++)
        {
            bit[i] = rand.nextInt(2);
//            System.out.print(bit[i]);
        }
        System.out.println(" ");
        int n = HamChuyenDoi.ThapPhan(bit, 0, bit.length-2);
        if(MillerRobin(n)==true) return n;
        }
    }
    
}