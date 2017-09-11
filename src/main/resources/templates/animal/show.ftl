<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Greeting</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

  </head>
  <body>
<#if entity??>
    <h1>Show ${entity.name}</h1>

    <a href="/animal">Go to list</a>

    <table class="table-condensed">
        <tr>
            <td>Id</td>
            <td>${entity.id}</td>
        </tr>
        <tr>
            <td>Name</td>
            <td>${entity.name}</td>
        </tr>
        <tr>
            <td>Species</td>
            <td>${entity.species}</td>
        </tr>
        <tr>
            <td>Country</td>
            <td>${entity.country}</td>
        </tr>
    </table>
<#else>
    <p class="text text-warning">Bouhou!</p>
</#if>
  </body>
</html>
