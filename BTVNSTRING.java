/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btvn;

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
            if(count == P.length()) return i+1;
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
    
    
    
    public static int BoyerMoore(String T, String P)
    {
        
        return -1;
    }
}
