<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Traventure-Stay Anywhere!</title>
	<meta name="description" content="Traventure">
	<!-- Latest compiled and minified CSS -->
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
	<!-- jQuery -->
	<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<!-- <script src="resources/js/jquery-2.2.2.min.js"></script> -->
	<script src="resources/js/hoteldetails.js"></script>
		<!-- add json2html; both the core library and the jquery wrapper -->
	<script type="text/javascript" src="resources/js/json2html.js"></script>
	<script type="text/javascript" src="resources/js/jquery.json2html.js"></script>
	<!-- Common Style CSS -->
	<link rel="stylesheet" type="text/css" href="resources/css/commonStyle.css">
</head>

<body data-spy="scroll" data-target="#my-navbar">
<div id="wrapper">
<div id="header">

<!-- navbar -->
	<nav class="navbar navbar-inverse navbar-fixed-top" id="my-navbar">
  		<div class="container-fluid" style="background-image: url('resources/img/img3.jpg');">
  			<div class="navbar-header">
  				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse">
  					<span class="icon-bar"></span>
  					<span class="icon-bar"></span>
  					<span class="icon-bar"></span>
  					<span class="icon-bar"></span>
  				</button>
  				<a href="home" class="navbar-brand">TRAVENTURE</a>
  			</div>
  			<div class="collapse navbar-collapse" id="navbar-collapse">
  			<a href="signup" class="btn btn-success navbar-btn navbar-right full">Sign up</a>
  			<a href="signin" class="btn btn-default navbar-btn navbar-right full">Sign in</a>
          	<a href="" class="btn btn-info navbar-btn navbar-right full">LIKE TRAVENTURE!</a>
          
  				<ul class="nav navbar-nav">
  					<li><a href="aboutus">ABOUT US</a> </li>
  					<li><a href="FAQs">FAQ's</a> </li>
  				</ul>
  			</div>
  		</div>
  	</nav>
  </div>	
  	<!--About Us-->
  <div  class="page-header" id="aboutus">
 	<h2>Frequently Asked Questions</h2>
  </div>
<div id="content">
	<div class="row">
		<div class="col-xs-12 col-md-8">
	<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
	  <div class="panel panel-default">
	    <div class="panel-heading" role="tab" id="headingOne">
	      <h4 class="panel-title">
	      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
	        <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
	           What is Traventure?
	        </a>
	      </h4>
	    </div>
	    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
			<div class="panel-body">
			    Traventure is a personalized hotel recommendation web application developed by a team of 4 as a project in Dayananda Sagar University.<br>
				It takes the user rating for the hotels they like and suggests them similar hotels in the location they search for.<br>
			</div>
	    </div>
	  </div>
	  <div class="panel panel-default">
	    <div class="panel-heading" role="tab" id="headingTwo">
	      <h4 class="panel-title">
	      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
	        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
	          Collapsible Group Item #2
	        </a>
	      </h4>
	    </div>
	    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
	      <div class="panel-body">
	        Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla.
	      </div>
	    </div>
	  </div>
	  <div class="panel panel-default">
	    <div class="panel-heading" role="tab" id="headingThree">
	      <h4 class="panel-title">
	      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
	        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
	          Collapsible Group Item #3
	        </a>
	      </h4>
	    </div>
	    <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
	      <div class="panel-body">
	       Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla.
	      </div>
	    </div>
	  </div>
	</div>
 </div>
</div>
</div>
  <div id="footer">
	<footer align="center">
		<center><p>Copyright &copy 2016 &middot; Traventure &middot; <a href="privacy">Privacy</a> &middot; <a href="terms">Terms</a></p></center>
	</footer>
  </div>
  	
</div>
</body>
</html>