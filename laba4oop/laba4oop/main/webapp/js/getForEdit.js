let Names = {
    title: "",
    genre: "",
    time: "",
    amount: 0,
    rate: "",
    idInDatabase: 0
}
function sendEditedNames(){
    let xhrEdit = new XMLHttpRequest();
    Names.title=document.getElementById("title").value;
    Names.genre=document.getElementById("genre").value;
    Names.time=document.getElementById("time").value;
    Names.amount=document.getElementById("amount").value;
    Names.rate=document.getElementById("rate").value;
    Names.idInDatabase=location.search.split("=")[1];
    let namesJson = JSON.stringify(Names);
    console.log(Names);
    xhrEdit.open("POST", "saveChanges",true);
    xhrEdit.setRequestHeader('Content-Type', 'application/json');
    xhrEdit.send(namesJson);
    location.href="read"
}