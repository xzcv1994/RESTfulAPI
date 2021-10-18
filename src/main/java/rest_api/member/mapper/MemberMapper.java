package rest_api.member.mapper;

import org.apache.ibatis.annotations.Mapper;
import rest_api.member.vo.MemberVO;

import java.util.List;

@Mapper
public interface MemberMapper {
    MemberVO selectById(String id);
    MemberVO selectByName(String name);
    List<MemberVO> selectAll();
    int insertMember(MemberVO member);
    int updateMember(MemberVO member);
    int deleteMember(MemberVO member);
}
