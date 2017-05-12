/**
 * Created by bakla410 on 03.05.17.
 */
var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/messenger-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/user/queue/login/', function (response) {
             $('.alert-success').html(JSON.parse(response.body)["content"]);
            if (JSON.parse(response.body)["content"] == "OK") {

                $(".container").html("NEW PAGE");
                // $.ajax({
                //     url: '/chat/',
                //     success: function(){
                //         alert('Load was performed.');
                //     }
                // });
            }
        });
    });
}

// function disconnect() {
//     if (stompClient != null) {
//         stompClient.disconnect();
//     }
//     setConnected(false);
//     console.log("Disconnected");
// }
//
// function sendName(chatName) {
//     stompClient.send("/app/validateLogin/" + chatName, {}, JSON.stringify({'name': $("#name").val(), 'chatName': chatName}));
// }

function validateInput () {
    stompClient.send("/app/validateLogin/",
        {},
        JSON.stringify({'username': $("#inputUsername").val(),
            'password': $("#inputPassword").val()}));
}

// function showResponse(message) {
//     $("#greetings").append("<tr><td>" + message + "</td></tr>");
// }
//
// $(function () {
//     $("form").on('submit', function (e) {
//         e.preventDefault();
//     });
//     $( "#connect" ).click(function() { connect(); });
//     $( "#disconnect" ).click(function() { disconnect(); });
//     $( "#send" ).click(function() { sendName(chatName); });
// });

// $( document ).ready(function() {
//
//     connect();
//     $("form").on('submit', function (e) {
//          e.preventDefault();
//      });
//     $( "#send" ).click(function() { validateInput(); });
//
//
//
// });

