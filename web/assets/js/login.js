/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function toastMessageAction(text, color, link) {
    if (text && text !== "") {
        $('#toast').text(text);
        $('#toast').css('background-color', color);
        $('#toast').toggleClass('show');

        // After 3 seconds, remove the show class from DIV and redirect
        if (link && link !== "") {
            setTimeout(function () {
                window.location.href = link;
            }, 3000);
        }
        setTimeout(function () {
            $('#toast').text("");
            $('#toast').toggleClass('show');
        }, 4000);
    }
}

$(document).ready(function () {
    $('#togglePassword').click(function () {
        var passwordInput = $('#password');
        var icon = $(this);

        if (passwordInput.attr('type') === 'password') {
            passwordInput.attr('type', 'text');
            icon.html('&#x1F440;'); // Mắt mở
        } else {
            passwordInput.attr('type', 'password');
            icon.html('&#x1F441;'); // Mắt đóng
        }
    });


    $('#loginForm').submit(function (event) {
        event.preventDefault();

        var formData = $(this).serialize();
        $.ajax({
            url: "/SWP391_SE1749_NET_GROUP2/login",
            type: "post",
            data: formData,
            success: function (data) {
                let text = "Login successfully! Sendirect home...";
                let color = "green";
                let link = "/SWP391_SE1749_NET_GROUP2/home";

                switch (data) {
                    case "success":
                        break;
                    
                    case "notCorrect":
                        text = "Username or password not correct. Please try again!";
                        color = "red";
                        link = "";
                        break;

                    case "inActive":
                        text = "Your account is inactive. Please contact Admin!";
                        color = "red";
                        link = "";
                        break;
                }

                toastMessageAction(text, color, link);
            },
            error: function (err) {
                toastMessageAction(err, "red", "/SWP391_SE1749_NET_GROUP2/login");
            }
        });
    });
});

