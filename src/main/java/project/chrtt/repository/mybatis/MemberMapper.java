package project.chrtt.repository.mybatis;

import org.apache.ibatis.annotations.Mapper;
import project.chrtt.domain.Mem;

@Mapper
public interface MemberMapper {

    void signUp(Mem mem);

    Mem findById(String id);

}
