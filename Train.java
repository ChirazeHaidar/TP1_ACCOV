/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chiraze Haidar
 */
public class Train extends Thread
{
    private int _vi;
    private String _nom;
    
    public Train (int V, String N)
    {
     _vi = V;
     _nom = N;
    }
    
    public void run()
    {
     System.out.println("Le Train " + _nom + " part.");

     try
     {
     Thread.sleep(_vi*500);
     System.out.println("Le Train " + _nom + " roule.");
     Thread.sleep(_vi*500);
     System.out.println("Le Train " + _nom + " s'arrête.");
     }
     catch (Exception e)
     {     }
    }
    public static void main (String args [])
    {
     Thread Tgv = new Thread(new Train(10 , "TGV"));
     Thread Corail = new Thread(new Train(20 , "CORAIL"));
     Tgv.start();
     Corail.start();
     System.out.println ("Fin du main.");
    }
    
}
