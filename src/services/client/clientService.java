package project.tasks_management.services.client;

import project.tasks_management.entities.Client;

import java.sql.SQLException;
import java.util.List;

public interface clientService {
    void addClient(Client c) throws SQLException;
    void deleteClient(Client c) throws SQLException;
    void updateClient(Client c) throws SQLException;
    List<Client> getClients() throws SQLException;
}
