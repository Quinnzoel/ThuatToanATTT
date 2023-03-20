/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btvn;

import java.util.Arrays;

/**
 *
 * @author Admin
 */
public class BTVNSTRING {
    
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
            if(count == P.length()) return i;
            }
        }
        System.out.println(T);
        System.out.println(P);
        return -1;
    }
    
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
            System.out.println(i + " " + j + " " + T.charAt(i)+ " " + P.charAt(j));
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
            if(count == P.length()-1) return i;
            if (i>=T.length()) break;
        }
        return -1;
    }
    
    public static int FailureFunction(int j, String P)
    {
        String[] TienTo = new String[10];
        String[] HauTo = new String[10];
        TienTo[0] ="";
        HauTo[0] ="";
//        HauTo[1] = "";
        if(j==0) {return -1;}
        else {
            for(int i=1;i<=j;i++)
            {
                TienTo[i] = "" + TienTo[i-1] + P.charAt(i-1);
                HauTo[i] = "" + P.charAt(j-i+1) + HauTo[i-1];
                if(i==1) HauTo[i] = "";
 //               System.out.println("i: " + i +" "+TienTo[i] +" " + HauTo[i]);
            }
            int count = 0 ;
            for(int i=1;i<=j;i++)
            {
                for(int k=1;k<=j;k++)
                {
                    if(TienTo[i].equalsIgnoreCase(HauTo[k])) count++;
                }
            }
            return count;
            
        }
//        return -1;
    }
    
    public static int KMP(String T, String P)
    {
        int j=0;
        int i=0;
        int count=0;
        while(true)
        {
            int tong = i+j;
//            System.out.println("i+j "+ tong  + " "+ j + " " + T.charAt(i+j) + " " + P.charAt(j));
            if(T.charAt(i+j)!=P.charAt(j))
            {
                i = i + j - FailureFunction(j, P);
                j = FailureFunction(j, P);
                if(j==-1) j=0;
                count = 0;
            }
            else {
                j++;
                count++;
            }
//            System.out.println("count " +count);
            if(count==P.length()) return i;
        }
    }
    
}
