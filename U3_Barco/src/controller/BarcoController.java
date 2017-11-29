package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import dao.BarcoDAO;
import dao.BarcoDAOImpl;
import model.Barco;


/**
 * Servlet implementation class BarcoController
 */
@WebServlet("/BarcoController")
public class BarcoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private Barco barco;
       private List<Barco> barcos;
       private BarcoDAOImpl barcoDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BarcoController() {
        super();
        barco = new Barco();
        barcos = new ArrayList<Barco>();
        barcoDAO = new BarcoDAOImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		if (request.getParameter("btn_save")!= null) {
			
			barco.setPais(request.getParameter("pais"));
			barco.setCapitan(request.getParameter("capitan"));
			barco.setCapacidad(Integer.parseInt(request.getParameter("capacidad")));
			
				
				
			if(barco.getId()==0) {
	
				barcoDAO.createBarco(barco);
				}else {
					barcoDAO.updateBarco(barco);
			}
			
			barcos = barcoDAO.readAllBarcos();
			request.setAttribute("barcos",barcos);
			request.getRequestDispatcher("barco_list.jsp").forward(request, response);
			
		}else if (request.getParameter("btn_new")!=null) {
			barco = new Barco();
			request.getRequestDispatcher("barco_form.jsp").forward(request, response);
			
		
		}else if(request.getParameter("btn_edit")!=null) {	
			try {
				Long id = Long.parseLong(request.getParameter("id"));
				barco = barcoDAO.readBarco(id);
				
			}catch (Exception e) {
				
				barco = new Barco();
			}
			request.setAttribute("barco", barco);
			
			request.getRequestDispatcher("barco_form.jsp").forward(request, response);
			
			
			
		}else if(request.getParameter("btn_delete")!=null) {
		
			
			try {
			Long id = Long.parseLong(request.getParameter("id"));
			
			barcoDAO.deleteBarco(id);
			barcos = barcoDAO.readAllBarcos();
			
			}catch(Exception e) {
				e.printStackTrace();
				
				
			}
			request.setAttribute("barcos", barcos);
			request.getRequestDispatcher("barco_list.jsp").forward(request, response);
		}else {
			System.out.println("Entre");
			barcos = barcoDAO.readAllBarcos();
			request.setAttribute("barcos", barcos);
			request.getRequestDispatcher("barco_list.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
