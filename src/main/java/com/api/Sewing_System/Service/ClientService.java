package com.api.Sewing_System.Service;

import com.api.Sewing_System.Models.ClientModel;
import com.api.Sewing_System.Repositories.ClientRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class ClientService {

    final ClientRepository clientRepository;
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional
    public ClientModel save(ClientModel clientModel) {
        return clientRepository.save(clientModel);

    }
}
