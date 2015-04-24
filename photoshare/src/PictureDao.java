package photoshare;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PictureDao {
  private static final String SEARCH_MYPIC_TAG_STMT = "SELECT " +
      "p.pid  FROM pictures p, tag t, albums a, users u" +
      " WHERE p.pid = t.pid AND p.myalbumid = a.aid AND a.ownid = u.user_id AND t.word = ? AND u.email = ?";
  
  private static final String SEARCH_ALLPIC_TAG_STMT = "SELECT " +
      "p.pid  FROM pictures p, tag t" +
      " WHERE p.pid = t.pid AND t.word = ?";
  
  private static final String LOAD_PICTURE_STMT = "SELECT " +
      "\"caption\", \"imgdata\", \"thumbdata\", \"size\", \"content_type\" FROM pictures WHERE \"pid\" = ?";

  private static final String SAVE_PICTURE_STMT = "INSERT INTO " +
      "pictures (\"caption\", \"imgdata\", \"thumbdata\", \"size\", \"content_type\", \"myalbumid\" ) VALUES (?, ?, ?, ?, ?, ?)";

  private static final String ALL_PICTURE_IDS_STMT = "SELECT \"pid\" FROM pictures ORDER BY \"pid\" DESC";
  
  private static final String ALL_PICTURE_ALBUM_STMT = "SELECT \"pid\" FROM pictures WHERE \"myalbumid\" = ? ORDER BY \"pid\" DESC";
 
  private static final String DELETE_PICTURE_STMT = "DELETE FROM " +
      "pictures WHERE pid = ?";

    private static final String GET_PICTURE_CAPTION_STMT = "SELECT \"caption\" FROM PICTURES WHERE \"pid\" = ?";
 
  
  public String getCaption(int pid) {
		PreparedStatement stmt = null;
		Connection conn = null;
		ResultSet rs = null;

		String value = "";
		try {
      		conn = DbConnection.getConnection();
      		stmt = conn.prepareStatement(GET_PICTURE_CAPTION_STMT);
      		stmt.setInt(1, pid);
      		rs = stmt.executeQuery();
      		if(rs.next()) {
				value = rs.getString(1);
      	}
      	return value;
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

  public boolean delete(int pid){
    PreparedStatement stmt = null;
    Connection conn = null;
    ResultSet rs = null;
    try {
      conn = DbConnection.getConnection();
      stmt = conn.prepareStatement(DELETE_PICTURE_STMT);
      stmt.setInt(1, pid);
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

  public Picture load(int id) {
		PreparedStatement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		Picture picture = null;
    try {
			conn = DbConnection.getConnection();
			stmt = conn.prepareStatement(LOAD_PICTURE_STMT);
      stmt.setInt(1, id);
			rs = stmt.executeQuery();
      if (rs.next()) {
        picture = new Picture();
        picture.setId(id);
        picture.setCaption(rs.getString(1));
        picture.setData(rs.getBytes(2));
        picture.setThumbdata(rs.getBytes(3));
        picture.setSize(rs.getLong(4));
        picture.setContentType(rs.getString(5));
      }

			rs.close();
			rs = null;
		
			stmt.close();
			stmt = null;
			
			conn.close();
			conn = null;
    } catch (SQLException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
		} finally {
			if (rs != null) {
				try { rs.close(); } catch (SQLException e) { ; }
				rs = null;
			}
			if (stmt != null) {
				try { stmt.close(); } catch (SQLException e) { ; }
				stmt = null;
			}
			if (conn != null) {
				try { conn.close(); } catch (SQLException e) { ; }
				conn = null;
			}
		}

		return picture;
	}

	public void save(Picture picture, int albumid) {
		PreparedStatement stmt = null;
		Connection conn = null;
		try {
			conn = DbConnection.getConnection();
			stmt = conn.prepareStatement(SAVE_PICTURE_STMT);
			stmt.setString(1, picture.getCaption());
			stmt.setBytes(2, picture.getData());
			stmt.setBytes(3, picture.getThumbdata());
			stmt.setLong(4, picture.getSize());
			stmt.setString(5, picture.getContentType());
			stmt.setInt(6,albumid);
			stmt.executeUpdate();
			
			stmt.close();
			stmt = null;
			
			conn.close();
			conn = null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			if (stmt != null) {
				try { stmt.close(); } catch (SQLException e) { ; }
				stmt = null;
			}
			if (conn != null) {
				try { conn.close(); } catch (SQLException e) { ; }
				conn = null;
			}
		}
	}

	public List<Integer> allPicturesforAlbum(int aid){
		PreparedStatement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		
		List<Integer> picturesIds = new ArrayList<Integer>();
		try {
			conn = DbConnection.getConnection();
			stmt = conn.prepareStatement(ALL_PICTURE_ALBUM_STMT);
			stmt.setInt(1,aid);	
			rs = stmt.executeQuery();
			while (rs.next()) {
				picturesIds.add(rs.getInt(1));
			}

			rs.close();
			rs = null;

			stmt.close();
			stmt = null;

			conn.close();
			conn = null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			if (rs != null) {
				try { rs.close(); } catch (SQLException e) { ; }
				rs = null;
			}
			if (stmt != null) {
				try { stmt.close(); } catch (SQLException e) { ; }
				stmt = null;
			}
			if (conn != null) {
				try { conn.close(); } catch (SQLException e) { ; }
				conn = null;
			}
		}

		return picturesIds;

	}

	public List<Integer> allPicturesIds() {
		PreparedStatement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		
		List<Integer> picturesIds = new ArrayList<Integer>();
		try {
			conn = DbConnection.getConnection();
			stmt = conn.prepareStatement(ALL_PICTURE_IDS_STMT);
			rs = stmt.executeQuery();
			while (rs.next()) {
				picturesIds.add(rs.getInt(1));
			}

			rs.close();
			rs = null;

			stmt.close();
			stmt = null;

			conn.close();
			conn = null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			if (rs != null) {
				try { rs.close(); } catch (SQLException e) { ; }
				rs = null;
			}
			if (stmt != null) {
				try { stmt.close(); } catch (SQLException e) { ; }
				stmt = null;
			}
			if (conn != null) {
				try { conn.close(); } catch (SQLException e) { ; }
				conn = null;
			}
		}

		return picturesIds;
	}
	
	public List<Integer> myPicturesbyTag(String username, String tag){
		PreparedStatement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		
		List<Integer> picturesIds = new ArrayList<Integer>();
		try {
			conn = DbConnection.getConnection();
			stmt = conn.prepareStatement(SEARCH_MYPIC_TAG_STMT);
			stmt.setString(1,tag);	
			stmt.setString(2,username);	
			rs = stmt.executeQuery();
			while (rs.next()) {
				picturesIds.add(rs.getInt(1));
			}

			rs.close();
			rs = null;

			stmt.close();
			stmt = null;

			conn.close();
			conn = null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			if (rs != null) {
				try { rs.close(); } catch (SQLException e) { ; }
				rs = null;
			}
			if (stmt != null) {
				try { stmt.close(); } catch (SQLException e) { ; }
				stmt = null;
			}
			if (conn != null) {
				try { conn.close(); } catch (SQLException e) { ; }
				conn = null;
			}
		}

		return picturesIds;

	}
	
 	public List<Integer> allPicturesbyTag(String tag){
		PreparedStatement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		
		List<Integer> picturesIds = new ArrayList<Integer>();
		try {
			conn = DbConnection.getConnection();
			stmt = conn.prepareStatement(SEARCH_ALLPIC_TAG_STMT);
			stmt.setString(1,tag);	
			rs = stmt.executeQuery();
			while (rs.next()) {
				picturesIds.add(rs.getInt(1));
			}

			rs.close();
			rs = null;

			stmt.close();
			stmt = null;

			conn.close();
			conn = null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			if (rs != null) {
				try { rs.close(); } catch (SQLException e) { ; }
				rs = null;
			}
			if (stmt != null) {
				try { stmt.close(); } catch (SQLException e) { ; }
				stmt = null;
			}
			if (conn != null) {
				try { conn.close(); } catch (SQLException e) { ; }
				conn = null;
			}
		}

		return picturesIds;

	}
}