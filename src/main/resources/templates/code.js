// Attach a submit handler to the form
$( "#login" ).submit(function( event ) {
 
  // Stop form from submitting normally
  event.preventDefault();
 
  // Get some values from elements on the page:
  var $form = $( this ),
    user = $form.find( "input[name='user']" ).val(),
	pass = $form.find("input[name='pass']").val();
 
  // Send the data using post
  var posting = $.post( "/join", { user: user, pass:pass } );
 
  // Put the results in a div
  posting.done(function( data ) {
	  console.log(data);
  });
});

$("#refreshMsgs").click(function(event){
	$.get("/get_msg").done(function(data){
		console.log(data);
	});
});

$("#refreshUsers").click(function(event){
	$.get("/list_users").done(function(data){
		console.log(data);
	});
});

$("#post").submit(function(event){
	 event.preventDefault();
	 var $form = $( this ),
	 message = $form.find( "input[name='message']" ).val(),
	addressee = $form.find("input[name='addressee']").val();
	$.post("/post_msg", {message: message, addressee: addressee} ).done(function(data){
		console.log(data);
	});
});