package project.chrtt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/pay")
    public String pay(@RequestParam String pid, @RequestParam String paymentType, Model model) throws IOException {
        int isSuccess=1;
        orderService.savePay(pid, paymentType);

        return "redirect:/order/result/" + isSuccess;
    }

    @GetMapping("/result/{isSuccess}")
    public String showResult(@PathVariable int isSuccess, Model model) throws IOException {

        model.addAttribute("isSuccess", isSuccess);
        return "order/ordercomplete";
    }
}
