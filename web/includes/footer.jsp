<%@ page import="java.util.GregorianCalendar, java.util.Calendar" %>



<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:useBean id="now" class="java.util.Date"/>    



<p>&copy; Copyright - <fmt:formatDate value="${now}" dateStyle="long"/> -  Kathy Borne,  Web Developer</p>
</body>
</html>