import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {

    public static String getOrgNameFromId(Integer id) {
        Connection connection = ConnectionFactory.createConnection();
        PreparedStatement preparedStatement = null;
        String result = null;
        try {
            preparedStatement = connection.prepareStatement(
                    "select * from public.organization where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                result = resultSet.getString("orgname");
            }
        } catch (SQLException e) {
            System.out.println("Не получилось исполнить запрос " + e.getMessage());
        }
        return result;
    }

    public static String getStringFieldFromId(Integer id, String fieldName) {
        Connection connection = ConnectionFactory.createConnection();
        PreparedStatement preparedStatement = null;
        String result = null;
        try {
            preparedStatement = connection.prepareStatement(
                    "select * from public.organization where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                result = resultSet.getString(fieldName);
            }
        } catch (SQLException e) {
            System.out.println("Не получилось исполнить запрос " + e.getMessage());
        }
        return result;
    }
}
