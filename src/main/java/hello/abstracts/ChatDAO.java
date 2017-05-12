package hello.abstracts;

import hello.models.Message;
import hello.models.User;
import hello.models.Chat;
import javax.sql.DataSource;
import java.util.List;

/**
 * Created by bakla410 on 07.05.17.
 */
public interface ChatDAO {

    Integer create(String name, String adminName);

    Chat getChat(Integer chatId);

    List<Chat> listChat(String username);

    boolean ifExists(String name);
}
