package project.chrtt.repository.mybatis;

import org.apache.ibatis.annotations.Mapper;
import project.chrtt.domain.Product;

@Mapper
public interface OrderMapper {
    Product findById(String pId);
}
