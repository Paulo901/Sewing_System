package com.api.Sewing_System.Controller;

import com.api.Sewing_System.Models.Discounts;
import com.api.Sewing_System.Service.DiscountsService;
import com.api.Sewing_System.dtos.DiscountsDto;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/discounts")
public class DiscountController {

    final DiscountsService discountService;

    public DiscountController (DiscountsService discountService) {
        this.discountService = discountService;
    }

    @PostMapping
    public ResponseEntity<Object> createDiscount(@RequestBody @Valid DiscountsDto discountsDto){
        var discounts = new Discounts();
        BeanUtils.copyProperties(discountsDto, discounts);
        return ResponseEntity.status(HttpStatus.CREATED).body(discountService.save(discounts));
    }
    @GetMapping
    public ResponseEntity<List<Discounts>> getAllDiscount(){
        return ResponseEntity.status(HttpStatus.OK).body(discountService.findAll());
    }
    @GetMapping("/{idDiscount}")
    public ResponseEntity<Object> getOneDiscount(@PathVariable(value = "idDiscount" ) Long id ) {
        Optional<Discounts> discountsModelOptional = discountService.findById(id);
        if (!discountsModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Discount Not Found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(discountsModelOptional.get());
    }
    @DeleteMapping("/{idDiscount}")
    public ResponseEntity<Object> deleteDiscount(@PathVariable(value = "idDiscount" ) Long id ) {
        Optional<Discounts> discountsModelOptional = discountService.findById(id);
        if (!discountsModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Discount Not Found!");
        }
        discountService.delete(discountsModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(discountsModelOptional.get() + " deleted successfully");
    }
    @PutMapping("/{idDiscount}")
    public ResponseEntity<Object> updateDiscount(@PathVariable(value = "idDiscount" ) Long id,
                                                 @RequestBody @Valid DiscountsDto discountsDto) {
        Optional<Discounts> discountsModelOptional = discountService.findById(id);
        if (!discountsModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Discount Not Found!");
        }
        var discounts = new Discounts();
        BeanUtils.copyProperties(discountsDto, discounts);
        discounts.setId(discountsModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(discountService.save(discounts));
    }
}
