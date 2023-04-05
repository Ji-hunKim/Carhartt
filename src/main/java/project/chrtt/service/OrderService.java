package project.chrtt.service;

import org.springframework.stereotype.Service;
import project.chrtt.domain.Product;
import project.chrtt.repository.mybatis.OrderMapper;

@Service
public class OrderService {

    private final OrderMapper orderMapper;

    public OrderService(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    public Product findById(String pId){
        Product product = orderMapper.findById(pId);
        if(product == null) return null;
        else return product;
    }

    public void savePayAndOrder(String pid, String paymentType){

        if(paymentType.equals("0")){
            //무통장입금


        }else{
            //카카오페이 (이미 결제 완료됨을 가정)
        }
    }
}
