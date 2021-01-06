/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gsb.rv.dr.technique;
import fr.gsb.rv.dr.entites.Visiteur;
import java.time.LocalDate;

/**
 *
 * @author developpeur
 */
  public class Session {
    private static Session session=null;
    private Visiteur visiteur;
  
 
  private Session (Visiteur leVisiteur){
      this.visiteur=leVisiteur;
    }
  public static void ouvrir(Visiteur leVisiteur){
      if(session==null){
          session= new Session(leVisiteur);
      }
  }
  public static Session getSession(){
      return session;
  }
  public Visiteur getLeVisiteur(){
      return visiteur;
  }
  public static void fermer(){
      session = null;
  }
  public  static boolean estOuverte(){
      if(session!= null){
          return true;
      } 
      else{
          return false;
      }
  }

    
    
}