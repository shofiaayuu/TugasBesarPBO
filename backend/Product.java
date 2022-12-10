package backend;
import java.util.ArrayList;
import java.sql.*;


/**
 *
 * @author shofiatul
 */
public class Product {
    public int idProduct,harga;
    public String namaProduct;
    
    public Product(){
    }
    public Product(String namaProduct, int harga ){
        this.namaProduct = namaProduct;
        this.harga = harga;
    }

    public void setIdProduct(int idProduct){
        this.idProduct = idProduct;
    }
    public void setHarga(int harga){
        this.harga = harga;
    }
    public void setNamaProduct(String namaProduct){
        this.namaProduct = namaProduct;
    } 
   
    public int getIdProduct(){
        return idProduct;
    }
    public int getHarga(){
        return harga;
    }
    public String getNamaProduct(){
        return namaProduct;
    }
   
    
    public Product getById(int id){
        Product product = new Product();
        ResultSet rs = DBHelper.selectQuery("SELECT "
                + "p.idProduct AS idProduct, "
                + "p.harga AS harga,"
                + "p.namaProduct AS namaProduct "
                + "FROM product p "
                + "WHERE p.idProduct ='"+id+"'");
       try{
           while(rs.next()){
               product = new Product();
               product.setIdProduct(rs.getInt("idProduct"));
               product.setHarga(rs.getInt("harga"));
               product.setNamaProduct(rs.getString("namaProduct"));
           }
       }
       catch(Exception e){
           e.printStackTrace();
       }
       return product;
    }
   public ArrayList<Product> getAll(){
       ArrayList<Product>ListProduct = new ArrayList();
       ResultSet rs = DBHelper.selectQuery("SELECT "
               + "p.idProduct AS idProduct, "
               + "p.harga AS harga, "
               + "p.namaProduct AS namaProduct "
               + "FROM product p "
               );
       try{
           while(rs.next()){
              Product product = new Product();
              product.setIdProduct(rs.getInt("idProduct"));
              product.setHarga(rs.getInt("harga"));
              product.setNamaProduct(rs.getNString("namaProduct"));
              ListProduct.add(product);
           }
       }
       catch(Exception e){
           e.printStackTrace();
       }
       return ListProduct;
   }
   public ArrayList<Product> search(String keyword) throws SQLException{
       ArrayList<Product> ListSkincare = new ArrayList();
       ResultSet rs = DBHelper.selectQuery("SELECT "
               + "p.idProduct AS idProduct, "
               + "p.harga AS harga, "
               + "p.namaProduct AS namaProduct "
               + " FROM product p "
               + "WHERE p.namaProduct LIKE '%"+keyword+"%' "
               );
       try{
           while(rs.next()){
              Product product = new Product();
              product.setIdProduct(rs.getInt("idProduct"));
              product.setHarga(rs.getInt("harga"));
              product.setNamaProduct(rs.getString("namaProduct"));
              ListSkincare.add(product);
           }
       }
        catch(Exception e){
           e.printStackTrace();
       }
       return ListSkincare;
   }
   
   public void save(){
       if(getById(idProduct).getIdProduct()==0){
           String sql = "INSERT INTO product (harga,namaProduct) VALUES("
                   + "'" +this.harga+"',"
                   + "'" +this.namaProduct+"')";
           
           this.idProduct=DBHelper.insertQueryGetId(sql);
       }else{
           String sql = "UPDATE product SET"
                   +" harga = '"+this.harga +"',"
                   +" namaProduct = '"+this.namaProduct + "'"
                   +" WHERE idProduct = '"+this.idProduct + "'";
           DBHelper.executeQuery(sql);
       }
   }
   
   public void delete(){
       String sql = "DELETE FROM product WHERE idProduct = '"+this.idProduct+"' ";
       DBHelper.executeQuery(sql);
   }
   
   @Override
   public String toString(){
       return namaProduct;
   }
   
   
    
    
}
