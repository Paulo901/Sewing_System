package com.api.Sewing_System.Controller;

import com.api.Sewing_System.Models.ClientModel;
import com.api.Sewing_System.Service.ClientService;
import com.api.Sewing_System.dtos.ClientDto;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/Client")
public class ClientController {

    final ClientService clientService;
    public ClientController (ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<Object> saveClient(@RequestBody @Valid ClientDto clientDto) {
        var clientModel = new ClientModel();
        BeanUtils.copyProperties(clientDto, clientModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(clientModel));
    }
    @GetMapping
    public ResponseEntity<List<ClientModel>> getAllClient(){
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findAll());
    }
    @GetMapping("/{idClient}")
    public ResponseEntity<Object> getOneClient(@PathVariable(value = "idClient" ) Long id ) {
        Optional<ClientModel> clientModelOptional = clientService.findById(id);
        if (!clientModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client Not Found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(clientModelOptional.get());
    }
    @DeleteMapping("/{idClient}")
    public ResponseEntity<Object> DeleteClient(@PathVariable(value = "idClient" ) Long id ) {
        Optional<ClientModel> clientModelOptional = clientService.findById(id);
        if (!clientModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client Not Found!");
        }
        clientService.delete(clientModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(clientModelOptional.get() + " deleted successfully");
    }
    @PutMapping("/{idClient}")
    public ResponseEntity<Object> updateClient(@PathVariable(value = "idClient" ) Long id,
                                               @RequestBody @Valid ClientDto clientDto) {
        Optional<ClientModel> clientModelOptional = clientService.findById(id);
        if (!clientModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client Not Found!");
        }
        var clientModel = new ClientModel();
        BeanUtils.copyProperties(clientDto, clientModel);
        clientModel.setIdCliente(clientModelOptional.get().getIdCliente());
        return ResponseEntity.status(HttpStatus.OK).body(clientService.save(clientModel));
    }

}