package com.api.Sewing_System.Service;

import com.api.Sewing_System.Models.Cart;
import com.api.Sewing_System.Repositories.CartRepository;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
}
