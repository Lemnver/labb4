package Bordell.tools;
import javax.swing.DefaultListModel<E>;
import Bordell.tools.Customer;

public class Queue {
    private DefaultListModel model;

    public Queue(DefaultListModel list){
        model = list;
    }
    // pre:
    // post: model.add(cust)
    public void enqueue (Customer cust){
        // adds element to the back of the queue
        model.addElement(cust);
            
    }
    // pre:
    // post: model.get(0) && model.remove(0)
    public Customer pop(){
        // returns and removes element from the  front of the queue
        Customer ret = model.get(0);
        model.remove(0);
        return ret;
    }
}
