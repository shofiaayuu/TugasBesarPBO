package backend;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author shofiatul
 */
public class Customer extends User {
    
    public Customer(){
    
    }
    public Customer(String nama,String email,String noTelepon,String password){
        super(nama,email,noTelepon,password);
    }
    public Customer getById(int id) {
        Customer cust = new Customer();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM customer " 
                + "WHERE idCust = '" +id+"'");
        try{
            while(rs.next()){
                cust = new Customer();
                cust.setId(rs.getInt("idCust"));
                cust.setNama(rs.getString("nama"));
                cust.setEmail(rs.getString("email"));
                cust.setNoTelepon(rs.getString("noTelepon"));
                cust.setPassword(rs.getString("password"));
                
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return cust;
    }
    
    public ArrayList<Customer>getAll(){
        ArrayList nama = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM customer");
        try{
            while(rs.next()){
                Customer cust = new Customer();
                cust.setId(rs.getInt("idCust"));
                cust.setNama(rs.getString("nama"));
                cust.setEmail(rs.getString("email"));
                cust.setNoTelepon(rs.getString("noTelepon"));
                cust.setPassword(rs.getString("password"));
                nama.add(cust);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return nama;
    }
    
    public ArrayList<Customer>search(String keyword){
        ArrayList nama = new ArrayList();
       String sql = "SELECT * FROM  customer WHERE "+"nama LIKE '%"+keyword+"%'";
       ResultSet rs = DBHelper.selectQuery(sql);
        try{
            while(rs.next()){
                Customer cust = new Customer();
                cust.setId(rs.getInt("id"));
                cust.setNama(rs.getString("nama"));
                cust.setEmail(rs.getString("email"));
                cust.setNoTelepon(rs.getString("noTelepon"));
                cust.setPassword(rs.getString("password"));
                nama.add(cust);
                
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return nama;
    }
    
    public void save() {
        if(getById(id).getId()== 0){
            String sql = "INSERT INTO customer (nama,email,noTelepon,password) VALUES("
                    +"'"+this.nama+"' , "
                    +"'"+this.email+"' , "
                    +"'"+this.noTelepon+"' , "
                    +"'"+this.password+"' ) ";
            this.id=DBHelper.insertQueryGetId(sql);
        } else {
            String sql = "UPDATE customer SET "
            + "nama = '" + this.getNama() + "',"
            + "email = '" + this.getEmail() + "',"
            + "noTelepon = '" + this.getNoTelepon()+"',"
            + "password = '" + this.getPassword()+ "'"
            + "WHERE idCust = '" + this.id + "'";
            DBHelper.executeQuery(sql);
        }
    }
    
    public void delete(){
        String sql = "DELETE FROM customer WHERE idCust = "+this.id+" ";
        DBHelper.executeQuery(sql);
    }
    
    @Override
    public String toString(){
        return nama;
    }
    
    
}
