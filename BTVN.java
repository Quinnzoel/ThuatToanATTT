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
    public static int Timt(int p, int W)
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
        int p = 2147483647;
        int W = 8;
        System.out.println(BTVNSTRING.BoyerMoore("abacaabadcabacabaabb", "abacab"));
////        for(int i=0;i<x.length-1;i++)
////        {
////            System.out.print(x[i]);
////        }
//        System.out.println(" ");
//        System.out.println(BTVNSTRING.HamTienXuLy('d', "abacab"));
    }
    
}
