package photoshare;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class CommentDao {
  private static final String GET_UID_OWNER = "SELECT " +
      "\"user_id\" FROM users WHERE \"email\" = ?";
  
  private static final String NEW_COMMENT_STMT = "INSERT INTO " +
      "comments (owner, pid, ctext,datamade) VALUES (?, ?, ?,?)";
  
  private static final String GET_COMMENT_STMT = "SELECT ctext " +
      "FROM comments WHERE pid = ?";

  private static final String GET_PID_OWNER = "SELECT a.ownid FROM pictures p, albums a " +
						"WHERE p.myalbumid = a.aid AND p.pid = ?";

  
  public boolean create(String username, String comment,int pid){
    PreparedStatement stmt = null;
    Connection conn = null;
    ResultSet rs = null;
    try {
      conn = DbConnection.getConnection();
      stmt = conn.prepareStatement(GET_UID_OWNER);
      stmt.setString(1, username);
      rs = stmt.executeQuery();
      

      if (!rs.next()) {
        return false;
      }
      
      int uid = rs.getInt(1);
      try { stmt.close(); }
      catch (Exception e) { }
      
      stmt = conn.prepareStatement(GET_PID_OWNER);
      stmt.setInt(1, pid);
      rs = stmt.executeQuery();
      if (!rs.next()) {
        return false;
      }
      if(rs.getInt(1)==uid)
	return false;
      try { stmt.close(); }
      catch (Exception e) { }


      Date date = new Date();  
      
      stmt = conn.prepareStatement(NEW_COMMENT_STMT);
      stmt.setInt(1, uid);
      stmt.setInt(2, pid);
      stmt.setString(3, comment);
      stmt.setDate(4,new java.sql.Date(date.getTime()));
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

  public List<String>  getAllComments(int pid){
    PreparedStatement stmt = null;
    Connection conn = null;
    ResultSet rs = null;
    List<String> comments = new ArrayList();
    try {
      conn = DbConnection.getConnection();
      stmt = conn.prepareStatement(GET_COMMENT_STMT);
      stmt.setInt(1, pid);
      rs = stmt.executeQuery();
      

      while(rs.next()) {
        comments.add(rs.getString(1));
      }
      
      try { stmt.close(); }
      catch (Exception e) { }
      
      return comments;
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