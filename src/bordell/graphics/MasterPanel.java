package bordell.graphics;
import bordell.graphics.SubPanel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MasterPanel extends JPanel {
    private CustomerPanel cust_panel;
    private LobbyPanel lobby_panel;
    private QueuePanel q_panel;
    
    public MasterPanel() {
        // panel for the queues
        q_panel = new QueuePanel();
        q_panel.setLayout(new BoxLayout(q_panel, BoxLayout.X_AXIS));
        // panel for the lobby
        lobby_panel = new LobbyPanel(q_panel);
        lobby_panel.setLayout(new BoxLayout(lobby_panel, BoxLayout.Y_AXIS));
        // panel for creating Customers
        cust_panel = new CustomerPanel(lobby_panel);
        cust_panel.setLayout(new BoxLayout(cust_panel, BoxLayout.Y_AXIS));

        JLabel appName = new JLabel("Stures Bordell");

        this.add(appName);
		try {
			BufferedImage img = ImageIO.read(new File("./img.jpg"));
			ImageIcon icon = new ImageIcon(img);
			JLabel sign = new JLabel(icon);
            this.add(sign);
		} catch (IOException e) {
            System.out.println("Logo not found");
		}        
        this.add(cust_panel);
        this.add(lobby_panel);
        this.add(q_panel);
    }
}
