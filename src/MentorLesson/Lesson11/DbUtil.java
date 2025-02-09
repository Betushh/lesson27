package MentorLesson.Lesson11;

import MainLesson.Lesson26.MySQLInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
    static final String CONNECTION_URL = MySQLInfo.CONNECTION_URL.getInfo()+"my_example";
    static final String USERNAME = MySQLInfo.USERNAME.getInfo();
    static final String PASSWORD = MySQLInfo.PASSWORD.getInfo();


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
    }

}
