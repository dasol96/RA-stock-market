<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Connect Plus</title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="assets/vendors/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="assets/vendors/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" href="assets/vendors/css/vendor.bundle.base.css">
    <!-- endinject -->
    <!-- Plugin css for this page -->
    <link rel="stylesheet" href="assets/vendors/select2/select2.min.css">
    <link rel="stylesheet" href="assets/vendors/select2-bootstrap-theme/select2-bootstrap.min.css">
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <!-- endinject -->
    <!-- Layout styles -->
    <link rel="stylesheet" href="assets/css/style.css">
    <!-- End layout styles -->
    <link rel="shortcut icon" href="assets/images/favicon.png" />
  </head>
  <body>
      <%@ include file="header.jsp" %>
      

        <!-- partial -->
        <div class="main-panel">
          <div class="content-wrapper">
            <div class="page-header">
              
              <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                 
                </ol>
              </nav>
            </div>
            <div class="row">
              <div class="col-12 grid-margin stretch-card">
                <div class="card">
                  <div class="card-body">
                    <h4 class="card-title">RA 투자증권</h4>
                    <p class="card-description"> SignUp </p>
                    
                    <form class="forms-sample" action="insertMember.do" method="post"  enctype="multipart/form-data">
                      <div class="form-group">
                        <label for="exampleInputName1">ID</label>
                        <input type="text" class="form-control" id="mid" name="mid" placeholder="id" required>
                      </div>
                      <div class="form-group">
                        <label for="exampleInputEmail3">Name</label>
                        <input type="text" class="form-control" id="mname" name="mname" placeholder="name" required>
                      </div>
                      <div class="form-group">
                        <label for="exampleInputPassword4">Password</label>
                        <input type="password" class="form-control" id="mpassword" name="mpassword" placeholder="password" required>
                      </div>
                      <div class="form-group">
                        <label for="exampleInputPassword4">Password Check</label>
                        <input type="password" class="form-control" id="mpassword2" name="mpassword2" placeholder="password check" required>
                      </div>
                      <div class="form-group">
                        <label for="exampleInputPassword4">Account</label>
                        <input type="text" class="form-control" id="maccount" name="maccount" placeholder="account" required>
                      </div>
                      <div class="form-group">
                        <label for="exampleInputPassword4">Phone</label>
                        <input type="text" class="form-control" id="mphone" name="mphone" placeholder="phone" required>
                      </div>
                        <!-- 파일 업로드 -->
                      <div class="form-group">
                        <label for="exampleInputPassword4">Picture</label>
                        <input type=file name="uploadFile">
                      </div>
	                  <!-- 파일 업로드 끝 -->
                      
<!-- END -->
					  <div class="form-check">
                     	 <label class="form-check-label text-muted">
                         <input type="checkbox" class="form-check-input"> 개인정보 처리 약관 동의 </label>
                      </div>
                      <input type="submit" class="btn btn-primary mr-2" onclick="signin_check();"value="Submit">
                      <button class="btn btn-light" onclick="location.href='main.do'">Cancel</button>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- content-wrapper ends -->
          
          
          <!-- partial:partials/_footer.html -->
          <footer class="footer">
            <div class="footer-inner-wraper">
              <div class="d-sm-flex justify-content-center justify-content-sm-between">
                <span class="text-muted d-block text-center text-sm-left d-sm-inline-block">Copyright © bootstrapdash.com 2020</span>
                <span class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center"> Free <a href="https://www.bootstrapdash.com/" target="_blank">Bootstrap dashboard templates</a> from Bootstrapdash.com</span>
              </div>
            </div>
          </footer>
          <!-- partial -->
        </div>
        <!-- main-panel ends -->
      </div>
      <!-- page-body-wrapper ends -->
    </div>
    <!--  회원가입 유효성
     <script type="text/javascript">
      function signin_check() {

         var upw = document.getElementById("mpassword");
         var upw2 = document.getElementById("mpassword2");

         var name = document.getElementById("mname");
         var mid = document.getElementById("mid");

         var handphone = document.getElementById("mphone");

         var checkboxp = document.getElementById("policyp");
         var checkboxs = document.getElementById("policys");

         //값을 입력하지 않았을때 alert창
         if (name.value == "") {
            alert("이름을 입력하세요.");
            name.focus();
            return false; //아래코드부터 진행되지 않도록
         }

         var pattern_num = /[0-9]/;
         var pattern_spc = /[~!@#$%^&*()_+|<>?:{}]/;

         if (name.value.indexOf(" ") >= 0 || pattern_spc.test(name.value)
               || pattern_num.test(name.value)) {
            alert("한글과 영문 대 소문자를 사용하세요. (특수기호, 공백 사용 불가)");
            name.focus();
            return false; //아래코드부터 진행되지 않도록
         }


         if (mid.value == "") {
            alert("아이디를 입력하세요.");
            mid.focus();
            return false;
         }
         
         if (upw.value == "") {
            alert("비밀번호를 입력하세요.");
            upw.focus();
            return false;
         }

         var upwReg = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$/;

         if (!upwReg.test(upw.value)) {
            alert("8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.");
            upw.focus();
            return false;
         }
         if (upw2.value == "") {
            alert("비밀번호 확인란을 입력하세요.");
            upw2.focus();
            return false;
         }
         if (upw.value != upw2.value) {
            alert("비밀번호가 일치하지 않습니다.");
            upw2.focus();
            return false;
         }

         if (handphone.value == "") {
            alert("핸드폰번호를 입력하세요.");
            handphone.focus();
            return false;
         }
         var handphoneReg = /^(?=.*[0-9]).{11}$/;

         if (!handphoneReg.test(handphone.value)) {
            alert("형식에 맞지 않는 번호입니다.");
            handphone.focus();
            return false;
         }

         if (phonecheck.value == "") {
            alert("핸드폰 인증번호를 입력하세요.");
            phonecheck.focus();
            return false;
         }

         if(!checkboxp.checked){
            alert("개인정보처리는 필수동의 사항입니다.");
            return false;
        }
         if(!checkboxs.checked){
            alert("서비스약관은 필수동의 사항입니다.");
            return false;
         }
         
         alert("회원가입을 축하드립니다!!");
         location.href = 'signin.jsp';
      }
   </script> -->
    
    <!-- container-scroller -->
    <!-- plugins:js -->
    <script src="assets/vendors/js/vendor.bundle.base.js"></script>
    <!-- endinject -->
    <!-- Plugin js for this page -->
    <script src="assets/vendors/select2/select2.min.js"></script>
    <script src="assets/vendors/typeahead.js/typeahead.bundle.min.js"></script>
    <!-- End plugin js for this page -->
    <!-- inject:js -->
    <script src="assets/js/off-canvas.js"></script>
    <script src="assets/js/hoverable-collapse.js"></script>
    <script src="assets/js/misc.js"></script>
    <!-- endinject -->
    <!-- Custom js for this page -->
    <script src="assets/js/file-upload.js"></script>
    <script src="assets/js/typeahead.js"></script>
    <script src="assets/js/select2.js"></script>
    <!-- End custom js for this page -->
  </body>
</html>