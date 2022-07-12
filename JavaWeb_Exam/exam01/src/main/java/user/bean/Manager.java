package user.bean;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @version V1.0
 * @author: buguniao
 * @date: 2019/6/2 22:15
 * @description:
 */
public class Manager {
    private int id;
    private String username;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", name='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
