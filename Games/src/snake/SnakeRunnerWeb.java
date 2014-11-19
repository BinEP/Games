package snake;

import java.awt.EventQueue;
import javax.swing.JFrame;


public class SnakeRunnerWeb extends JFrame {

    public SnakeRunnerWeb() {

        add(new WebSnake());
        
        setResizable(false);
        pack();
        
        setTitle("Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {                
                JFrame ex = new SnakeRunnerWeb();
                ex.setVisible(true);                
            }
        });
    }
}
