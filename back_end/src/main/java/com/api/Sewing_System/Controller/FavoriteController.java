package com.api.Sewing_System.Controller;

import com.api.Sewing_System.Models.Client;
import com.api.Sewing_System.Models.Favorites;
import com.api.Sewing_System.Models.Products;
import com.api.Sewing_System.Service.ClientService;
import com.api.Sewing_System.Service.FavoritesService;
import com.api.Sewing_System.Service.ProductService;
import com.api.Sewing_System.dtos.CartDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public class FavoriteController {

    final FavoritesService favoritesService;
    private ClientService clientService;
    private ProductService productService;

    public FavoriteController(FavoritesService favoritesService, ClientService clientService, ProductService productService) {
        this.favoritesService = favoritesService;
        this.clientService = clientService;
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Object> createFavorites(@RequestBody @Valid CartDto cartDto) {
        Optional<Client> client = clientService.findById(cartDto.getClient());
        Optional<Products> product = productService.findById(cartDto.getProduct());

        if (client.isPresent()) {
            var favorites = new Favorites(client.get(), product.get());
            return ResponseEntity.status(HttpStatus.CREATED).body(favoritesService.save(favorites));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Favorites>> getAllFavorites() {
        return ResponseEntity.status(HttpStatus.OK).body(favoritesService.findAll());
    }

    @GetMapping("/{idFavorites}")
    public ResponseEntity<Object> getOneFavorites(@PathVariable(value = "idFavorites") Long id) {
        Optional<Favorites> cartModelOptional = favoritesService.findById(id);
        if (!cartModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Favorites Not Found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(cartModelOptional.get());
    }

    @DeleteMapping("/{idFavorites}")
    public ResponseEntity<Object> deleteFavorites(@PathVariable(value = "idFavorites") Long id) {
        Optional<Favorites> favoritesModelOptional = favoritesService.findById(id);
        if (!favoritesModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Favorites Not Found!");
        }
        favoritesService.delete(favoritesModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(favoritesModelOptional.get() + " deleted successfully");
    }

}
