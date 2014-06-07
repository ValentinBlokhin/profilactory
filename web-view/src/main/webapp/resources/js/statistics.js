/**
 * Created by ValentinBlokhin on 6/5/2014.
 */

$(document).ready(function () {

    $('#fromInput').datepicker({
        format: 'yyyy-mm-dd'
    });
    $('#toInput').datepicker({
        format: 'yyyy-mm-dd'
    });

    /* check input date fields */
    $('#submitDate').click(function (event) {
        event.preventDefault();
        if ($('#fromInput').val() == "" || $('#toInput').val() == "") {
            event.preventDefault();
            var errorMessage = $('#error-noDataFound');
            errorMessage.removeClass('hide');
            errorMessage.text('Some fields is empty');
            return false;
        }
        else checkData(event);
    });


});

function checkData(event) {
    var errorMessage = $('#error-noDataFound');
    $.ajax({
        type: "POST",
        cache: false,
        url: "/manage/permstats/data",
        data: {
            'checkIn': $('#fromInput').val(),
            'checkOut': $('#toInput').val()
        },
        success: function (response) {
            var obj = JSON.parse(response);
            if (obj == "false") {
                event.preventDefault();
                errorMessage.removeClass('hide');
                errorMessage.text('no data found');
                return false;
            }
            else {
                $('#checkDateForm').submit();
                return true;
            }
        },
        error: function (jqXhr, textStatus, errorThrown) {
            event.preventDefault();
            console.log('xhRequest: ' + jqXhr + "\n");
            console.log('ErrorText: ' + textStatus + "\n");
            console.log('thrownError: ' + errorThrown + "\n");
        }
    })
}
