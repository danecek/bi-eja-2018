/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.hellorsclient;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author danecek
 */
public class NewFXMain extends Application {

    private CustomersPanel cp;
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button("Add Customer");
        btn.setText("Add Customer");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                new AddCustomerDialog().exec();
                cp.refresh();
                
            }
        });
        
        VBox root = new VBox(cp = new CustomersPanel(), btn);
       // root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Customers");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
