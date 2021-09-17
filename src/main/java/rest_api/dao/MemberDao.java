package rest_api.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import rest_api.controller.MemberController;
import rest_api.model.Member;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MemberDao {
    private JdbcTemplate jdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger(MemberDao.class);

    public MemberDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Member> selectById(String id){
        logger.info("selectById is called id : " + id);

        List<Member> result = jdbcTemplate.query("select * from MEMBER where id = ?",
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

    public List<Member> selectByName(String name){
        logger.info("selectByName is called id : " + name);

        List<Member> result = jdbcTemplate.query("SELECT * FROM MEMBER WHERE NAME = ?",
                new RowMapper<Member>() {
                    public Member mapRow(ResultSet rs, int i) throws SQLException {
                        Member member = new Member(
                                rs.getString("ID"),
                                rs.getString("NAME")
                        );
                        return member;
                    }
                }, name);

        return result;
    }

    public List<Member> selectAll(){
        logger.info("selectAll is called");

        List<Member> result = jdbcTemplate.query("SELECT * FROM MEMBER",
                new RowMapper<Member>() {
                    public Member mapRow(ResultSet rs, int i) throws SQLException {
                        Member member = new Member(
                                rs.getString("ID"),
                                rs.getString("NAME")
                        );
                        return member;
                    }
                });

        return result;
    }

    public void insertMember(Member member){
        logger.info("insertMember is called id");
        jdbcTemplate.update("INSERT INTO MEMBER(ID, NAME) VALUES(?, ?)",member.getId(), member.getName());
    }

    public void updateMember(Member member){
        logger.info("updateMember is called id");
        jdbcTemplate.update("UPDATE MEMBER SET id = ?, NAME = ? WHERE ID = ?", member.getId(), member.getName(), member.getId());
    }

    public void deleteMember(Member member){
        logger.info("deleteMember is called id");
        jdbcTemplate.update("DELETE FROM MEMBER WHERE ID = ?", member.getId());
    }
}
