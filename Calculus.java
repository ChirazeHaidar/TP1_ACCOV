/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chiraze Haidar
 */
import java.util.Date;
class Calculus extends Thread 
{
    String _s;
    static Long _l;
 
    Calculus (long L)
    {
     _l = L;
    }
    
    @Override
    public void run()
    {
     Date T = new Date(_l);
     _s = T.toString();
     
     try
     {
      Thread.sleep(100);
     }
     catch (Exception e)
     {
      System.out.println(e);
     }
    }
    
    String Get ()
    {
     return _s; 
    }
    
    public static void main (String args[])
    {
     Calculus C1 = new Calculus (0);
     Calculus C2 = new Calculus (4560000);
     Calculus C3 = new Calculus (System.currentTimeMillis());
     
     C1.start();
     C2.start();
     
     try 
     {
      C1.join();
      C2.join();     
     }
     catch (Exception e)
     {
      System.out.println(e);
     }
     
     String S1 = C1.Get();
     String S2 = C2.Get();
     
     System.out.println(S1);
     System.out.println(S2);
     
     C3.start();
     System.out.println(C3.Get());
    }
}
