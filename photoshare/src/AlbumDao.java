package photoshare;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class AlbumDao {
  private static final String GET_UID_OWNER = "SELECT " +
      "\"user_id\" FROM users WHERE \"email\" = ?";
  
private static final String GET_AID_STMT = "SELECT " +
      "\"aid\" FROM albums WHERE \"aname\" = ?";
  
  private static final String GET_ALBUMS_USER = "SELECT " +
      "\"aname\" FROM albums WHERE \"ownid\" = ?";
  
private static final String GET_ALBUMS_ALL = "SELECT " +
      "\"aname\" FROM albums";
  
  private static final String NEW_ALBUM_STMT = "INSERT INTO " +
      "albums (aname, ownid, datecreate) VALUES (?, ?, ?)";
  
 private static final String DELETE_ALBUM_STMT = "DELETE FROM " +
      "albums WHERE aname = ?";
  
 public boolean delete(String albumname){
    PreparedStatement stmt = null;
    Connection conn = null;
    ResultSet rs = null;
    try {
      conn = DbConnection.getConnection();
      stmt = conn.prepareStatement(DELETE_ALBUM_STMT);
      
      stmt.setString(1, albumname);
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

  public int getAlbumID(String albumName){
    PreparedStatement stmt = null;
    Connection conn = null;
    ResultSet rs = null;
    int aid = 0;
    try {
      conn = DbConnection.getConnection();
      stmt = conn.prepareStatement(GET_AID_STMT);
      stmt.setString(1, albumName);
      rs = stmt.executeQuery();
      if(rs.next()) {
	aid = rs.getInt(1);
      }
      return aid;
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
  public List<String> getAllalbums(){
    PreparedStatement stmt = null;
    Connection conn = null;
    ResultSet rs = null;
    List<String> albumList = new ArrayList<String>();
    int myid = 0;
    try {
      conn = DbConnection.getConnection();
      stmt = conn.prepareStatement(GET_ALBUMS_ALL);
      rs = stmt.executeQuery();
      

      while (rs.next()) {
	albumList.add(rs.getString(1));
      }
      
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
   return albumList;
  
  }

  public List<String> getAlbums(String username){
    PreparedStatement stmt = null;
    Connection conn = null;
    ResultSet rs = null;
    List<String> albumList = new ArrayList<String>();
    int myid = 0;
    try {
      conn = DbConnection.getConnection();
      stmt = conn.prepareStatement(GET_UID_OWNER);
      stmt.setString(1, username);
      rs = stmt.executeQuery();
      if(rs.next()) {
	myid = rs.getInt(1);
      }
        try { stmt.close(); }
        catch (SQLException e) { ; }
	


      stmt = conn.prepareStatement(GET_ALBUMS_USER);
      stmt.setInt(1, myid);
      rs = stmt.executeQuery();
      

      while (rs.next()) {
	albumList.add(rs.getString(1));
      }
      
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
   return albumList;
  
  }
  
  public boolean create(String username, String albumname){
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
      


      Date date = new Date();  
      
      stmt = conn.prepareStatement(NEW_ALBUM_STMT);
      stmt.setString(1, albumname);
      stmt.setInt(2, uid);
      stmt.setDate(3,new java.sql.Date(date.getTime()));
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

}