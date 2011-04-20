package com.project.dataaccess.dao;


import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;


import org.springframework.jdbc.core.JdbcTemplate;

import com.project.web.form.User;


public class UserDAOImpl implements UserDAO {
	private JdbcTemplate jdbcTemplate;
	 
	    public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource);
	        
	    }
	 
    public void addUser(User user) throws Exception {
	        /**
	         * Specify the statement
	         */
	        String query = "INSERT INTO USER (USER_ID, FIRST_NAME" +
	        		", LAST_NAME, EMAIL" +
	        		", TELEPHONE) VALUES (?,?,?,?,?)";
	        /**
	         * Specify the values
	         */

	        jdbcTemplate.update(query, new Object[] 
	           { Integer.valueOf("1"),user.getFirstname()
	        		   ,user.getLastname()
	        		   ,user.getEmail()
	        		   ,user.getTelephone()
	                });
    }

    
    public User selectUser(int userId) {
    	        /**
    	         * Specify the statement
    	         */
    	        String query = "SELECT * FROM USER WHERE USER_ID=?";
    	        /**
    	         * Implement the RowMapper callback interface
    	         */
    	        return (User) jdbcTemplate.queryForObject(query, new Object[] { Integer.valueOf(userId) },
    	                new RowMapper() {
    	                    public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
    	                        return new User(resultSet.getInt("USER_ID"), resultSet.getString("FIRST_NAME"),
    	                                resultSet.getString("LAST_NAME"),resultSet.getString("EMAIL"),resultSet.getString("TELEPHONE"));
    	                    }
    	                });
    	    }
}
