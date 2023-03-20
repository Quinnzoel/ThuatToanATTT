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
    public static int Timt(long p, int W)
    {
        long m = Math.round(Math.log(p)/Math.log(2));
        int t = Math.round((float)m/W);
        return t;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        long p = 2147483647;
        int W = 8;
        //Bai 1 a
//        System.out.println("Nhap a: ");
//        int a = input.nextInt();
//        System.out.println(HamChuyenDoi.DangMang(a, p, W));
        //Bai 1 b
//        System.out.println("Nhap Mang a:");
//        int[] a = new int[10];
//        for(int i=3;i>=0;i--)
//        {
//            a[i] = input.nextInt();
//        }
//        System.out.println(HamChuyenDoi.GiaTriMang(p, W, a));
        //Bai 2,3,4,5
        InBTVN show = new InBTVN();
        
//        show.Bai1a(p, W);
//        
//        show.Bai1b(p, W);
//        
//       show.Bai23456(p, W);

//        show.Bai7();
        
//        show.Bai8();

//show.Bai81();

//show.Bai9();

show.Bai10();

//show.Bai11();

//show.Bai12and13and14();

//show.Bai15();

//show.Bai16();

//show.Bai17();

//show.Bai18();
    }
    
}
