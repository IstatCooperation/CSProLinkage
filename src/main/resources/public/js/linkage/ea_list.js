var _ctx = $("meta[name='ctx']").attr("content");
var table;
$(document)
  .ready(
    function () {        
        setMenuActive("ea_list");

        table = $('#ea_list_tab').DataTable(
            {
                dom: "<'row'<'col-sm-6'B><'col-sm-6'f>>"
                  + "<'row'<'col-sm-12'tr>>"
                  + "<'row'<'col-sm-5'i><'col-sm-7'p>>",
                responsive: true,
                buttons: [],
                "ajax": {
                    "dataType": 'json',
                    "contentType": "application/json; charset=utf-8",
                    "type": "POST",
                    "url": _ctx + "/linkage/ea_list_user",
                    "dataSrc": function (json) {
                        return json;
                    }
                },
                "columns": [                 
                    {'data': 'eaCod'},
                    {
                        "render": function (data, type, row) {
                            return (row.selected === 0 ? 
                                "<a href='javascript:void(0)' title='Select EA' " +
                                "onclick='javascript:ea_select(\"" + row.eaCod + "\",\"" + row.userName + "\")'><i class='fa fa-square-o'></i></a>" : 
                                "<i class='fa fa-check-square-o'></i>");
                        },
                        "orderable": false
                    }                      
                ]
            });
    });// fine ready

function ea_select(eaCode, userName) {
    $.ajax({
        url: _ctx + "/linkage/setEaUser",
        data: {"eaCode": eaCode, "userName": userName},        
        type: "POST",
        dataType: "JSON",
        success: function (data) {
            table.ajax.reload();
        }
    });        
}
