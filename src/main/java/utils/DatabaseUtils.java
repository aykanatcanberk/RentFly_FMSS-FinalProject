package utils;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DatabaseUtils {

    private static Connection connection;
    public static Map<String, String> columns = new HashMap<>();
    public static Map<String, Integer> varcharLengths = new HashMap<>();

    public static void connect() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/deneme2", "postgres", "postgres");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ResultSet executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void checkEmailColumnType() {
        String query = "SELECT data_type, character_maximum_length " +
                "FROM information_schema.columns " +
                "WHERE table_name = 'signup' AND column_name = 'email'";
        try {
            ResultSet rs = executeQuery(query);
            if (rs.next()) {
                String dataType = rs.getString("data_type");
                int length = rs.getInt("character_maximum_length");
                columns.put("email", dataType);
                varcharLengths.put("email", length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void checkSignUpDateColumnType() {
        String query = "SELECT data_type " +
                "FROM information_schema.columns " +
                "WHERE table_name = 'signup' AND column_name = 'sign_up_date'";
        try {
            ResultSet rs = executeQuery(query);
            if (rs.next()) {
                String dataType = rs.getString("data_type");
                columns.put("sign_up_date", dataType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void checkPasswordColumnType() {
        String query = "SELECT data_type, character_maximum_length " +
                "FROM information_schema.columns " +
                "WHERE table_name = 'signup' AND column_name = 'password'";
        try {
            ResultSet rs = executeQuery(query);
            if (rs.next()) {
                String dataType = rs.getString("data_type");
                int length = rs.getInt("character_maximum_length");
                columns.put("password", dataType);
                varcharLengths.put("password", length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void checkPhoneColumnType() {
        String query = "SELECT data_type, character_maximum_length " +
                "FROM information_schema.columns " +
                "WHERE table_name = 'signup' AND column_name = 'phone'";
        try {
            ResultSet rs = executeQuery(query);
            if (rs.next()) {
                String dataType = rs.getString("data_type");
                int length = rs.getInt("character_maximum_length");
                columns.put("phone", dataType);
                varcharLengths.put("phone", length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void checkForeignKeyConstraints() {
        String query = "SELECT tc.constraint_name, kcu.column_name, ccu.table_name AS foreign_table_name, ccu.column_name AS foreign_column_name " +
                "FROM information_schema.table_constraints AS tc " +
                "JOIN information_schema.key_column_usage AS kcu ON tc.constraint_name = kcu.constraint_name " +
                "JOIN information_schema.constraint_column_usage AS ccu ON ccu.constraint_name = tc.constraint_name " +
                "WHERE tc.constraint_type = 'FOREIGN KEY' AND tc.table_name='signup'";
        try {
            ResultSet rs = executeQuery(query);
            while (rs.next()) {
                String foreignTable = rs.getString("foreign_table_name");
                String foreignColumn = rs.getString("foreign_column_name");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean foreignKeysExist() {
        String query = "SELECT constraint_name FROM information_schema.table_constraints WHERE table_name = 'signup' AND constraint_type = 'FOREIGN KEY'";
        try {
            ResultSet rs = executeQuery(query);
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void checkBirthDateColumnType() {
        String query = "SELECT data_type " +
                "FROM information_schema.columns " +
                "WHERE table_name = 'signup' AND column_name = 'birth_date'";
        try {
            ResultSet rs = executeQuery(query);
            if (rs.next()) {
                String dataType = rs.getString("data_type");
                columns.put("birth_date", dataType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void checkStatusColumnType() {
        String query = "SELECT data_type, character_maximum_length " +
                "FROM information_schema.columns " +
                "WHERE table_name = 'signup' AND column_name = 'status'";
        try {
            ResultSet rs = executeQuery(query);
            if (rs.next()) {
                String dataType = rs.getString("data_type");
                int length = rs.getInt("character_maximum_length");
                columns.put("status", dataType);
                varcharLengths.put("status", length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean foreignKeysExist(String tableName, String foreignTableName, String foreignColumnName) {
        try {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet foreignKeys = metaData.getImportedKeys(null, null, tableName);

            while (foreignKeys.next()) {
                String pkTableName = foreignKeys.getString("PKTABLE_NAME");
                String fkColumnName = foreignKeys.getString("FKCOLUMN_NAME");

                if (pkTableName.equals(foreignTableName) && fkColumnName.equals(foreignColumnName)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
