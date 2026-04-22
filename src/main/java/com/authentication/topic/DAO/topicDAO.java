package com.authentication.topic.DAO;

import com.authentication.topic.model.TopicModel;
import com.authentication.utils.DbConnection;

import java.sql.*;
import java.util.ArrayList;

public class TopicDAO {
    public boolean isAddTopic(String topic_name){
        String sql="INSERT INTO topic(name,createdAt) VALUES(?,?)";
        try(Connection con= DbConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
        ){
            Timestamp now=new Timestamp(System.currentTimeMillis());
            ps.setString(1,topic_name);
            ps.setTimestamp(2,now);
            int row=ps.executeUpdate();
            return row>0;
        } catch (Exception e) {
            System.out.println("Error while adding topic "+e.getMessage());
            return false;
        }
    }
    public ArrayList<TopicModel> getAllTopics(){
        String sql="SELECT * FROM topic";
        ArrayList<TopicModel> topicList=new ArrayList<>();
        try(Connection con= DbConnection.getConnection();
            Statement s=con.createStatement();
        ){
            ResultSet rs=s.executeQuery(sql);
            while(rs.next()){
                int id=rs.getInt(1);
                String name=rs.getString(2);
                Timestamp createdAt=rs.getTimestamp(3);
                Timestamp updatedAt=rs.getTimestamp(4);
                TopicModel topic=new TopicModel();
                topic.setId(id);
                topic.setName(name);
                topic.setCreatedAt(createdAt);
                topic.setUpdatedAt(updatedAt);
                topicList.add(topic);
            }
            return topicList;
        }catch (Exception e){
            System.out.println("Error while fetching topic "+e.getMessage());
            return null;
        }
    }
}