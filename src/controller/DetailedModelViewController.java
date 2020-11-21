/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Packages;

/**
 * FXML Controller class
 *
 * @author clarissapun
 */
public class DetailedModelViewController implements Initializable {

    private Packages pkg;
     @FXML
    private Label pkgId;

    @FXML
    private Label pkgDelivery;

    @FXML
    private Label pkgTo;

    @FXML
    private Label pkgFrom;
    
     @FXML 
    private ImageView image; 
     
    Scene previousScene;
    @FXML
    private Button backButton; 

     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void initData(Packages pkgs) {
        pkg = pkgs;
        pkgId.setText(pkg.getId().toString());
        pkgDelivery.setText(pkg.getCompany());
        pkgTo.setText(pkg.getToaddress());
        pkgFrom.setText(pkg.getFromaddress());


        try {
            // path points to /resource/images/
            String imagename = "/resource/images/box_PNG27.png";
            Image profile = new Image(getClass().getResourceAsStream(imagename));
            image.setImage(profile);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
     public void setPreviousScene(Scene scene) {
        previousScene = scene;
        backButton.setDisable(false);

    }
    @FXML
    public void goBack(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        //  option 2: get current stage -- from backbutton        
        // Stage stage = (Stage)backButton.getScene().getWindow();
        
        if (previousScene != null) {
            stage.setScene(previousScene);
        }
    }
}
  
