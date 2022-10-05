package com.api.Sewing_System.Service;

import com.api.Sewing_System.Models.Cart;
import com.api.Sewing_System.Models.Client;
import com.api.Sewing_System.Models.Products;
import com.api.Sewing_System.Repositories.CartRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class CartService {

    final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Transactional
    public Cart save(Cart cart) {return cartRepository.save(cart);}

    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Transactional
    public void delete(Cart cart) {
        cartRepository.delete(cart);
    }

    public Optional<Cart> findById(Long id) {
        return cartRepository.findById(id);
    }

    public void upDatingCart(Client client, Products product){
        Stream<Cart> carts = client.getCart().stream().filter(cart -> cart.getProduct() == product);
        Cart cart = carts.findFirst().get();
        if(cart != null) {
            delete(cart);
        }
    }
}
