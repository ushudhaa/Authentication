package com.authentication.user.DAO;

import com.authentication.user.model.UserModel;
import com.authentication.utils.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
    public boolean isEmailExit(String email){
        String sql="SELECT * FROM user WHERE email=?";
        try(Connection con= DbConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
        ){
            ps.setString(1,email);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                return true;
            }
            return false;
        }catch (Exception e){
            System.out.println("Error while searching user "+e.getMessage());
            return false;
        }
    }

    public boolean insertUser(UserModel user){
        String sql="INSERT INTO user (name,email,password) VALUES(?,?,?)";
        try(Connection con= DbConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){
            ps.setString(1,user.getName());
            ps.setString(2,user.getEmail());
            ps.setString(3,user.getPassword());
            int row=ps.executeUpdate();
            return row>0;
        }catch (Exception e){
            System.out.println("Error while adding user"+e.getMessage());
            return false;
        }
    }
    public UserModel getUserDetail(String email) {
 String sql="Select * from user where email=?";
    try(Connection con= DbConnection.getConnection();
        PreparedStatement ps=con.prepareStatement(sql);
        ) {
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
//             int id=rs.getInt("id");
//             String name=rs.getString("name");
//             String userEmail=rs.getString("Email");
//             String userPassword= rs.getString("password");
            UserModel user = new UserModel();
            user.setId(rs.getInt("id"));
            user.setEmail(rs.getString("Email"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            return user;
        }
        return null;
    }catch (Exception e) {
        System.out.println("Error while searcghing user");
        return null;
    }
    }
}