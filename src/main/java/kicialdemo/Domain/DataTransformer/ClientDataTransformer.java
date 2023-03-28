package kicialdemo.Domain.DataTransformer;

import kicialdemo.Domain.Entity.Client;
import kicialdemo.Domain.ValueObject.ClientValueObject;
import org.springframework.stereotype.Service;

@Service
public class ClientDataTransformer {

    public ClientValueObject transform(Client client) {
        return new ClientValueObject(client.getId(), client.getName(), client.getSurname());
    }
}
