package rest_api.member.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import rest_api.member.vo.MemberVO;

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

    public List<MemberVO> selectById(String id){
        logger.info("selectById is called id : " + id);

        List<MemberVO> result = jdbcTemplate.query("select * from MEMBER where id = ?",
                new RowMapper<MemberVO>() {
                    public MemberVO mapRow(ResultSet rs, int i) throws SQLException {
                        MemberVO member = new MemberVO(
                                rs.getString("ID"),
                                rs.getString("NAME")
                        );
                        return member;
                    }
                }, id);

        return result;
    }

    public List<MemberVO> selectByName(String name){
        logger.info("selectByName is called id : " + name);

        List<MemberVO> result = jdbcTemplate.query("SELECT * FROM MEMBER WHERE NAME = ?",
                new RowMapper<MemberVO>() {
                    public MemberVO mapRow(ResultSet rs, int i) throws SQLException {
                        MemberVO member = new MemberVO(
                                rs.getString("ID"),
                                rs.getString("NAME")
                        );
                        return member;
                    }
                }, name);

        return result;
    }

    public List<MemberVO> selectAll(){
        logger.info("selectAll is called");

        List<MemberVO> result = jdbcTemplate.query("SELECT * FROM MEMBER",
                new RowMapper<MemberVO>() {
                    public MemberVO mapRow(ResultSet rs, int i) throws SQLException {
                        MemberVO member = new MemberVO(
                                rs.getString("ID"),
                                rs.getString("NAME")
                        );
                        return member;
                    }
                });

        return result;
    }

    public void insertMember(MemberVO member){
        logger.info("insertMember is called id");
        jdbcTemplate.update("INSERT INTO MEMBER(ID, NAME) VALUES(?, ?)",member.getId(), member.getName());
    }

    public void updateMember(MemberVO member){
        logger.info("updateMember is called id");
        jdbcTemplate.update("UPDATE MEMBER SET id = ?, NAME = ? WHERE ID = ?", member.getId(), member.getName(), member.getId());
    }

    public void deleteMember(MemberVO member){
        logger.info("deleteMember is called id");
        jdbcTemplate.update("DELETE FROM MEMBER WHERE ID = ?", member.getId());
    }
}
