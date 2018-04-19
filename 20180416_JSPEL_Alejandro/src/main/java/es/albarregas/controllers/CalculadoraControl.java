/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.Calculadora;
import es.albarregas.models.Sumar;
import es.albarregas.models.Restar;
import es.albarregas.models.Multiplicar;
import es.albarregas.models.Dividir;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ale_m
 */
@WebServlet(name = "CalculadoraControl", urlPatterns = {"/calculadora"})
public class CalculadoraControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CalculadoraControl</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CalculadoraControl at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url;
        Calculadora calculadora = new Calculadora();
        
            int op1 = Integer.parseInt(request.getParameter("operando1"));
            int op2 = Integer.parseInt(request.getParameter("operando2"));
            String opcion = request.getParameter("opcion");
            
            
            switch (opcion) {
                case "suma":
                    Sumar sumar = new Sumar();    
                    int resultado = sumar.sumar(op1,op2);
                    calculadora.setResultado(resultado);
                    calculadora.setOpcion("suma");
                    break;
                case "resta":
                    Restar restar = new Restar();
                    calculadora.setResultado(restar.restar(op1, op2));
                    calculadora.setOpcion("resta");
                    break;
                case "multiplicar":
                    Multiplicar multiplicar = new Multiplicar();
                    calculadora.setResultado(multiplicar.multiplicar(op1, op2));
                    calculadora.setOpcion("mmultiplicar");
                    break;
                case "dividir":
                    Dividir dividir = new Dividir();
                    calculadora.setResultado(dividir.dividir(op1, op2));
                    calculadora.setOpcion("dividir");
    }
            url="jsp/resultado.jsp";
            request.setAttribute("calcula", calculadora);
        request.getRequestDispatcher(url).forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
