package project.chrtt.repository.mybatis;

import org.apache.ibatis.annotations.Mapper;
import project.chrtt.domain.Mem;

@Mapper
public interface MemberMapper {

    void save(Mem mem);

    Mem findById(Long id);

}
