import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface DbConnection {
    default Connection connect() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/medved_db",
                    "postgres",
                    "admin"
            );
            System.out.println("Connection successful!");
            return connection;
        } catch (ClassNotFoundException | SQLException ex) {
            return null;

        }

    }

    void select();
    void insert(Product product);
    void delete();
    void update();
}
