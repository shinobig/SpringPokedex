<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/stylesheet.css">
</head>
<body>
<div class="container">
<h2>Testing Intellij</h2>
<div class="row">
<c:forEach var="pokemon" items="${allPokemons.allPokemon}">
<div class="col-md-3">
    <div class="poke-card">

        <h3>${pokemon.value.name}</h3>
        <div >
        <img class="poke-image-holder" src="${pokemon.value.mainImageUrl}" />
            <button >See pokemon</button>
        </div>
    </div>
</div>
</c:forEach>

</div>
</div>
</body>
</html>