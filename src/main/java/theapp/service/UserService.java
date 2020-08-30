package theapp.service;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import theapp.config.Connector;
import theapp.config.Constants;
import theapp.model.User;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static theapp.config.Constants.*;

@org.springframework.stereotype.Service
public class UserService {

    public static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public User fetchUser() throws IOException {

        URL url = new URL("https://api.github.com/users");
        InputStreamReader reader = new InputStreamReader(url.openStream());

        User user = new Gson().fromJson(reader, User.class);
        if (user == null) {
            logger.error("Could not return desired output.");
            return null;
        } else {
            logger.info("The output returned.");
            return user;
        }
    }

    public void insertRecord(String login) {
        String sql = "select * from calls where LOGIN = ?";
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setString(1, login);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String updateSql = "update calls set REQUEST_COUNT = REQUEST_COUNT + 1 where login = ?";
                PreparedStatement updatePreparedStatement;
                try {
                    updatePreparedStatement = getConnection().prepareStatement(updateSql);
                    updatePreparedStatement.setString(1, login);
                } catch (SQLException e) {
                    logger.error("Could not insert a record into the database.");
                    e.printStackTrace();
                }
            } else {
                String insertSql = "insert into calls (LOGIN, REQUEST_COUNT) values (?, ?)";
                try (final PreparedStatement insertPreparedStatement = getConnection().prepareStatement(insertSql)) {
                    insertPreparedStatement.setString(1, login);
                    insertPreparedStatement.setInt(1, 1);
                } catch (SQLException e) {
                    logger.error("Could not insert a record into the database.");
                    e.printStackTrace();
                }
            }

        } catch (SQLException e) {
            logger.error("Operation failed.");
            e.printStackTrace();
        }
    }


    private Connection getConnection() {
        Connection connection = Connector.createConnection(DEFAULT_DRIVER, DEFAULT_URL, DEFAULT_USERNAME, DEFAULT_PASSWORD);
        if (connection == null) {
            logger.error("Cannot get the connection.");
            return null;
        }
        return connection;
    }
}
