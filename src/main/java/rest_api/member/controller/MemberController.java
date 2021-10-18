package rest_api.member.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rest_api.member.service.MemberService;
import rest_api.member.vo.MemberVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/members")
public class MemberController {
    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
    @Autowired
    private MemberService memberService;

    @RequestMapping(method = RequestMethod.GET)
    public Map<String, Object> getMember(@RequestParam(value="id", defaultValue = "") String id,
                                             @RequestParam(value="name", defaultValue = "") String name){
        MemberVO member = null;
        Map<String, Object> response = new HashMap<String, Object>();

        if(!"".equals(id)){
            logger.info("retrieveById request arrived. id : " + id);
            member = memberService.getMemberByID(id);
        }
        else if(!"".equals(name)){
            logger.info("retrieveById request arrived. name : " + name);
            member = memberService.getMemberByName(name);
        }

        if(member != null){
            logger.info("/member/retrieveById result is not null");
            response.put("id", member.getId());
            response.put("name", member.getName());
        }
        else{
            logger.info("/member/retrieveById result is null");
            response.put("id", null);
            response.put("name", null);
        }

        return response;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<MemberVO> getAllMembers(){
        logger.info("retrieveAll request arrived.");
        Map<String, Object> response = new HashMap<String, Object>();
        List<MemberVO> member = memberService.getAllMembers();

        if(member.size() != 0){
            logger.info("/member/retrieveAll result is not null");
            return member;
        }
        else {
            logger.info("/member/retrieveAll result is null");
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public void insertMember(@RequestParam(value="id", required = true) String id,
                                        @RequestParam(value="name", required = true) String name){
        logger.info("/member/insertMember request arrived.");
        MemberVO memberTemp = new MemberVO(id, name);
        memberService.insertMember(memberTemp);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteMember(@RequestParam(value="id", required = true) String id,
                             @RequestParam(value="name", required = true) String name){
        logger.info("/member/deleteMember request arrived.");
        MemberVO memberTemp = new MemberVO(id, name);
        memberService.deleteMember(memberTemp);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateMember(@RequestParam(value="id", required = true) String id,
                                     @RequestParam(value="name", required = true) String name){
        logger.info("/member/updateMember request arrived.");
        MemberVO memberTemp = new MemberVO(id, name);
        memberService.updateMember(memberTemp);
    }
}