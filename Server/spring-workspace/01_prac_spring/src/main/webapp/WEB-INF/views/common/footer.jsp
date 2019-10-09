<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

  <div class="container footer card my-5 w-100 form">
    <div class="input-group">
      <div class="input-group-append">
        <span class="input-group-text attach_btn"><i class="fas fa-paperclip"></i></span>
      </div>
      <textarea name="" class="form-control type_msg" placeholder="Type your message..." style="resize:none;"></textarea>
      <div class="input-group-append">
        <span class="input-group-text send_btn"><i class="fas fa-location-arrow"></i></span>
      </div>
    </div>

    <!-- <button type="button" class="form-control btn btn-sm">attach</button>
    <textarea name="" id="" rows="3" style="resize:none;" placeholder="hello footer"></textarea>
    <button type="button" class="form-control btn btn-sm">submit</button> -->
  </div>

  <!-- Popper.JS -->
  <!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script> -->
  <!-- Bootstrap JS -->
  <!-- <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script> -->
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"
    integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
  <!-- jQuery Custom Scroller CDN -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.concat.min.js"></script>

  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

  <script>
    var insertToggled = false;
    var searchToggled = false;
    var updateToggled = false;
    var deleteToggled = false;

    $(function(){
      $('#toggleInsertBtn').click(function(e){

        if(insertToggled)
          $('#insertArea').html("");
        else{
          $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath }/insertEmp.do",
            dataType: "html",
            success: function(data){
              html = $('<div>').html(data);

              $('#insertArea').html(html.find("div#insertFrm"));
            },
            error: function(request, status, error){
              console.log(error);
              alert("insert ajax ERROR!");
            }
          });
        }
        insertToggled = !insertToggled;
      });

      $("#sidebar").mCustomScrollbar({
        theme: "minimal"
      });

      // $('#sidebarCollapse').on('click', function () {
      //   $('#sidebar, #content').toggleClass('active');
      //   $('.collapse.in').toggleClass('in');
      //   $('a[aria-expanded=true]').attr('aria-expanded', 'false');
      // });
    });
  </script>
  </div>
</body>
</html>
