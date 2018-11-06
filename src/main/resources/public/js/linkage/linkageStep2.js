var _ctx = $("meta[name='ctx']").attr("content");
var table;
var stepID = 2; 
var codEA;

$(document).ready(function () {
        
    setMenuActive("linkage");
    codEa = $("input#codEA").val();
    
    table = $('#tabStep').DataTable({

        dom: "<'row'<'col-sm-6'B><'col-sm-6'f>>"
          + "<'row'<'col-sm-12'tr>>"
          + "<'row'<'col-sm-5'i><'col-sm-7'p>>",

        responsive: true,

        buttons: [],
        
        order: [
                [ 12, "asc" ],
                [ 1, "asc" ]
        ],        

        ajax: {
            dataType: 'json',
            type: 'POST',
            data: { "codEA" : codEa, "step" : stepID},
            url: _ctx + '/linkage/allRecStep',
            dataSrc : function (json) {
                return json;
            }
        },
        
        rowId: 'linkageIndiv',
        
        columns: [
            {'data': 'idIndividualA'},
            {'data': 'fullNameA'},
            {'data': 'idIndividualB'},
            {'data': 'fullNameB'},
            {'data': 'ageA'},
            {'data': 'sexA'},
            {'data': 'religionA'},
            {'data': 'relatA'},            
            {'data': 'gradeA'},
            {'data': 'ethnicA'},
            {'data': 'maritalA'},
            {'data': 'eaCode'},
            {
                'render': function (data, type, row) {
                        return buttonHHUnlinked(row, stepID);                                
                },
                'orderable': false
            },
            {
                'render': function (data, type, row) {
                    return buttonHHLinked(row);
                },
                'orderable': false
            }            
        ]
    });


    table.buttons().container().appendTo(
      '#userslist_wrapper .col-sm-6:eq(0)'); 
      
    $("#btnSave").hide();

});// fine ready

function enableSubmit() {
    var n = $( "input:checked" ).length;
    if (n < 1)
        $("#btnSave").hide();
    else
        $("#btnSave").show();
}