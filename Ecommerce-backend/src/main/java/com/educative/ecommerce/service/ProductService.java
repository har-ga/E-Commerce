package com.educative.ecommerce.service;


import com.educative.ecommerce.dto.cart.CartItemDto;
import com.educative.ecommerce.dto.product.ProductDto;
import com.educative.ecommerce.exceptions.ProductNotExistException;
import com.educative.ecommerce.model.Category;
import com.educative.ecommerce.model.Product;
import com.educative.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public boolean isProductInCart(List<ProductDto> cart, Integer productId) {
        for (ProductDto productInCart : cart) {
            if (productInCart.getId().equals(productId)) {
                return true; // Product is already in the cart
            }
        }
        return false; // Product is not in the cart
    }

    public List<ProductDto> listProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        for(Product product : products) {
            if(product.isActive()) {
                productDtos.add(new ProductDto(product));
            }
        }
        return productDtos;
    }

    public List<ProductDto> listProductsByCategory(Category category ) {
        List<Product> products = productRepository.findAllByCategory(category);
        List<ProductDto> productDtos = new ArrayList<>();
        for(Product product : products) {
            if(product.isActive()) {
                productDtos.add(new ProductDto(product));
            } 
        }
        return productDtos;
    }

    public static Product getProductFromDto(ProductDto productDto, Category category) {
        Product product = new Product();
        product.setCategory(category);
        product.setDescription(productDto.getDescription());
        product.setImageURL(productDto.getImageURL());
        product.setPrice(productDto.getPrice());
        product.setName(productDto.getName());
        product.setActive(productDto.isActive());
        return product;
    }


    public void addProduct(ProductDto productDto, Category category) {
        // Product product = getProductFromDto(productDto, category);
        
        // productRepository.save(product);
        
        Product product = getProductFromDto(productDto, category);
        Optional<Product> optionalProduct = productRepository.findByName(product.getName());
        if(optionalProduct.isPresent()) {
            return;
        }
        else{
            productRepository.save(product);
        }
    }

    public void updateProduct(Integer productID, ProductDto productDto, Category category, boolean active) {
        Product product = getProductFromDto(productDto, category);
        product.setId(productID);
        product.setActive(active);
        productRepository.save(product);
    }


    public Product getProductById(Integer productId) throws ProductNotExistException {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (!optionalProduct.isPresent())
            throw new ProductNotExistException("Product id is invalid " + productId);
        return optionalProduct.get();
    }

    // public void deleteProductById(){

    // }

    public List<ProductDto> listProductItems(Category category) {
        // first get all the product items for category
        List<Product> productList = productRepository.findAllByCategory(category);
        
        // convert product to productItemDto
        List<ProductDto> products = new ArrayList<>();
        for(Product product : productList) {
            ProductDto productDto = new ProductDto(product);
            products.add(productDto);
        }

        return products;

    }




}
