<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <div class="container-scroller">
      <!-- partial:partials/_navbar.html -->
      <c:choose>
      	<c:when test="${mdata.mid!=null}">
      	<nav class="navbar default-layout-navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
        <div class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
          <a class="navbar-brand brand-logo" href="main.do?mid=${mdata.mid}"><img src="assets/images/logo.png" alt="logo" /></a>
          <a class="navbar-brand brand-logo-mini" href="main.do"><img src="assets/images/icon.png" alt="logo" /></a>
        </div>
        <div class="navbar-menu-wrapper d-flex align-items-stretch">
          <button class="navbar-toggler navbar-toggler align-self-center" type="button" data-toggle="minimize">
            <span class="mdi mdi-menu"></span>
          </button>
<!-- 원래 검색창 -->
<!-- HEADER START -->            
          <ul class="navbar-nav navbar-nav-right">
             	          <!-- 다국어 처리 -->
            <li class="nav-item nav-language dropdown d-none d-md-block">
              <a class="nav-link dropdown-toggle" id="languageDropdown" href="" data-toggle="dropdown">
                <div class="nav-language-icon">
                </div>
                <div class="nav-language-text">
                  <p class="mb-1 text-black">Language</p>
                </div>
              </a>
               <div class="dropdown-menu navbar-dropdown" aria-labelledby="languageDropdown">
                <a class="dropdown-item" href="signinlang.do?lang=ko">
                  <div class="nav-language-icon mr-2">
                    <img alt="" src="assets/images/kor_flag.png">
                  </div>
                  <div class="nav-language-text">
                    <p class="mb-1 text-black">한국어</p>
                  </div>
                </a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="signinlang.do?lang=en">
                  <div class="nav-language-icon mr-2">
                  <img alt="" src="assets/images/us_flag.png">
                  </div>
                  <div class="nav-language-text">
                    <p class="mb-1 text-black">English</p>
                  </div>
                </a>
              </div>
            </li>  
            <!-- 다국어처리 끝 -->  
             
            <li class="nav-item nav-profile dropdown">
              <a class="nav-link dropdown-toggle" id="profileDropdown" href="#" data-toggle="dropdown" aria-expanded="false">
				<!-- 로그인 했을 시, 드롭바 나오게 -->
                <div class="nav-profile-img">
                  <img src="images/${mdata.filename}" alt="image">
                </div>
                <div class="nav-profile-text">
                  <p class="mb-1 text-black">${mdata.mid }</p>
                </div>
              </a>
              <div class="dropdown-menu navbar-dropdown dropdown-menu-right p-0 border-0 font-size-sm" aria-labelledby="profileDropdown" data-x-placement="bottom-end">
                <div class="p-3 text-center bg-primary">
				<img  class="img-avatar img-avatar48 img-avatar-thumb" src="images/${mdata.filename}" alt="image">
				
                </div>
                <div class="p-2">
                  <h5 class="dropdown-header text-uppercase pl-2 text-dark">User Options</h5>
                  <a class="dropdown-item py-1 d-flex align-items-center justify-content-between" href="mypage.do?mid=${mdata.mid}">
                    <span>MyPage</span>
                    <span class="p-0">
                      <i class="mdi mdi-account-outline ml-1"></i>
                    </span>
                  </a>
                  
                  <div role="separator" class="dropdown-divider"></div>
                  <h5 class="dropdown-header text-uppercase  pl-2 text-dark mt-2">Actions</h5>
                  <a class="dropdown-item py-1 d-flex align-items-center justify-content-between" href="setting.do?mid=${mdata.mid}">
                    <span>Settings</span>
                    <i class="mdi mdi-settings"></i>
                  </a>
                  <a class="dropdown-item py-1 d-flex align-items-center justify-content-between" href="logout.do">
                    <span>Log Out</span>
                    <i class="mdi mdi-logout ml-1"></i>
                  </a>
                </div>
              </div>
              <!-- 로그인 안했을때 이거 뜨게 -->
            </li>
           </ul>   
      </nav>
      </div>
<!-- HEADER END --> 

     <!-- partial -->
      <div class="container-fluid page-body-wrapper">
        <!-- partial:partials/_sidebar.html -->
        <nav class="sidebar sidebar-offcanvas" id="sidebar">
          <ul class="nav">
          <li class="nav-item sidebar-user-actions">
              <div class="user-details">
                <div class="d-flex justify-content-between align-items-center">
                  <div>
                    <div class="d-flex align-items-center">
                      <div class="sidebar-profile-img">
                        <img src="assets/images/faces/face28.png" alt="image">
                      </div>
                      <div class="sidebar-profile-text">
                        <p class="mb-1">${mdata.mid }</p>
                      </div>
                    </div>
                  </div>
                  <div class="badge badge-danger">3</div>
                </div>
              </div>
            </li>
            <li class="nav-item sidebar-user-actions">
              <div class="sidebar-user-menu">
                <a href="mypage.do?mid=${mdata.mid}" class="nav-link"><i class="mdi mdi-speedometer menu-icon"></i>
                  <span class="menu-title">MyPage</span></a>
              </div>
            </li>
            <li class="nav-item sidebar-user-actions">
              <div class="sidebar-user-menu">
                <a href="setting.do?mid=${mdata.mid}" class="nav-link"><i class="mdi mdi-settings menu-icon"></i>
                  <span class="menu-title">Settings</span>
                </a>
              </div>
            </li>
            <li class="nav-item sidebar-user-actions">
              <div class="sidebar-user-menu">
                <a href="logout.do" class="nav-link"><i class="mdi mdi-logout menu-icon"></i>
                  <span class="menu-title">Log Out</span></a>
              </div>
            </li>
            <li class="nav-item nav-category">Main</li>
            <li class="nav-item">
              <a class="nav-link" href="https://finance.naver.com/news/mainnews.naver">
                <span class="icon-bg"><i class="mdi mdi-cube menu-icon"></i></span>
                <span class="menu-title">증권 뉴스 보기</span>
              </a>
            </li>
          </ul>
        </nav>
        <!-- partial -->
        <div class="main-panel">
          <div class="content-wrapper">
            <div class="page-header">
              <h3 class="page-title"></h3>
              <nav aria-label="breadcrumb">

              </nav>
            </div>   
      	</c:when>
      	<c:otherwise>
      		<nav class="navbar default-layout-navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
        <div class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
          <a class="navbar-brand brand-logo" href="main.do"><img src="assets/images/logo.png" alt="logo" /></a>
          <a class="navbar-brand brand-logo-mini" href="main.do"><img src="assets/images/icon.png" alt="logo" /></a>
        </div>
        <div class="navbar-menu-wrapper d-flex align-items-stretch">
          <button class="navbar-toggler navbar-toggler align-self-center" type="button" data-toggle="minimize">
            <span class="mdi mdi-menu"></span>
          </button>
<!-- 원래 검색창 -->
          <ul class="navbar-nav navbar-nav-right">
            
<!-- HEADER START -->            
            <li class="nav-item nav-profile dropdown">
            	          <!-- 다국어 처리 -->
            <li class="nav-item nav-language dropdown d-none d-md-block">
              <a class="nav-link dropdown-toggle" id="languageDropdown" href="" data-toggle="dropdown">
                <div class="nav-language-icon">
                </div>
                <div class="nav-language-text">
                  <p class="mb-1 text-black">Language</p>
                </div>
              </a>
               <div class="dropdown-menu navbar-dropdown" aria-labelledby="languageDropdown">
                <a class="dropdown-item" href="signinlang.do?lang=ko">
                  <div class="nav-language-icon mr-2">
                    <img alt="" src="assets/images/kor_flag.png">
                  </div>
                  <div class="nav-language-text">
                    <p class="mb-1 text-black">한국어</p>
                  </div>
                </a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="signinlang.do?lang=en">
                  <div class="nav-language-icon mr-2">
                  <img alt="" src="assets/images/us_flag.png">
                  </div>
                  <div class="nav-language-text">
                    <p class="mb-1 text-black">English</p>
                  </div>
                </a>
              </div>
            </li>  
            <!-- 다국어처리 끝 -->  
              <!-- 로그인 안했을때 이거 뜨게 -->
            </li>
             <li class="nav-item  dropdown d-none d-md-block">
              <button type="button" class="btn btn-inverse-primary btn-fw" onclick="location.href='signinlang.do'">SIGNIN</button>
            </li>
            <li>
            	&ensp;
            </li>
            <li class="nav-item  dropdown d-none d-md-block">
              <button type="button" class="btn btn-inverse-primary btn-fw" onclick="location.href='signup.jsp'">SIGNUP</button>
            </li>
           </ul>   
      </nav>
      </div>
<!-- HEADER END --> 

     <!-- partial -->
      <div class="container-fluid page-body-wrapper">
        <!-- partial:partials/_sidebar.html -->
        <nav class="sidebar sidebar-offcanvas" id="sidebar">
          <ul class="nav">
          <li class="nav-item sidebar-user-actions">
              <div class="user-details">
                <div class="d-flex justify-content-between align-items-center">
                  <div>
                    <div class="d-flex align-items-center">
                      <div class="sidebar-profile-img">
                        <img src="assets/images/faces/face28.png" alt="image">
                      </div>
                      <div class="sidebar-profile-text">
                        <p class="mb-1"></p>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </li>
            <li class="nav-item sidebar-user-actions">
              <div class="sidebar-user-menu">
                <a href="signinlang.do" class="nav-link"><i class="mdi mdi-logout menu-icon"></i>
                  <span class="menu-title">SIGNIN</span></a>
              </div>
            </li>
            <li class="nav-item sidebar-user-actions">
              <div class="sidebar-user-menu">
                <a href="signup.jsp" class="nav-link"><i class="mdi mdi-logout menu-icon"></i>
                  <span class="menu-title">SignUp</span></a>
              </div>
            </li>
            <li class="nav-item nav-category">Main</li>
            <li class="nav-item">
              <a class="nav-link" href="https://finance.naver.com/news/mainnews.naver">
                <span class="icon-bg"><i class="mdi mdi-cube menu-icon"></i></span>
                <span class="menu-title">증권 뉴스 보기</span>
              </a>
            </li>     
          </ul>
        </nav>
        <!-- partial -->
        <div class="main-panel">
          <div class="content-wrapper">
            <div class="page-header">
              <h3 class="page-title"></h3>
              <nav aria-label="breadcrumb">

              </nav>
            </div>   
      	</c:otherwise>
      </c:choose>
      
</body>
</html>