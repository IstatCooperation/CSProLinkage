var _ctx = $("meta[name='ctx']").attr("content");
var table;
var polling = false;
var poll;
/* valorizza il campo nascosto con il valore dello step */
var stepID = 0;
var selIndA, selIndB;

$(document).ready(function () {
    
    setMenuActive("linkedIndiv");
    
    table = $('#linkedIndivTab').DataTable({

        dom: "<'row'<'col-sm-6'B><'col-sm-6'f>>"
          + "<'row'<'col-sm-12'tr>>"
          + "<'row'<'col-sm-5'i><'col-sm-7'p>>",

        responsive: true,

        buttons: [],
        
        order: [
                [ 10, "asc" ],
                [ 2, "asc" ]
        ],        

        ajax: {
            "dataType": 'json',
            "contentType": "application/json; charset=utf-8",
            "type": "POST",
            "url": _ctx + "/linkage/allLinkedIndiv",
            "dataSrc": function (json) {
                return json;
            }
        },

        rowId: 'linkageIndiv',

        columns: [
            {'data': 'idIndividualA'},
            {'data': 'idQuestA'},
            {'data': 'name1A'},
            {'data': 'name2A'},
            {'data': 'name3A'},
            {'data': 'idIndividualB'},
            {'data': 'idQuestB'},
            {'data': 'name1B'},
            {'data': 'name2B'},
            {'data': 'name3B'},
            {'data': 'eaCode'},
            {'data': 'step'},
            {
                'render': function (data, type, row) {
                    return '<a class="btn btn-sm btn-primary" href="javascript:void(0)" title="Households" ' +
                        'onclick="javascript:showHouseholdPanel('+ row.idIndividualA + ',' + row.idQuestA + ',' 
                        + row.idIndividualB + ',' + row.idQuestB + ',' + row.step + ')"><i class="fa fa-users"></i></a>';
                },
                'orderable': false
            },            
            {
                'render': function (data, type, row) {
                    return '<a class="btn btn-sm btn-primary" href="javascript:void(0)" title="Linked Households" ' +
                        'onclick="javascript:showLinkedHouseholdPanel('+ row.idQuestA + ',' + 
                            row.idQuestB + ')"><i class="fa fa-home"></i></a>';
                },
                'orderable': false
            },            
            {
                'render': function (data, type, row) {
                    if (row.step != "0")
                        return '<a class="btn btn-sm btn-primary" href="javascript:void(0)" title="Remove link" ' +
                            'onclick="javascript:showDeleteConfirm('+ row.idIndividualA + ',' + row.idIndividualB + ')"><i class="fa fa-trash-o"></i></a>';
                    else
                        return "&nbsp;";
                },
                'orderable': false
            }            
        ],

        rowId: 'linkageIndiv'
    });

    table.buttons().container().appendTo(
      '#userslist_wrapper .col-sm-6:eq(0)');   

    /*$('#linkedIndivTab tfoot th span').each( function () {
        var title = $(this).text();
        $(this).html( '<input type="text" placeholder="Search '+title+'" />' );
    } );
    
    // Apply the search
    table.columns().every( function () {
        var that = this;
        $( 'input', this.footer() ).on( 'keyup change', function () {
            if ( that.search() !== this.value ) {
                that.search( this.value ).draw();
            }
        } );
    } );*/  
}); // fine ready


function showDeleteConfirm(idIndA, idIndB, step) {
    selIndA = idIndA;
    selIndB = idIndB;
    $('#titleDelIndivA').text('Individual A ' + selIndA);
    $('#titleDelIndivB').text('Individual B ' + selIndB);
    $('#modalDeleteConfirm').modal('show');
}

function delLinkedIndividuals() {      
    if (selIndA && selIndB) {
        var rowIndiv = $("tr#" + selIndA + "_" + selIndB);    
        if (rowIndiv) {
            $.ajax({
                dataType: 'json',
                contentType: "application/json; charset=utf-8",
                type: "GET",
                cache: false,
                url: _ctx + "/linkage/delLinkedIndiv?idA=" + selIndA + "&idB=" + selIndB,
                success: function () {
                    $("#modalDeleteConfirm").modal("hide");
                    rowIndiv.remove();
                }
            });
        }
    }
}



