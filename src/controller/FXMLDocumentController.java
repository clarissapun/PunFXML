/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Packages;

/**
 *
 * @author clarissapun
 */
public class FXMLDocumentController implements Initializable {
    private EntityManager manager;
   
    @FXML
    private Button button;

    @FXML
    private Label label;

    @FXML
    private Button updatePackages;

    @FXML
    private Button readPackages;

    @FXML
    private Button createPackages;

    @FXML
    private Button deletePackages;
    
    @FXML
    private Button readToAndFromAddress;

    @FXML
    private Button readCompanyAndToAddress;

    @FXML
    private TableView<Packages> packageTable;

    @FXML
    private TableColumn<Packages, Integer> tableID = new TableColumn<>("id");

    @FXML
    private TableColumn<Packages, String> tableCompany = new TableColumn<>("company");

    @FXML
    private TableColumn<Packages, String> tableToAddress = new TableColumn<>("to address");

    @FXML
    private TableColumn<Packages, String> tableFromAddress = new TableColumn<>("from address");

    @FXML
    private TextField findPackage;

    @FXML
    private Button searchPackage;
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("clicked");
        ///label.setText("Hello World!");
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        manager = (EntityManager) Persistence.createEntityManagerFactory("PunFXMLPU").createEntityManager();

    }    
    /*
    Implementing CRUD operations
 */
    
    // Create operation
    public void create(Packages pkg) {
        try {
            // begin transaction
            manager.getTransaction().begin();
            
            // sanity check
            if (pkg.getId() != null) {
                
                // create package
                manager.persist(pkg);
                
                // end transaction
                manager.getTransaction().commit();
                
                System.out.println(pkg.toString() + " is created");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    // Read Operations
    public List<Packages> readAll(){
        Query query = manager.createNamedQuery("Packages.findAll");
        List<Packages> pkgs = query.getResultList();

        for (Packages pkg : pkgs) {
            System.out.println(pkg.getId() + " " + pkg.getCompany() + " " + pkg.getToaddress() + " " + pkg.getFromaddress());
        }
        
        return pkgs;
    }
    
    public Packages readById(int id){
        Query query = manager.createNamedQuery("Packages.findById");
        
        // setting query parameter
        query.setParameter("id", id);
        
        // execute query
        Packages pkg = (Packages) query.getSingleResult();
        if (pkg != null) {
            System.out.println(pkg.getId() + " " + pkg.getCompany() + " " + pkg.getToaddress() + " " + pkg.getFromaddress());
        }
        
        return pkg;
    }      
    public Packages readByTracking(String trackingNum){
        Query query = manager.createNamedQuery("Packages.findByTrackingNumber");
        
        // setting query parameter
        query.setParameter("trackingNumber", trackingNum);
        
        // execute query
        Packages pkg = (Packages) query.getSingleResult();
        if (pkg != null) {
            System.out.println(pkg.getId() + " " + pkg.getCompany() + " " + pkg.getToaddress() + " " + pkg.getFromaddress());
        }
        
        return pkg;
    }   
    
    public List<Packages> readByCompany(String name){
        Query query = manager.createNamedQuery("Packages.findByCompany");
        
        // setting query parameter
        query.setParameter("company", name);
        
        // execute query
        List<Packages> pkgs =  query.getResultList();
        for (Packages pkg: pkgs) {
            System.out.println(pkg.getId() + " " + pkg.getCompany() + " " + pkg.getToaddress() + " " + pkg.getFromaddress());
        }
        
        return pkgs;
    }        
    
    public List<Packages> readByToFromAddress(String Toaddress, String Fromaddress){
        Query query = manager.createNamedQuery("Student.findByToaddressAndFromaddress");
        
        // setting query parameter
        query.setParameter("Toaddress", Toaddress);
        query.setParameter("Fromaddress", Fromaddress);
        
        
        // execute query
        List<Packages> pkgs =  query.getResultList();
        for (Packages pkg: pkgs) {
            System.out.println(pkg.getId() + " " + pkg.getCompany() + " " + pkg.getToaddress() + " " + pkg.getFromaddress());
        }
        
        return pkgs;
    }    
    public List<Packages> readByCompanyToAddress(String company, String toaddress){
        Query query = manager.createNamedQuery("Student.findByCompanyAndFromaddress");
        
        // setting query parameter
        query.setParameter("company", company);
        query.setParameter("Toaddress", toaddress);
        
        
        // execute query
        List<Packages> pkgs =  query.getResultList();
        for (Packages pkg: pkgs) {
            System.out.println(pkg.getId() + " " + pkg.getCompany() + " " + pkg.getToaddress() + " " + pkg.getFromaddress());
        }
        
        return pkgs;
    }    

    
    // Update operation
    public void update(Packages model) {
        try {

            Packages existingPkg = manager.find(Packages.class, model.getId());

            if (existingPkg != null) {
                // begin transaction
                manager.getTransaction().begin();
                
                // update all atttributes
                existingPkg.setId(model.getId());
                existingPkg.setCompany(model.getCompany());
                existingPkg.setToaddress(model.getToaddress());
                existingPkg.setFromaddress(model.getFromaddress());

                
                // end transaction
                manager.getTransaction().commit();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Delete operation
    public void delete(Packages pkg) {
        try {
            Packages exisitingPkg = manager.find(Packages.class, pkg.getId());

            // sanity check
            if (exisitingPkg != null) {
                
                // begin transaction
                manager.getTransaction().begin();
                
                //remove Package
                manager.remove(exisitingPkg);
                
                // end transaction
                manager.getTransaction().commit();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    @FXML
    void createPackages(ActionEvent event) {
        Scanner input = new Scanner(System.in);
        
        // read input from command line
        System.out.println("Enter ID:");
        int id = input.nextInt();
        
        System.out.println("Enter Company:");
        String company = input.next();
        
        System.out.println("Enter To Address:");
        String toAddress = input.nextLine();
        
        System.out.println("Enter From Address:");
        String fromAddress = input.nextLine();
        // create a package instance
        Packages pkg = new Packages();
        
        // set properties
        pkg.setId(id);
        pkg.setCompany(company);
        pkg.setToaddress(toAddress);
        pkg.setFromaddress(fromAddress);
        
        // save this package to database by calling Create operation        
        create(pkg);
    }

    @FXML
    void deletePackages(ActionEvent event) {
        Scanner input = new Scanner(System.in);
        
         // read input from command line
        System.out.println("Enter ID:");
        int id = input.nextInt();
        
        Packages p = readById(id);
        System.out.println("we are deleting this package: "+ p.toString());
        delete(p);

    }
    

    @FXML
    void readByID(ActionEvent event) {
        Scanner input = new Scanner(System.in);
        
        // read input from command line
        System.out.println("Enter ID:");
        int id = input.nextInt();
        
        Packages p = readById(id);
        System.out.println(p.toString());

    }

    @FXML
    void readByCompany(ActionEvent event) {
        Scanner input = new Scanner(System.in);
        
        // read input from command line
        System.out.println("Enter Company:");
        String name = input.next();
        
        List<Packages> p = readByCompany(name);
        System.out.println(p.toString());

    }

    @FXML
    void readPackages(ActionEvent event) {
        readAll();
    }

    @FXML
    void updatePackages(ActionEvent event) {
        Scanner input = new Scanner(System.in);
        
        // read input from command line
        System.out.println("Enter ID:");
        int id = input.nextInt();
        
        System.out.println("Enter Company:");
        String company = input.next();
        
        System.out.println("Enter To Address:");
        String toAddress = input.nextLine();
        
        System.out.println("Enter From Address:");
        String fromAddress = input.nextLine();
        
        // create a package instance
        Packages pkg = new Packages();
        
        // set properties
        pkg.setId(id);
        pkg.setCompany(company);
        pkg.setToaddress(toAddress);
        pkg.setFromaddress(fromAddress);
        
        // save this package to database by calling Create operation        
        update(pkg);
    }

    @FXML
    void readByToFromAddress(ActionEvent event) {
        // name and cpga
        
        Scanner input = new Scanner(System.in);
        
        // read input from command line
        
        System.out.println("Enter To Address:");
        String to = input.nextLine();
        
        System.out.println("Enter From Address:");
        String from = input.nextLine();
        
        // create a student instance      
        List<Packages> p =  readByToFromAddress(to, from);
        System.out.println(p.toString());

    }
    @FXML
    void readByCompanyToAddress(ActionEvent event) {
        // name and cpga
        
        Scanner input = new Scanner(System.in);
        
        // read input from command line
        
        System.out.println("Enter Company:");
        String company = input.nextLine();
        
        System.out.println("Enter To Address:");
        String to = input.nextLine();
        
        // create a student instance      
        List<Packages> p =  readByToFromAddress(company, to);
        System.out.println(p.toString());

    }
    
    @FXML
    void searchPackage(ActionEvent event) {
        System.out.println("clicked");
        int packageToFind = Integer.valueOf(findPackage.getText());
        Packages pkg = readById(packageToFind);
        //TableView<Packages> table = new TableView<>();
        tableID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableCompany.setCellValueFactory(new PropertyValueFactory<>("company"));
        tableToAddress.setCellValueFactory(new PropertyValueFactory<>("toaddress"));
        tableFromAddress.setCellValueFactory(new PropertyValueFactory<>("fromaddress"));
        packageTable.getItems().add(pkg);
        //packageTable.getColumns().addAll(tableID, tableCompany, tableToAddress, tableFromAddress);
    }

}
