
  # Servlet-Examples  
  Different Servlet Examples

## Mysql Database Connectivity
          
* Driver class: The driver class for the mysql database is com.mysql.jdbc.Driver.
* Connection URL: The connection URL for the mysql database is jdbc:mysql://localhost:3306/sonoo where jdbc is the API, mysql is the database, localhost is the server name on which          mysql is running, we may also use IP address, 3306 is the port number and sonoo is the database name. We may use any database, in such case, we need to replace the sonoo with our database name.
* Username: The default username for the mysql database is root.
* Password: It is the password given by the user at the time of installing the mysql database. In this example, we are going to use root as the password.

## Servlet Context Attribute Example
Attribute specific methods of ServletRequest, HttpSession and ServletContext interface
There are following 4 attribute specific methods. They are as follows:

   1. public void setAttribute(String name,Object object):sets the given object in the application scope.
   2. public Object getAttribute(String name):Returns the attribute for the specified name.
   3.  public Enumeration getInitParameterNames():Returns the names of the context's initialization parameters as an Enumeration of String objects.
   4. public void removeAttribute(String name):Removes the attribute with the given name from the servlet context.

## Employee Info:
Assume   that   the   information   regarding   the   salary   and   age   for   all   employees   of   an   organization  are  available  in  a  database.    Develop  a  Servlet  application  which  takes  the  employee  id  of  an  employee  as  a  request  parameter  and  displays  the  details  of employee

## login logout application
A Login application using servlet and JSP, where the user will provide his login details in a servlet page and if the login is successful then, a JSP page with “Welcome”message and “Log  Out”  button  should  be  shown.  If  the  login  is  failed,  then  message  of  failure  and  link  to  further  login  should  be  shown  on  a  JSP  page. 

## Simple Online ShoppingA
An online shopping website, where the customer registers himself with his name and email-id. The continue button will be available on that page and each subsequent page,  which  displays  the  list  of  items.  The  customer  will  choose  the  items  and  the  required  quantity.  In  last  webpage  the  customer’sname,  email  id,  the  list  of  his  purchased  items  and  the bill amount is shown. The students are advised to make the use of cookies. 
