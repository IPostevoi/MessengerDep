/**
 * Created by bakla410 on 02.05.17.
 */
var stompClient = null;
var chatName = null;

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
        setConnected(true);
        console.log('Connected: ' + frame);
        var msg = stompClient.subscribe('/topic/chat/' + chatId, function (message) {
            showMessage(JSON.parse(message.body))
        });
    });
}

function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function send() {
    stompClient.send("/app/chat/" + chatId, {}, JSON.stringify({'senderName': username,
        'content': $("#message").val(), 'chatId': chatId}));
    $("#message").val("");
}

function showMessage(message) {
    $("#chat").append("<tr><td>" + message.senderName + ": " + message.content + "</td></tr>");
}

// $(function () {
//     $("#connectForm").submit(function (e) {
//         return false;
//     });
//     $("#sendForm").submit(function (e) {
//         return false;
//     });
//     $( "#connect" ).click(function() { connect(); });
//     $( "#disconnect" ).click(function() { disconnect(); });
//     // $( "#send" ).click(function() { send(); });
// });

$( document ).ready(function() {

    $("#sendForm").submit(function () {
        return false;
    });

    connect();

    $( "#send" ).click(function() { send(); });
});


