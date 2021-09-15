package rest_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest_api.dao.MemberDao;
import rest_api.model.Member;

@Service
public class MemberService {
    @Autowired
    MemberDao memberDao;

    public Member getMemberByID(String id){
        Member member = memberDao.selectById(id);
        return member;
    }
}
