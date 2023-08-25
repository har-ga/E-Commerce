// package com.educative.ecommerce.service;

// import com.educative.ecommerce.dto.product.ProductDto;
// import com.educative.ecommerce.dto.wishlist.AddToWishListDto;
// import com.educative.ecommerce.exceptions.AuthenticationFailException;
// import com.educative.ecommerce.exceptions.CartItemNotExistException;
// import com.educative.ecommerce.model.Cart;
// import com.educative.ecommerce.model.Product;
// import com.educative.ecommerce.model.User;
// import com.educative.ecommerce.model.WishList;
// import com.educative.ecommerce.repository.WishListRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.springframework.web.bind.annotation.RequestParam;

// import java.util.List;
// import java.util.Optional;

// @Service

// public class WishListService {
//     @Autowired
//     private WishListRepository wishListRepository;
//     @Autowired
//     private AuthenticationService authenticationService;
    
    
//     // public void createWishlist(WishList wishList) {
//     //     wishListRepository.save(wishList);
//     // }

//     public boolean isProductInWishList(List<WishList> wishLists, Product product) {
//         for (WishList wishList : wishLists) {
//             if (wishList.getProduct().equals(product)) {
//                 return true;
//             }
//         }
//         return false;
//     }

//     public void addToWishlist(AddToWishListDto addToWishListDto, Product product, User user) throws AuthenticationFailException {
        
//         List<WishList> wishLists = wishListRepository.findAllByUserOrderByCreatedDateDesc(user);

//         if(!isProductInWishList(wishLists, product)) {
//             WishList wishList = new WishList(user, product);
//             wishListRepository.save(wishList);
//         }      
        

//     }


//     public List<WishList> readWishList(User user) {
//         return wishListRepository.findAllByUserOrderByCreatedDateDesc(user);
//     }

//     public void deleteWishListItem(int wishListId, User user) throws CartItemNotExistException {
//         //TODO

//         // first check if wishListId is valid else throw an wishListItemNotExistException

//         Optional<WishList> optionalWishList = wishListRepository.findById(wishListId);

//         if (!optionalWishList.isPresent()) {
//             throw new CartItemNotExistException("cartItemId not valid");
//         }

//         // next check if the cartItem belongs to the user else throw CartItemNotExistException exception

//         WishList wishList = optionalWishList.get();

//         if (wishList.getUser() != user) {
//             throw new CartItemNotExistException("wishList item does not belong to user");
//         }

//         wishListRepository.deleteById(wishListId);
//         // delete the wishList item
//     }

// }
