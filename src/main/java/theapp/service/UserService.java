package theapp.service;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import theapp.model.User;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

@org.springframework.stereotype.Service
public class UserService {

    public static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public User fetchUser() throws IOException {

        URL url = new URL("https://api.github.com/users/octocat");
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
}
