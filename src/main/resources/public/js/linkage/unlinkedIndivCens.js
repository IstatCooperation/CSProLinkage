var _ctx = $("meta[name='ctx']").attr("content");
var table;

$(document).ready(function () {
    
    setMenuActive("unlinkedIndivCens");
    
    table = $('#unlinkedIndivTab').DataTable({

        dom: "<'row'<'col-sm-6'B><'col-sm-6'f>>"
          + "<'row'<'col-sm-12'tr>>"
          + "<'row'<'col-sm-5'i><'col-sm-7'p>>",

        responsive: true,

        buttons: [],
        
        order: [
                [ 2, "asc" ]
        ],        

        ajax: {
            "dataType": 'json',
            "contentType": "application/json; charset=utf-8",
            "type": "POST",
            "url": _ctx + "/linkage/unlinkedIndivCens",
            "dataSrc": function (json) {
                return json;
            }
        },

        columns: [
            {'data': 'idIndividual'},
            {'data': 'fullName'},
            {'data': 'age'},
            {'data': 'sex'},
            {'data': 'religion'},
            {'data': 'relat'},
            {'data': 'grade'},
            {'data': 'ethnic'},
            {'data': 'marital'},
            {'data': 'eaCode'}
        ],

        rowId: 'idIndividual'
    });


    table.buttons().container().appendTo(
      '#userslist_wrapper .col-sm-6:eq(0)');

}); // fine ready



