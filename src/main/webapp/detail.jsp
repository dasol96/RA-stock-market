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
            <div class="row">
              <div class="col-lg-12 grid-margin stretch-card">
                <div class="card">
                  <div class="card-body">
                    <h4 class="card-title">상세 주식 정보 &ensp;&ensp;<button type="button" class="btn btn-inverse-primary btn-rounded btn-icon" onclick="location.href='updatecrw.do?spk=${sdata.spk}&mid=${mdata.mid}'">
                       	 <i class="mdi mdi-sync"></i>
                   	 	</button></h4>
                     
                    	
                  
                    <table class="table table-striped">
                      <thead>
                        <tr>
                          <th style="text-align: center;"> 즐겨찾기 </th>
                          <th style="text-align: center;"> 번호 </th>
                          <th style="text-align: center;"> 종목명 </th>
                          <th style="text-align: center;"> 현재가 </th>
                          <th style="text-align: center;"> 전일비 </th>
                          <th style="text-align: center;"> 등락률 </th>
                          <th style="text-align: center;"> 거래량 </th>     
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                        <td class="py-1"><a href="infav.do?spk=${sdata.spk}&mid=${mdata.mid}">
                        	&ensp;&ensp;&ensp;&ensp;<i class="mdi mdi-heart" id="favoritebtn"></i>       	
                          </a>
                          </td>
                          <td style="text-align: center;"> ${sdata.spk } </td>
                          <td style="text-align: center;"> ${sdata.sname } </td>
                          <td style="text-align: right;"> ${sdata.snprice }원 </td>
                          <td style="text-align: right;"> ${sdata.sypriceupdown }원 </td>
                          <td style="text-align: right;"> ${sdata.snpercent }% </td>
                          <td style="text-align: right;"> ${sdata.sntrade }개 </td>
                        </tr>
                        <tr>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
              <div class="card-body" style="padding:0px;">
              <form action="buyOrSellStock.do" method="post">
              <input type="hidden" name="hpk" value="${sdata.spk}">
              <input type="hidden" name="mid" value="${mdata.mid}">
              <input type="hidden" name="spk" value="${sdata.spk}">
              <input type="hidden" name="hscnt" value="${hdata.hscnt}">
              <div class="col-lg-12 stretch-card">
                <div class="card">
                  <div class="card-body">
                    <h4 class="card-title">Table with contextual classes</h4>

					<!-- 매수 가능금액 -->
					<div class="template-demo">
						<h3>매수 가능 금액 : ${mdata.mmoney}</h3>
					</div>
					<!-- 매도 가능갯수 -->
					<div class="template-demo">
						<h3>매도 가능 갯수 : ${hdata.hscnt }</h3>
					</div>
                    <!-- 매수 매도 -->
                    <div class="template-demo" style="margin-top:20px;">
                    <select class="btn btn-inverse-primary btn-fw" name="moneyCondition" style="cursor:pointer">
                    		<option style="cursor: pointer;" value="1">매수</option>
							<option style="cursor: pointer;" value="2">매도</option>
					</select>
					
					<input type="text" class="blockquote" name="moneykeyword" placeholder="갯수를 입력하세요" style="width: 480px; height: 40px;">
					<input type="submit" class="btn btn-primary" value="선택" style="margin-top:-8px; margin-left:11px; ">
                   
                    </div>
                  </div>
                </div>
              </div>
               </form>
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
    <!-- End custom js for this page  -->
      
      
    

  </body>
</html>