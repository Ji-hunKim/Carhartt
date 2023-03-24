package project.chrtt.service;

import org.springframework.stereotype.Service;
import project.chrtt.domain.Mem;
import project.chrtt.repository.mybatis.MemberMapper;

@Service
public class MemberService {
    private final MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public void save(Mem member){
        memberMapper.save(member);
    }
}
