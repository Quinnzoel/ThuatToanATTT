/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btvn;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class InBTVN {
    
    static Scanner input = new Scanner(System.in);
    
    public static void Bai1a(long p,int w)
    {
        System.out.println("Nhap a: ");
        long a = input.nextLong();
        int t = BTVN.Timt(p, w);
        long[] arr = HamChuyenDoi.DangMang(a, p, w);
        System.out.print("Mảng : {");
        for(int i=t-1;i>=0;i--)
        {
            if(i==0) System.out.print(arr[i]);
            else       System.out.print(arr[i] + ", ");
        }
        System.out.println("}");
    }
    
    public static void Bai1b(long p, int w)
    {
        int t = BTVN.Timt(p, w);
        System.out.println("Nhap Mang: ");
        long[] arr = new long [30];
        for(int i=t-1;i>=0;i--)
        {
            arr[i] = input.nextInt();
        }
        long s = HamChuyenDoi.GiaTriMang(p, w, arr);
        System.out.println("Gia tri mang: " + s);
    }
    
    public static void Bai23456(long p, int w)
    {
        int t = BTVN.Timt(p, w);
        System.out.println("Nhap a: ");
        long A = input.nextLong();
        long[] a = HamChuyenDoi.DangMang(A, p, w); 
        System.out.println("Nhap b: ");
        long B = input.nextLong();
        long[] b = HamChuyenDoi.DangMang(B, p, w);
        long[] c = new long[600];
        
        System.out.println("Phep Cong: ");
        c = CongTruNhanChia.PhepCong(p, w, a, b);
        System.out.print("("+c[t]+", (");
        for(int i=t-1;i>=1;i--)
        {
            System.out.print(c[i] +", ");
        }
        System.out.println(c[0]+"))");
        
        System.out.println("Phep Tru: ");
        c = CongTruNhanChia.PhepTru(p, w, a, b);
        System.out.print("("+c[t]+", (");
        for(int i=t-1;i>=1;i--)
        {
            System.out.print(c[i] +", ");
        }
        System.out.println(c[0]+"))");
        
        System.out.println("Pheo cong trep P: ");
        c = CongTruNhanChia.PhepCongTrenFp(p, w, a, b);
        System.out.print("("+c[t]+", (");
        for(int i=t-1;i>=1;i--)
        {
            System.out.print(c[i] +", ");
        }
        System.out.println(c[0]+"))");
        
        
        System.out.println("Phep tru tren P: ");
        c = CongTruNhanChia.PhepTruTrenFp(p, w, a, b);
        System.out.print("("+c[t]+", (");
        for(int i=t-1;i>=1;i--)
        {
            System.out.print(c[i] +", ");
        }
        System.out.println(c[0]+"))");
        
        System.out.println("Phep Nhan: ");
        c = CongTruNhanChia.PhepNhan(p, w, a, b);
        System.out.print("(");
        for(int i=t*2-1;i>0;i--)
        {
            System.out.printf("%d, ", c[i]);
        }
        System.out.println(c[0]+")");
    }
    
    public static void Bai7()
    {
        System.out.println("Nhap a: ");
        long a = input.nextLong();
        System.out.println("Nhap b: ");
        long b = input.nextLong();
        System.out.println(Euclide.ThuatToanEuclide(a, b));
    }
    
    public static void Bai8()
    {
        System.out.println("Nhap a: ");
        long a = input.nextLong();
        System.out.println("Nhap b: ");
        long b = input.nextLong();
        long[] c = Euclide.EuClideMoRong(a, b);
        System.out.println(c[0] + " " + c[1] + " " + c[2]);
    }
    
    public static void Bai81()
    {
        System.out.println("Nhap p: ");
        long p = input.nextLong();
        System.out.println("Nhap a: ");
        long a = input.nextLong();
        System.out.println(CongTruNhanChia.NghichDaoFp(a, p));
    }
    
    public static void Bai9()
    {
        System.out.println("Nhap n: ");
        long n = input.nextLong();
        System.out.println("Nhap a: ");
        long a = input.nextLong();
        System.out.println("Nhap k: ");
        long k = input.nextLong();
        
        System.out.println(CongTruNhanChia.NhanBinhPhuongCoLap(n, a, k));
    }
    
    public static void Bai10()
    {
        System.out.println("Nhap n: ");
        long n = input.nextLong();
        System.out.println("Cach Thong Thuong: ");
        long[] c = SoNguyenTo.SoNguyenTo(n);
        for(int i=0;i<n;i++)
        {
            if(c[i] == 0) break;
            System.out.print(c[i] + " ");
        }
        System.out.println(" ");
        System.out.println("Sang Erosthenes Nguyen Thuy: ");
        c = SoNguyenTo.EratosthenesNguyenThuy(n);
        for(int i=0;i<=n;i++)
        {
            if(c[i] == 0) break;
            System.out.print(c[i] + " ");
        }
        System.out.println(" ");
        System.out.println("Sang Erosthenes Phan Doan: ");
//        c = SoNguyenTo.EratosthenesNguyenThuy(n,2,n);
        c = SoNguyenTo.EratosthenesPhanDoan(n);
        for(int i=0;i<=n;i++)
        {
            if(c[i] == 0) break;
            System.out.print(c[i] + " ");
        }
//        System.out.println(SoNguyenTo.EratosthenesPhanDoan(n));
    }
    
    public static void Bai11()
    {
        System.out.println("Nhap n: ");
        long n = input.nextLong();
        System.out.println(SoNguyenTo.PollardRho(n));
    }
    
    public static void Bai12and13and14()
    {
        System.out.println("Nhap n: ");
        long n = input.nextLong();
        System.out.println("Thong Thuong: ");
        System.out.println(SoNguyenTo.KiemTraNguyenTo(n));
        System.out.println("Fermat: ");
        System.out.println(SoNguyenTo.ThuatToanFermat(n, 2));
        System.out.println("MillerRobin: ");
        System.out.println(SoNguyenTo.MillerRobin(n));
    }
    
    public static void Bai15()
    {
        System.out.println("Nhap k: ");
        int k = input.nextInt();
        System.out.println("So Nguyen To Dc Sinh: "+ SoNguyenTo.SinhSoNguyenTo(k, 3));
    }
    
    public static void Bai16()
    {
        System.out.println("Nhap T: ");
        String T = input.nextLine();
        System.out.println("Nhap P: ");
        String P = input.nextLine();
        
        System.out.println(BTVNSTRING.VetCan(T, P));
    }
    
    public static void Bai17()
    {
        System.out.println("Nhap T: ");
        String T = input.nextLine();
        System.out.println("Nhap P: ");
        String P = input.nextLine();
        
        System.out.println(BTVNSTRING.BoyerMoore(T, P));
    }
    
    public static void Bai18()
    {
        System.out.println("Nhap T: ");
        String T = input.nextLine();
        System.out.println("Nhap P: ");
        String P = input.nextLine();
        
        System.out.println(BTVNSTRING.KMP(T, P));
    }
}
