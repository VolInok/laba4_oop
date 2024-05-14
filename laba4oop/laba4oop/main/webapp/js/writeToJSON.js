let Names = {
    title: "",
    genre: "",
    time: "",
    amount: 0,
    rate: ""
}
function getData(){
    Names.title = document.getElementById("title").value;
    Names.genre = document.getElementById("genre").value;
    Names.time = document.getElementById("time").value;
    Names.amount = document.getElementById("amount").value;
    Names.rate = document.getElementById("rate").value;
    let namesJson = JSON.stringify(Names);
    let xhrWrite = new XMLHttpRequest();
    xhrWrite.open("POST", "write",true);
    xhrWrite.setRequestHeader('Content-Type', 'application/json');
    xhrWrite.send(namesJson);
};