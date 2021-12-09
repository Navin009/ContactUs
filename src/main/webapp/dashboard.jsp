<!DOCTYPE html>
<%@page import="java.sql.Statement" %>
    <%@page import="java.sql.ResultSet" %>
        <%@page import="java.sql.Connection" %>
            <%@page import="admin.DatabaseConnection" %>
            <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta http-equiv="X-UA-Compatible" content="IE=edge">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Requests</title>
                    <link rel="stylesheet" href="./css/style.css">
                </head>

                <% 
                boolean userLoggedIn = false;
                Cookie[] cookies = request.getCookies();
                for(Cookie cookie : cookies){
                	if(cookie.getName().equals("UID")){
                		userLoggedIn = true;
                	}
                }
                if(!userLoggedIn){
                	 response.sendRedirect("../../login");
                }else{
                	
                }
                %>
                <body>

                    <button class="signout-btn" onclick="signOutUser()"> Sign Out</button>
                    <table>
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Message</th>
                                <th>Archive</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% Connection connection= DatabaseConnection.getConnection();
                            Statement statement = connection.createStatement(); 
                            ResultSet result=statement.executeQuery("select * from feedback");
                            while(result.next()) { %>
                                <tr>
                                    <td>
                                        <%=result.getString("name") %>
                                    </td>
                                    <td>
                                        <%=result.getString("email") %>
                                    </td>
                                    <td>
                                        <div class="message">
                                            <%=result.getString("message")%>
                                        </div>
                                    </td>
                                    <td><input type="checkbox" name="" id="" <% if(result.getInt("active")==1){
                                            out.print("checked");} %> >
                                    </td>
                                </tr>
                                <%} %>
                        </tbody>
                    </table>
                    <button class="save-btn">Save</button>
                    <script src="./js/script.js"></script>
                </body>

            </html>