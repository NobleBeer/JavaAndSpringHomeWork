import java.sql.*;
import java.util.Map;
import java.util.Optional;

public class StockRepository {
    static Map<String, String> environment = System.getenv();
    static String dbHost = environment.get("DB_HOST");
    static String dbUser = environment.get("DB_USER");
    static String dbPassword = environment.get("DB_PASSWORD");

    public StockRepository() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try (Connection connection = getConnection()) {
            try {
                try (Statement stmt = connection.createStatement()) {
                    final String createTable = "CREATE TABLE IF NOT EXISTS stocks " +
                            "(id_stock SERIAL PRIMARY KEY, " +
                            " name TEXT, " +
                            " cost INT, " +
                            " company_id INT REFERENCES company (id_comp))";
                    stmt.execute(createTable);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<StockEntity> find(int id) {
        try (Connection con = getConnection()) {
            String insertSql = "SELECT * FROM stocks WHERE id_stock = ?;";
            try (PreparedStatement stmt = con.prepareStatement(insertSql)) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    int idStock = rs.getInt("id_stock");
                    String name = rs.getString("name");
                    int cost = rs.getInt("cost");
                    int company_id = rs.getInt("company_id");

                    return Optional.of(new StockEntity(idStock, name, cost, company_id));
                }
                rs.close();
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection
                ("jdbc:postgresql://" + dbHost + ":7432/stocks", dbUser, dbPassword);
    }

    public void create(StockEntity entity) {
        try (Connection con = getConnection()) {
            String insertSql = "INSERT INTO stocks(name, cost, company_id)"
                    + "VALUES(?, ?, ?);";
            try (PreparedStatement stmt = con.prepareStatement(insertSql)) {
                stmt.setString(1, entity.name);
                stmt.setInt(2, entity.cost);
                stmt.setInt(3, entity.companyId);

                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // ok
    public void delete(StockEntity entity) {
        try (Connection con = getConnection()) {
            String insertSql = "DELETE FROM stocks WHERE name = ?"
                    + " AND cost = ? AND company_id = ?;";
            try (PreparedStatement stmt = con.prepareStatement(insertSql)) {
                stmt.setString(1, entity.name);
                stmt.setInt(2, entity.cost);
                stmt.setInt(3, entity.companyId);

                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // ok
    public void update(int id, StockEntity entityUp) {
        try (Connection con = getConnection()) {
            String insertSql = "UPDATE stocks SET name = ?," +
                    " cost = ?, company_id = ?" +
                    " WHERE id_stock = ?;";
            try (PreparedStatement stmt = con.prepareStatement(insertSql)) {
                stmt.setString(1, entityUp.name);
                stmt.setInt(2, entityUp.cost);
                stmt.setInt(3, entityUp.companyId);
                stmt.setInt(4, id);

                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
