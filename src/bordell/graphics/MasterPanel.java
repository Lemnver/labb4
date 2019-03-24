package bordell.graphics;
import bordell.graphics.SubPanel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;

public class MasterPanel extends JPanel {
    private CustomerPanel cust_panel;
    private LobbyPanel lobby_panel;
    private QueuePanel q_panel;
    
    public MasterPanel() {
        // panel for the queues
        q_panel = new QueuePanel();
        q_panel.setLayout(new BoxLayout(q_panel, BoxLayout.X_AXIS));
        this.add(q_panel);
        // panel for the lobby
        lobby_panel = new LobbyPanel(q_panel);
        lobby_panel.setLayout(new FlowLayout());
        // panel for creating Customers
        cust_panel = new CustomerPanel(lobby_panel);
        cust_panel.setLayout(new BoxLayout(cust_panel, BoxLayout.Y_AXIS));
    }
}
