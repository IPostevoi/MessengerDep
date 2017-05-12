package hello.storage;

import hello.models.Chat;
import hello.models.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by bakla410 on 10.05.17.
 */
public class ChatUsersMapperForChats implements RowMapper<Chat> {
    public Chat mapRow(ResultSet rs, int rowNum) throws SQLException {
        Chat chat = new Chat();
        chat.setId(rs.getInt("chatId"));
        chat.setName(rs.getString("chatName"));
        return chat;
    }
}
