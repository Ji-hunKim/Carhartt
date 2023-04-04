package project.chrtt.repository.mybatis;

import org.apache.ibatis.annotations.Mapper;
import project.chrtt.domain.Product;

import java.util.List;

@Mapper
public interface ProductBuyMapper {
    List<Product> findAllProducts();
    Product findById(String pId);
}
