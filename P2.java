/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chiraze Haidar
 */
public class P2 extends Thread
//La classe P2 execute le code d'un CoureurEgoiste
        
{
    
    private static int tick = 0;
    //tick est un entier initialisé à 0
    //tick représente le nombre de millisecondes écoulées
    //depuis le début de l'exécution du P2
    
    private final String Nom;
    //Nom est un string
    //Nom représente les noms des Threads créés
    
    public P2 (String name)
    { 
     Nom = name;
    }
   
    @Override
    public void run ()
    {
     while (tick <40000000)
     {
      tick++;
      if ((tick%5000)==0)
      {
       System.out.println("Thread #" + Thread.currentThread().getName() + " tick = " + tick);
      }
     }
    }
    
    public static void main (String args [])
    {
     P2 Thread1 = new P2("Processus1");
     P2 Thread2 = new P2("Processus2");
     P2 Thread3 = new P2("Processus3");
     
     Thread1.start(); 
     Thread2.start(); 
     Thread3.start();
    }
}