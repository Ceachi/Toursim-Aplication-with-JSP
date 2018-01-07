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

import com.DAO.Implementations.Factory;
import com.Tables.Accomodation;
import com.Tables.Accomodation_type;
import com.Tables.Address;
import com.Tables.Contact;

/**
 * Servlet implementation class Hotels
 */
@WebServlet("/Hotels")
public class Hotels extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if(action == null)action = "";
        switch (action) {
            case "new":
                create(request, response);
                break;
            case "insert":
                insert(request, response);
                break;
            case "edit":
                edit(request, response);
                break;
            case "update":
                update(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            default:
                list(request, response);
                break;
        }
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void insert(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Accomodation accomodation= Factory.getAccomodationImpl().getAccomodation(id);
		List<Address> addresses= Factory.getAddressImpl().getAllAddress();
		List<Contact> contacts= Factory.getContactImpl().getAllContacts();
		List<Accomodation_type> types= Factory.getAccomodation_typeImpl().getAllAccomodation_types();
		
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/hotel/edit.jsp");
        request.setAttribute("addresses", addresses);
        request.setAttribute("contacts", contacts);
        request.setAttribute("accomodation", accomodation);
        request.setAttribute("types", types);
        dispatcher.forward(request, response);
		
	}
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int type_id = Integer.parseInt(request.getParameter("type_id"));
        String description_short = request.getParameter("description_short");
        String description_full = request.getParameter("description_full");
        int stars = Integer.parseInt(request.getParameter("stars"));
        int address_id = Integer.parseInt(request.getParameter("address_id"));
        int contact_id = Integer.parseInt(request.getParameter("contact_id"));
        
        Accomodation accomodation= Factory.getAccomodationImpl().getAccomodation(id);
        
        accomodation.setName(name);
        accomodation.setAccomodation_type_id(type_id);
        accomodation.setStars(stars);
        accomodation.setDescription_short(description_short);
        accomodation.setDescription_full(description_full);
        accomodation.setAddress_id(address_id);
        accomodation.setContact_id(contact_id);
        
        Factory.getAccomodationImpl().updateAccomodation(accomodation);

        response.sendRedirect("?action=edit&id="+id);
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
        Accomodation accomodation= Factory.getAccomodationImpl().getAccomodation(id);
        Factory.getAccomodationImpl().deleteAccomodation(accomodation);

        response.sendRedirect("?");
	}
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Accomodation> accomodations = new ArrayList<Accomodation>();
		accomodations = Factory.getAccomodationImpl().getAllAccomodations();
		
		request.setAttribute("accomodations", accomodations);

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/hotelsView.jsp");
        dispatcher.forward(request, response);
	}
	
	private void create(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

}
