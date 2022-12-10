package frontend;
import backend.*;
/**
 *
 * @author shofiatul
 */
public class TestAdminStore {
    public static void main(String[] args) {
        AdminStore as1 = new AdminStore("Yisha","yisha12@gmail.com","085362728294","yisha12");
        
        
        //test insert
        as1.save();
        
        
        //test update
        as1.setNama("Yisha");
        as1.save();
        
        //test delete
        //as1.delete();
        
        //test select all
        for(AdminStore a : new AdminStore().getAll()){
            System.out.println("Nama : "+a.getNama() + ", Email : " + a.getEmail()+ ", NoTelepon : " + a.getNoTelepon());
        }
        
        //test search
        for(AdminStore a : new AdminStore().search("Yisha")){
            System.out.println("Nama : "+a.getNama() + ", Email : " + a.getEmail()+ ", NoTelepon : " + a.getNoTelepon());
        }
    }
    
}
