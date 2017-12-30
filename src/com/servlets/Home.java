package com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.Implementations.*;
import com.Tables.*;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Country country = Factory.getCountryImpl().getCountry("England");
		List<Region> regionList = new ArrayList<Region>();
		regionList = Factory.getCountryImpl().getAllCountryRegions(country);
		
		if(regionList != null) {
			for(Region i : regionList) {
				System.out.println(i.toString());
			}
		}
		
		request.setAttribute("regionList", regionList);

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/homeView.jsp");
        dispatcher.forward(request, response);
		//response.sendRedirect("homeView.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
