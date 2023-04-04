package project.chrtt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.chrtt.domain.Product;
import project.chrtt.service.ProductManageService;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/productmanage")
public class ProductManageController {
    private final ProductManageService productManageService;

    public ProductManageController(ProductManageService productManageService) {
        this.productManageService = productManageService;
    }


    // 상품 목록 불러오기
    @GetMapping("/productList")
    public String productList(Model model){
        List<Product> productList = productManageService.findAllProducts();
        model.addAttribute("productList", productList);
        return "product/productManageList";
    }

    // 상품 상세
    @GetMapping("/{itemId}")
    public String product(@PathVariable Long itemId, Model model) {
        Product product = productManageService.findById(String.valueOf(itemId));
        model.addAttribute("product", product);
        return "product/productManage";
    }

    // 상품 등록
    @GetMapping("/add")
    public String addForm(){
        return "product/addForm";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute("product") Product product, @RequestParam(required = false) MultipartFile file, Model model) throws IOException {

        if( file != null){
            String originalName = file.getOriginalFilename();
            String fullPath =  "/Users/jihunkim/Study/chrtt/src/main/resources/static/images/" + originalName;
            String dbPath = "/images/" + originalName;

            file.transferTo(new File(fullPath));

            product.setPImg(dbPath);
        }

        productManageService.addProduct(product);
        model.addAttribute("product", product);
        return "product/productManage";
    }

    // 상품 수정
    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model) {
        Product product = productManageService.findById(String.valueOf(itemId));
        model.addAttribute("product", product);
        return "product/editForm";
    }

    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable Long itemId, @ModelAttribute Product product, @RequestParam(required = false) MultipartFile file) throws IOException {

        if(!file.isEmpty()){
            String originalName = file.getOriginalFilename();
            String fullPath =  "/Users/jihunkim/Study/chrtt/src/main/resources/static/images/" + originalName;
            String dbPath = "/images/" + originalName;

            file.transferTo(new File(fullPath));

            product.setPImg(dbPath);
        }else{
            Product productOrigin = productManageService.findById(String.valueOf(itemId));
            product.setPImg(productOrigin.getPImg());
        }

        productManageService.updateProduct(product);
        return "redirect:/productmanage/{itemId}";
    }
}
