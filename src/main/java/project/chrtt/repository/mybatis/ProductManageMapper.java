package project.chrtt.repository.mybatis;

import org.apache.ibatis.annotations.Mapper;
import project.chrtt.domain.Product;

import java.util.List;

@Mapper
public interface ProductManageMapper {

    List<Product> findAllProducts();
    Product findById(String pId);
    void addProduct(Product product);
    void updateProduct(Product product);
}
