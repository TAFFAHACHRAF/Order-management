package project.tasks_management.services.client;

import project.tasks_management.dao.client.clientDAO;
import project.tasks_management.entities.Client;

import java.sql.SQLException;
import java.util.List;

public class clientServiceImpl implements clientService{
    clientDAO cda;
    @Override
    public void addClient(Client c) throws SQLException {
        cda.save(c);
    }

    @Override
    public void deleteClient(Client c) throws SQLException {
        cda.delete(c);
    }

    @Override
    public void updateClient(Client c) throws SQLException {
        cda.update(c);
    }

    @Override
    public List<Client> getClients() throws SQLException {
        return cda.findAll();
    }
}
