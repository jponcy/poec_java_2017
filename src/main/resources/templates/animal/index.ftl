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
    <h1>Animals list</h1>

    <#list animals>
    <table class="table table-hover table-stripped">
        <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Species</th>
                <th>Country</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
        <#items as entity>
            <tr>
                <td>${ entity.getId() }</td>
                <td>${ entity.getName() }</td>
                <td>${ entity.getSpecies() }</td>
                <td>${ entity.getCountry() }</td>
                <td>
                    <a
                        class="btn btn-default btn-show"
                        href="/animal/${entity.id}">
                        Show
                    </a>
                </td>
            </tr>
        </#items>
        </tbody>
    </table>
    <#else>
    <p class="text text-warning">No animals!</p>
    </#list>
  </body>
</html>
