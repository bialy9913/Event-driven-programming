package entities;

import javax.persistence.*;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String shortName;
    private String login;
    private String password;
    public Users(){

    }
    public int getUserId() {
        return userId;
    }
    public String getShortName() {
        return shortName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
