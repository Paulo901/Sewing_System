package com.api.Sewing_System.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.api.Sewing_System.dtos.HistoricDto;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.Sewing_System.Models.Client;
import com.api.Sewing_System.Models.Historic;
import com.api.Sewing_System.Service.ClientService;
import com.api.Sewing_System.Service.HistoricService;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/historic")
public class HistoricController {

    final HistoricService historicService;
    private ClientService clientService;

    public HistoricController(HistoricService historicService, ClientService clientService) {
        this.historicService = historicService;
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<Object> saveHistoric(@RequestBody @Valid HistoricDto historicDto) {
        Optional<Client> client = clientService.findById(historicDto.getClient());
        
        if (client.isPresent()) {

            var historicModel = new Historic(historicDto, client.get());
            return ResponseEntity.status(HttpStatus.CREATED).body(historicService.save(historicModel));

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Historic>> getAllHistoric() {
        return ResponseEntity.status(HttpStatus.OK).body(historicService.findAll());
    }

    @GetMapping("/{idHistoric}")
    public ResponseEntity<Object> getOneHistoric(@PathVariable(value = "idHistoric") Long id) {
        Optional<Historic> historicModelOptional = historicService.findById(id);
        if (!historicModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Historic Not Found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(historicModelOptional.get());
    }

    @DeleteMapping("/{idHistoric}")
    public ResponseEntity<Object> deleteHistoric(@PathVariable(value = "idHistoric") Long id) {
        Optional<Historic> historicModelOptional = historicService.findById(id);
        if (!historicModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Historic Not Found!");
        }
        historicService.delete(historicModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(historicModelOptional.get() + " deleted successfully");
    }

    @PutMapping("/{idHistoric}")
    public ResponseEntity<Object> updateHistoric(@PathVariable(value = "idHistoric") Long id,
            @RequestBody @Valid HistoricDto historicDto) {
        Optional<Historic> historicModelOptional = historicService.findById(id);
        if (!historicModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("HIstoric Not Found!");
        }
        var historicModel = new Historic();
        BeanUtils.copyProperties(historicDto, historicModel);
        historicModel.setIdHistoric(historicModelOptional.get().getIdHistoric());
        historicModel.setDataCompra(historicModelOptional.get().getDataCompra());

        return ResponseEntity.status(HttpStatus.OK).body(historicService.save(historicModel));
    }
}
