 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!Doctype html>
<html>
 <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="keywords"
              content="unique login form,leamug login form,boostrap login form,responsive login form,free css html login form,download login form">
        <meta name="author" content="leamug">
        <title>Unique Login Form | Bootstrap Templates</title>
        <style type="text/css">
        /*author:starttemplate*/
/*reference site : starttemplate.com*/
body {
  background-image:url(image/a.jpg);
  background-position:center;
  background-size:cover;
  
  -webkit-font-smoothing: antialiased;
  font: normal 14px Roboto,arial,sans-serif;
  font-family: 'Dancing Script', cursive!important;
}

.container {
    padding: 110px;
}
::placeholder { /* Chrome, Firefox, Opera, Safari 10.1+ */
    color: #ffffff!important;
    opacity: 1; /* Firefox */
    font-size:18px!important;
}
.form-login {
    background-color: rgba(0,0,0,0.55);
    padding-top: 10px;
    padding-bottom: 20px;
    padding-left: 20px;
    padding-right: 20px;
    border-radius: 15px;
    border-color:#d2d2d2;
    border-width: 5px;
    color:white;
    box-shadow:0 1px 0 #cfcfcf;
}
.form-control{
    background:transparent!important;
    color:white!important;
    font-size: 18px!important;
}
h1{
    color:white!important;
}
h4 { 
 border:0 solid #fff; 
 border-bottom-width:1px;
 padding-bottom:10px;
 text-align: center;
}

.form-control {
    border-radius: 10px;
}
.text-white{
    color: white!important;
}
.wrapper {
    text-align: center;
}
.footer p{
    font-size: 18px;
}
        </style>
        <link href="css/style.css" rel="stylesheet" id="style">
        <!-- Bootstrap core Library -->
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <!-- Google font -->
        <link href="https://fonts.googleapis.com/css?family=Dancing+Script" rel="stylesheet">
        <!-- Font Awesome-->
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
   <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>Gestion des étudiants</title>
    <style >
    	
.xyz{
 font-size:17px;
 font-family:Arial Black  ;
 color:white;

    }


    </style>
    
    
    </head>

<body>
<br> 

      <center>                    
     <form action="connServlet" method="POST">
     <div class="form-login">
      <a href="Connexion.jsp" class="btn btn-warning" >
          <span class="glyphicon glyphicon-log-out"></span> Déconnexion
        </a>
         
        	<br>
        	<p>
      
      </p> 
            <h1   class="text-danger"><center> Liste Etudiant </center> </h1>
            <br>
            <a href="ajouterEtudiant.jsp" class="btn btn-primary btn-xs pull-right"><span class="glyphicon glyphicon-plus-sign"></span> ajouter nouveau etudiant</a><br><br>

    <table class="table table-condensed table-bordered">
    <tr class='xyz'>
                <th scope="col">ID</th>
                <th scope="col">Nom</th>
                <th scope="col">Prenom</th>
                <th scope="col">Classe</th>
            </tr>
            <c:forEach items="${etudiants}" var="etudiant">
                <tr class='xyz'>
                    <td>${etudiant.id}</td>
                    <td>${etudiant.nom}</td>
                    <td>${etudiant.prenom}</td>
                    <td>${etudiant.classe}</td>
                    
                </tr>
            </c:forEach>
 </table>
 
           <td class="text-center"><a class='btn btn-info btn-xs' href="modifEtudiant.jsp"><span class="glyphicon glyphicon-pencil">
               </span> mise a jour</a>  &nbsp;&nbsp;&nbsp;
               <a href="suppEtudiant.jsp" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-trash">
                  </span> supprimer</a></td>
   </form>
   </center>
   
</div>
</body>
</html>