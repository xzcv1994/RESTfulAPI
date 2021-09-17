package rest_api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest_api.controller.MemberController;
import rest_api.dao.MemberDao;
import rest_api.model.Member;

import java.util.List;

@Service
public class MemberService {
    private static final Logger logger = LoggerFactory.getLogger(MemberService.class);

    @Autowired
    MemberDao memberDao;

    public List<Member> getMemberByID(String id){
        logger.info("getMemberByID is called id : " + id);
        List<Member> member = memberDao.selectById(id);
        return member;
    }

    public List<Member> getMemberByName(String name){
        logger.info("getMemberByName is called name : " + name);
        List<Member> member = memberDao.selectByName(name);
        return member;
    }

    public List<Member> getAllMembers(){
        logger.info("getAllMembers is called");
        List<Member> member = memberDao.selectAll();
        return member;
    }

    public void insertMember(Member member){
        logger.info("insertMember is called name");
        memberDao.insertMember(member);
    }

    public void updateMember(Member member){
        logger.info("updateMember is called name");
        memberDao.updateMember(member);
    }

    public void deleteMember(Member member){
        logger.info("deleteMember is called name");
        memberDao.deleteMember(member);
    }
}
