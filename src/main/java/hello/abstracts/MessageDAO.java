package hello.abstracts;

import hello.models.Message;
import hello.models.User;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by bakla410 on 04.05.17.
 */
public interface MessageDAO {

    void create(String content, Integer chatId, String senderName);

    Message getMessage(Integer id);

//    List<Message> listMessages(Long senderId);

//    boolean ifExists(String chat, String content);
}
