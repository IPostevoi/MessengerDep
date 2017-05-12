package hello.storage;

import java.util.List;
import javax.sql.DataSource;

import hello.abstracts.UserDAO;
import hello.abstracts.BaseSource;
import hello.models.User;
import org.springframework.jdbc.core.JdbcTemplate;
/**
 * Created by bakla410 on 03.05.17.
 */
public class UserJDBC extends BaseSource implements UserDAO {

    public void create(String username, String password) {
        String SQL = "insert into User (username, password, enabled) values (?, ?, ?)";
        jdbcTemplateObject.update(SQL, username, password, 1);
        SQL = "insert into UserRole (username, role) values (?, ?);";
        jdbcTemplateObject.update(SQL, username, "USER");
        System.out.println("Created Record Name = " + username + " password = " + password);
        return;
    }

    public User getUser(String username) {
        String SQL = "select * from User where username = ?";
        User user = jdbcTemplateObject.queryForObject(SQL,
                new Object[]{username}, new UserMapper());
        return user;
    }

    public List<User> listUsers() {
        String SQL = "select * from User";
        List <User> users = jdbcTemplateObject.query(SQL, new UserMapper());
        return users;
    }

    public void delete(Integer id) {
        String SQL = "delete from User where id = ?";
        jdbcTemplateObject.update(SQL, id);
        System.out.println("Deleted Record with ID = " + id );
        return;
    }

    public boolean ifExists(String username) {
        String SQL = "select count(*) from User where username = ?";
        Integer count = jdbcTemplateObject.queryForObject(SQL, new Object[] { username }, Integer.class);
        return count != null && count > 0;
    }
}
