/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chiraze Haidar
 */
public class P2C extends Thread
//La classe P2C execute le code d'un CoureurEgoiste
        
{
    private static int tick = 0;
    //tick est un entier initialisé à 0
    //tick représente le nombre de millisecondes écoulées
    //depuis le début de l'exécution du P2C
    
    public String Nom;
    //Nom est un string
    //Nom représente les noms des Threads créés
    
    public static int count = 0;
    //count est un entier initialisé à 0
    //count représente le nombre de processus légers créés 
    //lors de l'exécution du programme P2C
    
    public P2C (String name)
    { 
     Nom = name;
    }
   
    @Override
    public void run ()
    {
     
     for (int i = 1 ; i <= count; i++)
     {
      System.out.println ("Nom Thread: " + Nom +  
      "\nGroupe: " + Thread.currentThread().getThreadGroup() +              
      "\nPriorité: " + Thread.currentThread().getPriority());
      //getThreadGroup() renvoie le groupe du thread courant
      //getPriority() renvoie un entier indiquant la priorité du Thread courant
      
      if (Thread.currentThread().isDaemon())
      //isDaemon() est une méthode qui teste si un Thread est Demon ou pas
      { 
       System.out.println("Je suis un Thread Demon");
      }
      else
      {
       System.out.println("Je ne suis pas un Thread Demon");
      }
     }
        
     while (tick <40000000)
     {
      tick++;
      if ((tick%5000)==0)
      {
       System.out.println("Thread: " + Thread.currentThread().getName() + " ,tick = " + tick);
      }
     }
    }
    
    public static void main (String args [])
    {
     P2C Thread1 = new P2C("Processus1");
     P2C Thread2 = new P2C("Processus2");
     P2C Thread3 = new P2C("Processus3");
     
     Thread1.start(); 
     Thread2.start(); 
     Thread3.start();
     
     count = Thread.activeCount();
     //activeCount() est une méthode qui retourne le nombre de thread actifs
     
     System.out.println("Le nombre de Threads créés est: " + count);
     
     try
     {
      Thread1.join();
      Thread2.join();
      Thread3.join();

      System.out.println("Fin de P2C");
      System.exit(0);
     }
     catch (InterruptedException e) 
     {
      System.out.println(e);
     }
    }
}