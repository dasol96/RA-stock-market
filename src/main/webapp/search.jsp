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
      
            
<!-- 검색 추가 -->
        <div class="main-panel">
          <div class="content-wrapper">
            <div class="search-field d-none d-xl-block">
            
            <form class="d-flex align-items-center h-100" action="search.do" method="post"><!-- 첫 메인페이지 selectAll 실행 > 검색시 selectAll_name 실행  다른곳에서 main.do는 selectAll 그럼 컨트롤러에서 searchstock!=null이라면 selectAll_name 실행-->
              <div class="input-group">
                <div class="input-group-prepend bg-transparent">
                  <i class="input-group-text border-0 mdi mdi-magnify"></i>
                </div>
                <input type="text" class="form-control bg-transparent border-0" name="SearchCondition" placeholder="Search products">
                <input type="submit" class="btn btn-outline-primary btn-fw" value="검색">
              </div>
            </form>
            
          </div>
          
            <div class="row">                
              <div class="col-lg-12 grid-margin stretch-card">
                <div class="card">
                  <div class="card-body">
                    <h4 class="card-title">종목 List</h4>
                    <table class="table table-bordered">
                      <thead>
                        <tr>
                          <th> 번호 </th>
                          <th> 종목명 </th>
                          <th> 현재가 </th>
                          <th> 전일비 </th>
                          <th> 등락률 </th>
                          <th> 거래량 </th>                          
                        </tr>
                      </thead>
                      <tbody>
                      <c:forEach var="s" items="${sdatas }">
                        <tr>
                          <td class="py-1"> <a href="detail.do?spk=${s.spk }">${s.spk }</a></td>
                          <td> ${s.sname } </td>
                          <td> ${s.snprice }</td>
                          <td> ${s.sypriceupdown } </td>
                          <td> ${s.snpercent } </td>
                          <td> ${s.sntrade } </td>
                        </tr>
                       </c:forEach>

                      </tbody>
                    </table>
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
    <!-- End plugin js for this page -->
    <!-- inject:js -->
    <script src="assets/js/off-canvas.js"></script>
    <script src="assets/js/hoverable-collapse.js"></script>
    <script src="assets/js/misc.js"></script>
    <!-- endinject -->
    <!-- Custom js for this page -->
    <!-- End custom js for this page -->
  </body>
</html>