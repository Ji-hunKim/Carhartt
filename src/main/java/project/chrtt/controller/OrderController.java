package project.chrtt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.chrtt.domain.Mem;
import project.chrtt.domain.Product;
import project.chrtt.service.OrderService;
import project.chrtt.web.SessionConst;

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
    public String pay(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false)
                          Mem signInMember,@RequestParam String pid, @RequestParam String paymentType, Model model) throws IOException {
        int isSuccess=1;
        String logId = signInMember.getLogId();
        String payId = orderService.savePay(logId, pid, paymentType);
        orderService.saveOrder(logId, pid, paymentType, payId);

        return "redirect:/order/result/" + isSuccess;
    }

    @GetMapping("/result/{isSuccess}")
    public String showResult(@PathVariable int isSuccess, Model model) throws IOException {

        model.addAttribute("isSuccess", isSuccess);
        return "order/ordercomplete";
    }
}
