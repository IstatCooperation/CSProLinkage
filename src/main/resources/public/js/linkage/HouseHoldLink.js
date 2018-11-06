/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var linkedSomeone = false;
var indivA, indivB, currStepID;

function showHouseholdPanel(idA, idQA, idB, idQB, step) {
    indivA = idA;
    indivB = idB;
    currStepID = step;
    linkedSomeone = false;
    $('#titleTabA').text('HH Quest PES ' + idQA);
    $('#titleTabB').text('HH Quest CENS ' + idQB);
    $('#currStepID').text(step);
    loadDataTable("allMatchingVarPesQuest", idQA, "A");
    loadDataTable("allMatchingVarCensQuest", idQB, "B");
    $('#modalFamilies_form').modal('show');
    $('tr#' + idA + '_' + idB).css({ 'background-color': '#c2c7ce' });          
}

function loadDataTable(restUrl, idQ, idTable) {
    var table = $("#tabFamily" + idTable);
    table.DataTable().destroy();
    table.DataTable({
        retrieve: true,
        paging: false,
        searching: false,
        dom: "<'row'<'col-sm-6'B><'col-sm-6'f>>"
                + "<'row'<'col-sm-12'tr>>"
                + "<'row'<'col-sm-5'i><'col-sm-7'p>>",
        responsive: true,
        buttons: [],
        order: [[1, "asc"]],
        ajax: {
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            type: "POST",
            url: _ctx + "/linkage/" + restUrl + "?idq=" + idQ,
            data: {},
            dataSrc: function (json) {
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
            {
                'render': function (data, type, row) {
                    return "<input id='" + row.idIndividual + "_" + row.idQuest + "_" + idTable + "'" +
                            " type='radio' onClick='' name='indiv_quest_" + idTable + "' value='" + row.idIndividual + '_' + row.idQuest + "'/>";
                },
                'orderable': false
            }
        ]
    });
}

function effettuaLink() {
    linkedSomeone = true;
    var i1 = $("[name=indiv_quest_A]:checked").val();
    var i2 = $("[name=indiv_quest_B]:checked").val();
    if (i1 && i2) {
        $.ajax({
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            type: "GET",
            cache: false,
            url: _ctx + "/linkage/linkHHIndiv?indiv_quest_A=" + i1 + 
                    "&indiv_quest_B=" + i2 + 
                    "&step=" + currStepID + "m",
            success: function (data) {
                var p1 = $('#' + i1 + '_A').parent();
                var p2 = $('#' + i2 + '_B').parent();
                $('#' + i1 + '_A').remove();
                $('#' + i2 + '_B').remove();
                p1.append("<i class='fa fa-check'></i>");
                p2.append("<i class='fa fa-check'></i>");
            }
        });
    }
}

function showLinkedHouseholdPanel(idQA, idQB) {
    $('#titleQuestA').text('HH Quest PES ' + idQA);
    $('#titleQuestB').text('HH Quest CENS ' + idQB);
    loadLinkedDataTable(idQA, idQB);
    $('#modalLinkedFamilies_form').modal('show');
}

function loadLinkedDataTable(idQA, idQB) {
    var table = $("#tabLinkedInd");
    table.DataTable().destroy();
    table.DataTable({
        retrieve: true,
        paging: false,
        searching: false,
        dom: "<'row'<'col-sm-6'B><'col-sm-6'f>>"
                + "<'row'<'col-sm-12'tr>>"
                + "<'row'<'col-sm-5'i><'col-sm-7'p>>",
        responsive: true,
        buttons: [],
        order: [[1, "asc"]],
        ajax: {
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            type: "POST",
            url: _ctx + "/linkage/linkedIndQuestAQuestB?idQuestA=" + idQA + "&idQuestB=" + idQB,
            data: {},
            dataSrc: function (json) {
                return json;
            }
        },
        columns: [
            {'data': 'idIndividualA'},            
            {'data': 'fullNameA'},
            {'data': 'ageA'},
            {'data': 'sexA'},
            {'data': 'idIndividualB'},            
            {'data': 'fullNameB'},
            {'data': 'ageB'},
            {'data': 'sexB'},
            {'data': 'step'}
        ]
    });
}

function buttonHHUnlinked(row, currStepID) {
    var button;
    var id = 'bhhu_' + row.idIndividualA + '_' + row.idIndividualB;
    
    if (row.unlinkedQuestA != '0' && row.unlinkedQuestB != '0')
        button = '<i id="' + id + '"class="fa fa-users"> ' +  row.unlinkedQuestA + '/' + row.unlinkedQuestB + '</i>';
    else    
        button = '<i id="' + id + '" class="fa fa-times"> ' +  row.unlinkedQuestA + '/' + row.unlinkedQuestB + '</i>';
    
    return '<a class="btn btn-sm btn-primary" href="javascript:void(0)" title="Households" ' +
            'onclick="javascript:showHouseholdPanel('+ row.idIndividualA + ',' + row.idQuestA + ',' 
                + row.idIndividualB + ',' + row.idQuestB + ',' + currStepID + ')">' +  button + '</a>';    
}

function buttonHHLinked(row) {
    return '<a class="btn btn-sm btn-primary" href="javascript:void(0)" title="Households" ' +
        'onclick="javascript:showLinkedHouseholdPanel('+ row.idQuestA + ',' + 
            row.idQuestB + ')"><i class="fa fa-home"></i></a>';    
}

function closeHHLinkage() {   
    if (linkedSomeone == true) {
        $.ajax({
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            type: "GET",
            cache: false,
            url: _ctx + "/linkage/refreshEATable",
            success: function (data) {}
        });        
        setNewValueButtonUnlinked()
        linkedSomeone = false;
    }
    close();
}

function setNewValueButtonUnlinked() {
    $("#bhhu_" + indivA + "_" + indivB).text(" ?/?");
}

function getIDButtonUnlinked(indA, indB) {
    return "bhhu_" + indA + "_" + indB;        
}