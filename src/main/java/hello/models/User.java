package hello.models;

/**
 * Created by bakla410 on 03.05.17.
 */
public class User {

    private String username;
    private String password;
    private Integer id;

    public User() {}

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Integer getId() { return id; }
}
