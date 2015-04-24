package photoshare;

import org.apache.commons.io.output.ByteArrayOutputStream;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Friend  {
	private String frienda = "";
	private String friendb = "";
	
	public Friend() {
	}
	
	public String getFrienda(){
		return frienda;	
	}
	
	public String getFriendb(){
		return friendb;
	}

	public void setFrienda(String frienda){
		this.frienda = frienda;
	}

	public void setFriendb(String friendb){
		this.friendb = friendb;
	}
}