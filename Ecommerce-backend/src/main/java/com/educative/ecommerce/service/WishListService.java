package com.educative.ecommerce.service;

import com.educative.ecommerce.exceptions.CartItemNotExistException;
import com.educative.ecommerce.model.Cart;
import com.educative.ecommerce.model.User;
import com.educative.ecommerce.model.WishList;
import com.educative.ecommerce.repository.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class WishListService {
    @Autowired
    private WishListRepository wishListRepository;

    public void createWishlist(WishList wishList) {
        wishListRepository.save(wishList);
    }

    public List<WishList> readWishList(User user) {
        return wishListRepository.findAllByUserOrderByCreatedDateDesc(user);
    }

    public void deleteCartItem(int wishListId, User user) throws CartItemNotExistException {
        //TODO

        // first check if wishListId is valid else throw an wishListItemNotExistException

        Optional<WishList> optionalWishList = wishListRepository.findById(wishListId);

        if (!optionalWishList.isPresent()) {
            throw new CartItemNotExistException("cartItemId not valid");
        }

        // next check if the cartItem belongs to the user else throw CartItemNotExistException exception

        WishList wishList = optionalWishList.get();

        if (wishList.getUser() != user) {
            throw new CartItemNotExistException("wishList item does not belong to user");
        }

        wishListRepository.deleteById(wishListId);
        // delete the wishList item
    }
}
