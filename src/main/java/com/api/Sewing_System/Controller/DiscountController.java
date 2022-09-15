package com.api.Sewing_System.Controller;

import com.api.Sewing_System.Models.DiscountsModel;
import com.api.Sewing_System.Service.DiscountsService;
import com.api.Sewing_System.dtos.DiscountsDto;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/discounts")
public class DiscountController {

    final DiscountsService discountService;

    public DiscountController (DiscountsService discountService) {
        this.discountService = discountService;
    }

    @PostMapping
    public ResponseEntity<Object> saveDiscount(@RequestBody @Valid DiscountsDto discountsDto){
        var discountsModel = new DiscountsModel();
        BeanUtils.copyProperties(discountsDto, discountsModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(discountService.save(discountsModel));
    }
    @GetMapping
    public ResponseEntity<List<DiscountsModel>> getAllDiscount(){
        return ResponseEntity.status(HttpStatus.OK).body(discountService.findAll());
    }
    @GetMapping("/{idDiscount}")
    public ResponseEntity<Object> getOneDiscount(@PathVariable(value = "idDiscount" ) UUID id ) {
        Optional<DiscountsModel> discountsModelOptional = discountService.findById(id);
        if (!discountsModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Discount Not Found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(discountsModelOptional.get());
    }
    @DeleteMapping("/{idDiscount}")
    public ResponseEntity<Object> deleteDiscount(@PathVariable(value = "idDiscount" ) UUID id ) {
        Optional<DiscountsModel> discountsModelOptional = discountService.findById(id);
        if (!discountsModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Discount Not Found!");
        }
        discountService.delete(discountsModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(discountsModelOptional.get() + " deleted successfully");
    }
    @PutMapping("/{idDiscount}")
    public ResponseEntity<Object> updateDiscount(@PathVariable(value = "idDiscount" ) UUID id,
                                                 @RequestBody @Valid DiscountsDto discountsDto) {
        Optional<DiscountsModel> discountsModelOptional = discountService.findById(id);
        if (!discountsModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Discount Not Found!");
        }
        var discountsModel = new DiscountsModel();
        BeanUtils.copyProperties(discountsDto, discountsModel);
        discountsModel.setIdDesconto(discountsModelOptional.get().getIdDesconto());
        return ResponseEntity.status(HttpStatus.OK).body(discountService.save(discountsModel));
    }
}
