package kicialdemo.Application.Controller;

import kicialdemo.Domain.ValueObject.ClientRequestValueObject;
import kicialdemo.Domain.DataTransformer.ClientDataTransformer;
import kicialdemo.Domain.Service.ClientService;
import kicialdemo.Domain.ValueObject.ClientValueObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;

    @Autowired
    ClientDataTransformer clientDataTransformer;

    @GetMapping("")
    public List<ClientValueObject> getAll(@RequestParam(name = "page", defaultValue = "1") int page) {
        return clientService.getAll(page).stream().map(clientDataTransformer::transform).toList();
    }

    @GetMapping("/{id}")
    public ClientValueObject getById(@PathVariable("id") int id) {
        return clientDataTransformer.transform(clientService.getById(id));
    }

    @PostMapping("")
    public ClientValueObject add(@RequestBody ClientRequestValueObject client) {
        return clientDataTransformer.transform(clientService.add(client));
    }

    @PutMapping("/{id}")
    public ClientValueObject update(@PathVariable("id") int id, @RequestBody ClientRequestValueObject updatedClient) {
        return clientDataTransformer.transform(clientService.update(id, updatedClient));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        clientService.delete(id);
    }
}
