/**
* Copyright 2018 qmhd.con.cn Inc. All Rights Reserved. 
* @Title Test.java
* @Package pictoascii
* @Description: TODO:
* @author eric
* @date 2018年8月29日下午3:03:56
* @version V1.0
*/
package pictoascii;

/**
 * @Title Test.java
 * @Package pictoascii
 */

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
 
import javax.imageio.ImageIO;
 
public class Test {
 
  /**
   * @param path
   *            图片路径
   */
  public static void createAsciiPic(final String path) {
    final String base = "@#&$%*o!;.";// 字符串由复杂到简单
    try {
      final BufferedImage image = ImageIO.read(new File(path));
      BufferedImage tag = new BufferedImage(image.getWidth(), image.getHeight(),BufferedImage.TYPE_INT_RGB);
      for (int y = 0,m = 0; y < image.getHeight(); y += 1,m++) {
        for (int x = 0,n = 0; x < image.getWidth(); x += 1,n++) {
          final int pixel = image.getRGB(x, y);
          //System.out.println(Integer.toHexString(pixel));
          //System.out.println(pixel+" ");
          final int r = (pixel & 0xff0000) >> 16, g = (pixel & 0xff00) >> 8, b = pixel & 0xff;
          final int gray = (int) (0.299f * r + 0.578f * g + 0.114f * b);
          tag.setRGB(n, m, pixel);
//          System.out.println();
//          System.out.println();
//          System.out.println(Integer.toHexString(((((0xff<<8)+gray)<<8)+gray)<<8+gray));
          //String  hex = Integer.toHexString(alp)+Integer.toHexString(gray)+Integer.toHexString(gray)+Integer.toHexString(gray);
          //System.out.println(hex);
          //tag.setRGB(x, y, (((((0xff<<8)+gray)<<8)+gray)<<8)+gray);
          //final int index = Math.round(gray * (base.length() + 1) / 255);
          //System.out.print(index >= base.length() ? " " : String.valueOf(base.charAt(index)));*/
          
        }
        System.out.println();
      }
      ImageIO.write(tag, "JPG", new File("C:\\Users\\qmhd\\Desktop\\pic\\128.jpg"));
    } catch (final IOException e) {
      e.printStackTrace();
    }
  }
 
  /**
   * test
   *
   * @param args
   */
  public static void main(final String[] args) {
    Test.createAsciiPic("C:\\Users\\qmhd\\Desktop\\pic\\timg.jpg");
    
    /*int i = 0x000ff0000 ;
    System.out.println(Integer.toBinaryString(i));
    System.out.println(Integer.toBinaryString((i & 0xff0000)  >> 16) ) ;*/
  }
}