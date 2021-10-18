package rest_api.member.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest_api.member.mapper.MemberMapper;
import rest_api.member.vo.MemberVO;

import java.util.List;

@Service
public class MemberService {
    private static final Logger logger = LoggerFactory.getLogger(MemberService.class);

    @Autowired
    private MemberMapper memberMapper;

    public MemberVO getMemberByID(String id){
        logger.info("getMemberByID is called id : " + id);
        MemberVO member = memberMapper.selectById(id);
        return member;
    }

    public MemberVO getMemberByName(String name){
        logger.info("getMemberByName is called name : " + name);
        MemberVO member = memberMapper.selectByName(name);
        return member;
    }

    public List<MemberVO> getAllMembers(){
        logger.info("getAllMembers is called");
        List<MemberVO> member = memberMapper.selectAll();
        return member;
    }

    public void insertMember(MemberVO member){
        logger.info("insertMember is called name");
        memberMapper.insertMember(member);
    }

    public void updateMember(MemberVO member){
        logger.info("updateMember is called name");
        memberMapper.updateMember(member);
    }

    public void deleteMember(MemberVO member){
        logger.info("deleteMember is called name");
        memberMapper.deleteMember(member);
        memberMapper.deleteMember(member);
    }
}
