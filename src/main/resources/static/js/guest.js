function setSearchButton(){
    var element = document.getElementById('searchButton');
    element.onclick = function(event) {
      reloadPage()
    }
};
function setClearButton(){
    var element = document.getElementById('clearButton');
    element.onclick = function(event) {
      document.getElementById('lastName').value = '';
      reloadPage()
    }
};
function reloadPage(){
    var lastName = document.getElementById('lastName').value;
    var redirectLink = window.location.protocol + "//" + window.location.host + window.location.pathname + '?lastName=' + lastName;
    console.log('Redirecting to: ' + redirectLink);
    window.location.href = redirectLink;
};

$(document).ready(function(){
    setSearchButton();
    setClearButton();
});