package bordell.graphics;
import javax.swing.JPanel;
import bordell.tools.Customer;
import bordell.tools.Queue;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class QueuePanel extends SubPanel {

    private DefaultListModel<Customer> model1;
    private DefaultListModel<Customer> model2;
    private Queue queue1;
    private Queue queue2;
    private JList list1;
    private JList list2;
    private JButton qbutton1;
    private JButton qbutton2;
    public QueuePanel(){
        model1 = new DefaultListModel<Customer>();
        queue1 = new Queue(model1);
        list1 = new JList(model1);
        model1.add(0, new Customer("Edna", 1, 2, 3));
        JScrollPane pane1 = new JScrollPane(list1);
        JPanel qpanel1 = new SubPanel();
        
        qpanel1.setLayout(new BoxLayout(qpanel1, BoxLayout.Y_AXIS));
        qbutton1 = new JButton("Serve");
        qbutton1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                serveCustomer(queue1);
            }
            });

        qpanel1.add(pane1);
        qpanel1.add(qbutton1);
        this.add(qpanel1);
        
        model2 = new DefaultListModel<Customer>();
        queue2 = new Queue(model2);
        list2 = new JList(model2);
        model2.add(0, new Customer("Edna", 2, 2, 3));
        JScrollPane pane2 = new JScrollPane(list2);
        JPanel qpanel2 = new SubPanel();
        
        qpanel2.setLayout(new BoxLayout(qpanel2, BoxLayout.Y_AXIS));
        qbutton2 = new JButton("Serve");
        qbutton2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                serveCustomer(queue2);
            }
            });

        qpanel2.add(pane2);
        qpanel2.add(qbutton2);
        this.add(qpanel2);
        this.repaint();
    }
    // pre:
    // post: Queue.pop();
    public void serveCustomer(Queue queue){
        // removes customer from Queue
        Customer cust = queue.pop(); 
        String title = "Customer Served";
        String message = "Name: " + cust.getName() + 
            "\nPussar: " + cust.getPussar() + 
            "\nKramar" + cust.getKramar() + 
            "\nXXX: " + cust.getXXX();
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }
    public Queue getFirstQueue (){
        return queue1;
    }
    public Queue getSecondQueue (){
        return queue2;
    }
}
