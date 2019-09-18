<!DOCTYPE html>
<html>
<head>
<style>
div.container {
    width: 100%;
    border: 1px solid gray;
}

header, footer {
    padding: 1em;
    color: #4b0082;
    background-color: #e5e5e5;
    clear: left;
    text-align: center;
}

nav {
    float: left;
    max-width: 160px;
    margin: 0;
    padding: 1em;
}
nav ul {
    list-style-type: none;
    padding: 0;
}
   
nav ul a {
    text-decoration: none;
}

article {
    margin-left: 170px;
    border-left: 1px solid gray;
    padding: 1em;
    overflow: hidden;
}

form {  /* set width in form, not fieldset (still takes up more room w/ fieldset width */
  font:100% verdana,arial,sans-serif;
  margin: 0;
  padding: 0;
  min-width: 500px;
  max-width: 600px;
  width: 560px; 
}

form fieldset {
  / * clear: both; note that this clear causes inputs to break to left in ie5.x mac, commented out */
  border-color: #000;
  border-width: 1px;
  border-style: solid;
  padding: 10px;        /* padding in fieldset support spotty in IE */
  margin: 0;
}

form fieldset legend {
	font-size:1.1em; /* bump up legend font size, not too large or it'll overwrite border on left */
                       /* be careful with padding, it'll shift the nice offset on top of border  */
}

form label { 
	display: block;  /* block float the labels to left column, set a width */
	float: left; 
	width: 150px; 
	padding: 0; 
	margin: 5px 0 0; /* set top margin same as form input - textarea etc. elements */
	text-align: right; 
}

form fieldset label:first-letter { /* use first-letter pseudo-class to underline accesskey, note that */
	text-decoration:underline;    /* Firefox 1.07 WIN and Explorer 5.2 Mac don't support first-letter */
                                    /* pseudo-class on legend elements, but do support it on label elements */
                                    /* we instead underline first letter on each label element and accesskey */
                                    /* each input. doing only legends would  lessens cognitive load */
                                   /* opera breaks after first letter underlined legends but not labels */
}

form input, form textarea {
	/* display: inline; inline display must not be set or will hide submit buttons in IE 5x mac */
	width:auto;      /* set width of form elements to auto-size, otherwise watch for wrap on resize */
	margin:5px 0 0 10px; /* set margin on left of form elements rather than right of
                              label aligns textarea better in IE */
}

form input#submit {
	margin-left:200px; /* set margin-left back to zero on reset button (set above) */
}

textarea { overflow: auto; }

form small {
	display: block;
	margin: 0 0 5px 160px; /* instructions/comments left margin set to align w/ right column inputs */
	padding: 1px 3px;
	font-size: 88%;
}

form .required{font-weight:bold;} /* uses class instead of div, more efficient */

form br {
	clear:left; /* setting clear on inputs didn't work consistently, so brs added for degrade */
}
-->
</style>
<script>
<!--
function sf(){document.f.firstname.focus();}
-->
</script>

</head>

<body>
<div class="container">

<header>
   <h1>Club De Lectura</h1>
</header>
  

<article>
<form action="?method=PUT" method="POST">

<fieldset>
<legend>Informacion del Libro</legend>
	<label>Titulo: </label>
		<input type="text" name="title" size="55" value="${title!"Titulo del Libro"}"><br>
	<label>Autor: </label>
		<input type="text" name="lastName" size="55" value="${lastName!"Autor del Libro"}"><br>
</fieldset>
<fieldset>
<legend>Lugar de Reunion</legend>
	<label>Contacto: </label>
		<input type="text" name="line1" size="55" value="${line1!"Tu Nombre"}"><br>
	<label>Direccion: </label>
		<input type="text" name="line2" size="55" value="${line2!"Direccion de la Reunion"}"><br>
        <label>Ciudad: </label>
		<input type="text" name="city" size="55" value="${city!"Ciudad"}"><br> 
        <label>Codigo Postal: </label>
		<input type="text" name="zipcode" size="5" value="${zipcode!"99999"}"><br>
</fieldset>
<fieldset>
<legend>Fecha</legend>
	<label>Mes: </label>
		<input type="text" name="name" size="55" value="${name!"Mes del Libro"}"><br>
	<label>Dia: </label>
		<input type="number" name="age" size="2" value="${age!1}"><br>
        <label>Hora: </label>
		<input type="text" name="country" size="20" value="${country!"6:30 PM"}"><br>
</fieldset>
<fieldset>
<legend></legend>
	<input type="submit" value="Modificar" id="submit">
</fieldset>
</form>
</article>

<footer></footer>

</div>

</body>
</html>
