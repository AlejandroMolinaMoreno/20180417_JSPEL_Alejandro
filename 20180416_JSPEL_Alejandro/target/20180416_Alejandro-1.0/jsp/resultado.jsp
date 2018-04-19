<%-- 
    Document   : resultado
    Created on : 17-abr-2018, 2:02:37
    Author     : ale_m
--%>

<%@page import="es.albarregas.beans.Calculadora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado</title>
    </head>
    <body>
        
        <h1>${requestScope.calcula.operando1}
            ${requestScope.calcula.opcion}
            ${requestScope.calcula.operando2} = ${requestScope.calcula.resultado}</h1>
        <p><a href="<%= request.getContextPath()%>">Volver</a></p>
    </body>
</html>
