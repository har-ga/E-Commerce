// package com.educative.ecommerce.controllers;


// import com.educative.ecommerce.common.ApiResponse;
// import com.educative.ecommerce.dto.cart.AddToCartDto;
// import com.educative.ecommerce.dto.product.ProductDto;
// import com.educative.ecommerce.dto.wishlist.AddToWishListDto;
// import com.educative.ecommerce.exceptions.AuthenticationFailException;
// import com.educative.ecommerce.exceptions.CartItemNotExistException;
// import com.educative.ecommerce.exceptions.ProductNotExistException;
// import com.educative.ecommerce.model.Product;
// import com.educative.ecommerce.model.User;
// import com.educative.ecommerce.model.WishList;
// import com.educative.ecommerce.repository.ProductRepository;
// import com.educative.ecommerce.service.AuthenticationService;
// import com.educative.ecommerce.service.CategoryService;
// import com.educative.ecommerce.service.ProductService;
// import com.educative.ecommerce.service.WishListService;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.ArrayList;
// import java.util.List;

// @RestController
// @RequestMapping("/wishlist")
// public class WishListController {

//     @Autowired
//     private WishListService wishListService;

//     @Autowired
//     private AuthenticationService authenticationService;

//     @Autowired
//     private ProductRepository productRepository;

//     @Autowired
//     ProductService productService;
//     /*
//     API to add a new product in wishlist
//      */
//     @PostMapping("/add")
//     public ResponseEntity<ApiResponse> addWishList(@RequestBody AddToWishListDto addToWishListDto, @RequestParam("token") String token) 
//             throws AuthenticationFailException, ProductNotExistException {

//         // first authenticate the user
//         authenticationService.authenticate(token);

//         // then fetch the user linked to the token
//         User user = authenticationService.getUser(token);

//         //find the product to add and add item by service
//         Product product = productService.getProductById(addToWishListDto.getProductId());
//         wishListService.addToWishlist(addToWishListDto, product, user);
    

//         return new ResponseEntity<>(new ApiResponse(true, "Added to wishlist"), HttpStatus.CREATED);
//     }

//     @GetMapping("/{token}")
//     public ResponseEntity<List<ProductDto>> getWishList(@PathVariable("token") String token) throws AuthenticationFailException {
//         // first authenticate if the token is valid
//         authenticationService.authenticate(token);
//         // then fetch the user linked to the token
//         User user = authenticationService.getUser(token);
//         // first retrieve the wishlist items
//         List<WishList> wishLists = wishListService.readWishList(user);

//         List<ProductDto> products = new ArrayList<>();
//         for (WishList wishList : wishLists) {
//             // change each product to product DTO
//             products.add(new ProductDto(wishList.getProduct()));
//         }
//         // send the response to user
//         return new ResponseEntity<>(products, HttpStatus.OK);
//     }

//     @DeleteMapping("/delete/{wishListId}")
//     public ResponseEntity<ApiResponse> deleteWishList(@PathVariable("wishListId") int wishListId,
//                                                       @RequestParam("token") String token)
//             throws AuthenticationFailException, CartItemNotExistException {
//         authenticationService.authenticate(token);
//         User user = authenticationService.getUser(token);
//         // method to be completed
//         wishListService.deleteWishListItem(wishListId, user);
//         return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Item has been removed"), HttpStatus.OK);
//     }

// }
