package hello;

import hello.storage.MessageJDBC;
import hello.storage.UserJDBC;
import hello.storage.ChatJDBC;
import hello.storage.ChatUsersJDBC;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by bakla410 on 03.05.17.
 */

public class Config {

    private static ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
    private  static UserJDBC userJDBC =
            (UserJDBC)context.getBean("userJDBC");
    private  static ChatJDBC chatJDBC =
            (ChatJDBC)context.getBean("chatJDBC");
    private  static ChatUsersJDBC chatUsersJDBC =
            (ChatUsersJDBC)context.getBean("chatUsersJDBC");
    private  static MessageJDBC messageJDBC =
            (MessageJDBC)context.getBean("messageJDBC");

    public static UserJDBC getUser() {
        return userJDBC;
    }

    public static ChatJDBC getChat() {
        return chatJDBC;
    }

    public static ChatUsersJDBC getChatUsers() {
        return chatUsersJDBC;
    }

    public static MessageJDBC getMessage() {
        return messageJDBC;
    }
}
