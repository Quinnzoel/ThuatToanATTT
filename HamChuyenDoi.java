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
    
    
    public static int[] CatMang(int[] a)
    {
        int b = 0;
        for(int i=a.length-1;i>=0;i--)
        {
            if(a[i]==1) {b=i+1; break; }
        }
        int[] d = Arrays.copyOfRange(a, 0, b);
        
        for(int i=0;i<d.length;i++)
        {
            if(d[i]==1) {b=i; break;}
        }
        int[] e = Arrays.copyOfRange(d, b, d.length);
        return e;
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
    
    
    
}
