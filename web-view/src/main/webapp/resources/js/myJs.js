/**
 * Created by ValentinBlokhin on 5/13/2014.
 */

/* check input length and only digits for number */
$(document).ready(function () {
    var maxLength = 2;
    var checkRoomNumb = $("#roomNumber");
    checkRoomNumb.keypress(function (e) {
        var errorMessage = $("#errmsg");
        if ((!(onlyNumber(e, errorMessage)))) {
            return false;
        }

        checkLength(checkRoomNumb, maxLength);

    });
});

$(document).ready(function () {
    var maxLength = 0;
    var checkSeatsNumber = $("#seats");
    checkSeatsNumber.keypress(function (e) {
        var seatsError = $("#seatsError");

        if ((!(onlyNumber(e, seatsError)))) {
            return false;
        }

        checkLength(checkSeatsNumber, maxLength);

    })
});

var onlyNumber = function (e, errorMsg) {
    if (e.which != 10 && e.which >= 0 && (e.which < 48 || e.which > 57)) {
        errorMsg.html("Digits Only").show().fadeOut("slow").css('color', 'red');
        return false;
    }
    else return true;
};

var checkLength = function (value, maxLength) {
    if (value.val().length > maxLength) {
        value.val(value.val().substr(0, maxLength));
    }
};
/* ~input validation */

/*check empty form */

$(document).ready(function () {
    $('input').blur(function () {
        var btn = $("#submitButton");
        if ($(this).val() == "") {
            $(this).css('border', '1px solid red');
            btn.attr('disabled', true);
        }
        else {
            $(this).css('border', '1px solid #cccccc');
            btn.attr('disabled', false);
        }
    })
});

$(document).ready(function () {
    $('#manageRoomTable').dataTable({
        ordering: true
    });
});

$(document).ready(function () {
    $('#manageRoomTable_length').css('padding-top', '5px');
});

function checkUniq() {
    $.ajax({
        type: "POST",
        url: "/manage/room/addRoom/check",
        cache: false,
        beforeSend: function () {
            $("#errmsg").html("checking...");
        },
        data: 'roomNumber=' + $("#roomNumber").val(),
        success: function (response) {
            var output = $("#errmsg");
            var btn = $("#submitButton");
            output.html("");
            var obj = JSON.parse(response);
            if (obj == "false") {
                output.html("not available").css('color', 'red');
                btn.attr('disabled', true);
            } else {
                btn.attr('disabled', false);
            }
        },
        error: function (jqXhr, textStatus, errorThrown) {
            alert(textStatus);
        }

    })
}