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
    
    public static int NgauNhien(long n) 
    {
        while(true)
        {
           int a = new Random().nextInt(1000)+2;   
//           System.out.println("so  ngau nhien: " + a);
           if (a <= n-2 && a>=2) return a;
        }
    }
    
    public static long[] SoNguyenTo(long n)
    {
        long[] c = new long [5000];
        if(n<=3) {
            for(int i=1;i<n;i++)
            {
                c[i-1]=i+1;
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
 
        return c;
    }
 
    public static long[]  EratosthenesNguyenThuy(long n)
    {
        long[] c = new long [5000];
        if(n<=3) {
            for(int i=1;i<n;i++)
            {
                c[i-1]=i+1;
            }
            return c;
        }
        int p = 2;
        int j=0;
        int[] boi = new int[5000];
        boi[0] = 1;
        boi[1] = 1;
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
 
        for(int i=0; i<=n;i++)
        {
            if(boi[i]==1) continue;
            c[j++] = i;
        }
 
 
        return c;
    }
 
    public static long[]  EratosthenesPhanDoan(long n)
    {
        long[] boi = new long [5000];
        
        long[] c = new long [5000];
        
        int d = (int) Math.sqrt(n);
        int so = d;
        int s = 2;
        int r = s+d;
        long[] e = EratosthenesNguyenThuy(d);
        int dem=0;
        for(int i=0;i<e.length;i++)
        {
            if(e[i]==0) break;
            c[i] = e[i];
            dem++;
        }
        while(true)
        {
            int m = d+d;
            if(m>n) break;
            d+=1;
            int temp = (int) Math.sqrt(m);
            for(int i=d;i<=m;i++)
            {
                for(int p=2;p<=temp;p++)
                {
                    if(i%p==0) {
                        boi[i]=1;
                        break;
                    }
                }
            }
        }
        
        for(int i=(int)so+1;i<n;i++)
        {
            if(boi[i]==1) continue;
            c[dem++] = i;
        }
        
        
        return c;
        
        
    }
 
    public static boolean KiemTraNguyenTo(long n)
    {
        for(int i=2;i<n;i++)
        {
            if(n%i==0) return false;
        }
        return true;
    }
 
    public static long PollardRho(long n)
    {
        long a=2;
        long b=2;
        long d;
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
    
    public static boolean ThuatToanFermat(long n, int t)
    {
        for(int i=1;i<=t;i++)
        {
            Random rand = new Random();
            int a = NgauNhien(n);
            long r = CongTruNhanChia.NhanBinhPhuongCoLap(n, a, n-1);
//            System.out.println(r);
            if (r!=1) return false;
        }
        return true;
    }
    
    public static boolean MillerRobin(long n)
    {
        long t = n-1;
        int s=0;
        while(true)
        {
            if(t>=2 && t%2==0) s++;
            else break;
            t/=2;
        }
        long r = (n-1)/(int)(pow(2, s));
        for(int i=1;i<=2;i++)
        {
            int a = NgauNhien(n);
            long y = CongTruNhanChia.NhanBinhPhuongCoLap(n, a, r);
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
    
    public static long SinhSoNguyenTo(int k, int t)
    {
        while(true)
        {
        Random rand = new Random();
        long[] bit = new long[k+1];
        for(int i=0;i<k;i++)
        {
            bit[i] = rand.nextInt(2);
//            System.out.print(bit[i]);
        }
//        System.out.println(" ");
        long n = HamChuyenDoi.ThapPhan(bit, 0, bit.length-2);
        if(MillerRobin(n)==true) return n;
        }
    }
    
}
