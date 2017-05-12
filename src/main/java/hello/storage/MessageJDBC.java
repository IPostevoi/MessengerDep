package hello.storage;

import hello.abstracts.BaseSource;
import hello.abstracts.MessageDAO;
import hello.models.Message;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by bakla410 on 10.05.17.
 */
public class MessageJDBC extends BaseSource implements MessageDAO {

    public void create(String content, Integer chatId, String senderName) {
        String SQL = "insert into Message (content, chatId, senderName) values (?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplateObject.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps = connection.prepareStatement(SQL, new String[] {"id"});
                        ps.setString(1, content);
                        ps.setInt(2, chatId);
                        ps.setString(3, senderName);
                        return ps;
                    }
                },
                keyHolder);

        String SQLChat = "insert into ChatMessages (chatId, messageId) values (?, ?)";
        jdbcTemplateObject.update(SQLChat, chatId, Integer.parseInt(keyHolder.getKey().toString()));

        System.out.println("Created Record Name in Message, content = " + content + " id = " + chatId);
    }

    public Message getMessage(Integer id) {
        String SQL = "select * from Message where id = ?";
        Message message = jdbcTemplateObject.queryForObject(SQL,
                new Object[] {id}, new MessageMapper());
        return message;
    }


}
