import javax.swing.JFrame;

public class GraphicSim   //tester
{
  public static void main(String[] args)
  {
    JFrame appFrame = new YellowLightPanel();
    appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    appFrame.show();
  }
}
