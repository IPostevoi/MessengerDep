package hello.abstracts;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by bakla410 on 11.05.17.
 */
public class UserDTO {

    @NotNull
    @NotEmpty
    private String username;

    @NotNull
    @NotEmpty
    private String password;

    @NotNull
    @NotEmpty
    private String matchingPassword;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setMatchingPassword(String matchingPassword) {

        this.matchingPassword = matchingPassword;
    }

    public String getMatchingPassword() {

        return matchingPassword;
    }
}
