function writeWhatIamTyping() {
    var input =document.getElementById("whatIamtyping");
    var text=document.getElementById("typeing");

    var inputStr=input.value;
    text.innerHTML=inputStr;
}
function changeColor() {
    var btnsearch=document.getElementById("btnsearch");
    btnsearch.style="background: red";
}
function showHide(){
    var btnsearch=document.getElementById("btnsearch");
    btnsearch.style="display: none";
}