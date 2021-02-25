<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/stylesheet.css">
  <link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet">
</head>
<body>
<div class="container">
<div class="row">
<div class="col-md-12 col-xs-12 main-header">
<h2>Hello, welcome to my Spring Pokemon App!</h2>
<img class="poke-image" src="https://upload.wikimedia.org/wikipedia/commons/thumb/9/98/International_Pok%C3%A9mon_logo.svg/1024px-International_Pok%C3%A9mon_logo.svg.png" />
<h4>This application is for learning purposes only and holds no rights</h4>
</div>
</div>

<div class="row">
<c:forEach var="pokemon" items="${allPokemons.allPokemon}">
<div class="col-md-3">
    <div class="poke-card">

        <h3 class="poke-card-title">${pokemon.value.fixedName}</h3>
        <img class="poke-image-holder" src="${pokemon.value.mainImageUrl}" />
        <br>
        <a class="poke-card-button" href="${pokemon.value.pokemonUrl}">See Pokemon</a>

    </div>
</div>
</c:forEach>

</div>
</div>
</body>
</html>