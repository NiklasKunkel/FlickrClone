package photoshare;

import org.apache.commons.io.output.ByteArrayOutputStream;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;

public class Album {
  private String aname = "";
 public String getAname() {
    return aname;
  }

  public void setAname(String aname) {
    this.aname = aname;
  }
}