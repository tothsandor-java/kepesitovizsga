package hu.nive.ujratervezes.kepesitovizsga.jurassic;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JurassicPark {
    DataSource dataSource;

    public JurassicPark(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public ArrayList<String> checkOverpopulation() {

        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select breed, expected, actual from dinosaur")
        ) {
            ArrayList<String> result = new ArrayList<>();
            while (rs.next()) {
                int expected = rs.getInt("expected");
                int actual = rs.getInt("actual");
                if (actual > expected) {
                    String name = rs.getString("breed");
                    result.add(name);
                }
            }
            return result;
        }
        catch (SQLException se) {
            throw new IllegalStateException("Cannot select dinosaur", se);
        }
    }
}
