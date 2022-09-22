package com.api.Sewing_System.Controller;

import com.api.Sewing_System.Models.Products;
import com.api.Sewing_System.Service.ProductService;
import com.api.Sewing_System.dtos.ProductDto;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/items")
public class ProductController {

    final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Object> saveItem(@RequestBody @Valid ProductDto productDto){
        var itemsModel = new Products();
        BeanUtils.copyProperties(productDto, itemsModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(itemsModel));
    }
    @GetMapping
    public ResponseEntity<List<Products>> getAllItem(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAll());
    }
    @GetMapping("/{iditem}")
    public ResponseEntity<Object> getOneItem(@PathVariable(value = "iditem" ) Long id ) {
        Optional<Products> itemsModelOptional = productService.findById(id);
        if (!itemsModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item Not Found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(itemsModelOptional.get());
    }
    @DeleteMapping("/{iditem}")
    public ResponseEntity<Object> deleteIitem(@PathVariable(value = "iditem" ) Long id ) {
        Optional<Products> itemsModelOptional = productService.findById(id);
        if (!itemsModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item Not Found!");
        }
        productService.delete(itemsModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(itemsModelOptional.get() + " deleted successfully");
    }
    @PutMapping("/{iditem}")
    public ResponseEntity<Object> updateItem(@PathVariable(value = "iditem" ) Long id,
                                             @RequestBody @Valid ProductDto productDto) {
        Optional<Products> itemsModelOptional = productService.findById(id);
        if (!itemsModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("item Not Found!");
        }
        var itemsModel = new Products();
        BeanUtils.copyProperties(productDto, itemsModel);
        itemsModel.setId(itemsModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(productService.save(itemsModel));
    }
}
