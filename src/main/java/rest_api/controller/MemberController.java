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
import java.util.Map;

@RestController
@RequestMapping("/member")
public class MemberController {
    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
    @Autowired
    private MemberService memberService;

    @RequestMapping("/retrieve")
    public Map<String, Object> getMemberById(@RequestParam(value="id", required = true) String id){
        logger.info("/user/retrieve request arrived. id : " + id);
        Map<String, Object> response = new HashMap<String, Object>();
        Member member = memberService.getMemberByID(id);

        if(member != null){
            response.put("id", member.getId());
            response.put("name", member.getName());
        }
        else{
            response.put("id", null);
            response.put("name", null);
        }
        return response;
    }
}
