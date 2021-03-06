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

        // label for the queue
        String name1 = "Queue 1";
        JLabel label1 = new JLabel(name1);

        // create scrollable JList to hold customers
        model1 = new DefaultListModel<Customer>();
        queue1 = new Queue(model1);
        list1 = new JList(model1);
        // panel that holds all components for its queue
        JScrollPane pane1 = new JScrollPane(list1);
        JPanel qpanel1 = new SubPanel();
        
        //create button for serving customer
        qpanel1.setLayout(new BoxLayout(qpanel1, BoxLayout.Y_AXIS));
        qbutton1 = new JButton("Serve");
        // add action for when button is pressed 
        qbutton1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                serveCustomer(queue1);
            }
            });

        // add components
        qpanel1.add(label1);
        qpanel1.add(pane1);
        qpanel1.add(qbutton1);
        this.add(qpanel1);
        
        // label for the queue
        String name2 = "Queue 2";
        JLabel label2 = new JLabel(name2);

        // create scrollable JList to hold customers
        model2 = new DefaultListModel<Customer>();
        queue2 = new Queue(model2);
        list2 = new JList(model2);
        // panel that holds all components for its queue
        JScrollPane pane2 = new JScrollPane(list2);
        JPanel qpanel2 = new SubPanel();
        
        //create button for serving customer
        qpanel2.setLayout(new BoxLayout(qpanel2, BoxLayout.Y_AXIS));
        qbutton2 = new JButton("Serve");
        // add action for when button is pressed 
        qbutton2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                serveCustomer(queue2);
            }
            });

        // add components
        qpanel2.add(label2);
        qpanel2.add(pane2);
        qpanel2.add(qbutton2);
        this.add(qpanel2);
    }
    // pre: !queue.isEmpty()
    // post: Queue.pop();
    public void serveCustomer(Queue queue){
        // removes customer from Queue
        if (!queue.isEmpty()){
            Customer cust = queue.pop(); 
            String title = "Customer Served";
            String message = "Name: " + cust.getName() + 
                "\nPussar: " + cust.getPussar() + 
                "\nKramar" + cust.getKramar() + 
                "\nXXX: " + cust.getXXX();
            JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
        }

    }
    public Queue getFirstQueue (){
        return queue1;
    }
    public Queue getSecondQueue (){
        return queue2;
    }
}
