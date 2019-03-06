<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<html lang="en" xmlns:th="http://www.thymeleaf.org/">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title th:text="${title}">Glucose Monitor</title>

  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
  <script type="text/javascript" src="https:www.gstatic.com/charts/Loader.js"></script>

  <script>

    $(document).ready(function () {

      $.ajax({
        type: 'GET',
        dataType: "json",
        contentType: "application/json",
        url: '${pageContext.request.contextPath}/api/createrecord/findall',
        success: function (result) {
          google.charts.load('current', {
            'packages' : ['line']
          });
          google.charts.setOnLoadCallback(drawChart(result));

        }

      });

      function drawChart(result) {

        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Name');
        data.addColumn('number', 'Quantity');
        var dataArray = [];
        $.each(result, function (i, obj) {
          dataArray.push([obj.name, obj.quantity]);
        });

        data.addRows(dataArray);

        var options = {
          title: 'Line Chart: Placeholder',
          curveType: 'function',
          legend: { position: 'bottom'}
        };
        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

        chart.draw(data, options);
      }
    });

  </script>

</head>
<body>
<div id="curve_chart" style="width: 900px; height: 500px"></div>

<%--<table class="columns">
    <tr>
        <td><div id="linechart_div" style="border: 1px solid #ccc"></div></td>
    </tr>
</table>--%>

</body>
</html>