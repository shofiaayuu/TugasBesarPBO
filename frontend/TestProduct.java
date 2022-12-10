package frontend;
/**
 *
 * @author shofiatul
 */
import backend.*;
import java.sql.SQLException;

public class TestProduct {
    public static void main(String[] args) throws SQLException {
        Product pk1 = new Product("Serum GS Glow", 63500);
        Product pk2 = new Product("Toner GS Glow",60000);
        Product pk3 = new Product("Cream Malam GS Glow",90000);
        Product pk4 = new Product("Cream Siang GS Glow",90000);
        Product pk5 = new Product("Paket GS Glow",360000);
        Product pk6 = new Product("Paket Acne GS Glow",390000);
        Product pk7 = new Product("Facial wash GS Glow",45000);
        Product pk8 = new Product("Sunscreen GS Glow", 55000);
        Product pk9 = new Product("Moisturizer GS Glow", 70000);
        Product pk10 = new Product("Face Mask GS Glow", 25000); 
        // test insert
        pk1.save();
        pk2.save();
        pk3.save();
        pk4.save();
        pk5.save();
        pk6.save();
        pk7.save();
        pk8.save();
        pk9.save();
        pk10.save();
        //test update
        pk2.setHarga(60000);
        pk2.save();
        //test delete
        pk10.delete();
        //test selectAll
        for(Product p : new Product().getAll()){
            System.out.println("Nama: " + p.getNamaProduct()+ ", Harga: " + p.getHarga());
        }
        //test search
        for(Product p : new Product().search("Serum GS Glow")){
            System.out.println("Nama: " + p.getNamaProduct() + ", Harga: " + p.getHarga());
        }
        
    }
    
}
