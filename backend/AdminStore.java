package backend;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author shofiatul
 */
public class AdminStore extends User {
    
    public AdminStore(){
    
    }
    public AdminStore(String nama,String email,String noTelepon,String password){
        super(nama,email,noTelepon,password);
    }
    public AdminStore getById(int id){
        AdminStore as = new AdminStore();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM adminstore " 
                + "WHERE idAdmin = '" +id+" '");
        try{
            while(rs.next()){
                as = new AdminStore();
                as.setId(rs.getInt("idAdmin"));
                as.setNama(rs.getString("nama"));
                as.setEmail(rs.getString("email"));
                as.setNoTelepon(rs.getString("noTelepon"));
                as.setPassword(rs.getString("password"));
                
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return as;
    }
    
    public ArrayList<AdminStore>getAll(){
        ArrayList nama = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM adminstore ");
        try{
            while(rs.next()){
                AdminStore as = new AdminStore();
                as.setId(rs.getInt("idAdmin"));
                as.setNama(rs.getString("nama"));
                as.setEmail(rs.getString("email"));
                as.setNoTelepon(rs.getString("noTelepon"));
                as.setPassword(rs.getString("password"));
                nama.add(as);
                
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return nama;
    }
    
    public ArrayList<AdminStore>search(String keyword){
        ArrayList nama = new ArrayList();
        ResultSet rs = DBHelper.selectQuery( "SELECT * FROM adminstore WHERE "
               +"nama LIKE '%" + keyword + "%'"
               +"OR noTelepon LIKE '%" + keyword + "%'");
        try{
            while(rs.next()){
                AdminStore as = new AdminStore();
                as.setId(rs.getInt("idAdmin"));
                as.setNama(rs.getString("nama"));
                as.setEmail(rs.getString("email"));
                as.setNoTelepon(rs.getString("noTelepon"));
                as.setPassword(rs.getString("password"));
                nama.add(as);
                
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return nama;
    }
    
    public void save() {
        if(getById(id).getId()== 0){
            String sql = "INSERT INTO adminstore (nama,email,noTelepon,password) VALUES("
                    +"'"+this.nama+"' , "
                    +"'"+this.email+"' , "
                    +"'"+this.noTelepon+"' , "
                    +"'"+this.password+"') ";
            this.id=DBHelper.insertQueryGetId(sql);
            
            }else{
            String sql = "UPDATE adminstore SET"
                    +" nama='"+this.nama+ "',"
                    +" email='"+this.email+ "',"
                    +" noTelepon='"+this.noTelepon+ "',"
                    +" password='"+this.password+ "'"
                    +" WHERE idAdmin ='"+this.id+ "'";
                   
            DBHelper.executeQuery(sql);       
        }
    }
    public void delete(){
        String sql = "DELETE FROM adminstore WHERE idAdmin = '"+this.id+"'";
        DBHelper.executeQuery(sql);
    }
        @Override
        public String toString(){
        return nama;
    }


    
    
}
