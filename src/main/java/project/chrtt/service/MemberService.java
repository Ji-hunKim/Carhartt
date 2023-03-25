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

    public void signUp(Mem member){
        memberMapper.signUp(member);
    }

    public Mem signIn(String logId, String password){
        Mem member = memberMapper.findById(logId);
        if(member == null || !member.getLogPw().equals(password) ) return null;
        else return member;
    }
}
