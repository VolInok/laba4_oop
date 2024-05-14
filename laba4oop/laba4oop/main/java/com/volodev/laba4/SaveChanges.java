package com.volodev.laba4;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mysql.cj.jdbc.Driver;

import jakarta.servlet.ServletContext;

/**
 * Servlet implementation class SaveChanges
 */
@WebServlet("/saveChanges")
public class SaveChanges extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Connection connection;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/board_games_database", "root",
                    "5531");
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String data = request.getReader().readLine();
        Names names = gson.fromJson(data, Names.class);
        String query = String.format("update board_game set title='%s', genre='%s', game_time='%s', amount='%d', rate='%d' where game_id='%d'",
                names.getTitle(),names.getGenre(),names.getTime(),names.getAmount(),names.getRate(),names.getIdInDatabase());
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sc.getRequestDispatcher("/jsp/read.jsp").forward(request, response);
    }
}