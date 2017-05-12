package hello.storage;

import hello.abstracts.BaseSource;
import hello.abstracts.ChatUsersDAO;
import hello.models.Chat;
import hello.models.User;

import java.util.List;

/**
 * Created by bakla410 on 08.05.17.
 */
public class ChatUsersJDBC extends BaseSource implements ChatUsersDAO {

    public void create(String username, String chatName, Integer chatId) {
        String SQL = "insert into ChatUsers (username, chatId, chatName) values (?, ?, ?)";
        jdbcTemplateObject.update(SQL, username, chatId, chatName);
        System.out.println("Created Record in ChatUsers username = " + username + " chatId = " + chatId);
    }

    public boolean ifExists(String username, Integer chatId) {
        String SQL = "select count(1) from ChatUsers where username = ? and chatId = ?";
        Integer count = jdbcTemplateObject.queryForObject(SQL, new Object[] { username, chatId }, Integer.class);
        return count != null && count > 0;
    }

    public List<User> listUsers(Integer chatId) {
        String SQL = "select * from ChatUsers where chatId = ?";
        List<User> users = jdbcTemplateObject.query(SQL, new Object[]{chatId}, new ChatUsersMapperForUsers());
        return users;
    }

    public List<Chat> listChats(String username) {
        String SQL = "select * from ChatUsers where username = ?";
        List<Chat> chats = jdbcTemplateObject.query(SQL, new Object[]{username}, new ChatUsersMapperForChats());
        return chats;
    }
}
