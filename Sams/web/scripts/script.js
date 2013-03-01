function updateBulkTotal(tellerId) {
    var checkBoxId = "#selectedConsolidatedPhysicalCount" + tellerId;
    var hiddenTotalId = "#teller" + tellerId + "Total";
    if ($(checkBoxId).attr("checked")) {
        var totalAmount = parseInt($("#total").text()) + parseInt($(hiddenTotalId).attr("value"));
    } else {
        totalAmount = parseInt($("#total").text()) - parseInt($(hiddenTotalId).attr("value"));
    }
    $("#total").text(totalAmount);
    $("#hiddenTotal").attr("value", totalAmount);
}

function updateTotals(physicalCountId, tellerId) {
    var checkBoxId = "#selectedConsolidatedPhysicalCount" + physicalCountId;
    var pcAmountId = "#pc" + physicalCountId + "Amount";
    var tellerTotalId = "#teller" + tellerId + "Total";

    var pcAmount = parseInt($(pcAmountId).attr("value"));
    var tellerTotal = parseInt($(tellerTotalId).text());
    var total = parseInt($("#total").text());

    if ($(checkBoxId).attr("checked")) {
        tellerTotal += pcAmount;
        total += pcAmount;
    } else {
        tellerTotal -= pcAmount;
        total -= pcAmount;
    }

    $(tellerTotalId).text(tellerTotal);
    $("#total").text(total);
    $("#hiddenTotal").attr("value", total);
}

function updateTotalsMultiple(checkAll, tellerId) {
    var tellerTotalId = "#teller" + tellerId + "Total";
    var tellerMaxTotalId = "#teller" + tellerId + "MaxTotal";

    var tellerTotal = parseInt($(tellerTotalId).text());
    var tellerMaxTotal = parseInt($(tellerMaxTotalId).attr("value"));
    var total = parseInt($("#total").text());

    //Subtract the current teller total from the grand total and then zero it
    total -= tellerTotal;
    tellerTotal = 0;

    if (checkAll) {
        //Set the current teller total to its max and then add it to the grand total
        tellerTotal = tellerMaxTotal;
        total += tellerMaxTotal;
    }

    $(tellerTotalId).text(tellerTotal);
    $("#total").text(total);
    $("#hiddenTotal").attr("value", total);
}

function selectAllFormCheckBoxes(checkAll) {
    $('.checkAllMember').attr("checked", checkAll);
}

function selectFormCheckBoxes(checkAll, checkClass) {
    $('.' + checkClass).attr("checked", checkAll);
}

function selectVisibleFormCheckBoxes(checkAll, checkClass) {
    $('.' + checkClass).attr("checked", checkAll);
}


function uncheck(checkboxId) {
    $('#' + checkboxId).attr("checked", false);
}

function calcTotal(checkAll) {
    $("#total").text(0);
    if (checkAll) {
        var checkboxes = $('.checkAllMember');
        var checkboxIdPrefix = "selectedConsolidatedPhysicalCount";
        var checkboxIdPrefixLength = checkboxIdPrefix.length;
        jQuery.each(checkboxes, function(index, value) {
            updateBulkTotal(value.id.substr(checkboxIdPrefixLength));
        });
    }
}

function calcVariance(expectedAmount, count1, varianceTDId) {
    var varianceTD = $("#" + varianceTDId);
    var variance = parseInt(count1) - parseInt(expectedAmount);
    if (variance == 0) {
        varianceTD.css("color", "green");
    } else {
        varianceTD.css("color", "red");
    }
    varianceTD.text(variance);
}

$(function() {
    $('.datepicker').datepicker({showOn: 'button', showAnim: 'slideDown', buttonImage: 'img/calendar.gif', buttonImageOnly: true, dateFormat: 'dd/mm/yy'});
});


var ie = (document.all) ? true : false;

function showClass(objClass) {
    $('.' + objClass).show();
    $('.' + objClass).removeClass('hidden');
    $('.' + objClass).addClass('visible');
}

function hideClass(objClass) {
    $('.' + objClass).hide();
    $('.' + objClass).removeClass('visible');
    $('.' + objClass).addClass('hidden');
}

/* Used to convert an html table to CSV */
function getCSVData(obj) {
    var csv_value = $('#' + obj).table2CSV({delivery:'value'});
    $("#csv_text").val(csv_value);
}

function setEndDate(inDate, obj, numDays) {
    var newDate;
    inDate.setDate(inDate.getDate() + numDays);
    $('#' + obj).val($.format.date(inDate.toString(), "dd/MM/yyyy"));

}

function toggleConsolidateBy(num) {
    if (num == 1) {
        $('#' + "consolidateBy").show();
    } else
    if (num == 3) {
        $('#' + "consolidateBy").hide();
    }

}
/*
 * Used in new TMS screen
 *
 * */

function enableDisableSearchTypeCriteria() {
    var dateFrom = document.getElementById("dateFrom");
    var canisterNum = document.getElementById("canisterNum");
    var msisdn = document.getElementById("msisdn");
    var cardName = document.getElementById("cardName");
    var dateTo = document.getElementById("dateTo");
    var flashNum = document.getElementById("flashNum");
    var sealNum = document.getElementById("sealNum");
    var cardNumber = document.getElementById("cardNumber");
    var type = document.getElementById("type");
    var clientId = document.getElementById("clientId");
    var radioValue = '';
    var selection = document.getElementsByName('searchType');

    canisterNum.disabled = true;
    msisdn.disabled = true;
    cardName.disabled = true;
    flashNum.disabled = true;
    sealNum.disabled = true;
    cardNumber.disabled = true;
    type.disabled = false;
    clientId.disabled = true;

    for (i = 0; i < selection.length; i++) {
        if (selection[i].checked) {
            radioValue = selection[i].value;
            break;
        }
    }
    if (radioValue == 'Date') {
        dateFrom.disabled = false;
        dateTo.disabled = false;
    }
    else if (radioValue == 'Canister') {
        canisterNum.disabled = false;
    }
    else if (radioValue == 'MSISDN') {
        msisdn.disabled = false;
    }
    else if (radioValue == 'Flash') {
        flashNum.disabled = false;
    }
    else if (radioValue == 'Seal') {
        sealNum.disabled = false;
    }
    else if (radioValue == 'Card Name') {
        cardName.disabled = false;
    }
    else if (radioValue == 'Card Number') {
        cardNumber.disabled = false;
    }
    else if (radioValue == 'Client ID') {
        clientId.disabled = false;
    }

}

