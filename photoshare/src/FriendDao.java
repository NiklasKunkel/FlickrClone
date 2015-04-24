package photoshare;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FriendDao {
  	private static final String GET_UID_STMT = "SELECT " +
      		"\"user_id\" FROM Users WHERE email = ?";
  	
	private static final String GET_FRIEND_UID_STMT = "SELECT " +
      		"\"friendb\" FROM Friends WHERE frienda = ?";

	private static final String CREATE_FRIENDSHIP_STMT = "INSERT INTO " +
		"Friends (\"frienda\", \"friendb\") VALUES (?, ?)";
  
	private static final String SEARCH_USER_STMT = "SELECT " +
      		"\"firstname\",\"lastname\", \"email\"  FROM users WHERE user_id = ?";


	public List<String> getFriends(String email){
		PreparedStatement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		
		List<String> friends = new ArrayList<String>();
		List<Integer> friendsID = new ArrayList<Integer>();
		try {
			conn = DbConnection.getConnection();
			stmt = conn.prepareStatement(GET_UID_STMT);
			stmt.setString(1,email);
			rs = stmt.executeQuery();
			int myid = 0;
			if (rs.next()) {
				myid = rs.getInt(1);
			}
		      try { stmt.close(); }
		      catch (Exception e) { }
			
			stmt = conn.prepareStatement(GET_FRIEND_UID_STMT);
			stmt.setInt(1,myid);
			rs = stmt.executeQuery();
			while(rs.next()){
				friendsID.add(rs.getInt(1));
			}
			
		      try { stmt.close(); }
		      catch (Exception e) { }
			

			for(Integer ids: friendsID){
				stmt = conn.prepareStatement(SEARCH_USER_STMT);
				stmt.setInt(1,ids);
				rs = stmt.executeQuery();
				if(rs.next()){
					friends.add(rs.getString("firstname") + " " + rs.getString("lastname") + " "  +  rs.getString("email"));
				}
			      try { stmt.close(); }
			      catch (Exception e) { }
			}


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

		return friends;


	}

	public Boolean createFriendship(String frienda,String friendb) {
	    PreparedStatement stmt = null;
	    Connection conn = null;
	    ResultSet rs = null;
	    try {
	      conn = DbConnection.getConnection();
	      stmt = conn.prepareStatement(GET_UID_STMT);
	      stmt.setString(1, frienda);
	      rs = stmt.executeQuery();
		System.out.println("Email: " + frienda );
		System.out.println("Email: " + friendb );

	
		int userid1 = 0;
		int userid2 = 0;
		if(!rs.next())
			return false;	
		else{
			userid1 = rs.getInt(1);	
		}	
		System.out.println("GOT USERID " + userid1);
	      try { stmt.close(); }
	      catch (Exception e) { }
	      
		stmt = conn.prepareStatement(GET_UID_STMT);
		stmt.setString(1, friendb);
		rs = stmt.executeQuery();
		if(!rs.next())
			return false;	
		else{
			userid2 = rs.getInt(1);	
		}
		System.out.println("GOT USERID " + userid2);
	      try { stmt.close(); }
	      catch (Exception e) { }
		
		stmt = conn.prepareStatement(CREATE_FRIENDSHIP_STMT);
		stmt.setInt(1, userid1);
		stmt.setInt(2, userid2);
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