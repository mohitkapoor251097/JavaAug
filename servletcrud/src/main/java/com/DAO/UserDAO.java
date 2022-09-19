package com.DAO;


import com.mysql.jdbc.Statement;
import com.user.UserDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class UserDAO {
   private Connection conn;
    public UserDAO(Connection conn) {
        this.conn = conn;
    }
   public boolean addUser(UserDetails us)
   {
       boolean f=false;
       try
       {
           String query="insert into data(name,email,password) values (?,?,?)";
           PreparedStatement ps=conn.prepareStatement(query);
           ps.setString(1,us.getName());
           ps.setString(2, us.getEmail());
           ps.setString(3, us.getPassword());
          int i=ps.executeUpdate();
          if(i==1)
          {
              f=true;
          }
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
       return f; 
   }
   public UserDetails loginUser(UserDetails us)
   {
       UserDetails user=null;
       try
       {
           String query="select * from data where  email=? and password=?";
           PreparedStatement pt=conn.prepareStatement(query);
           pt.setString(1,us.getEmail());
           pt.setString(2,us.getPassword());
           ResultSet rs=pt.executeQuery();
           
           if(rs.next())
           {
               user=new UserDetails();
               user.setId(rs.getInt("id"));
               user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                //user.setProfile("profile");
                 // user.setProfile(rs.getString("profile"));
           }
           
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }

   return  user;
  }

    public List<UserDetails> getAllUser() {
        List<UserDetails> list=new ArrayList<UserDetails>();
        UserDetails b=null;
         try
         {
             String sql="select * from  data";
             PreparedStatement ps=conn.prepareStatement(sql); 
             ResultSet rs=ps.executeQuery();
             
             while(rs.next())
             {
//                 b=new Bookdtl();
//                 b.setBookId(rs.getInt(1));
//                 b.setBookName(rs.getString(2));
//                 b.setAuthor(rs.getString(3));
//                 b.setPrice(rs.getString(4));
//                 b.setBookCategory(rs.getString(5));
//                 b.setStatus(rs.getString(6));
//                 b.setPhotoName(rs.getString(7));
//                 b.setEmail(rs.getString(8));
//                 list.add(b);
            	 b=new UserDetails();
            	 b.setId(rs.getInt(1));
            	 b.setName(rs.getString(2));
            	 b.setEmail(rs.getString(3));
            	 b.setPassword(rs.getString(4));
            	 list.add(b);
            	 
             }
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
         
         
         return list;
     }
    
    public boolean deleteUsers(int id) {
        boolean f=false;
       try{
           String sql="delete  from data where id=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
           int i= ps.executeUpdate();
            if(i==1)
            {
                f=true;
            }
       }catch(Exception e)
       {
           e.printStackTrace();
       }
       
       return f;
   }
    public boolean updateUser(UserDetails user)
    {
        boolean f=false;
        try
        {
             String query="update data set name=? ,email=? ,password=? where id=?";
             PreparedStatement p=conn.prepareStatement(query);
             p.setString(1, user.getName());
             p.setString(2, user.getEmail());
             p.setString(3,user.getPassword());
           
            
             p.setInt(4,user.getId());
             p.executeUpdate();
              f=true;       
        }catch(Exception e){
            e.printStackTrace();
        }
        return f;
    }
    public UserDetails getUserById(int id) {
        UserDetails b=null;
        try
        {
            String sql="select * from data where id=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                b=new UserDetails();
//                 b.setBookId(rs.getInt(1));
//                 b.setBookName(rs.getString(2));
//                 b.setAuthor(rs.getString(3));
//                 b.setPrice(rs.getString(4));
//                 b.setBookCategory(rs.getString(5));
//                 b.setStatus(rs.getString(6));
//                 b.setPhotoName(rs.getString(7));
//                 b.setEmail(rs.getString(8));
                b.setId(rs.getInt(1));
           	 b.setName(rs.getString(2));
           	 b.setEmail(rs.getString(3));
           	 b.setPassword(rs.getString(4));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return b;
         
         
     }
   
}


