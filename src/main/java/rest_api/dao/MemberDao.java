package rest_api.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import rest_api.model.Member;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MemberDao {
    private JdbcTemplate jdbcTemplate;

    public MemberDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Member selectById(String id){
        Member result = jdbcTemplate.queryForObject("select * from MEMBER where id = ?",
                new RowMapper<Member>() {
                    public Member mapRow(ResultSet rs, int i) throws SQLException {
                        Member member = new Member(
                                rs.getString("ID"),
                                rs.getString("NAME")
                        );
                        return member;
                    }
                }, id);
        return result;
    }

    public Member selectByName(String name){
        return null;
    }

    public List<Member> selectAll(){
        return null;
    }

    public void insert(Member member){

    }

    public void update(Member member){

    }

    public void delete(Member member){

    }
}
