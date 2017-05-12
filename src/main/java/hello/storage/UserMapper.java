package hello.storage;

/**
 * Created by bakla410 on 03.05.17.
 */
import java.sql.ResultSet;
import java.sql.SQLException;

import hello.models.User;
import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User> {
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));

        return user;
    }
}

