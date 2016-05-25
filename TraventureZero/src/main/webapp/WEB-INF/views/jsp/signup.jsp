<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
	<!-- Latest compiled and minified JavaScript -->
	<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<!-- jQuery -->
	<!-- <script src="resources/js/jquery-2.2.2.min.js"></script> -->
	<script src="resources/js/hoteldetails.js"></script>
		<!-- add json2html; both the core library and the jquery wrapper -->
	<script type="text/javascript" src="resources/js/json2html.js"></script>
	<script type="text/javascript" src="resources/js/jquery.json2html.js"></script>
	<!-- Common Style CSS -->
	<link rel="stylesheet" type="text/css" href="resources/css/commonStyle.css">
	<link rel="stylesheet" type="text/css" href="resources/css/signup.css">
	<!-- javascript -->
	<script src="resources/js/signup.js"></script>
		<!-- jQuery -->
		<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
	onerror = handleErr;
	var txt = "";
	function handleErr(msg,url,l){
		txt = "There was an erron on this page.\n\n";
		txt += "Error: "+msg+"\n";
		txt += "URL: "+ url + "\n";
		txt += "Line: " + l + "\n\n";
		txt += "Click OK to Continue.\n\n";
		alert(txt);
		return true;
	}
	function validateSignup(status){
		//alert("Sign up again"+status);
		if(status == "Fail"){
			var s = "Fail";
			document.getElementById("message").innerHTML="Displayname already exists";
			alert("Sign up again"+status);
		}
		return true;
		}
    function validate()
    {
    	var pwd = document.getElementById("password").value;
    	var cpwd = document.getElementById("password_confirmation").value;
    	if(pwd!=null && cpwd!=null)
    		if(pwd == cpwd){
	    		document.getElementById("message").innerHTML="";
	    		//alert("Successfully Signed up!");
	    		return true;
    		}
    		else
    		{
    			document.getElementById("message").innerHTML="Passwords do not match";
    			return false;
    		}
    	return false;
    }
</script>
</head>
<%-- 			<% 
				String status = null;
				if(){
					status = (String) session.getAttribute("status"); 

					if(status.equals("success")){
						out.println("Feedback Successfully submitted! Thank you for the feedback.");
					}
					else if(status.equals("fail")){
						out.println("Feedback could not be submitted! Please try again.");
					}
				}
			%> --%>

<body data-spy="scroll" data-target="#my-navbar" onLoad="validateSignup(${status})">
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
  					<li><a href="home" onClick="scrollDownToHome();">HOME</a> </li>
            		<li><a href="#search" onClick="scrollDownToSearchBox();">SEARCH</a> </li>
  					<li><a href="aboutus">ABOUT US</a> </li>
  					<li><a href="FAQs">FAQ's</a> </li>
  				</ul>
  			</div>
  		</div>
  	</nav>
</div>
<div id="content">
<div class="container">

<div class="row">
    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
		<form:form role="form" method="post" action="user/signup" modelAttribute="user" onSubmit="return validate();">
			<h2>Please Sign Up <small>It's free and always will be.</small></h2>
			<h3 id = "message" style="color:red;">${status}</h3>
			<hr class="colorgraph">
			<div class="row">
				<div class="col-xs-12 col-sm-6 col-md-6">
					<div class="form-group">
                        <form:input path="firstName"  type="text" name="first_name" id="first_name" class="form-control input-lg" placeholder="First Name" tabindex="1"/>
					</div>
				</div>
				<div class="col-xs-12 col-sm-6 col-md-6">
					<div class="form-group">
						<form:input path="lastName" type="text" name="last_name" id="last_name" class="form-control input-lg" placeholder="Last Name" tabindex="2"/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<form:input path="displayName" type="text" name="display_name" id="display_name" class="form-control input-lg" placeholder="Display Name" tabindex="3"/>
			</div>
			<div class="form-group">
				<form:input path="email" type="email" name="email" id="email" class="form-control input-lg" placeholder="Email Address" tabindex="4"/>
			</div>
			<div class="row">
				<div class="col-xs-12 col-sm-6 col-md-6">
					<div class="form-group">
						<form:input path="password" type="password" name="password" id="password" class="form-control input-lg" placeholder="Password" tabindex="5"/>
					</div>
				</div>
				<div class="col-xs-12 col-sm-6 col-md-6">
					<div class="form-group">
						<input type="password" name="password_confirmation" id="password_confirmation" class="form-control input-lg" placeholder="Confirm Password" tabindex="6">
					</div>
				</div>
			</div>
			<div class="row">
<!-- 				<div class="col-xs-4 col-sm-3 col-md-3">
					<span class="button-checkbox">
						<button type="button" class="btn" data-color="info" tabindex="7">I Agree</button>
                        <input type="checkbox" name="t_and_c" id="t_and_c" class="hidden" value="1">
					</span>
				</div> -->
				<div class="col-xs-8 col-sm-9 col-md-9">
					 By clicking <strong class="label label-primary">Register</strong>, you agree to the <a href="#" data-toggle="modal" data-target="#t_and_c_m">Terms and Conditions</a> set out by this site, including our Cookie Use.
				</div>
			</div>
			
			<hr class="colorgraph">
			<div class="row">
				<div class="col-xs-12 col-md-6"><input type="submit" value="Register" class="btn btn-primary btn-block btn-lg" tabindex="7"></div>
				<div class="col-xs-12 col-md-6"><a href="signin" class="btn btn-success btn-block btn-lg">Sign In</a></div>
			</div>
		</form:form>
		
	</div>
</div>
<!-- Modal -->
<div class="modal fade" id="t_and_c_m" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">Terms & Conditions</h4>
			</div>
			<div class="modal-body">
			<p style="font-family:Arial;font-size:15px; color:#CC6600">USE OF THE WEBSITE</p>
			<p>As a condition of your use of this Website, you warrant that</p>
				<ol><li>you are at least 18 years of age and are of sound mind,</li>
	                <li>you possess the legal authority to create a binding legal obligation,</li>
	                <li>you will use this Website in accordance with the Terms of Use,</li>
	                <li>you will only use this Website to make legitimate reservations for you or for another person for whom you are legally authorized to act,</li>
	                <li>you will inform such other persons about the Terms of Use that apply to the reservations you have made on their behalf, including all rules and restrictions applicable thereto,</li>
	                <li>all information supplied by you on this Website is true, accurate, current and complete, and</li>
	                <li>if you have an online account with this Website, you will safeguard your account information and will supervise and be completely responsible for any use of your account by you and anyone other than you.</li>
	              </ol>
<!-- 				<p>As a condition of your use of this Website, you warrant that: </p>
				<p>you are at least 18 years of age and are of sound mind,</p>
				<p></p>
				<p></p>
				<p></p>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
			 --></div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" data-dismiss="modal">I Agree</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->
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