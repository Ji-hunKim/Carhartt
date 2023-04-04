package project.chrtt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import project.chrtt.domain.Product;
import project.chrtt.service.ProductBuyService;

import java.util.List;

@Controller
@RequestMapping("/productbuy")
public class ProductBuyController {
    private final ProductBuyService productBuyService;

    public ProductBuyController(ProductBuyService productBuyService) {
        this.productBuyService = productBuyService;
    }

    // 상품 목록 불러오기
    @GetMapping("/productList")
    public String productList(Model model){
        List<Product> productList = productBuyService.findAllProducts();
        model.addAttribute("productList", productList);
        return "product/productBuyList";
    }

    // 상품 상세
    @GetMapping("/{itemId}")
    public String product(@PathVariable Long itemId, Model model) {
        Product product = productBuyService.findById(String.valueOf(itemId));
        model.addAttribute("product", product);
        return "product/productBuy";
    }
}
