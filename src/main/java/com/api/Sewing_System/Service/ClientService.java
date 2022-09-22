package com.api.Sewing_System.Service;

import com.api.Sewing_System.Models.Client;
import com.api.Sewing_System.Repositories.ClientRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    final ClientRepository clientRepository;
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Transactional
    public Client save(Client clientModel) {
        return clientRepository.save(clientModel);

    }
    @Transactional
    public void delete(Client clientModel) {
        clientRepository.delete(clientModel);
    }
}
