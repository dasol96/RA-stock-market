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
    <div class="container-scroller">
     	<%@ include file="header.jsp"  %>
     
        <!-- partial -->
        <div class="main-panel">
          <div class="content-wrapper">
            <div class="row">
              <div class="col-12 grid-margin stretch-card">
                <div class="card">
                  <div class="card-body">
                    <h4 class="card-title">회원 정보 수정</h4>
                   
                    <form class="forms-sample" action="updateMember.do" method="post">
                      <div class="form-group">
                        <label for="exampleInputName1">ID</label>
                        <input type="text" class="form-control" id="mid" name="mid" value="${mdata.mid }" readonly>
                      </div>
                      <div class="form-group">
                        <label for="exampleInputEmail3">Name</label>
                        <input type="text" class="form-control" id="mname" name="mname" value="${mdata.mname }">
                      </div>
                      <div class="form-group">
                        <label for="exampleInputPassword4">Password</label>
                        <input type="password" class="form-control" id="mpassword" name="mpassword" value="${mdata.mpassword }">
                      </div>
                      <div class="form-group">
                        <label for="exampleInputPassword4">Account</label>
                        <input type="text" class="form-control" id="maccount" name="maccount" value="${mdata.maccount }">
                      </div>
                      <div class="form-group">
                        <label for="exampleInputPassword4">Phone</label>
                        <input type="text" class="form-control" id="mphone" name="mphone" value="${mdata.mphone }">
                      </div>
                      <div style="text-align: right;">
                      <input type="submit" class="btn btn-primary mr-2" value="수정하기">
                      <button class="btn btn-light" onclick="location.href='deleteMember.do?mid=${mdata.mid}'">회원 탈퇴하기</button>
                    </div>
                    </form>
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