package hello.storage;

import hello.models.Message;
import hello.models.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by bakla410 on 10.05.17.
 */
public class ChatMessagesMapper implements RowMapper<Message> {
    public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
        Message message = new Message();
        message.setChatId(rs.getInt("chatId"));
        message.setId(rs.getInt("id"));
        message.setContent(rs.getString("content"));
        message.setTime(rs.getTimestamp("time"));
        message.setSenderName(rs.getString("senderName"));
        return message;
    }
}
