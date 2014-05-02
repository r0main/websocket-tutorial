var request = {
    url :  'http://localhost:8081/websocket-tutorial/notifications/tweets',
    contentType : 'application/json;charset=UTF-8',
    dropAtmosphereHeaders : true,
    timeout: 120000,
    logLevel : 'debug',
    transport : 'websocket', // the first protocol to use
    fallbackTransport : 'long-polling', // if transport can't be use this one will be used instead
    keepalive : 'on'
};

request.onOpen = function(response) {
    console.log('Connected to atmosphere'+response)
};

/**
* @param response : strlen|responsebody
*/
request.onMessage = function(response) {
  var jsonResponse = response.responseBody.split('|')[1];
  var messageWrapper = JSON.parse(jsonResponse);
  $("#tweets").append("<div>" + messageWrapper.message + "</div>");
};

request.onClose = function(response) {
  console.log('onClose');
};

request.onError = function(response) {
  console.log('onError' + response);
};

request.onTransportFailure = function(errorMsg, AtmosphereRequest){
  console.log('onTransportFailure');
};

request.onReconnect = function(AtmosphereRequest, response){
  console.log('onReconnect');
};

socket = $.atmosphere;
socket.subscribe(request);

// code to submit the message en input enter
$(document).keypress(function(e) {
    if(e.which == 13) {
        var inputTweet = $("#input-tweet").val();
        $.post( "http://localhost:8081/websocket-tutorial/tweetpublisher", { message: inputTweet });
        $("#input-tweet").val("");
    }
});