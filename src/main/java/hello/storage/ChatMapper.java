package hello.storage;

import hello.models.Chat;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by bakla410 on 07.05.17.
 */
public class ChatMapper implements RowMapper<Chat> {
    public Chat mapRow(ResultSet rs, int rowNum) throws SQLException {
        Chat chat = new Chat();
        chat.setId(rs.getInt("id"));
        chat.setName(rs.getString("name"));
        return chat;
    }
}
