package hello.storage;

import hello.models.Chat;
import hello.models.Message;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by bakla410 on 10.05.17.
 */
public class MessageMapper implements RowMapper<Message> {
    public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
        Message message = new Message();
        message.setId(rs.getInt("id"));
        message.setContent(rs.getString("content"));
        message.setSenderName(rs.getString("senderName"));
        message.setChatId(rs.getInt("chatId"));
        message.setTime(rs.getTimestamp("time"));
        return message;
    }
}