var _ctx = $("meta[name='ctx']").attr("content");
var table;
var polling = false;
var poll;

$(document).ready(function () {
        
    setMenuActive("duplicate");

    table = $('#doubleRecList').DataTable({

        dom: "<'row'<'col-sm-6'B><'col-sm-6'f>>"
          + "<'row'<'col-sm-12'tr>>"
          + "<'row'<'col-sm-5'i><'col-sm-7'p>>",

        responsive: true,

        buttons: [],

        ajax: {
            "dataType": 'json',
            "contentType": "application/json; charset=utf-8",
            "type": "POST",
            "url": _ctx + "/linkage/duplicateRecs",
            "dataSrc": function (json) {
                return json;
            }
        },

        columns: [
            {'data': 'name'},
            {'data': 'num'},
        ]
        });


    table.buttons().container().appendTo(
      '#userslist_wrapper .col-sm-6:eq(0)');       

});// fine ready

function refreshData() {
    table.ajax.reload();    
}
