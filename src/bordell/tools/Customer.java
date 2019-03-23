package Bordell.tools;

public class Customer {
    private String name;
    private int pussar;
    private int kramar;
    private int xxx;

    // pre: pussar_count >= 0; kramar_count >= 0;  xxx_count >= 0;
    // post: 
    public Customer (String custName, int pussar_count, int kramar_count, int xxx_count){
        name = custName;
        pussar = pussar_count;
        kramar = kramar_count;
        xxx = xxx_count;
    }
    public String getName(){
        return name;
    }
    public int getPussar(){
        return pussar;
    }
    public int getKramar(){
        return kramar;
    }
    public int getxxx(){
        return xxx;
    }
    public String toString(){
        return name;
    }
}
