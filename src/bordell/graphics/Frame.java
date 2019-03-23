package bordell.graphics;
import bordell.graphics.MasterPanel;
import javax.swing.JFrame;

public class Frame extends JFrame {

    public Frame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        // modifieable settings
        int width = 720;
        int height = 1000;
        this.setSize(width, height);
    
        MasterPanel mpanel = new MasterPanel();
        this.add(mpanel);

    }
}
