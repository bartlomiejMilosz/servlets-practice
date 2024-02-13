// Inicjalizacja
var name = "Jan Kowalski";

// Wyświetlenie powitania
document.getElementById("welcomeMessage").innerHTML = "Witaj " + name + "!";

// Generowanie paragrafów
var paragraphsContainer = document.getElementById("paragraphs");
for(var i = 0; i < 5; i++) {
    var paragraph = document.createElement("p");
    paragraph.innerHTML = "Paragraf numer " + i;
    paragraphsContainer.appendChild(paragraph);
}