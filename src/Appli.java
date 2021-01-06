/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Optional;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import fr.gsb.rv.dr.entites.Visiteur;
import fr.gsb.rv.dr.technique.Session;
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import fr.gsb.rv.dr.modeles.ModeleGsbRv;
import static fr.gsb.rv.dr.modeles.ModeleGsbRv.seConnecter;
import fr.gsb.rv.dr.technique.ConnexionException;
import java.awt.Insets;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;
import javafx.util.Pair;
import fr.gsb.rv.dr.entites.vueConnexion;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
/**
 *
 * @author developpeur
 */
public class Appli extends Application {
    
   
    @Override
    
    // 1-- questions 4 et 5
//    public void start(Stage primaryStage) {
//        Button btn = new Button();
//        btn.setText("Question 5");
//        
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!!!!");
//            }
//        });
//        
//        BorderPane root = new BorderPane();
//       
//        
//        root.setLeft(btn);
//        Scene scene = new Scene(root, 300, 250);
//        
//        primaryStage.setTitle("Nouveau titre");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }

      
    
    
//    // 2 -- questions 1 et 2
//    public void start(Stage primaryStage) {
//          
//          // Create MenuBar
//          MenuBar barreMenus = new MenuBar();
//        
//        // Create menus
//          Menu menuFichier = new Menu("Fichier");
//          Menu Rapports = new Menu("Rapports");
//          Menu Praticiens = new Menu("Praticiens");
//        
//        // Create MenuItems
//          MenuItem itemSeConnecter = new MenuItem("Se connecter");
//          MenuItem itemSeDeconnecter = new MenuItem("Se déconnecter");
//          MenuItem itemQuitter = new MenuItem("Quitter");
//          MenuItem itemConsulter = new MenuItem("Consulter");
//          MenuItem itemHesitant = new MenuItem("Hésitant");
//       
//       
//            //Ajout des items
//          menuFichier.getItems().addAll(itemSeConnecter,itemSeDeconnecter,itemQuitter);
//          Rapports.getItems().add(itemConsulter);
//          Praticiens.getItems().add(itemHesitant);
//          //Ajout des menus
//          barreMenus.getMenus().addAll(menuFichier,Rapports,Praticiens);
//          
//          itemQuitter.setOnAction(
//               new EventHandler<ActionEvent>(){
//                   @Override
//                   public void handle(ActionEvent event){
//                       Platform.exit();
//                   }
//               }
//          );
//        
//          BorderPane root = new BorderPane();
//       
//        
//          root.setTop(barreMenus);
//          Scene scene = new Scene(root, 300, 250);
//        
//          primaryStage.setTitle("Nouveau titre");
//          primaryStage.setScene(scene);
//          primaryStage.show();
//      }
    
    
     public void start(Stage primaryStage) throws ConnexionException  {
          Visiteur visiteur = ModeleGsbRv.seConnecter("a131","azerty");
          
          // Create MenuBar
          MenuBar barreMenus = new MenuBar();
        
        // Create menus
          Menu menuFichier = new Menu("Fichier");
          Menu Rapports = new Menu("Rapports");
          Menu Praticiens = new Menu("Praticiens");
        
        // Create MenuItems
          MenuItem itemSeConnecter = new MenuItem("Se connecter");
          MenuItem itemSeDeconnecter = new MenuItem("Se déconnecter");
          MenuItem itemQuitter = new MenuItem("Quitter");
          MenuItem itemConsulter = new MenuItem("Consulter");
          MenuItem itemHesitant = new MenuItem("Hésitant");
       
       
            //Ajout des items
          menuFichier.getItems().add(itemSeConnecter);
          SeparatorMenuItem sep1=new SeparatorMenuItem();
          menuFichier.getItems().add(sep1);
          menuFichier.getItems().add(itemQuitter);
          
          //Ajout des menus
          barreMenus.getMenus().addAll(menuFichier,Rapports,Praticiens);
          
          itemQuitter.setOnAction(
               new EventHandler<ActionEvent>(){
                   @Override
                   public void handle(ActionEvent event){
                       Alert alertQuitter = new Alert(Alert.AlertType.CONFIRMATION);
          
                      alertQuitter.setTitle("Quitter");
                      alertQuitter.setHeaderText("Demande de confirmation");
                      alertQuitter.setContentText("Voulez-vous quitter l'application?");
                      ButtonType btnOui = new ButtonType("Oui");
                      ButtonType btnNon = new ButtonType("Non");
                      
                      alertQuitter.getButtonTypes().setAll(btnOui,btnNon);
                      
                      Optional<ButtonType> reponse=alertQuitter.showAndWait();
             
                      if(reponse.get()==btnOui){
                           Platform.exit();
               
                      }else{
                          System.out.println("Merci de rester parmis nous");
                          
                      }
               }}
          );
          itemSeConnecter.setOnAction(
                new EventHandler<ActionEvent>(){
                    
                    @Override
                    public void handle(ActionEvent event){
                        vueConnexion vue = new vueConnexion();
                        Optional<Pair<String,String>> reponse = vue.showAndWait();
//                        if( reponse.isPresent()){
//                            try {
//                              Pair<String,String>p;
//                              p=new Pair<String,String>();
//                                if(ModeleGsbRv.seConnecter(){
//                                    System.out.println("SUPER");
//                                }else{
//                                    System.out.println("Erreur");
//                                } 
//                            } catch (ConnexionException ex) {
//                                Logger.getLogger(Appli.class.getName()).log(Level.SEVERE, null, ex);
//                            }
//                            
//                        }
                    reponse.ifPresent(pair-> {
                        try{
                            Visiteur vis = ModeleGsbRv.seConnecter(pair.getKey(), pair.getValue());
                            if(vis!= null){
                                
                                menuFichier.getItems().remove(itemSeConnecter);
                                menuFichier.getItems().remove(itemQuitter);
                                Rapports.getItems().add(itemConsulter);
                                Praticiens.getItems().add(itemHesitant);
                                menuFichier.getItems().add(itemSeDeconnecter);
                                SeparatorMenuItem sep1=new SeparatorMenuItem();
                                menuFichier.getItems().add(sep1);
                                menuFichier.getItems().add(itemQuitter);
                                Session.ouvrir(vis);
                                System.out.println("Bienvenue");
                                primaryStage.setTitle(Session.getSession().getLeVisiteur().getNom()+" "+Session.getSession().getLeVisiteur().getPrenom());
                               
                            }
                        }   catch (ConnexionException ex) {
                                Logger.getLogger(Appli.class.getName()).log(Level.SEVERE, null, ex);
                            }
                    });
                    }
           });
          itemConsulter.setOnAction(
                new EventHandler<ActionEvent>(){
                    
                    @Override
                    public void handle(ActionEvent event){
                        Pane accueil = new Pane();
                        
                        System.out.println("[Consulter]"+Session.getSession().getLeVisiteur().getNom()+" "+Session.getSession().getLeVisiteur().getPrenom());
                    }
           });
                        
          itemSeDeconnecter.setOnAction(
                new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event){
                     
                        primaryStage.setTitle("Nouveau");
                        Session.fermer();
                        menuFichier.getItems().removeAll(itemSeDeconnecter,itemQuitter);
                        menuFichier.getItems().add(itemSeConnecter);
                        SeparatorMenuItem sep1=new SeparatorMenuItem();
                        menuFichier.getItems().add(sep1);
                        menuFichier.getItems().add(itemQuitter);
                        Rapports.getItems().remove(itemConsulter);
                        Praticiens.getItems().remove(itemHesitant);
                        
                        
                        
                    }
               }
          );
          itemHesitant.setOnAction(
                new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event){
                          System.out.println("[Hesitant]"+Session.getSession().getLeVisiteur().getNom()+" "+Session.getSession().getLeVisiteur().getPrenom());
                          
//                          System.out.println(Session.estOuverte());
                        
                        
                    }
               }
          );
          Alert alertQuitter = new Alert(Alert.AlertType.CONFIRMATION);
          
          alertQuitter.setTitle("Quitter");
         
          BorderPane root = new BorderPane();
       
        
          root.setTop(barreMenus);
          Scene scene = new Scene(root, 300, 250);
        
          primaryStage.setTitle("Nouveau");
          primaryStage.setScene(scene);
          primaryStage.show();
      }
     public static void main(String[] args) throws ClassNotFoundException, SQLException, ConnexionException{
          
		
        try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
		}
		
		catch( ClassNotFoundException e) {
			
			System.out.println("Erreur lors du chargement"+ e.getMessage());
			
		}
		
		String url = "jdbc:mysql://localhost:3306/gsbrv";
		Connection connexion = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		
		try {
			
			
			connexion = DriverManager.getConnection(url, "developpeur" , "azerty");
			String req = "select * from Visiteur where vis_matricule='a131'";
			pstmt = connexion.prepareStatement(req);
			res = pstmt.executeQuery();
//			while(res.next()) {
//				
//				System.out.println(res.getString("vis_nom"));
//                             				
//			}
			
		}
		
		
		
		catch(SQLException e) {
			
			while(e != null) {
				
				System.out.println("Description :" + e.getMessage() );
				System.out.println("Code d'erreur :" + e.getErrorCode() );
				System.out.println("État SQL :" + e.getSQLState() );
				e = e.getNextException();
			}
			
		}
		
		
//               System.out.println(ModeleGsbRv.seConnecter("a17","azerty"));
                launch(args);
	}

}

      
      
      
      
      
      
      
      
      