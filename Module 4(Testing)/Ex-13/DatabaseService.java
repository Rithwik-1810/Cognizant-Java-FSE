public class DatabaseService {
    private final Database database;

    public DatabaseService(Database database) {
        this.database = database;
    }

    public void persist(String data) {
        database.save(data);
    }
}
