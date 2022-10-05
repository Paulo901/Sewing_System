package com.api.Sewing_System.Controller;

import com.api.Sewing_System.Models.*;
import com.api.Sewing_System.Service.*;
import com.api.Sewing_System.dtos.CartDto;
import com.api.Sewing_System.dtos.HistoricDto;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/cart")
public class CartController {

    final CartService cartService;
    private ClientService clientService;
    private ProductService productService;

    public CartController(CartService cartService, ClientService clientService, ProductService productService) {
        this.cartService = cartService;
        this.clientService = clientService;
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Object> createCart(@RequestBody @Valid CartDto cartDto) {
        Optional<Client> client = clientService.findById(cartDto.getClient());
        Optional<Products> product = productService.findById(cartDto.getProduct());

        if (client.isPresent()) {
            var cart = new Cart(client.get(), product.get());
            return ResponseEntity.status(HttpStatus.CREATED).body(cartService.save(cart));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Cart>> getAllCart() {
        return ResponseEntity.status(HttpStatus.OK).body(cartService.findAll());
    }

    @GetMapping("/{idCart}")
    public ResponseEntity<Object> getOneCart(@PathVariable(value = "idCart") Long id) {
        Optional<Cart> cartModelOptional = cartService.findById(id);
        if (!cartModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cart Not Found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(cartModelOptional.get());
    }

    @DeleteMapping("/{idCart}")
    public ResponseEntity<Object> deleteCart(@PathVariable(value = "idCart") Long id) {
        Optional<Cart> cartModelOptional = cartService.findById(id);
        if (!cartModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cart Not Found!");
        }
        cartService.delete(cartModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(cartModelOptional.get() + " deleted successfully");
    }

    @PutMapping("/{idCart}")
    public ResponseEntity<Object> updateCart(@PathVariable(value = "idCart") Long id,
                                             @RequestBody @Valid CartDto cartDto) {
        Optional<Cart> cartModelOptional = cartService.findById(id);
        if (!cartModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cart Not Found!");
        }
        var cart = new Cart();
        BeanUtils.copyProperties(cartDto, cart);
        cart.setId(cartModelOptional.get().getId());
        cart.setInCartDate(cartModelOptional.get().getInCartDate());

        return ResponseEntity.status(HttpStatus.OK).body(cartService.save(cart));
    }
}
