package hello.storage;

import hello.models.Chat;
import hello.models.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by bakla410 on 09.05.17.
 */
public class ChatUsersMapperForUsers implements RowMapper<User> {
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setUsername(rs.getString("username"));
        return user;
    }
}
