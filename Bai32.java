/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kthp;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Bai32 {
    
    public static long NghichDao(long a, long b)
    {
        long i=1;
        while(true)
        {
            if((a*i)%b == 1) return i;
            else i++;
//            System.out.println("i: "+i);
        }
    }
    
    public static long TimE(long y)
    {
        Random rand = new Random();
        for(long i=2;i<y;i++)
        {
            if(Bai20.UCLN(i, y)==1) {
//                System.out.println(i+ "%"+y);
            long e = i;
            return e;
            }
        }
            return -1;
    }
    
    public static long NguyenToCungNhau(long y)
    {
        long d = NghichDao(TimE(y), y);
        return d;
    }
    
    public static long BanMa(char x)
    {
        return (long)x;
    }
    
    public static void in()
    {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        int p = rand.nextInt(400)+100;
        int q = rand.nextInt(400)+100;
        System.out.println(p+" "+q);
        long n = p*q;
        long y = (p-1)*(q-1);
        long d = NguyenToCungNhau(y);
        System.out.println("d: "+d);
        long[] M = new long[30];
        System.out.println("Nhap m: ");
        String m = input.nextLine();
        m=m+"123";
        String c = "";
        for(int i=0;i<m.length();i++)
        {
            M[i] = BanMa(m.charAt(i));
            long temp = Cau34.NhanBinhPhuongCoLap(n, M[i], TimE(y));
            System.out.println("temp: "+temp);
            c += (char)(temp);
        }
        System.out.println(c);
        m="";
        long[] C = new long [30];
        for(int i=0;i<c.length();i++)
        {
            C[i] = BanMa(c.charAt(i));
            long temp = Cau34.NhanBinhPhuongCoLap(n, C[i], d);
            System.out.println("temp: "+temp);
            m+=(char)(temp);
        }
        System.out.println(m);
    }
    
}
