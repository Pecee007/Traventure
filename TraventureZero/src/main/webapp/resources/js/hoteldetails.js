/**
 * 
 */


function doAjaxPost() {
    // get the form values
/*    var name = $('#name').val();
    var education = $('#education').val();
*/
	console.log("Hello world, I'm in doAjaxPost function!!");
	console.log("Hotel Search clicked");
	alert("I'm in doAjaxPost function!!");
    var placename = $('#pname').val();
    var username = $('#uname').val();
    
    $.ajax({
        type: "POST",
        url: "search",
        data : "placename=" + placename + "&username=" + username,
        success: function(response){
        	console.log(response);  
            // we have the response
            if(response.status == "SUCCESS"){
                hotelDetails = "<ol>";
                for(i =0 ; i < response.result.length ; i++){
                	hotelDetails += "<br><li><b>Hotel Name</b> : " + response.result[i].hotel_name +
                    ";<b> Hotel Description</b> : " + response.result[i].hotel_description+
                    ";<b> Hotel Location</b> : " + response.result[i].hotel_location+
                    ";<b> Hotel ID</b> : " + response.result[i].id
                 }
                hotelDetails += "</ol>";
                 $('#info').html("Hotels has been added to the list successfully. " + hotelDetails);
                 $('#pname').val('');
                 $('#uname').val('');
                 $('#error').hide('slow');
                 $('#info').show('slow');
                 
                 
                 //display with format
                 
/*                 for(i =0 ; i < response.result.length ; i++){
                	 newHotelDetails="<tr><td><div class=/"container/"><div class=/"row/">";
                	 for(i =0 ; i < response.result.length ; i++){
                		 newHotelDetails += "";
                	 }
                	 newHotelDetails+="</td></tr></div></div>";
                 }
                 */
                 
                 
                 
                 
/*                 
                 <li>
	                 <b>Name:</b>
	                  ${hotel_name}
	                 <b> Description:</b>
	                 ${hotel_description}
	                 <b> Hotel Location</b>
	                 ${hotel_location};
	                 <b> Hotel ID:</b>
	                  ${id};
	                 <br>
                 </li>
                 
                 */
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 var transform;
                 
                 for(i =0 ; i < response.result.length ; i++){
                	 transform += {"tag":"tr","children":[
                                         {"tag":"td","children":[
                                             {"tag":"div","class":"container","children":[
                                                 {"tag":"div","class":"row","children":[
                                                     {"tag":"div","class":"col-xs-12 col-md-4","children":[
                                                         {"tag":"center","children":[
                                                             {"tag":"div","class":"carousel slide","id":"screenshot-carouse${response.result[i].id}","data-ride":"carousel","children":[
                                                                 {"tag":"ol","class":"carousel-indicators","children":[
                                                                     {"tag":"li","data-target":"#screenshot-carouse${response.result[i].id}","data-slide-to":"0","class":"active","html":""},
                                                                     {"tag":"li","data-target":"#screenshot-carouse${response.result[i].id}","data-slide-to":"1","html":""},
                                                                     {"tag":"li","data-target":"#screenshot-carouse${response.result[i].id}","data-slide-to":"2","html":""},
                                                                     {"tag":"li","data-target":"#screenshot-carouse${response.result[i].id}","data-slide-to":"3","html":""}
                                                                   ]},
                                                                 {"tag":"div","class":"carousel-inner","children":[
                                                                     {"tag":"div","class":"item active","children":[
                                                                         {"tag":"img","src":"resources/img/luxury.png","alt":"Text of the image","html":""},
                                                                         {"tag":"div","class":"carousel-caption","children":[
                                                                             {"tag":"h3","html":"Luxury Stay"},
                                                                             {"tag":"p","html":"Experience your Dream"}
                                                                           ]}
                                                                       ]},
                                                                     {"tag":"div","class":"item","children":[
                                                                         {"tag":"img","src":"resources/img/river.png","alt":"Text of the image","html":""},
                                                                         {"tag":"div","class":"carousel-caption","children":[
                                                                             {"tag":"h3","html":"River Side Holiday"},
                                                                             {"tag":"p","html":"Natures blessing"}
                                                                           ]}
                                                                       ]},
                                                                     {"tag":"div","class":"item","children":[
                                                                         {"tag":"img","src":"resources/img/fun.jpg","alt":"Text of the image","html":""},
                                                                         {"tag":"div","class":"carousel-caption","children":[
                                                                             {"tag":"h3","html":"Have some Fun!!"},
                                                                             {"tag":"p","html":"Start Off HERE..."}
                                                                           ]}
                                                                       ]},
                                                                     {"tag":"div","class":"item","children":[
                                                                         {"tag":"img","src":"resources/img/eco.jpg","alt":"Text of the image","html":""},
                                                                         {"tag":"div","class":"carousel-caption","children":[
                                                                             {"tag":"h3","html":"IN LOVE with ECO-WORLD?"},
                                                                             {"tag":"p","html":"Nothing better than this..#"}
                                                                           ]}
                                                                       ]}
                                                                   ]},
                                                                 {"tag":"a","href":"#screenshot-carouse${response.result[i].id}","class":"left carousel-control","data-slide":"prev","children":[
                                                                     {"tag":"span","class":"glyphicon glyphicon-chevron-left","html":""}
                                                                   ]},
                                                                 {"tag":"a","href":"#screenshot-carouse${response.result[i].id}","class":"right carousel-control","data-slide":"next","children":[
                                                                     {"tag":"span","class":"glyphicon glyphicon-chevron-right","html":""}
                                                                   ]}
                                                               ]}
                                                           ]}
                                                       ]},
                                                     {"tag":"div","class":"col-xs-12 col-md-8","children":[
                                                         {"tag":"div","class":"col-xs-12 col-md-10","children":[
                                                             {"tag":"div","class":"row-md-2","children":[
                                                                 {"tag":"b","html":" ${response.result[i].hotel_name} "}
                                                               ]},
                                                             {"tag":"div","class":"row-md-4","children":[
                                                                 {"tag":"b","html":"${response.result[i].hotel_location}"}
                                                               ]},
                                                             {"tag":"div","class":"row-md-2","children":[
                                                                 {"tag":"div","class":"panel-group","id":"description${response.result[i].id}","role":"tablist","aria-multiselectable":"true","children":[
                                                                     {"tag":"div","class":"panel panel-default","children":[
                                                                         {"tag":"div","class":"panel-heading","role":"tab","id":"desc${response.result[i].id}","children":[
                                                                             {"tag":"h4","class":"panel-title","children":[
                                                                                 {"tag":"a","data-toggle":"collapse","data-present":"#description${response.result[i].id}","href":"#info${response.result[i].id}","aria-expanded":"true","aria-controls":"info1                    ","html":"More details / Description"}
                                                                               ]}
                                                                           ]},
                                                                         {"tag":"div","id":"info${response.result[i].id}","class":"panel-collapse collapse","role":"tabpanel","aria-labelledby":"desc${response.result[i].id}","children":[
                                                                             {"tag":"div","class":"panel-body","html":"${response.result[i].hotel_description}"}
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
                                       ]};
                 
                 }
                 
                 
                 console.log(transform);
                 $('#hotelslist').json2html(response, transform);
                 
             }else{
                 errorInfo = "";
                 for(i =0 ; i < response.result.length ; i++){
                     errorInfo += "<br>" + (i + 1) +". " + response.result[i].code;
                 }
                 $('#error').html("Please correct following errors: " + errorInfo);
                 $('#info').hide('slow');
                 $('#error').show('slow');
             }
         },
         error: function(e){
             alert('Error: ' + e);
         }
    });
}