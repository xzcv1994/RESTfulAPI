package rest_api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rest_api.model.Member;
import rest_api.service.MemberService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/member")
public class MemberController {
    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
    @Autowired
    private MemberService memberService;

    @RequestMapping("/retrieveById")
    public Map<String, Object> getMemberById(@RequestParam(value="id", required = true) String id){
        logger.info("/member/retrieveById request arrived. id : " + id);
        Map<String, Object> response = new HashMap<String, Object>();
        List<Member> member = memberService.getMemberByID(id);

        if(member.size() != 0){
            logger.info("/member/retrieveById result is not null");
            response.put("id", member.get(0).getId());
            response.put("name", member.get(0).getName());
        }
        else{
            logger.info("/member/retrieveById result is null");
            response.put("id", null);
            response.put("name", null);
        }
        return response;
    }

    @RequestMapping("/retrieveByName")
    public Map<String, Object> getMemberByName(@RequestParam(value="name", required = true) String name){
        logger.info("/member/retrieveById request arrived. name : " + name);
        Map<String, Object> response = new HashMap<String, Object>();
        List<Member> member = memberService.getMemberByName(name);

        if(member.size() != 0){
            logger.info("/member/retrieveByName result is not null");
            response.put("id", member.get(0).getId());
            response.put("name", member.get(0).getName());
        }
        else {
            logger.info("/member/retrieveByName result is null");
            response.put("id", null);
            response.put("name", null);
        }
        return response;
    }

    @RequestMapping("/retrieveAll")
    public List<Member> getAllMembers(){
        logger.info("/member/retrieveAll request arrived.");
        Map<String, Object> response = new HashMap<String, Object>();
        List<Member> member = memberService.getAllMembers();

        if(member.size() != 0){
            logger.info("/member/retrieveAll result is not null");
            return member;
        }
        else {
            logger.info("/member/retrieveAll result is null");
            return null;
        }
    }

    @RequestMapping("/insertMember")
    public void insertMember(@RequestParam(value="id", required = true) String id,
                                        @RequestParam(value="name", required = true) String name){
        logger.info("/member/insertMember request arrived.");
        Member memberTemp = new Member(id, name);
        memberService.insertMember(memberTemp);
    }

    @RequestMapping("/deleteMember")
    public void deleteMember(@RequestParam(value="id", required = true) String id,
                             @RequestParam(value="name", required = true) String name){
        logger.info("/member/deleteMember request arrived.");
        Member memberTemp = new Member(id, name);
        memberService.deleteMember(memberTemp);
    }

    @RequestMapping("/updateMember")
    public void updateMember(@RequestParam(value="id", required = true) String id,
                                     @RequestParam(value="name", required = true) String name){
        logger.info("/member/updateMember request arrived.");
        Member memberTemp = new Member(id, name);
        memberService.updateMember(memberTemp);
    }
}