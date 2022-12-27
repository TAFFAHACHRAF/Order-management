import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ClientController {

    // Observable list to store the clients
    private ObservableList<Client> clientList = FXCollections.observableArrayList();

    // TableView and columns to display the client data
    @FXML
    private TableView<Client> clientTable;
    @FXML
    private TableColumn<Client, String> nameColumn;
    @FXML
    private TableColumn<Client, String> emailColumn;
    @FXML
    private TableColumn<Client, String> phoneColumn;

    // TextFields to enter and edit the client data
    @FXML
    private TextField nameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField phoneField;

    // Initialize the controller
    public void initialize() {
        // Set up the cell value factories for the table columns
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));

        // Load the client data into the table
        clientTable.setItems(clientList);
    }

    // Add a new client to the list
    @FXML
    public void handleAddClient() {
        // Create a new client object with the entered data
        Client newClient = new Client(nameField.getText(), emailField.getText(), phoneField.getText());

        // Add the new client to the list
        clientList.add(newClient);

        // Clear the input fields
        nameField.clear();
        emailField.clear();
        phoneField.clear();
    }

    // Edit the selected client in the list
    @FXML
    public void handleEditClient() {
        // Get the selected client
        Client selectedClient = clientTable.getSelectionModel().getSelectedItem();

        // Update the client data with the entered data
        selectedClient.setName(nameField.getText());
        selectedClient.setEmail(emailField.getText());
        selectedClient.setPhone(phoneField.getText());

        // Clear the input fields
        nameField.clear();
        emailField.clear();
        phoneField.clear();
    }

    // Delete the selected client from the list
    @FXML
    public void handleDeleteClient() {
        // Get the selected client
        Client selectedClient = clientTable.getSelectionModel().getSelectedItem();

        // Remove the selected client from the list
        clientList.remove(selectedClient);
    }
}