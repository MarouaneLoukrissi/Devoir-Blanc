package com.devoirBlanc.view;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.devoirBlanc.service.Membre;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("UI.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("Add a member");
            primaryStage.setScene(scene);
            primaryStage.show();
            
            Membre m = new Membre();
            Set<Membre> membres = new HashSet<Membre>();
            try {
    			membres = m.chargerListeMembre("membre.csv");
    			for (Membre membre : membres) {
    			    System.out.println(membre);
    			}
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args); 
    }
}

