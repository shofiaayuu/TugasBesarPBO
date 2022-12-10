package frontend;
import backend.*;
/**
 *
 * @author shofiatul
 */
public class TestCustomer {
    public static void main(String[] args) {
        Customer cs1 = new Customer("Shofia","shofiaayu@gmail.com","085457835213","shofia06");
        Customer cs2 = new Customer("Kayla","kayla21@gmail.com","085623412543","kayla021");
        Customer cs3 = new Customer("Melanie","mel09@gmail.com","082678452356","melanie09");
        
        //test insert
        cs1.save();
        cs2.save();
        cs3.save();
        
        //test update
        cs2.setNama("Kayla");
        cs2.save();
        
        //test delete
        cs3.delete();
        
        //select all
        for(Customer c : new Customer().getAll()){
            System.out.println("Nama : "+c.getNama()+ ", Email : "+c.getEmail()+ ", NoTelepon : "+c.getNoTelepon());
        }
        //test search
        for(Customer c : new Customer().search("Yisha")){
            System.out.println("Nama : "+c.getNama()+ ", Email : "+c.getEmail()+ ", NoTelepon : "+c.getNoTelepon());
        }
    }
    
}
