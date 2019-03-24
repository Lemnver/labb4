package bordell.graphics;
import javax.swing.JPanel;
import bordell.tools.Customer;
import bordell.tools.Queue;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LobbyPanel extends JPanel {

    private QueuePanel qpanel;
    private JList list;
    private DefaultListModel<Customer> model;

    public LobbyPanel(QueuePanel queue_panel){
        qpanel = queue_panel;

        String lobbyLabel = "Lobby";
        JLabel label = new JLabel(lobbyLabel);
        
        model = new DefaultListModel<Customer>();
        model.add(0, new Customer("Edna", 1, 2, 3));
        list = new JList(model);
        JScrollPane pane = new JScrollPane(list);
        
        JButton buttonQ1 = new JButton("Queue 1");
		buttonQ1.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						addToFirstQueue(list.getSelectedIndex());
					}
				});        
        JButton buttonQ2 = new JButton("Queue 2");
		buttonQ2.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						addToSecondQueue(list.getSelectedIndex());
					}
				});        
        // bPane holds the buttons to make sure they are horizontal under the list
        JPanel bPane = new JPanel();
        bPane.setLayout(new BoxLayout(bPane, BoxLayout.X_AXIS));
        bPane.add(buttonQ1);
        bPane.add(buttonQ2);
        
        this.add(label);
        this.add(pane);
        this.add(bPane);
    }

    public void addToFirstQueue(int index){
        // moves selected customer to the first queue
        if (list.getSelectedIndex() != -1){
            Customer cust = model.get(index);
            model.remove(index);
            Queue queue = qpanel.getFirstQueue();
            queue.enqueue(cust);
        }
    }

    public void addToSecondQueue(int index){
        // moves selected customer to the second queue
        if (list.getSelectedIndex() != -1){
            Customer cust = model.get(index);
            model.remove(index);
            Queue queue = qpanel.getSecondQueue();
            queue.enqueue(cust);
        }
    }

}
