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
public class Euclide {
    
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
    
}
