package com.api.Sewing_System.Controller;

import com.api.Sewing_System.Models.ClientModel;
import com.api.Sewing_System.Models.HistoricModel;
import com.api.Sewing_System.Service.ClientService;
import com.api.Sewing_System.Service.HistoricService;
import com.api.Sewing_System.dtos.ClientDto;
import com.api.Sewing_System.dtos.HistoricDto;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.swing.JOptionPane;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/historic")
public class HistoricController {

    final HistoricService historicService;
    private ClientService clientService;


    public HistoricController (HistoricService historicService, ClientService clientService) {
        this.historicService = historicService;
        this.clientService = clientService;
        }

    @PostMapping
    public ResponseEntity<Object> saveHistoric(@RequestBody @Valid HistoricDto historicDto) {

        Optional<ClientModel> client = clientService.findById(historicDto.getCliente());
        historicDto.setCliente(client.get().getIdCliente());

        var historicModel = new HistoricModel(client.get());

        BeanUtils.copyProperties(historicDto, historicModel);
        historicModel.setDataCompra(LocalDateTime.now(ZoneId.of("UTC")));
        historicModel.setClient(client.get());
        //client.get().setHistoric(historicModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(historicService.save(historicModel));
        }
    @GetMapping
    public ResponseEntity<List<HistoricModel>> getAllHistoric(){
        return ResponseEntity.status(HttpStatus.OK).body(historicService.findAll());
    }
    @GetMapping("/{idHistoric}")
    public ResponseEntity<Object> getOneHistoric(@PathVariable(value = "idHistoric" ) UUID id ) {
        Optional<HistoricModel> historicModelOptional = historicService.findById(id);
        if (!historicModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Historic Not Found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(historicModelOptional.get());
    }
    @DeleteMapping("/{idHistoric}")
    public ResponseEntity<Object> deleteHistoric(@PathVariable(value = "idHistoric" ) UUID id ) {
        Optional<HistoricModel> historicModelOptional = historicService.findById(id);
        if (!historicModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Historic Not Found!");
        }
        historicService.delete(historicModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(historicModelOptional.get() + " deleted successfully");
    }
    @PutMapping("/{idHistoric}")
    public ResponseEntity<Object> updateHistoric(@PathVariable(value = "idHistoric" ) UUID id,
                                                 @RequestBody @Valid HistoricDto historicDto) {
        Optional<HistoricModel> historicModelOptional = historicService.findById(id);
        if (!historicModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("HIstoric Not Found!");
        }
        var historicModel = new HistoricModel();
        BeanUtils.copyProperties(historicDto, historicModel);
        historicModel.setIdHistoric(historicModelOptional.get().getIdHistoric());
        historicModel.setDataCompra(historicModelOptional.get().getDataCompra());

        return ResponseEntity.status(HttpStatus.OK).body(historicService.save(historicModel));
    }
}
