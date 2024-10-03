import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnectionImp implements DbConnection {

    @Override
    public void select() {
        try {
            String request = "SELECT * FROM public.products_db";
            Statement statement = connect().createStatement();
            ResultSet resultSet = statement.executeQuery(request);
            while (resultSet.next()) {
                var id = resultSet.getLong("id");
                var model = resultSet.getString("model");
                var price = resultSet.getDouble("price");
                System.out.println("Id - " + id + ", model - " + model + ", price - " + price);
            }

        } catch (SQLException e){
            System.out.println("ne poluchilos");
        }
    }

    @Override
    public void insert(Product product) {
        try {
            var request = "INSERT INTO public.products_db(model, price) VALUES(?, ?)";
            var connection = connect();
            var prepareStatement = connection.prepareStatement(
                    request, Statement.RETURN_GENERATED_KEYS
            );
            prepareStatement.setString(1, product.getModel());
            prepareStatement.setDouble(2, product.getPrice());
            prepareStatement.executeUpdate();
            System.out.println("Data insertion completed");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete() {

    }

    @Override
    public void update() {

    }
}
