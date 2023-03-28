package kicialdemo.Domain.Service;

import kicialdemo.Domain.Entity.Client;
import kicialdemo.Domain.Exception.ClientNotFoundException;
import kicialdemo.Domain.ValueObject.ClientRequestValueObject;
import kicialdemo.Infrastructure.ClientRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    final int pageSize = 4;

    public List<Client> getAll(int page) {
        Pageable paging = PageRequest.of(page - 1, pageSize);
        Page<Client> pageClient = clientRepository.findAll(paging);

        return pageClient.getContent();
    }

    public Client getById(int id) {
        return clientRepository.findById(id).orElseThrow(ClientNotFoundException::new);
    }

    public Client add(ClientRequestValueObject client) {
        return clientRepository.save(new Client(client.name(), client.surname()));
    }

    public Client update(int id, ClientRequestValueObject updatedClient) {
        Client client = clientRepository.findById(id).orElseThrow(ClientNotFoundException::new);

        client.setName(updatedClient.name());
        client.setSurname(updatedClient.surname());

        return clientRepository.save(client);
    }

    public void delete(int id) {
        clientRepository.deleteById(id);
    }
}
