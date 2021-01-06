/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gsb.rv.dr.entites;

import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;
import javafx.util.Pair;

/**
 *
 * @author developpeur
 */
     public class vueConnexion extends Dialog{
           
                   public vueConnexion(){
                      super();
                      super.setTitle("Connexion"); 
                      super.setHeaderText("Veuillez saisir vos identifiants");
                      ButtonType loginButtonType = new ButtonType("Connexion", ButtonBar.ButtonData.OK_DONE); 
                      super.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);
                      
                      // Création de l'IU. 
                      final GridPane gridPane = new GridPane(); 
                      gridPane.setHgap(15); 
                      gridPane.setVgap(15); 
                      
                      final TextField username = new TextField(); 
                      username.setPromptText("Utilisateur"); 
                      final PasswordField password = new PasswordField(); 
                      password.setPromptText("Mot de passe"); 
                      gridPane.add(new Label("Utilisateur :"), 0, 0); 
                      gridPane.add(username, 1, 0); 
                      gridPane.add(new Label("Mot de passe :"), 0, 1); 
                      gridPane.add(password, 1, 1);     
                      super.getDialogPane().setContent(gridPane);
//                      Optional<String> textIn= inDialog.showAndWait();
                      
                      super.setResultConverter(
                           new Callback<ButtonType, Pair<String, String>>() { 

                                @Override 
                                public Pair<String, String> call(ButtonType dialogButton) { 
                                 if (dialogButton == loginButtonType) { 
                                     return new Pair<String, String>(username.getText(), password.getText()); 
                                 } 
                                 return null; 
                               } 
                      });
                      
                      
                      }   
                        
                    
                    
               
      
          }
