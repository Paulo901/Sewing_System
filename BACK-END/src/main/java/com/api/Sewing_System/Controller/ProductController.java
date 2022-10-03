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
@RequestMapping("/product")
public class ProductController {

    final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Object> saveProduct(@RequestBody @Valid ProductDto productDto){

        var products = new Products(productService.selectItem(productDto.getItem()));
        BeanUtils.copyProperties(productDto, products);
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(products));
    }
    @GetMapping
    public ResponseEntity<List<Products>> getAllProduct(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAll());
    }
    @GetMapping("/{idProduct}")
    public ResponseEntity<Object> getOneProduct(@PathVariable(value = "idProduct" ) Long id ) {
        Optional<Products> itemsModelOptional = productService.findById(id);
        if (!itemsModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item Not Found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(itemsModelOptional.get());
    }
    @DeleteMapping("/{idProduct}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value = "idProduct" ) Long id ) {
        Optional<Products> itemsModelOptional = productService.findById(id);
        if (!itemsModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item Not Found!");
        }
        productService.delete(itemsModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(itemsModelOptional.get() + " deleted successfully");
    }
    @PutMapping("/{idProduct}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value = "idProduct" ) Long id,
                                                @RequestBody @Valid ProductDto productDto) {
        Optional<Products> itemsModelOptional = productService.findById(id);
        if (!itemsModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("item Not Found!");
        }
        var products = new Products();
        BeanUtils.copyProperties(productDto, products);
        products.setId(itemsModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(productService.save(products));
    }
}
