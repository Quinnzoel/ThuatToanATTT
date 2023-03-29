/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kthp;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Bai36 {
    
    public static int MIN(int m, int n)
    {
        if(m>=n) return n;
        else return m;
    }
    
    public static int HamTienXuLy(char x, String P)
    {
        
        for(int i=P.length()-1;i>=0;i--)
        {
            if(x == P.charAt(i)) return i;
        }
        return -1;
    }
    
    public static int BoyerMoore(String T, String P)
    {
        int m = P.length();
        int i=P.length()-1;
        int j=i;
        int count=0;
        while(true)
        {
//            System.out.println(i + " " + j + " " + T.charAt(i)+ " " + P.charAt(j));
            if(T.charAt(i)!= P.charAt(j))
            {
                i=i+m - MIN(j, 1 + HamTienXuLy(T.charAt(i), P));
                j = m-1;
                count = 0;
            }
            else {
            i-=1;
            j-=1;
            count++;
            }
//            System.out.println("Count: " + count);
            if(count == P.length()) return i+1;
            if (i>=T.length() || i<0) break;
        }
        return -1;
    }
    
    public static void In()
    {
        Scanner input = new Scanner(System.in);
        while(true)
        {
            System.out.println("Nhap S2: ");
            String a = input.nextLine();
            System.out.println("Nhap S1: ");
            String b = input.nextLine();
            if(b.length()>a.length()) System.out.println("Ham P > T -> Huy");
            else { System.out.println("Vi tri: "+ BoyerMoore(a, b)); break;}
        }
    }
    
}
