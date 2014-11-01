import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.Color;
import javax.swing.*;

public class YellowLightPanel extends JPanel
{
  private static int PANEL_WIDTH = 500;
  private static int PANEL_HEIGHT = 500;
  
  public YellowLightPanel()
  {
    setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
  }
  
  private void draw(Graphics2D g2)
  {
    //draw cars traveling up and down (blue)
    //draw cars traveling left and right  (red)
  }
  
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    draw(g2);
  }
}
