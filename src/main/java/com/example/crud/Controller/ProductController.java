package com.example.crud.Controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.repository.query.Param;
import com.example.crud.Models.Product;
import com.example.crud.Repository.ProductRepository;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/create")
    public String createAction(Model model) {
        model.addAttribute("message", "Enter The Product Details");
        return "Create";
    }

    @PostMapping("/create")
    public String createActionProcess(Product product, Model model) {
        productRepository.save(product);
        model.addAttribute("message", "The Product " + product.getName() + " has been created successfully");
        return "create";
    }

    @GetMapping("/all")
    public String getAllProducts(Model model, @Param("keyword") String keyword) {
        Iterable<Product> products = (keyword != null && !keyword.isEmpty()) 
            ? productRepository.findAllByKeyword(keyword) 
            : productRepository.findAll();
        model.addAttribute("products", products);
        return "list";
    }

    @GetMapping("/update/{id}")
    public String updateProduct(@PathVariable Integer id, Model model) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            model.addAttribute("product", product);
            return "update";
        } else {
            model.addAttribute("message", "Product not found.");
            return "error";
        }
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable Integer id, Product updatedProduct, Model model) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setName(updatedProduct.getName());
            product.setDescription(updatedProduct.getDescription());
            product.setExpirydate(updatedProduct.getExpirydate());
            product.setMRP(updatedProduct.getMRP());
            productRepository.save(product);
            return "redirect:/all";
        } else {
            model.addAttribute("message", "Product not found.");
            return "error";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id, Model model) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            model.addAttribute("product", product);
            return "delete";
        } else {
            model.addAttribute("message", "Product not found.");
            return "error";
        }
    }

    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        productRepository.deleteById(id);
        return "redirect:/all";
    }
}
