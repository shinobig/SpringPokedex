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



<div class="col-md-2">
   <div class="poke-button-next">
   <h4 style="color:#424242;" class="poke-button-title">${pokemonBefore.fixedName}</h4>
   <img style="width: 100%" src="${pokemonBefore.icon}" />
   </div>
   </a>
</div>






<div class="col-md-8">
<div class="poke-card">
<div class="single-pokemon-name-holder">
<h2>${pokemonToDisplay.fixedName}</h2>
</div>
<div class="row">
<div class="col-md-6">
<div class="poke-card">
<div class="row justify-content-md-center">
<c:forEach var="type" items="${pokemonToDisplay.types}">
<div class="col-md-6">
<div class="${type}">
${type}
</div>
</div>

</c:forEach>
</div>
</div>
</div>
<div class="col-md-6">

<img class="single-pokemon-image-holder" src="${pokemonToDisplay.mainImageUrl}" />
</div>
</div>
</div>
</div>

<div class="col-md-2">
   <a  href="${pokemonAfter.pokemonUrl}">
   <div class="poke-button-next">
   <h4 style="color:#424242;" class="poke-button-title">${pokemonAfter.fixedName}</h4>
   <img style="width: 100%" src="${pokemonAfter.icon}" />
   </div>
   </a>

</div>


</div>
</div>
</body>
</html>