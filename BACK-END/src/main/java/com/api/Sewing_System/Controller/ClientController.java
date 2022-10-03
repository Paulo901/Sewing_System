package com.api.Sewing_System.Controller;

import com.api.Sewing_System.Models.Client;
import com.api.Sewing_System.Service.ClientService;
import com.api.Sewing_System.dtos.ClientDto;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/client")
public class ClientController {

    final ClientService clientService;
    public ClientController (ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<Object> saveClient(@RequestBody @Valid ClientDto clientDto) {
        var client = new Client();
        BeanUtils.copyProperties(clientDto, client);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(client));
    }
    @GetMapping
    public ResponseEntity<List<Client>> getAllClient(){
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findAll());
    }
    @GetMapping("/{idClient}")
    public ResponseEntity<Object> getClientById(@PathVariable(value = "idClient" ) Long id ) {
        Optional<Client> clientModelOptional = clientService.findById(id);
        if (!clientModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client Not Found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(clientModelOptional.get());
    }
    @GetMapping("/{email}/{password}")
    public ResponseEntity<Object> getClientByEmail(@PathVariable(value = "email" ) String email,
                                                   @PathVariable(value = "password") String password) {
        Stream<Client> clientModelStream = clientService.findByEmail(email);
        Optional<Client> clientModelOptional = clientModelStream.findFirst();

        if (!clientModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client Not Found!");
        }
        clientService.validation(clientModelOptional.get(), password);
        return ResponseEntity.status(HttpStatus.OK).body(clientModelOptional.get());
    }

    @DeleteMapping("/{idClient}")
    public ResponseEntity<Object> DeleteClient(@PathVariable(value = "idClient" ) Long id ) {
        Optional<Client> clientModelOptional = clientService.findById(id);
        if (!clientModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client Not Found!");
        }
        clientService.delete(clientModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(clientModelOptional.get() + " deleted successfully");
    }
    @PutMapping("/{idClient}")
    public ResponseEntity<Object> updateClient(@PathVariable(value = "idClient" ) Long id,
                                               @RequestBody @Valid ClientDto clientDto) {
        Optional<Client> clientModelOptional = clientService.findById(id);
        if (!clientModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client Not Found!");
        }
        var client = new Client();
        BeanUtils.copyProperties(clientDto, client);
        client.setId(clientModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(clientService.save(client));
    }

}