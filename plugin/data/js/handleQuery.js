// handleQuery.js - GooPIR's module that listens the sendQuery event

//Gets and sends query to add-on
function sendQuery() {
	$("#rso").empty();
    if ($("#q").val()) {
    	//$("#center_col").html("<img src='./img/loading.gif' alt='loading...'></img>");
    	self.port.emit("querySent", $("#q").val());
    }
}

// Set event listeners
$("#btnS").on("click", sendQuery);
$(document).on("keypress", function(event) {
	if (event.keyCode == 13) {
		event.preventDefault();		
		sendQuery();
	}
});

// When the response arrives is loaded on a new document
self.port.on("loadResponse", function(result) {
	// Load the results DOM	
	$("#ires ol").append(result);
    //$("#center_col").html($("#center_col", resListDOM).html());
});