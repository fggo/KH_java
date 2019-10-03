/**
 * 
 */

var isToggled = "false";
function addToggleEvent(btn, url, dataType, find, area){
  btn.click(function(){
  })
}
$(function(){
  $('#toggleInsert').click(function(){
    isToggled = !isToggled;
    if(isToggled){
      $('#insertEmp').html("");
      return;
    }
    $.ajax({
      type: "POST",
      url: "${path }/insertEmp.do",
      dataType: "html",
      success: function(data){
        html = $('<div>').html(data);
        $('#insertEmp').html(html.find('div#insertFrm'));
      },
      error: function(request, status, error){
        alert("insertEmp.do ajax ERROR!");
      }
    });
  });
});