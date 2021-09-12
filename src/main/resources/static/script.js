var stompClient = null;

function executeCommand() {
            stompClient.send("/app/execute", {}, $('#command').val());
        }

function init() {
             var socket = new SockJS('/execute');
             stompClient = Stomp.over(socket);
             stompClient.connect({}, function(frame) {
                 console.log('Connected: ' + frame);
                 stompClient.subscribe('/command/output', function(commandOutput) {
                     showCommandOutput(commandOutput.body);
                 });
             });
         }

function showCommandOutput(commandOutput) {
        $('#response').val(commandOutput)
}

