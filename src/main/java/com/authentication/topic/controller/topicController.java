package com.authentication.topic.controller;

import com.authentication.topic.dao.TopicDAO;
import com.authentication.user.dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AddTopicServlet extends HttpServlet {
    topicDAO tdao=new topicDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/topic/addTopic.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("topic_name");
        if(name==null){
            req.setAttribute("error","Please fill all the fields");
            req.getRequestDispatcher("/WEB-INF/topic/addTopic.jsp").forward(req,resp);
        }
        if(tdao.isAddTopic(name)){
            resp.sendRedirect(req.getContextPath()+"/topic-list");
        }else{
            req.setAttribute("error","Unable to add topic");
            req.getRequestDispatcher("/WEB-INF/topic/addTopic.jsp").forward(req,resp);
        }
    }
}