var stompClient = null;


 function executeCommand() {
                var command = document.getElementById('command').value;
                  stompClient.send("/app/execute", {},
                  JSON.stringify({'command':command}));
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
                 var response = document.getElementById('response');
                 response.appendChild(document.createTextNode(commandOutput));
             }

