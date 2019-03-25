package bordell.graphics;
import bordell.tools.Customer;
import bordell.tools.Queue;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerPanel extends JPanel {

    private LobbyPanel lpanel;
    private JTextField nameField;
    private JSpinner kramSpinner;
    private JSpinner pussSpinner;
    private JSpinner xxxSpinner;
    private SpinnerNumberModel kramModel;
    private SpinnerNumberModel pussModel;
    private SpinnerNumberModel xxxModel;
    public CustomerPanel(LobbyPanel lobby_panel){
        lpanel = lobby_panel;
        String name = "Customer Creation";
        JLabel label = new JLabel(name);
        
        // name section
        int namelength = 30;
        JLabel nameLabel = new JLabel("Name: ");
        nameField = new JTextField(namelength);
       
        JPanel namePane = new JPanel();
        namePane.add(nameLabel);
        namePane.add(nameField);

        // max amount for all products
        int max = 10;

        JLabel kramLabel = new JLabel("kramar: ");
        // spinnermodel 
        kramModel = new SpinnerNumberModel(
                0, 0, max, 1); 
        kramSpinner =  new JSpinner(kramModel); 
        // container panel 
        JPanel kramPane = new JPanel();
        kramPane.add(kramLabel);
        kramPane.add(kramSpinner);

        JLabel pussLabel = new JLabel("pussar: ");
        // spinnermodel 
        pussModel = new SpinnerNumberModel(
                0, 0, max, 1); 
        pussSpinner =  new JSpinner(pussModel); 
        // container panel 
        JPanel pussPane = new JPanel();
        pussPane.add(pussLabel);
        pussPane.add(pussSpinner);
        
        JLabel xxxLabel = new JLabel("xxx: ");
        // spinnermodel 
        xxxModel = new SpinnerNumberModel(
                0, 0, max, 1); 
        xxxSpinner =  new JSpinner(xxxModel); 
        // container panel 
        JPanel xxxPane = new JPanel();
        xxxPane.add(xxxLabel);
        xxxPane.add(xxxSpinner);
        
        this.add(label);
        this.add(namePane);
        this.add(kramPane);
        this.add(pussPane);
        this.add(xxxPane);

        // button for submitting customer to lobby
        JButton submButton = new JButton("Send to lobby");
        submButton.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                if (source instanceof JButton){
                    try {
                        submit();
                    } catch (java.text.ParseException err) {}
                }
                }
            });

        this.add(submButton);
    }
    // pre: 
    // post: customer created and sent to lobby, input fields reset
    public void submit() throws java.text.ParseException{
        // checks if the input fields are valid, if so creates a customer
        // and sends it to lobby, resets fields
        // validate fields
        String name = nameField.getText();
        int kramar = kramModel.getNumber().intValue();
        int pussar = pussModel.getNumber().intValue();
        int xxx = xxxModel.getNumber().intValue(); 
        if (name != null && !name.isEmpty()){
            if (kramar > 0 || pussar > 0 || xxx > 0) {
                // create customer
                Customer cust = new Customer(
                        name,
                        kramar,
                        pussar,
                        xxx
                        );
                
                // send to lobby
                (lpanel.getModel()).add(0, cust);
                // reset fields
                nameField.setText("");
                kramSpinner.setValue(0);
                pussSpinner.setValue(0);
                xxxSpinner.setValue(0);
            }
        }
    }
}
