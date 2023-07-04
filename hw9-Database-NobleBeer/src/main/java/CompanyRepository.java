import java.sql.*;
import java.util.Map;
import java.util.Optional;

public class CompanyRepository {
    static Map<String, String> environment = System.getenv();
    static String dbHost = environment.get("DB_HOST");
    static String dbUser = environment.get("DB_USER");
    static String dbPassword = environment.get("DB_PASSWORD");

    public CompanyRepository() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try (Connection con = getConnection()) {
            try (Statement stmt = con.createStatement()) {
                final String createTable = "CREATE TABLE IF NOT EXISTS company " +
                        "(id_comp SERIAL PRIMARY KEY, " +
                        " name text, " +
                        " country text, " +
                        " creation_date date, " +
                        " stocks_count int)";
                stmt.execute(createTable);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // ok
    public Optional<CompanyEntity> find(int id) {
        try (Connection con = getConnection()) {
            String insertSql = "SELECT * FROM company WHERE id_comp = ?;";
            try (PreparedStatement stmt = con.prepareStatement(insertSql)) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    int idComp = rs.getInt("id_comp");
                    String name = rs.getString("name");
                    String country = rs.getString("country");
                    String creationDate = rs.getString("creation_date");
                    int stocksCount = rs.getInt("stocks_count");

                    return Optional.of(new CompanyEntity(idComp, name, country, creationDate, stocksCount));
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

    // ok
    public void create(CompanyEntity entity) {
        try (Connection con = getConnection()) {
            String insertSql = "INSERT INTO company(name, country, creation_date, stocks_count)"
                    + "VALUES(?, ?, ?, ?);";
            try (PreparedStatement stmt = con.prepareStatement(insertSql)) {
                // проверить на создание
                    stmt.setString(1, entity.name);
                    stmt.setString(2, entity.country);
                    stmt.setDate(3, java.sql.Date.valueOf(entity.creationDate));
                    stmt.setInt(4, entity.stocksCount);
                    int count = stmt.executeUpdate();
                    if (count == 0) {
                        throw new RuntimeException();
                    }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // ok
    public void delete(CompanyEntity entity) {
        try (Connection con = getConnection()) {
            String insertSql = "DELETE FROM company WHERE name = ?" +
                    " AND country = ? AND creation_date = ? AND stocks_count = ?;";
            try (PreparedStatement stmt = con.prepareStatement(insertSql)) {
                stmt.setString(1, entity.name);
                stmt.setString(2, entity.country);
                stmt.setDate(3, java.sql.Date.valueOf(entity.creationDate));
                stmt.setInt(4, entity.stocksCount);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    // ok
    public void update(int id, CompanyEntity entityUp) {
        try (Connection con = getConnection()) {
            String insertSql = "UPDATE company SET name = ?, country = ?," +
            " creation_date = ?, stocks_count = ? WHERE id_comp = ?;";
            try (PreparedStatement stmt = con.prepareStatement(insertSql)) {
                stmt.setString(1, entityUp.name);
                stmt.setString(2, entityUp.country);
                stmt.setDate(3, java.sql.Date.valueOf(entityUp.creationDate));
                stmt.setInt(4, entityUp.stocksCount);
                stmt.setInt(5, id);

                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
