package photoshare;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewUserDao {
  private static final String CHECK_EMAIL_STMT = "SELECT " +
      "COUNT(*) FROM Users WHERE email = ?";

  private static final String NEW_USER_STMT = "INSERT INTO " +
      "Users (email, password, firstName, lastName, dateOfBirth, userGender, currentCity, currentState, currentCountry, homeCity, homeState, homeCountry, schoolName, schoolMajor, schoolYear) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

  private static final String SEARCH_USER_STMT = "SELECT " +
      "\"firstname\",\"lastname\" FROM users WHERE email = ?";

  private static final String GRAND_TOTAL_STMT = " " +
      "SELECT results.email, SUM(results.total) as grandTotal " +
      "FROM   ((SELECT u.email, COUNT(*) as total " +
      "FROM users u, pictures p, albums a  " +
      "WHERE u.user_id = a.ownid AND a.aid = p.myalbumid " +
      "GROUP BY u.email " +
      "ORDER BY total DESC) " + 
      "UNION ALL " +
      "(SELECT u.email ,COUNT(*) as total " +
      "FROM users u, comments c " +
      "WHERE u.user_id = c.owner " +
      "GROUP BY u.email " +
      "ORDER BY total DESC))   as results " +
      "WHERE results.email != \'ANONYMOUS\' " + 
      "GROUP BY results.email " +
      "ORDER BY grandTotal DESC " +
      "LIMIT 10 ";

  public String search(String email){
    PreparedStatement stmt = null;
    Connection conn = null;
    ResultSet rs = null;
    try {
      conn = DbConnection.getConnection();
      stmt = conn.prepareStatement(SEARCH_USER_STMT);
      stmt.setString(1, email);
      rs = stmt.executeQuery();

      String firstname;
      String lastname;
      if (!rs.next()) {
        return null;
      }
      else{
        firstname = rs.getString("firstname");
        lastname = rs.getString("lastname");
      }
      return email + " " + firstname + " " + lastname;
    } catch (SQLException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
      } finally {
        if (rs != null) {
          try { rs.close(); }
        catch (SQLException e) { ; }
        rs = null;
      }
      
      if (stmt != null) {
        try { stmt.close(); }
        catch (SQLException e) { ; }
        stmt = null;
      }
      
      if (conn != null) {
        try { conn.close(); }
        catch (SQLException e) { ; }
        conn = null;
      }
    }
  }

  public boolean create(String email, String password, String firstName, String lastName, String dateOfBirth, String userGender, String currentCity, String currentState, String currentCountry, String homeCity, String homeState, String homeCountry, String schoolName, String schoolMajor, String schoolYear) {
    PreparedStatement stmt = null;
    Connection conn = null;
    ResultSet rs = null;
    try {
      conn = DbConnection.getConnection();
      stmt = conn.prepareStatement(CHECK_EMAIL_STMT);
      stmt.setString(1, email);
      rs = stmt.executeQuery();
      if (!rs.next()) {
        // Theoretically this can't happen, but just in case...
        return false;
      }
      int result = rs.getInt(1);
      if (result > 0) {
        // This email is already in use
        return false; 
      }
      
      try { stmt.close(); }
      catch (Exception e) { }

      stmt = conn.prepareStatement(NEW_USER_STMT);
      stmt.setString(1, email);
      stmt.setString(2, password);
      stmt.setString(3, firstName);
      stmt.setString(4, lastName);
      stmt.setString(5, dateOfBirth);
      stmt.setString(6, userGender);
      stmt.setString(7, currentCity);
      stmt.setString(8, currentState);
      stmt.setString(9, currentCountry);
      stmt.setString(10, homeCity);
      stmt.setString(11, homeState);
      stmt.setString(12, homeCountry);
      stmt.setString(13, schoolName);
      stmt.setString(14, schoolMajor);
      stmt.setString(15, schoolYear);

      stmt.executeUpdate();

      return true;
    } catch (SQLException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    } finally {
      if (rs != null) {
        try { rs.close(); }
        catch (SQLException e) { ; }
        rs = null;
      }
      
      if (stmt != null) {
        try { stmt.close(); }
        catch (SQLException e) { ; }
        stmt = null;
      }
      
      if (conn != null) {
        try { conn.close(); }
        catch (SQLException e) { ; }
        conn = null;
      }
    }
  }
  public void topUsers(List<Integer> points,List<String> emails){
    PreparedStatement stmt = null;
    Connection conn = null;
    ResultSet rs = null;
    try {
      conn = DbConnection.getConnection();
      stmt = conn.prepareStatement(GRAND_TOTAL_STMT);
      rs = stmt.executeQuery();
      while(rs.next()){
        emails.add(rs.getString(1));  
        points.add(rs.getInt(2));
      }
      return;
    } catch (SQLException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    } finally {
      if (rs != null) {
        try { rs.close(); }
        catch (SQLException e) { ; }
        rs = null;
      }
      
      if (stmt != null) {
        try { stmt.close(); }
        catch (SQLException e) { ; }
        stmt = null;
      }
      
      if (conn != null) {
        try { conn.close(); }
        catch (SQLException e) { ; }
        conn = null;
      }
    }
  }
}