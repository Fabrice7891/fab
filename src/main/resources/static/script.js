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
                     setConnected(true);
                     console.log('Connected: ' + frame);
                     stompClient.subscribe('/command/output', function(commandOutput) {
                         showCommandOutput(commandOutput.body);
                     });
                 });
             }

 function showCommandOutput(commandOutput) {
                 var response = document.getElementById('response');
                 var p = document.createElement('p');
                 p.style.wordWrap = 'break-word';
                 p.appendChild(document.createTextNode(commandOutput));
                 response.appendChild(p);
             }

