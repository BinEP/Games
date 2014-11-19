package utilityClasses;
import java.awt.*;
import javax.swing.*;

public class Fonts extends JComponent {
   String[] differentFonts;
   Font[] font;
   static final int IN = 15;
   public Fonts() {
   
   differentFonts = GraphicsEnvironment.getLocalGraphicsEnvironment()
        .getAvailableFontFamilyNames();
    font = new Font[differentFonts.length];
  }
  public void paintComponent(Graphics g) {
    for (int j = 0; j < differentFonts.length; j += 1) {
      if (font[j] == null) {
        font[j] = new Font(differentFonts[j], Font.PLAIN, 8);
      }
      g.setFont(font[j]);
      int p = 15;
      int q = 15+ (IN * j);
      g.drawString(differentFonts[j],p,q);
    }
  }
  public static void main(String[] args) {
    JFrame frame = new JFrame("Different Fonts");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  //  frame.getContentPane().add(new JScrollPane(new Fonts(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, ));
    frame.setSize(350, 650);
    frame.setVisible(true);
  }
} 