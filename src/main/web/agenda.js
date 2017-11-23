$(document).ready(function ($) {
    $.getJSON("", function (data) {

    });

});

jQuery(document).ready(function ($) {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/agenda/week'
    }).done(function (data, textStatus, jqXHR) {
        $.each(data, function (key, val) {
            console.log("<li id='" + key + "'>" + val + "</li>");
        });
    }).fail(function (jqXHR, textStatus, errorThrown) {
        if (jqXHR.status === 401) { // HTTP Status 401: Unauthorized
            var preLoginInfo = JSON.stringify({method: 'GET', url: '/'});
            $.cookie('restsecurity.pre.login.request', preLoginInfo);
            window.location = '/login.html';

        } else {
            alert('Houston, we have a problem...');
        }
    });
});
