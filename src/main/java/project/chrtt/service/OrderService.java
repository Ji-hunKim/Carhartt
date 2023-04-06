package project.chrtt.service;

import org.springframework.stereotype.Service;
import project.chrtt.domain.OrderP;
import project.chrtt.domain.Pay;
import project.chrtt.domain.Product;
import project.chrtt.repository.mybatis.OrderMapper;

import java.sql.Time;
import java.sql.Timestamp;

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

    public String savePay(String logId, String pid, String paymentType){
        Long curtime = System.currentTimeMillis();
        String payId = curtime.toString() + logId.hashCode();
        Product product = orderMapper.findById(pid);

        if(paymentType.equals("0")){
            //무통장입금
            //결제 정보 저장
            Pay pay = new Pay(payId, product.getPPrice(), "입금전", 0,
                    Integer.parseInt(paymentType), "무통장입금", Long.parseLong(pid), logId);
            orderMapper.addPay(pay);
        }else{
            //카카오페이 (이미 결제 완료됨을 가정)
            //결제 정보 저장
            Timestamp timestamp = new Timestamp(curtime);
            Pay pay = new Pay(payId, timestamp, product.getPPrice(), "입금완료", 1,
                    Integer.parseInt(paymentType), "카카오페이", Long.parseLong(pid), logId);
            orderMapper.addPay(pay);
        }
        return payId;
    }

    public void saveOrder(String logId, String pid, String paymentType, String payId){
        Long curtime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(curtime);
        int oCodeNum = curtime.hashCode() + logId.hashCode();;
        String oCode = String.valueOf(oCodeNum);
        Product product = orderMapper.findById(pid);

        if(paymentType.equals("0")){
            //무통장입금
            //주문 정보 저장
            OrderP orderP = new OrderP(timestamp, product.getPPrice(), product.getPPrice(), "입금전", 0, product.getPId(),
                    logId, payId, oCode, 1);
            orderMapper.addOrder(orderP);
        }else{
            //카카오페이
            //주문 정보 저장
            OrderP orderP = new OrderP(timestamp, product.getPPrice(), product.getPPrice(), "입금완료", 1, product.getPId(),
                    logId, payId, oCode, 1);
            orderMapper.addOrder(orderP);
        }
    }
}
