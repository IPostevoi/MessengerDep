package hello.storage;

/**
 * Created by bakla410 on 07.05.17.
 */

import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import hello.abstracts.BaseSource;
import hello.abstracts.ChatDAO;
import hello.models.Chat;
import hello.models.Message;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class ChatJDBC extends BaseSource implements ChatDAO {

    public Integer create(String name, String adminName) {
        String SQL = "insert into Chat (name, adminName) values (?, ?)";
//        jdbcTemplateObject.update(SQL, name, adminName);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplateObject.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps = connection.prepareStatement(SQL, new String[] {"id"});
                        ps.setString(1, name);
                        ps.setString(2, adminName);
                        return ps;
                    }
                },
                keyHolder);
// keyHolder.getKey() now contains the generated key
        System.out.println("Created Chat, name = " + name + " id: " + Integer.parseInt(keyHolder.getKey().toString()));
        return Integer.parseInt(keyHolder.getKey().toString());
    }

    public Chat getChat(Integer chatId) {
        String SQL = "select * from Chat where id = ?";
        Chat chat = jdbcTemplateObject.queryForObject(SQL,
                new Object[]{chatId}, new ChatMapper());
        return chat;
    }

    public List<Chat> listChat(String username) {
        String SQL = "select * from Chat where adminName = ?";
        List<Chat> chats = jdbcTemplateObject.query(SQL, new Object[]{username}, new ChatMapper());
        return chats;
    }

    public boolean ifExists(String name) {
        String SQL = "select count(1) from Chat where username = ?";
        Integer count = jdbcTemplateObject.queryForObject(SQL, new Object[] {name}, Integer.class);
        return count != null && count > 0;
    }

    public List<Message> getMessages(Integer chatId) {
        String SQL = "select * from Message where chatId = ?";
        List<Message> messages = jdbcTemplateObject.query(SQL,
                new Object[] { chatId }, new ChatMessagesMapper());
        return messages;
    }
}
