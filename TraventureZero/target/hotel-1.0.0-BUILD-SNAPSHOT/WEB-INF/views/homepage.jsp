<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Traventure-Stay Anywhere!</title>
	<meta name="description" content="Wiredwiki App">
	<!-- Latest compiled and minified CSS -->
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
</head>
<body>
<style>
	body{
		padding-top: 40px;
	}
</style>

	<body data-spy="scroll" data-target="#my-navbar">

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
  				<a href="" class="navbar-brand">TRAVENTURE</a>
  			</div>
  			<div class="collapse navbar-collapse" id="navbar-collapse">
          <a href="" class="btn btn-info navbar-btn navbar-right">LIKE TRAVENTURE!</a>
  				<ul class="nav navbar-nav">
  					<li><a href="#home">HOME</a> 
            <li><a href="#search">SEARCH</a>
  					<li><a href="#aboutus">ABOUT US</a> 
  					<li><a href="#faq">FAQ</a> 
  				</ul>
  			</div>
  		</div>
  	</nav>
<!-- jumbotron-->

  	<div class="jumbotron">
  		<div class="container text-center" style="height:200px; background-image: url('img2.jpg'); ">
  			<h1>TRAVENTURE</h1>
  			<p>Stay Anywhere</p>
  			<div class="btn-group">
  				<a href="" class="btn btn-lg btn-primary">Seasons Special Stay</a>
  				<a href="" class="btn btn-lg btn-default">Offers/Discounts</a>
  				<a href="" class="btn btn-lg btn-danger">Traventure Reloaded!!</a>
  			</div>
  		</div><!-- End container -->
  	</div><!-- End jumbotron-->
	
	<!--home-->
  <div  class="page-header" id="home">
  </div>

	<div class="container">
  		<section>
  			<div class="page-header">
          <h2>Home</h2>
  			</div>
  			<div class="row">
  						<p class="lead">Traventure is a travel metasearch engine focusing on personalized search for hotels. The site compares prices for over 730,700 hotels from more than 200 booking sites, such as Expedia, Booking.com, Hotels.com and Priceline.com. Based in Düsseldorf, Germany, the website receives about 45 million users per month on its 47 international platforms.</p>
  			</div><!-- End row -->
  		</section>
  </div><!--End Container-->
  
<!-- Displaying hotel details -->
  

<button onClick="loadHotelDetails()">Search</button>
<table id = "hotelDetails" >
</table>

  <!-- Search Feature -->
  <div class="page-header" id="search">
  </div>

  <table class="table table-striped">
    <tbody>


      <tr>
        <td>
          <center>
          <div class="jumbotron">
            <h2>Search your hotel!</h2>
            <form action="search" class="form-inline" method="get">
              <div class="form-group">
                <label for="placename">Place</label>
                <input type="text" class="form-control" id="placename" name="placename" placeholder="Hotel location">
              </div> &nbsp; &nbsp;
              <div class="form-group">
                <label for="username">UserName/UserID</label>
                <input type="text" class="form-control" id="username" name="username" placeholder="Enter your UserID">
              </div>
              <button type="submit" class="btn btn-info">Search</button>
            </form>
          </div>
          </center>
        </td>
      </tr>


      <tr>
        <td>
          <div class="container">
            <div class="row">
              <div class="col-xs-12 col-md-4">
                <center>
                  <div class="carousel slide" id="screenshot-carousel" data-ride="carousel">
                    <ol class="carousel-indicators">
                      <li data-target="#screenshot-carousel" data-slide-to="0" class="active"></li>
                      <li data-target="#screenshot-carousel" data-slide-to="1"></li>
                      <li data-target="#screenshot-carousel" data-slide-to="2"></li>
                      <li data-target="#screenshot-carousel" data-slide-to="3"></li>
                    </ol>
                    <div class="carousel-inner">
                      <div class="item active">
                        <img src="resources/img/luxury.png" alt="Text of the image">
                        <div class="carousel-caption">
                          <h3>Luxury Stay</h3>
                          <p>Experience your Dream</p>
                        </div>
                      </div>
                      <div class="item">
                        <img src="resources/img/river.png" alt="Text of the image">
                        <div class="carousel-caption">
                          <h3>River Side Holiday</h3>
                          <p>Natures blessing</p>
                        </div>
                      </div>
                      <div class="item">
                        <img src="resources/img/fun.jpg" alt="Text of the image">
                        <div class="carousel-caption">
                          <h3>Have some Fun!!</h3>
                          <p>Start Off HERE...</p>
                        </div>
                      </div>
                      <div class="item">
                        <img src="resources/img/eco.jpg" alt="Text of the image">
                        <div class="carousel-caption">
                          <h3>IN LOVE with ECO-WORLD?</h3>
                          <p>Nothing better than this..#</p>
                        </div>
                      </div>
          
                    </div><!-- End Carousel inner -->
                    
                    <a href="#screenshot-carousel" class="left carousel-control" data-slide="prev">
                      <span class="glyphicon glyphicon-chevron-left"></span>
                    </a>
                    <a href="#screenshot-carousel" class="right carousel-control" data-slide="next">
                      <span class="glyphicon glyphicon-chevron-right"></span>
                    </a>
                  </div><!-- End Carousel -->
                </center>
              </div>
              <div class="col-xs-12 col-md-8">
                <div class="col-xs-12 col-md-10">
                  <div class="row-md-2"> Name of the hotel:<b> Steve Bruce </b>
                  </div>
                  <div class="row-md-2"> Rating: <b> *****</b>
                  </div>
                  <div class="row-md-4"> Location details: <b>English football manager, currently for Hull City</b></div>
                  <div class="row-md-2"> Price: <b>Rs.5000/- </b></div>
                  <div class="row-md-2">
                     <div class="panel-group" id="description1" role="tablist" aria-multiselectable="true">
                       <div class="panel panel-default">
                         <div class="panel-heading" role="tab" id="desc1">
                           <h4 class="panel-title">
                             <a data-toggle="collapse" data-present="#description1" href="#info1" aria-expanded="true" aria-controls="info1                    ">More details / Description</a>
                           </h4>
                         </div>
                         <div id="info1" class="panel-collapse collapse" role="tabpanel" aria-labelledby="desc1">
                           <div class="panel-body">
                             He began his professional career at Gillingham in 1979, and made over 200 appearances before transferring to                     Norwich City five years later. From 1987 to 1996, he played for Manchester United, winning the Premier                     League, FA Cup, Football League Cup and European Cup Winner's Cup. He was the first English player of the                    twentieth century to captain a team to the Double. 
                           </div>
                         </div>
                       </div>
                     </div>
                  </div>
                </div>
                <div class="col-xs-12 col-md-2">
                  <center>
                    <a class="btn btn-primary btn-lg" href="#" role="button">LIKE</a>
                  </center>
                </div>
              </div>
            </div>
          </div>
        </td>
      </tr>



      <tr>
        <td>
          <div class="container">
            <div class="row">
              <div class="col-xs-12 col-md-4">
                <center>
                  <div class="carousel slide" id="screenshot-carouse2" data-ride="carousel">
                    <ol class="carousel-indicators">
                      <li data-target="#screenshot-carouse2" data-slide-to="0" class="active"></li>
                      <li data-target="#screenshot-carouse2" data-slide-to="1"></li>
                      <li data-target="#screenshot-carouse2" data-slide-to="2"></li>
                      <li data-target="#screenshot-carouse2" data-slide-to="3"></li>
                    </ol>
                    <div class="carousel-inner">
                      <div class="item active">
                        <img src="resources/img/luxury.png" alt="Text of the image">
                        <div class="carousel-caption">
                          <h3>Luxury Stay</h3>
                          <p>Experience your Dream</p>
                        </div>
                      </div>
                      <div class="item">
                        <img src="resources/img/river.png" alt="Text of the image">
                        <div class="carousel-caption">
                          <h3>River Side Holiday</h3>
                          <p>Natures blessing</p>
                        </div>
                      </div>
                      <div class="item">
                        <img src="resources/img/fun.jpg" alt="Text of the image">
                        <div class="carousel-caption">
                          <h3>Have some Fun!!</h3>
                          <p>Start Off HERE...</p>
                        </div>
                      </div>
                      <div class="item">
                        <img src="resources/img/eco.jpg" alt="Text of the image">
                        <div class="carousel-caption">
                          <h3>IN LOVE with ECO-WORLD?</h3>
                          <p>Nothing better than this..#</p>
                        </div>
                      </div>
          
                    </div><!-- End Carousel inner -->
                    
                    <a href="#screenshot-carouse2" class="left carousel-control" data-slide="prev">
                      <span class="glyphicon glyphicon-chevron-left"></span>
                    </a>
                    <a href="#screenshot-carouse2" class="right carousel-control" data-slide="next">
                      <span class="glyphicon glyphicon-chevron-right"></span>
                    </a>
                  </div><!-- End Carousel -->
                </center>
              </div>
              <div class="col-xs-12 col-md-8">
                <div class="col-xs-12 col-md-10">
                  <div class="row-md-2"> Name of the hotel:<b> Steve Bruce </b>
                  </div>
                  <div class="row-md-2"> Rating: <b> *****</b>
                  </div>
                  <div class="row-md-4"> Location details: <b>English football manager, currently for Hull City</b></div>
                  <div class="row-md-2"> Price: <b>Rs.5000/- </b></div>
                  <div class="row-md-2">
                     <div class="panel-group" id="description2" role="tablist" aria-multiselectable="true">
                       <div class="panel panel-default">
                         <div class="panel-heading" role="tab" id="desc2">
                           <h4 class="panel-title">
                             <a data-toggle="collapse" data-present="#description2" href="#info2" aria-expanded="true" aria-controls="info2">More details / Description</a>
                           </h4>
                         </div>
                         <div id="info2" class="panel-collapse collapse" role="tabpanel" aria-labelledby="desc2">
                           <div class="panel-body">
                             He began his professional career at Gillingham in 1979, and made over 200 appearances before transferring to                     Norwich City five years later. From 1987 to 1996, he played for Manchester United, winning the Premier                     League, FA Cup, Football League Cup and European Cup Winner's Cup. He was the first English player of the                    twentieth century to captain a team to the Double. 
                           </div>
                         </div>
                       </div>
                     </div>
                  </div>
                </div>
                <div class="col-xs-12 col-md-2">
                  <center><a class="btn btn-primary btn-lg" href="#" role="button">LIKE</a></center>
                </div>
              </div>
            </div>
          </div>
        </td>
      </tr>

      <tr>
        <td>
          <div class="container">
            <div class="row">
              <div class="col-xs-12 col-md-4">
                <center>
                  <div class="carousel slide" id="screenshot-carouse3" data-ride="carousel">
                    <ol class="carousel-indicators">
                      <li data-target="#screenshot-carouse3" data-slide-to="0" class="active"></li>
                      <li data-target="#screenshot-carouse3" data-slide-to="1"></li>
                      <li data-target="#screenshot-carouse3" data-slide-to="2"></li>
                      <li data-target="#screenshot-carouse3" data-slide-to="3"></li>
                    </ol>
                    <div class="carousel-inner">
                      <div class="item active">
                        <img src="resources/img/luxury.png" alt="Text of the image">
                        <div class="carousel-caption">
                          <h3>Luxury Stay</h3>
                          <p>Experience your Dream</p>
                        </div>
                      </div>
                      <div class="item">
                        <img src="resources/img/river.png" alt="Text of the image">
                        <div class="carousel-caption">
                          <h3>River Side Holiday</h3>
                          <p>Natures blessing</p>
                        </div>
                      </div>
                      <div class="item">
                        <img src="resources/img/fun.jpg" alt="Text of the image">
                        <div class="carousel-caption">
                          <h3>Have some Fun!!</h3>
                          <p>Start Off HERE...</p>
                        </div>
                      </div>
                      <div class="item">
                        <img src="resources/img/eco.jpg" alt="Text of the image">
                        <div class="carousel-caption">
                          <h3>IN LOVE with ECO-WORLD?</h3>
                          <p>Nothing better than this..#</p>
                        </div>
                      </div>
                    </div><!-- End Carousel inner -->
                    
                    <a href="#screenshot-carouse3" class="left carousel-control" data-slide="prev">
                      <span class="glyphicon glyphicon-chevron-left"></span>
                    </a>
                    <a href="#screenshot-carouse3" class="right carousel-control" data-slide="next">
                      <span class="glyphicon glyphicon-chevron-right"></span>
                    </a>
                  </div><!-- End Carousel -->
                </center>
              </div>
              <div class="col-xs-12 col-md-8">
                <div class="col-xs-12 col-md-10">
                  <div class="row-md-2"> Name of the hotel:<b> Steve Bruce </b>
                  </div>
                  <div class="row-md-2"> Rating: <b> *****</b>
                  </div>
                  <div class="row-md-4"> Location details: <b>English football manager, currently for Hull City</b></div>
                  <div class="row-md-2"> Price: <b>Rs.5000/- </b></div>
                  <div class="row-md-2">
                     <div class="panel-group" id="description3" role="tablist" aria-multiselectable="true">
                       <div class="panel panel-default">
                         <div class="panel-heading" role="tab" id="desc3">
                           <h4 class="panel-title">
                             <a data-toggle="collapse" data-present="#description3" href="#info3" aria-expanded="true" aria-controls="info3">More details / Description</a>
                           </h4>
                         </div>
                         <div id="info3" class="panel-collapse collapse" role="tabpanel" aria-labelledby="desc3">
                           <div class="panel-body">
                             He began his professional career at Gillingham in 1979, and made over 200 appearances before transferring to                     Norwich City five years later. From 1987 to 1996, he played for Manchester United, winning the Premier                     League, FA Cup, Football League Cup and European Cup Winner's Cup. He was the first English player of the                    twentieth century to captain a team to the Double. 
                           </div>
                         </div>
                       </div>
                     </div>
                  </div>
                </div>
                <div class="col-xs-12 col-md-2">
                  <center><a class="btn btn-primary btn-lg" href="#" role="button">LIKE</a></center>
                </div>
              </div>
            </div>
          </div>
        </td>
      </tr>

    </tbody>
  </table>
  
	<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
  
</body>
</html>