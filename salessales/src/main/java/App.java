public class App {
    public  static void main(String[] args) {
        DbConnectionImp dbConnection = new DbConnectionImp();
        dbConnection.insert(new Product("Moto", 111));


    }
}
