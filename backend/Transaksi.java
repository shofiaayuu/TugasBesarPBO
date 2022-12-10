package backend;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author shofiatul
 */
public class Transaksi {
    public int idTransaksi;
    Product product = new Product();
    Customer customer = new Customer();
    public double totalBayar;
    
    
    
    
    public Transaksi(){
        
    }
    public Transaksi(int idTransaks,Product product,Customer customer,double totalBayar){
        this.idTransaksi = idTransaksi;
        this.product = product;
        this.customer = customer;
        this.totalBayar = totalBayar;
    }
    
    public void setIdTransaksi(int idTransaksi){
        this.idTransaksi = idTransaksi;
    }
    public void setProduct(Product product){
        this.product = product;
    }
    public void setCustomer(Customer customer){
        this.customer =  customer;
    }
    public void setTotalBayar(double totalBayar){
        this.totalBayar = totalBayar;
    }
    public int getIdTransaksi(){
        return idTransaksi;
    }
    public Product getProduct(){
        return product;
    }
    public Customer getCustomer(){
        return customer;
    }
    public double getTotalBayar(){
        return totalBayar;
    }
    public Transaksi getById(int id){
       Transaksi tr = new Transaksi();
       ResultSet rs = DBHelper.selectQuery("SELECT"
               + "tr.idTransaksi AS idTransaksi,"
               + "tr.totalBayar AS totalBayar,"
               + "p.idProduct AS idProduct,"
               + "p.harga AS harga,"
               + "c.idCustomer AS idCustomer,"
               + "c.nama AS nama "
               + "FROM transaksi tr "
               + "LEFT JOIN customer c ON tr.idCustomer=c.idCustomer"
               + "LEFT JOIN product p ON tr.harga = p.harga "
               + "WHERE p.idProduct LIKE '%'" );
       try{
           while(rs.next()){
               tr = new Transaksi();
               tr.setIdTransaksi(rs.getInt("idTransaksi"));
               tr.setTotalBayar(rs.getDouble("TotalBayar"));
               tr.getProduct().setIdProduct(rs.getInt("idProduct"));
               tr.getCustomer().setNama(rs.getString("nama"));
               tr.getProduct().setHarga(rs.getInt("harga"));
           }
       }
       catch(Exception e){
           e.printStackTrace();
       }
       return tr;
   }
    public ArrayList<Transaksi>getAll(){
        ArrayList<Transaksi> totalBayar = new ArrayList();
       ResultSet rs = DBHelper.selectQuery("SELECT"
               + "tr.idTransaksi AS idTransaksi,"
               + "tr.totalBayar AS totalBayar,"
               + "p.idProduct AS idProduct,"
               + "p.harga AS harga,"
               + "c.idCustomer AS idCustomer,"
               + "c.nama AS nama "
               + "FROM transaksi st "
               + "LEFT JOIN customer c ON tr.idCustomer=c.idCustomer"
               + "AND product p ON tr.harga = p.harga ");
       try{
           while(rs.next()){
               Transaksi tr = new Transaksi();
               tr.setIdTransaksi(rs.getInt("idTransaksi"));
               tr.setTotalBayar(rs.getDouble("TotalBayar"));
               tr.getProduct().setIdProduct(rs.getInt("idProduct"));
               tr.getCustomer().setNama(rs.getString("nama"));
               tr.getProduct().setHarga(rs.getInt("harga"));
               totalBayar.add(tr);
           }
       }
       catch(Exception e){
           e.printStackTrace();
       }
       return totalBayar;
    }
    public ArrayList<Transaksi> search(String keyword){
       ArrayList<Transaksi> totalBayar = new ArrayList();
       ResultSet rs = DBHelper.selectQuery("SELECT"
               + "tr.idTransaksi AS idTransaksi,"
               + "tr.totalBayar AS totalBayar,"
               + "p.idProduct AS idProduct,"
               + "p.harga AS harga,"
               + "FROM Product p "
               + "LEFT JOIN Product p ON tr.idProduct=a.idProduct"
               + "WHERE tr.totalBayar LIKE '%"+keyword+"%'");
       try{
           while(rs.next()){
               Transaksi tr = new Transaksi();
               tr.setIdTransaksi(rs.getInt("idTransaksi"));
               tr.setTotalBayar(rs.getDouble("totalBayar"));
               tr.getProduct().setIdProduct(rs.getInt("idProduct"));
               tr.getProduct().setHarga(rs.getInt("harga"));
               totalBayar.add(tr);
           }
       }
       catch(Exception e){
           e.printStackTrace();
       }
       return totalBayar;
   }
    public void save() {
        if(getById(idTransaksi).getIdTransaksi()==0){
            String sql = "INSERT INTO transaksi (hargaTr,idProduct) VALUES("
                    +"' "+this.totalBayar+"', "
                    +"' "+this.getProduct().getIdProduct()+"') ";
            this.idTransaksi = DBHelper.insertQueryGetId(sql);
        }else{
            String sql = "UPDATE transaksi SET"
                    +" totalBayar = '"+this.totalBayar+"', "
                    +" idProduct = '"+this.getProduct().getIdProduct()+"' "
                    +"WHERE idTransaksi '"+this.idTransaksi+"' ";
            DBHelper.executeQuery(sql);
        }
        
    }
   public void delete(){
       String sql = "DELETE FROM store WHERE idStore = '"+this.idTransaksi+"' ";
       DBHelper.executeQuery(sql);
   }
    
}
