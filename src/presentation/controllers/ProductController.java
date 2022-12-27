package presentation.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProductController {

    // Observable list to store the produits
    private ObservableList<Produit> produitList = FXCollections.observableArrayList();

    // TableView and columns to display the produit data
    @FXML
    private TableView<Produit> produitTable;
    @FXML
    private TableColumn<Produit, Long> idColumn;
    @FXML
    private TableColumn<Produit, String> nomColumn;
    @FXML
    private TableColumn<Produit, String> descriptionColumn;
    @FXML
    private TableColumn<Produit, Float> prixColumn;
    @FXML
    private TableColumn<Produit, Integer> quantiteColumn;

    // TextFields to enter and edit the produit data
    @FXML
    private TextField idField;
    @FXML
    private TextField nomField;
    @FXML
    private TextField descriptionField;
    @FXML
    private TextField prixField;
    @FXML
    private TextField quantiteField;

    // Initialize the controller
    public void initialize() {
        // Set up the cell value factories for the table columns
        idColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("NOM"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("DESCRIPTION"));
        prixColumn.setCellValueFactory(new PropertyValueFactory<>("PRIX"));
        quantiteColumn.setCellValueFactory(new PropertyValueFactory<>("QUANTITE"));

        // Load the produit data into the table
        produitTable.setItems(produitList);
    }

    // Add a new produit to the list
    @FXML
    public void handleAddProduit() {
        // Create a new produit object with the entered data
        Produit newProduit = new Produit(
                Long.parseLong(idField.getText()),
                nomField.getText(),
                descriptionField.getText(),
                Float.parseFloat(prixField.getText()),
                Integer.parseInt(quantiteField.getText())
        );

        // Add the new produit to the list
        produitList.add(newProduit);

        // Clear the input fields
        idField.clear();
        nomField.clear();
        descriptionField.clear();
        prixField.clear();
        quantiteField.clear();
    }

    // Delete the selected produit from the list
    @FXML
    public void handleDeleteProduit() {
        // Get the selected produit
        Produit selectedProduit = produitTable.getSelectionModel().getSelectedItem();

        // Remove the selected produit from the list
        produitList.remove(selectedProduit);
    }


    // Edit the selected produit in the list
    @FXML
    public void handleEditProduit() {
        // Get the selected produit
        Produit selectedProduit = produitTable.getSelectionModel().getSelectedItem();

        // Update the produit data with the entered data
        selectedProduit.setID(Long.parseLong(idField.getText()));
        selectedProduit.setNOM(nomField.getText());
        selectedProduit.setDESCRIPTION(descriptionField.getText());
        selectedProduit.setPRIX(Float.parseFloat(prixField.getText()));
        selectedProduit.setQUANTITE(Integer.parseInt(quantiteField.getText()));

        // Clear the input fields
        idField.clear();
        nomField.clear();
        descriptionField.clear();
        prixField.clear();
        quantiteField.clear();
    }

}