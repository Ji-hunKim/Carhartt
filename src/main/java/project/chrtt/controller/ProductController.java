package project.chrtt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.chrtt.domain.Product;
import project.chrtt.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    // 상품 목록 불러오기
    @GetMapping("/productList")
    public String productList(Model model){
        List<Product> productList = productService.findAllProducts();
        model.addAttribute("productList", productList);
        return "product/productList";
    }

    // 상품 상세
    @GetMapping("/{itemId}")
    public String product(@PathVariable Long itemId, Model model) {
        Product product = productService.findById(String.valueOf(itemId));
        model.addAttribute("product", product);
        return "product/product";
    }

    // 상품 등록
    @GetMapping("/add")
    public String addForm(){
        return "product/addForm";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute("product") Product product, Model model) {
        productService.addProduct(product);
        model.addAttribute("product", product);
        return "product/product";
    }

    // 상품 수정
    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model) {
        Product product = productService.findById(String.valueOf(itemId));
        model.addAttribute("product", product);
        return "product/editForm";
    }

    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable Long itemId, @ModelAttribute Product product) {
        productService.updateProduct(product);
        return "redirect:/product/{itemId}";
    }
}
