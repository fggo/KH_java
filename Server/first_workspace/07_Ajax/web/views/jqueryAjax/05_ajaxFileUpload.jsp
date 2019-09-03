<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <!-- CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
  <!-- jQuery -->
  <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
  <!-- JS -->
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  <title>ajax로 파일 업로드하기</title>
</head>
<body>
  <form name="ajaxFile" method="post"
        enctype="multipart/form-data">
        <input type="file" name="ajaxFileTest" multiple/>
        <!-- multiple attribute : 파일 여러개 선택가능 -->
        <button type="button" id="btn">업로드</button>
  </form>
  <div id="image"></div>
  <script>
    $(function(){
      //div에 이미지 출력하기
      $("[name=ajaxFileTest]").change(function(){
        // var reader = new FileReader();
        // reader.onload = function(e){ //e.target.result: 변환주소
        //   var img = $('<img>').attr("src", e.target.result)
        //                       .css({"width": "100px", "height": "100px"});
        //   $('#image').append(img);
        // }
        // reader.readAsDataURL(ajaxFile.ajaxFileTest.files[0]); // $(this)[0].files[0];
        // // name이 ajaxFileTest인 input이 하나밖에 없으므로 [0]
        // // 파일 한개 올린것이므로 files[0]

        //multiple files
        //item: image files[0]...[n]
        $.each($(this)[0].files, function(i, item){
          var reader = new FileReader();

          reader.onload = function(e){
            var img = $('<img>').attr("src", e.target.result)
                                .css({"width": "100px", "height": "100px"});
            $('#image').append(img);
          };

          reader.readAsDataURL(item); // $(this)[0].files[i];
        });
      });
    });

    $('#btn').click(function(){
      //보낼 데이터 -> 업로드파일 설정
      var fd = new FormData();
      //업로드 파일을 formData에 추가함.
      // fd.append("bs", ajaxFile.ajaxFileTest.files[0]); //parameter "bs"

      //여러개 파일을 업로드
      $.each(ajaxFile.ajaxFileTest.files, function(i, item){
        fd.append("bs" + i, item);
      });
      $.ajax({
        url: "<%=request.getContextPath() %>/ajaxUpload",
        data: fd,
        type: "POST",
        processData: false,
        contentType: false,
        success: function(data){
          alert("upload complete!!!");
          $('#image').html("");
          $('[name=ajaxFileTest]').val("");
        }
      });
    });
  </script>

</body>
</html>