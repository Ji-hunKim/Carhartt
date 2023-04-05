package project.chrtt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import project.chrtt.domain.Product;
import project.chrtt.service.OrderService;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/payment")
    public String order(@RequestParam String pid, Model model) throws IOException {
        Product product = orderService.findById(pid);
        model.addAttribute("product", product);
        return "order/order";
    }
}
