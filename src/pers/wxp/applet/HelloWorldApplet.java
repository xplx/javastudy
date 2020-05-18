package pers.wxp.applet;

import java.applet.Applet;
import java.awt.Graphics;

/**
* @author wuxiaopeng 
* @Description: TODO(这里用一句话描述这个类的作用)  
* @date 2017年7月4日 上午8:49:02 
* 
*/
public class HelloWorldApplet extends Applet
{
   /**
	* @Description: TODO(这里用一句话描述这个类的作用)  
	* @date 2017年7月4日 上午8:49:56 
	* 
	*/
	private static final long serialVersionUID = 1L;

public void paint (Graphics g)
   {
      g.drawString ("Hello World", 25, 50);
   }
}
