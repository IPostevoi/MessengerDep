package hello.controller;

import hello.models.Message;
import hello.models.User;
import hello.Config;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

/**
 * Created by bakla410 on 03.05.17.
 */
@Controller
public class SocketController {

//    @RequestMapping(value = "/")
//    public String login() {
//        return "login_page.html";
//    }
//    @MessageMapping("/validateLogin/")
//    @SendToUser("/queue/login/")
//    public Message validate(User user) throws Exception {
//        boolean ifUser = Config.getStorage().ifExists(user.getUsername());
//        if (ifUser) {
//            return new Message("OK");
//        } else {
//            return new Message("ERROR");
//        }
//    }
//    public void sendMessages(Principal principal) {
//    messagingTemplate
// .convertAndSendToUser(principal.getName(), "/queue/horray", "Horray, " + principal.getName() + "!");
//}


    @MessageMapping("/chat/{id}")
    @SendTo("/topic/chat/{id}")
    public Message send(Message message) throws Exception {
        Config.getMessage().create(message.getContent(), message.getChatId(), message.getSenderName());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        message.setTime(timestamp);
        return message;
    }
}
