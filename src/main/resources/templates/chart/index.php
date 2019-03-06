<?php


require('db_config.php');


/* Getting demo_viewer table data */
$sql = "SELECT SUM(glucose) as count FROM create_record 
			GROUP BY YEAR (placed_at) ORDER BY placed_at";
$viewer = mysqli_query($mysqli,$sql);
$viewer = mysqli_fetch_all($viewer,MYSQLI_ASSOC);
$viewer = json_encode(array_column($viewer, 'count'),JSON_NUMERIC_CHECK);


?>


<!DOCTYPE html>
<html lang="en" xmlns:th="http:thymeleaf.org">
<head>
    <meta charset="UTF-8"/>
    <title th:text="${title}">HighChart</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.js"></script>
    <script src="https://code.highcharts.com/highcharts.js"></script>
</head>
<body>


<script type="text/javascript">


    $(function () {

        var data_viewer = <?php echo $viewer; ?>;


        $('#container').highcharts({
            chart: {
                type: 'line'
            },
            title: {
                text: 'Yearly Website Ratio'
            },
            xAxis: {
                categories: ['2013','2014','2015', '2016']
            },
            yAxis: {
                title: {
                    text: 'Rate'
                }
            },
            series: [{
                name: 'View',
                data: data_viewer
            }]
        });
    });


</script>


<div class="container">
    <br/>
    <h2 class="text-center">Highcharts php mysql json example</h2>
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <div class="panel panel-default">
                <div class="panel-heading">Dashboard</div>
                <div class="panel-body">
                    <div id="container"></div>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>