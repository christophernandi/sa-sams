<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>

    <script type="text/javascript" src="../../scripts/jquery-1.4.1.min.js"></script>
    <script type="text/javascript" src="../../scripts/jquery-ui-1.7.2.custom.min.js"></script>
    <script type="text/javascript" src="../../scripts/script.js"></script>
    <script type="text/javascript" src="../../scripts/jquery-1.9.1.js">
        function onChangeValue() {

            window.alert("FUCK THIS");
            var valueTotal = 0;
            $(":text".each(function () {
                if (!isNaN(this.value) && this.value.length != 0) {
                    valueTotal -= parseFloat(this.value);
                }
            }));
//            $("#t_balance").html(valueTotal.toFixed(2))
            $("#total").html(valueTotal.toFixed(2))
        }
        //        $(":text").keyup(onChangeValue());
        $(":text").keyup(onChangeValue());
        //        total
        /*function onCheck() {
         var t_balance = 0;
         $("input[type=checkbox]:checked").each(function() {
         t_balance += parseFloat($(this).attr("alt"));
         });
         $("#t_balance").html(t_balance.toFixed(2));

         calculateSum();
         }

         function calculateSum() {
         var sum = parseFloat( $("#t_balance").text() );

         $(":text").each(function() {
         if (!isNaN(this.value) && this.value.length != 0) {
         sum -= parseFloat(this.value);
         }
         });
         $("#t_balance").html(sum.toFixed(2));
         }

         $("input[type=checkbox]").change(onCheck);
         $(":text").keyup(onCheck);*/

        /*        function onCheck() {
         var t_balance = 0;
         $("input[type=checkbox]:checked").each(function () {
         t_balance += parseFloat($(this).attr("alt"));
         });
         $("#t_balance").html(t_balance.toFixed(2));
         }

         function calculateSum() {
         var sum = 0;
         $(":text").each(function () {
         if (!isNaN(this.value) && this.value.length != 0) {
         sum += parseFloat(this.value);
         }
         });
         $("#t_balance").html(parseFloat($("#t_balance").text()) - sum.toFixed(2));
         }
         $("input[type=checkbox]").change(function () {
         onCheck();
         });

         $(":text").each(function () {
         $(this).keyup(function () {
         calculateSum();
         });
         });*/

        $(document).ready(function () {
            $('input.amount').keyup(function () {
                window.alert("Amount changed")
                calculateTotal(this);
            });
        });

        function onChangeEvent() {

        }

        function calculateTotal(src) {
            var sum = 0,
                    tbl = $(src).closest('table');
            tbl.find('input.amount').each(function (index, elem) {
                var val = parseFloat($(elem).val());
                if (!isNaN(val)) {
                    sum += val;
                }
            });
            tbl.find('.total').html(sum.toFixed(2));
        }

    </script>
</head>
<body>

<%--<input type="checkbox" rel="90" alt="30.00">Pearl or White
<input type="checkbox" rel="120" alt="35.00">Natural
<div id="t_balance"></div>
<input type="text" id="discount"/>--%>

<table border="1">

    <tr>
        <td>Amount 1</td>
        <td><input class="amount" type="text" onchange="onChangeValue()"/></td>
    </tr>

    <tr>
        <td>Amount 2</td>
        <td><input class="amount" type="text"/></td>
    </tr>

    <tr>
        <td>Amount 3</td>
        <td><input class="amount" type="text"/></td>
    </tr>

    <tr>
        <td>Total Amount</td>
        <td><span class="total">0</span></td>
    </tr>

</table>


</body>
</html>