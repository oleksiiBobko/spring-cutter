/**
 * 
 */
package x.y.z.screensaver;

import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.springframework.stereotype.Service;

/**
 * @author OBobko
 * @date 2017-01-10
 */
@Service
public abstract class ColorFrame extends JFrame {
    
    private static final long serialVersionUID = 1L;
    
    public ColorFrame() {
        setSize(200, 200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    public void showOnRundomPlace() {
        Random random = new Random();
        setLocation(random.nextInt(1200), random.nextInt(700));
        getContentPane().setBackground(getColor());
        repaint();
    }

    protected abstract Color getColor();
    
}
