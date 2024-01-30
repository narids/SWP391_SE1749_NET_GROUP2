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
        if (link) {
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
    $('#togglePassword1').click(function () {
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

    $('#togglePassword2').click(function () {
        var passwordInput = $('#repassword');
        var icon = $(this);

        if (passwordInput.attr('type') === 'password') {
            passwordInput.attr('type', 'text');
            icon.html('&#x1F440;'); // Mắt mở
        } else {
            passwordInput.attr('type', 'password');
            icon.html('&#x1F441;'); // Mắt đóng
        }
    });

    $('#resetForm').submit(function (event) {
        event.preventDefault();

        // Kiểm tra xem mật khẩu và mật khẩu nhập lại có khớp nhau không
        var password = $('#password').val();
        var confirmPassword = $('#repassword').val();

        if (password !== confirmPassword) {
            toastMessageAction("Confirm password does not match!", "red");

        } else {
            $.ajax({
                url: "/SWP391_SE1749_NET_GROUP2/forgot-password",
                type: "post",
                data: {
                    action: "changepassword",
                    password: password
                },
                success: function (data) {
                    let text = "";
                    let color = "green";

                    switch (data) {
                        case "success":
                            text = "Reset password successfully! Sendirect...";
                            break;

                        case "failed":
                            text = "Verification code has expired! Sendirect...";
                            color = "red";
                            break;
                    }

                    toastMessageAction(text, color, "/SWP391_SE1749_NET_GROUP2/login");
                },
                error: function (err) {
                    toastMessageAction(err, "red", "/SWP391_SE1749_NET_GROUP2/forgot-password");
                }
            });
        }
    });
});
