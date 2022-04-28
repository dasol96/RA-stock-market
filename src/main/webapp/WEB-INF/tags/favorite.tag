<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ attribute name="favorite"%>

<c:choose>
		<c:when test="${mdata.mid!=null and fdatas!=null}">
			<div class="col-lg-12 grid-margin stretch-card">
				<div class="card" style="margin-top: 20px;">
					<div class="card-body">
						<h4 class="card-title">${mdata.mid}님의즐겨찾기 목록</h4>
						<table class="table table-striped">
							<thead>
								<tr>
									<th>번호</th> 
									<th>종목명</th>
									<th>현재가</th>
									<th>전일비</th>
									<th>등락률</th>
									<th>거래량</th>
									<th>즐겨찾기 취소</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="v" items="${fdatas}">
									<tr>
										<td><a href="detail.do?spk=${v.spk}&mid=${mdata.mid}">${v.spk}</a></td>
										<td>${v.sname}</td>
										<td>${v.snprice}</td>
										<td>${v.sypriceupdown}</td>
										<td>${v.snpercent}</td>
										<td>${v.sntrade}</td>
										<td>&ensp; &ensp;
											<button type="button" class="btn btn-outline-secondary">
												<a href="delfav.do?mid=${mdata.mid}&spk=${v.spk}"><i
													class="mdi mdi-close"></i></a>
										</td>
									</tr>

								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</c:when>
		
		<c:otherwise>

		</c:otherwise>
		
</c:choose>

