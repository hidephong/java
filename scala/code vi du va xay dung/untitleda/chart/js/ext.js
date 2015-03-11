/**
 * Created by tuanna on 5/6/14.
 */
function dataGraph() {
    var data = "";

    $.ajax({
        type: 'GET',
        url: "http://localhost:60539/GraphHandler.ashx",
        dataType: 'json',
        async: false,
        contentType: "application/json; charset=utf-8",
        data: { 'GraphName': 'line' },
        success: function (result) {
            data = result;
        },
        error: function (xhr, status, error) {
            alert(error);
        }
    });

    return data;
}