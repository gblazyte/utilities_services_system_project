import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseStatement {
    private final Statement statement;

    public DatabaseStatement(Connection connection){
        try {
            //This statement is used for executing SQL queries against the database
            statement = connection.createStatement();
        } catch (SQLException e){
            throw new RuntimeException("Failed to create a statement", e);
        }
    }

    //allows external classes to obtain the statement for executing SQL queries
    public Statement getStatement() {
        return statement;
    }
    public void closeStatement() {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
