/**
 * 
 */


function doAjaxPost() {
	
    // get the form values

	//console.log("Hello world, I'm in doAjaxPost function!!");
	//console.log("Hotel Search clicked");
	//alert("I'm in doAjaxPost function!!");
    var placename = $('#placename').val();
    var username = $('#username').val();
    
    $.ajax({
        type: "GET",
        url: "search.htm",
        data : "placename=" + placename + "&username=" + username,
        success: function(response){
        	console.log(response);  
            // we have the response
            if(response.status == "SUCCESS"){
            	console.log("Response Objects\n"+response.result);
                displayHotelDetails(response.result,response.length);
                console.log("Hotels has been added to the list successfully. ");
                scrollDownToSearchBox();
             }
            else if(response.status == "FAIL"){
            	$('#info').html("Sorry, No Hotels Found, try another location");
            	console.log("Sorry, No Hotels Found, try another location ");
            	$('#hoteldetails > #hotellist ').html("");
            	$("#go_up").hide();
            	scrollDownToSearchBox();
            }
         },
         error: function(e){
             alert("Please start mongod server!!" + '\n Error: ' + e );
         }
    });
}

	//Function to display the response object
	function displayHotelDetails(response,length){
		
		//set the field to empty
	    $('#hoteldetails > #hotellist ').html("");
	    	$('#info').html("Found " + length + " Hotels for you!");
	    //Transform all the hotel details returned by response object to html by using json2html template
	    var transformHotels =   {"tag":"tr","children":[
	                              {"tag":"td","children":[
	                                  {"tag":"div","class":"container","children":[
	                                      {"tag":"div","class":"row","children":[
	                                          {"tag":"div","class":"col-xs-12 col-md-4","children":[
	                                              {"tag":"center","children":[
	                                                  {"tag":"div","class":"carousel slide","id":"screenshot-carouse${id}","data-ride":"carousel","children":[
	                                                      {"tag":"ol","class":"carousel-indicators","children":[
	                                                          {"tag":"li","data-target":"#screenshot-carouse${id}","data-slide-to":"0","class":"active","html":""},
	                                                          {"tag":"li","data-target":"#screenshot-carouse${id}","data-slide-to":"1","html":""},
	                                                          {"tag":"li","data-target":"#screenshot-carouse${id}","data-slide-to":"2","html":""},
	                                                          {"tag":"li","data-target":"#screenshot-carouse${id}","data-slide-to":"3","html":""}
	                                                        ]},
	                                                      {"tag":"div","class":"carousel-inner","children":[
	                                                          {"tag":"div","class":"item active","children":[
	                                                              {"tag":"img","src":"/hotel/resources/img/luxury.png","alt":"Text of the image","html":""},
	                                                              {"tag":"div","class":"carousel-caption","children":[
	                                                                  {"tag":"h3","html":"Luxury Stay"},
	                                                                  {"tag":"p","html":"Experience your Dream"}
	                                                                ]}
	                                                            ]},
	                                                          {"tag":"div","class":"item","children":[
	                                                              {"tag":"img","src":"/hotel/resources/img/river.png","alt":"Text of the image","html":""},
	                                                              {"tag":"div","class":"carousel-caption","children":[
	                                                                  {"tag":"h3","html":"River Side Holiday"},
	                                                                  {"tag":"p","html":"Natures blessing"}
	                                                                ]}
	                                                            ]},
	                                                          {"tag":"div","class":"item","children":[
	                                                              {"tag":"img","src":"/hotel/resources/img/fun.jpg","alt":"Text of the image","html":""},
	                                                              {"tag":"div","class":"carousel-caption","children":[
	                                                                  {"tag":"h3","html":"Have some Fun!!"},
	                                                                  {"tag":"p","html":"Start Off HERE..."}
	                                                                ]}
	                                                            ]},
	                                                          {"tag":"div","class":"item","children":[
	                                                              {"tag":"img","src":"/hotel/resources/img/eco.jpg","alt":"Text of the image","html":""},
	                                                              {"tag":"div","class":"carousel-caption","children":[
	                                                                  {"tag":"h3","html":"IN LOVE with ECO-WORLD?"},
	                                                                  {"tag":"p","html":"Nothing better than this..#"}
	                                                                ]}
	                                                            ]}
	                                                        ]},
	                                                      {"tag":"a","href":"#screenshot-carouse${id}","class":"left carousel-control","data-slide":"prev","children":[
	                                                          {"tag":"span","class":"glyphicon glyphicon-chevron-left","html":""}
	                                                        ]},
	                                                      {"tag":"a","href":"#screenshot-carouse${id}","class":"right carousel-control","data-slide":"next","children":[
	                                                          {"tag":"span","class":"glyphicon glyphicon-chevron-right","html":""}
	                                                        ]}
	                                                    ]}
	                                                ]}
	                                            ]},
	                                          {"tag":"div","class":"col-xs-12 col-md-8","children":[
	                                              {"tag":"div","class":"col-xs-12 col-md-10","children":[
	                                                  {"tag":"div","class":"row-md-2","children":[
	                                                      /*{"tag":"b","html":" ${hotel_name} "}*/
	                                                       {"tag":"a","href":"hotelDesc.htm","style":"text-decoration:none; font-weight: bold; font-size: 18;","html":"${hotel_name}"}
	                                                    ]},
	                                                  {"tag":"div","class":"row-md-4","children":[
	                                                      {"tag":"b","html":"${hotel_location}"}
	                                                    ]},
	                                                  {"tag":"div","class":"row-md-4","id":"rating${id}","children":[
	                                                      {"tag":"b","html":"${hotel_rating}"}
	                                                    ]},
	                                                  {"tag":"div","class":"row-md-2","children":[
	                                                      {"tag":"div","class":"panel-group","id":"description${id}","role":"tablist","aria-multiselectable":"true","children":[
	                                                          {"tag":"div","class":"panel panel-default","children":[
	                                                              {"tag":"div","class":"panel-heading","role":"tab","id":"desc${id}","children":[
	                                                                  {"tag":"h4","class":"panel-title","children":[
	                                                                      {"tag":"span","class":"glyphicon glyphicon-align-left","aria-hidden":"true","html":""},
	                                                                      {"tag":"a","data-toggle":"collapse","data-present":"#description${id}","href":"#info${id}","aria-expanded":"true","aria-controls":"info${id}","html":" More details / Description"}
	                                                                    ]}
	                                                                ]},
	                                                              {"tag":"div","id":"info${id}","class":"panel-collapse collapse","role":"tabpanel","aria-labelledby":"desc${id}","children":[
	                                                                  {"tag":"div","class":"panel-body","html":"${hotel_description}"}
	                                                                ]}
	                                                            ]}
	                                                        ]}
	                                                    ]}
	                                                ]},
	                                              {"tag":"div","class":"col-xs-12 col-md-2","children":[
	                                                  {"tag":"center","children":[
	                                                      {"tag":"a","class":"btn btn-primary btn-lg","href":"#","role":"button","html":"LIKE"}
	                                                    ]}
	                                                ]}
	                                            ]}
	                                        ]}
	                                    ]}
	                                ]}
	                            ]}
	
	   		 $('#hoteldetails > #hotellist ').json2html(response, transformHotels);
             console.log("You are here");
	         $("#go_up").show();
	         
	         //Ratings to be displayed
	         /*Display ratings average using stars*/
	      	  var len = response.length;
	         //console.log("Length of objects Array: " +len);
	      	  for(i=0;i<len;i++){
	      		  var ratings = response[i].hotel_rating;
	      		  //console.log("Ratings: " +ratings);
	      		  var id = "#rating"+response[i].id;
	      		  //console.log("Ratings id: "+ id);
	      		  $(id).rateYo({
	      			    rating: ratings,
	      			    starWidth: "20px",
	      			    multiColor: {
	
	      		            startColor: "#c0392b",
	      		            endColor  : "#f1c40f"
	      		          },
	      		          
	      			    readOnly: true
	      			    
	      			  });
	    	  };
	}


	function scrollDownToSearchBox(){
			(function($) {
			    $(document).ready(function() {
			         $('html, body').animate({
			           'scrollTop':$('#search').offset().top
			         }, 500);
			    });
			    //$("#go_up").show();
			})(jQuery);
	}
	
	$(window).bind("mousewheel", function() {
	    $("html, body").stop(true, false);
	});
	
	function scrollDownToHome(){
		console.log("Hello");
		(function($) {
		    $(document).ready(function() {
			  $('html, body').animate({
			    'scrollTop':$('#home').offset().top
			     }, 500);
			   console.log("Hello");
			});
		})(jQuery);
	}
	
	
	(function($) {
	    $(document).ready(function() {
	    	 $("#go_up").hide();
	    });
	})(jQuery);



