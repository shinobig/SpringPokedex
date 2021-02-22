<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<body>
<h2>Testing Intellij</h2>
<%@ include file="poke-card.jsp" %>

<c:forEach var="pokemon" items="${allPokemons.allPokemon}">

Pokemon = ${pokemon.value.name}
<br />
</c:forEach>


</body>
</html>