package com.ohgiraffers.mapping.section03.compositekey.idclass;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Transactional
    public void addItemToCart(CartDTO cartDTO) {

        Cart cart = new Cart(
                cartDTO.getCartOwnerMemberNo(),
                cartDTO.getAddedBookNo(),
                cartDTO.getQuantity()
        );

        cartRepository.save(cart);
    }
}
