package user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;

@RestController
@RequestMapping("/searcher")
public class userController {

    private final static String URL = "jdbc:mysql://localhost:3306/invertabrate";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "jecode4wcs";

    @GetMapping()
    public String getAll() {

        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Searcher;");

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                System.out.println(result.getString("firstname"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "weshwesh";
    }
}
