package com.api.Sewing_System.Controller;


import com.api.Sewing_System.Models.HistoricModel;
import com.api.Sewing_System.Service.HistoricService;
import com.api.Sewing_System.dtos.HistoricDto;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/Historic")
public class HistoricController {

    final HistoricService historicService;

    public HistoricController (HistoricService historicService) {
        this.historicService = historicService;
        }

    @PostMapping
    public ResponseEntity<Object> saveHistoric(@RequestBody @Valid HistoricDto historicDto){
        var historicModel = new HistoricModel();
        BeanUtils.copyProperties(historicDto, historicModel);
        //historicModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(historicService.save(historicModel));
        }

}
