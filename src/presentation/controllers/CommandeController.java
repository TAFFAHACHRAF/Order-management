package presentation.controllers;

package presentation.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CommandeController {

    // Observable list to store the commandes
    private ObservableList<Commande> commandeList = FXCollections.observableArrayList();

    // TableView and columns to display the commande data
    @FXML
    private TableView<Commande> commandeTable;
    @FXML
    private TableColumn<Commande, Long> idColumn;
    @FXML
    private TableColumn<Commande, Date> dateColumn;
    @FXML
    private TableColumn<Commande, Client> clientColumn;

    // TextFields to enter and edit the commande data
    @FXML
    private TextField idField;
    @FXML
    private TextField dateField;
    @FXML
    private TextField clientField;

    // Initialize the controller
    public void initialize() {
        // Set up the cell value factories for the table columns
        idColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("DATE_COMMANDE"));
        clientColumn.setCellValueFactory(new PropertyValueFactory<>("CLIENT"));

        // Load the commande data into the table
        commandeTable.setItems(commandeList);
    }

    // Add a new commande to the list
    @FXML
    public void handleAddCommande() throws ParseException {
        // Create a new commande object with the entered data
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = formatter.parse(dateField.getText());
        Client client = new Client(clientField.getText(), "", "");
        Commande newCommande = new Commande(
                Long.parseLong(idField.getText()),
                date,
                client
        );

        // Add the new commande to the list
        commandeList.add(newCommande);

        // Clear the input fields
        idField.clear();
        dateField.clear();
        clientField.clear();
    }

    // Edit the selected commande in the list
    @FXML
    public void handleEditCommande() throws ParseException {
        // Get the selected commande
        Commande selectedCommande = commandeTable.getSelectionModel().getSelectedItem();

        // Update the commande data with the entered data
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = formatter.parse(dateField.getText());
        Client client = new Client(clientField.getText(), "", "");
        selectedCommande.setID(Long.parseLong(idField.getText()));
        selectedCommande.setDATE_COMMANDE(date);
        selectedCommande.setCLIENT(client);

        // Clear the input fields
        idField.clear();
        dateField.clear();
        clientField.clear();
    }

    // Delete the selected commande from the list
    @FXML
    public void handleDeleteCommande() {
        // Get the selected commande
        Commande selectedCommande = commandeTable.getSelectionModel().getSelectedItem();

        // Remove the selected commande from the list
        commandeList.remove(selectedCommande);
    }
}
