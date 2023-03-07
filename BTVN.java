/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btvn;
import static java.lang.Math.pow;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Admin
 */
public class BTVN {
    public static int[] CatMang(int[] a)
    {
        int b = 0;
        for(int i=a.length-1;i>=0;i--)
        {
            if(a[i]==1) {b=i+1; break; }
        }
        int[] d = Arrays.copyOfRange(a, 0, b);
        return d;
    }
    public static int Timt(int p, int W)
    {
        long m = Math.round(Math.log(p)/Math.log(2));
        int t = Math.round((float)m/W);
        return t;
    }
 
    public static int[] NhiPhan(int a)
    {
        int c=15;
        int[] b = new int[30];
        while(a>0) 
        {
            b[c--] = a%2;
            a=a/2;
        }
        for(int i=b.length-1;i>=0;i--)
        {
            if(b[i]==1) {c=i+1; break; }
        }
        int[] d = Arrays.copyOfRange(b, 0, c);
        for(int i=0;i<d.length;i++)
        {
            if(b[i]==1) {c=i; break; }
        }
        d = Arrays.copyOfRange(b, c, d.length);
        for(int i=0;i<d.length;i++)
        {
            System.out.print(d[i]);
        }
        return b;
//        return b;
    }
 
    public static int ThapPhan(int[] a, int c, int d)
    {
        int b = 0;
        int e = 0;
        for(int i=d;i>=0;i--)
        {
            b += pow(2, i)*a[c];
            c++;
        }
        return b;
    }
 
    public static int[] DangMang(int a,int p, int W) {
        int t = Timt(p, W);
        int[] arr = new int[t];
        int temp = (int)Math.pow(2, (t-1)*W);
        arr[t-1] = a/temp;
        for(int i=t-2;i>=0;i--)
        {
            int s = a;
            for(int j=t-1;j>i;j--)
            {
                temp = (int)Math.pow(2, j*W);
                s = s-arr[j]*temp;
            }
            temp = (int)Math.pow(2, i*W);
            arr[i]=s/temp;
        }
        System.out.print("Mảng : {");
        for(int i=t-1;i>=0;i--)
        {
            if(i==0) System.out.print(arr[i]);
            else       System.out.print(arr[i] + ", ");
        }
        System.out.println("}");
        return arr;
    }
 
    public static int GiaTriMang(int p, int W, int[] arr)
    {
        int t = Timt(p, W);
        int s=0;
        for(int i=t-1;i>=0;i--)
        {
            s+=arr[i]*Math.pow(2, i*W);
        }
        System.out.println("S: "+ s);
        return s;
    }
 
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
            c = PhepTru(p,W,c,DangMang(p, p, W));
        }
        return c;
    }
 
    public static int[] PhepTruTrenFp(int p, int W, int[] a, int[] b)
    {
        int[] c = PhepTru(p,W,a,b);
        int t = Timt(p, W);
        if(c[t] == 0) {return c;}
        else {
            c = PhepCong(p,W,c,DangMang(p, p, W));
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
                V = ThapPhan(NhiPhan(UV), 8, 15);
                U = ThapPhan(NhiPhan(UV), 0, 7);
                c[i+j] = V;
            }
            c[i+t] = U;
        }
        return c;
    }
 
    public static int ThuatToanEuclide(int a,int b)
    {
        if(a==b) return a;
        else if(a>b)
        {
            int s = a%b;
            if (s==0) return b;
            while(true)
            {
                int t = b%s;
                b=s;
                s=t;
                if(s==0) break;
            }
            return b;
        }
        else if(a<b)
        {
            int s = b%a;
            if (s==0) return a;
            while(true)
            {
                int t = a%s;
                a=s;
                s=t;
                if(s==0) break;
            }
            return a;
        }
        int c =1;
        return c;
    }
    public static int[] EuClideMoRong(int a,int b)
    {
        int d,x,y,x1,x2,y1,y2,q,r;
        int[] c = new int [3];
        if(a<b)
        {
            int temp = a;
            a=b;
            b=temp;
        }
 
        if(a>=b)
        {
            if (b==0) {
                d=a; x=1; y=0;
                c[0] = d;
                c[1] = x;
                c[2] = y;
                return c;
            }
            x2=1;
            x1=0;
            y2=0;
            y1=1;
            while(b>0)
            {
                q=a/b;
                r=a-q*b;
                x=x2-q*x1;
                y=y2-q*y1;
 
                a=b;
                b=r;
                x2=x1;
                x1=x;
                y2=y1;
                y1=y;
            }
            d=a;
            x=x2;
            y=y2;
            c[0] = d;
            c[1] = x;
            c[2] = y;
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
            d = ThuatToanEuclide(a-b, n);
            if(d>1 && d<n) return d;
            if(d==n) return 0;
        }
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
        c = CatMang(c);
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

    public static boolean ThuatToanFermat(int n, int t)
    {
        for(int i=1;i<=t;i++)
        {
            Random rand = new Random();
            int a = rand.nextInt(n-2)+2;
            int r = NhanBinhPhuongCoLap(n, a, n-1);
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
            int y = NhanBinhPhuongCoLap(n, a, r);
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
        int n = ThapPhan(bit, 0, bit.length-2);
        if(MillerRobin(n)==true) return n;
        }
    }
    
    public static int VetCan(String T, String P)
    {
        for(int i=0;i<T.length();i++)
        {
            int count = 1;
            if(T.charAt(i) == P.charAt(0)) 
            {
                for(int j=1;j<P.length();j++)
            {
                if(T.charAt(i+j)!=P.charAt(j)) break;
                else count ++;
            }
            if(count == P.length()) return i+1;
            }
        }
        System.out.println(T);
        System.out.println(P);
        return -1;
    }
    
    public static int BoyerMoore(String T, String P)
    {
        
        return -1;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        int p = 2147483647;
        int W = 8;
        System.out.println(VetCan("12748132983" ,"13"));
//        System.out.println(MillerRobin(101));
//        NhanBinhPhuongCoLap(211, 41, 101);
//        int[] a = NhanBinhPhuongCoLap(211, 41, 101);
//        for(int i=0;i<a.length;i++)
//        {
//            System.out.print(a[i]);
//        }
                
//       System.out.println("Điền a: ");
//       int a = input.nextInt();
//       System.out.println("Điền b: ");
//       int b = input.nextInt();
//        System.out.println("Điền mảng A: ");
//        int[] a = new int[10];
//        for(int i=3;i>=0;i--)
//        {
//            System.out.println("Điền A["+i+"]");
//            a[i] = input.nextInt();
//        }
//        int[] b = new int[10];
//        System.out.println("Điền mảng B: ");
//        for(int i=3;i>=0;i--)
//        {
//            System.out.println("Điền B["+i+"]");
//            b[i] = input.nextInt();
//        }
 
// Nhan
//        int c[] = PhepNhan(p, W, DangMang(765432, p, W), DangMang(123456, p, W));
//        for(int i=Timt(p, W)*2;i>=0;i--)
//        {
//            System.out.printf("%d, ", c[i]);
//        }
//                
////        DangMang(p,p,W);
//////        DangMang(a,p,W);
//////        GiaTriMang(p,W,a);
////        PhepCong(p,W,DangMang(a, p, W),DangMang(b, p, W));
//        int[] c = PhepCongTrenFp(p, W, a, b);
//        for(int i=4;i>=0;i--)
//        {
//            System.out.println(c[i]);
//        }
    }
    
}
