package com.api.Sewing_System.Controller;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import javax.validation.Valid;

import com.api.Sewing_System.Models.*;
import com.api.Sewing_System.Properties.historic.PaymentCalculator;
import com.api.Sewing_System.Service.ClientService;
import com.api.Sewing_System.Service.DiscountsService;
import com.api.Sewing_System.Service.HistoricService;
import com.api.Sewing_System.Service.ProductService;
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

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/historic")
public class HistoricController {

    final HistoricService historicService;
    private ClientService clientService;
    private ProductService productService;
    private DiscountsService discountsService;

    public HistoricController(HistoricService historicService, ClientService clientService,
                              ProductService productService, DiscountsService discountsService) {
        this.historicService = historicService;
        this.clientService = clientService;
        this.productService = productService;
        this.discountsService = discountsService;
    }

    @PostMapping
    public ResponseEntity<Object> saveHistoric(@RequestBody @Valid HistoricDto historicDto) {
        Optional<Client> client = clientService.findById(historicDto.getClient());
        Optional<Products> product = productService.findById(historicDto.getProduct());

        List<Discounts> discounts = new ArrayList<>();
        if (historicDto.getDiscounts() != null) {
            historicDto.getDiscounts().forEach(discount ->
                    discounts.add(discountsService.findById(discount).get()));
        }
        if (client.isPresent()) {

            var historic = new Historic(historicDto, client.get(), product.get()
                    ,discounts, historicService.selectState(historicDto.getState()));
//            historic.setTotalPay(new PaymentCalculator(product.get().getPrice(), historicService.selectState(historicDto.getState()))
//                    .totalToPay(discounts));

//            client.get().getCart().;

            return ResponseEntity.status(HttpStatus.CREATED).body(historicService.save(historic));
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
        var historic = new Historic();
        BeanUtils.copyProperties(historicDto, historic);
        historic.setId(historicModelOptional.get().getId());
        historic.setPurchaseDate(historicModelOptional.get().getPurchaseDate());

        return ResponseEntity.status(HttpStatus.OK).body(historicService.save(historic));
    }
}
