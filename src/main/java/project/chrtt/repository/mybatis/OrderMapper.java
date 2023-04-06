package project.chrtt.repository.mybatis;

import org.apache.ibatis.annotations.Mapper;
import project.chrtt.domain.OrderP;
import project.chrtt.domain.Pay;
import project.chrtt.domain.Product;

@Mapper
public interface OrderMapper {
    Product findById(String pId);
    void addPay(Pay pay);
    void addOrder(OrderP orderP);
}
