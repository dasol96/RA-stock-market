<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
            
              <div class="col-lg-12 grid-margin stretch-card">
                <div class="card">
                  <div class="card-body">
                  <!-- 인출기능 -->
	                <h4 class="card-title">${mdata.mid } 님의 지갑</h4>
	                <hr>
	                <form action="takeMoney.do?mid=${mdata.mid }" method="post">
	                <input type="hidden" name=mmoney value=${mdata.mmoney }>
	                <select class="btn btn-inverse-primary btn-fw" name="inOrOut" style="margin-top: -5px;">
	                	<option value="0" style="cursor: pointer;" >선택</option>
	                	<option value="1" style="cursor: pointer;" >입금</option>
	                	<option value="2" style="cursor: pointer;" >인출</option>
	                </select>
	                <input type="text" class="blockquote" placeholder="입금/출금할 금액을 입력하세요" name="inOrOutMoney" style="width:520px; height:40px;">
	                <input type="submit"class="btn btn-primary" value="확인" style="margin-top: -7px; margin-left:5px;">
	                </form>
	                <div class="col-lg-12 grid-margin stretch-card">
                <div class="card">
                  <div class="card-body">
                    <h5 class="card-title">현재 보유 자금</h5>
                    </p>
                    <table class="table table-bordered">

                      <tbody>
                        <tr>
                          <td> ${mdata.mmoney } 원</td>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
                  
                  	<hr>
                    <h4 class="card-title">${mdata.mid }님의 보유 종목 List</h4>
                    </p>
                    <table class="table table-bordered">
                      <thead>
                        <tr>
                          <th style="text-align: center;"> 번호 </th>
                          <th style="text-align: center;"> 종목명 </th>
                          <th style="text-align: center;"> 소유 갯수 </th>
                          <th style="text-align: center;"> 구매가 </th>
                          <th style="text-align: center;"> 현재가 </th>                      
                        </tr>
                      </thead>
                      <tbody>
                        <c:forEach var="h" items="${hdatas}">
                        <tr>
                          <td style="text-align: center;"> <a href="detail.do?spk=${h.hpk}&mid=${mdata.mid}">${h.hpk}</a> </td>
                          <td style="text-align: center;"> ${h.hsname} </td>
                          <td style="text-align: right;"> ${h.hscnt} </td>
                          <td style="text-align: right;"> ${h.hsbuyprice} </td>
							<c:choose>
								<c:when test="${h.hsnowprice==0 }">
									<td style="text-align: right;">-</td>
								</c:when>
								<c:otherwise>
                          		<td style="text-align: right;"> ${h.hsnowprice} </td>
                          		</c:otherwise>
							</c:choose>
                        </tr>
                        </c:forEach>
                        </tr>
                        <!-- 여기서부터도 foreach로 삭제 예정 -->
                        
                      </tbody>
                    </table>
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