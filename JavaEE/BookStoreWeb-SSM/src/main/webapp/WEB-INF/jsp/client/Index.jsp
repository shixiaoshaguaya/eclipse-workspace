<%@ page language="java"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01  Transitional//EN"  "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible"  content="IE=edge">
    <meta name="viewport"  content="width=device-width,  initial-scale=1">
    <title></title>   
</head>
<body>
    <%@ include file="Header.jsp"%>
    <!-- list-shop -->
    <section class="grid-shop">
       <!-- .grid-shop -->
       <div class="container">
           <div class="row">
               <div class="col-sm-3  col-md-3">
                  <div class="weight">
                      <div class="title">
                          <h2>大类导航</h2>
                      </div>
                      <div  class="product-categories">
                          <ul>
                              <c:forEach  items="${categorys}" var="row">
                              <li><a  href="?category.name=${row.name}">${row.name}<span><i class="fa fa-angle-right"  aria-hidden="true"></i></span></a></li>
                              </c:forEach>                         
                          </ul>
                      </div>
                  </div>
                  <div class="weight">
                      <div class="title">
                          <h2>filter by  price</h2>
                      </div>
                      <div  class="filter-outer">
                          <h3>Price</h3>
                          <!-- Bootstrap  Pricing Slider by ZsharE -->
                          <div  class="button-slider">
                              <div  class="btn-group">
                                 <div  class="btn btn-default">
                                     <p>Range: <strong>$<span  id="sliderValue">100.0</span></strong> -  <strong>$<span  id="sliderValue2">1.700.00</span></strong>  </p>
                                     <input  id="bootstrap-slider" data-slider-min="1"  data-slider-max="1700" data-slider-step="1"  data-slider-value="100" type="text">
                                     <div  class="valueLabelblck">Filter</div>
                                 </div>
                              </div>
                          </div>
                          <!-- End of  Bootstrap Pricing Slider by ZsharE -->
                          <div  class="brands">
                              <h3>Brands</h3>
                              <ul>
                                 <li><a  href="#">Black  <span>(10)</span></a></li>
                                 <li><a  href="#">White   <span>(13)</span></a></li>
                                 <li><a  href="#">Blue  <span>(05)</span></a></li>
                                 <li><a  href="#">Red  <span>(87)</span></a></li>
                                 <li><a  href="#">Screen <span>(40)</span></a></li>
                              </ul>
                          </div>
                          <div  class="color">
                              <h3>Color</h3>
                              <ul>
                                 <li><a  href="#" class="color-1"><span  ></span></a></li>
                                 <li><a  href="#" class="color-2"><span  ></span></a></li>
                                 <li><a  href="#" class="color-3"><span  ></span></a></li>
                                 <li><a  href="#" class="color-4"><span  ></span></a></li>
                                 <li><a  href="#" class="color-5"><span  ></span></a></li>
                                 <li><a  href="#" class="color-6"><span  ></span></a></li>
                                 <li><a  href="#" class="color-7"><span  ></span></a></li>
                              </ul>
                          </div>
                          <div class="size">
                              <h3>Size</h3>
                              <ul>
                                 <li><a  href="#">L </a></li>
                                 <li><a  href="#">M </a></li>
                                 <li><a  href="#">S </a></li>
                                 <li><a  href="#">XL</a></li>
                                 <li><a  href="#">XXL</a></li>
                              </ul>
                          </div>
                      </div>
                  </div>
                  <div class="weight">
                      <div class="title">
                          <h2>Compare  products</h2>
                      </div>
                      <div class="ads-lft">
                          <p>You have no  item to compare. </p> <img  src="assets/images/add-banner2.jpg" alt="add  banner"> </div>
                  </div>
                  <div class="weight">
                      <div class="title">
                          <h2>BEST  PRODUCTS</h2>
                      </div>
                      <div  class="toprating-box">
                          <ul>
                              <li>
                                 <div  class="e-product">
                                     <div  class="pro-img"> <img  src="assets/images/products/digital/5.jpg"  alt="2"> </div>
                                     <div  class="pro-text-outer"> <span>Macbook,  Laptop</span>
                                         <a  href="#">
                                            <h4> Apple Macbook Retina 23’ </h4>
                                         </a>
                                         <p  class="wk-price">$290.00 </p>
                                     </div>
                                 </div>
                              </li>
                              <li>
                                 <div  class="e-product">
                                     <div  class="pro-img"> <img  src="assets/images/products/digital/9.jpg"  alt="2"> </div>
                                     <div  class="pro-text-outer"> <span>Macbook,  Laptop</span>
                                         <a  href="#">
                                            <h4> Apple Macbook Retina 23’ </h4>
                                         </a>
                                         <p  class="wk-price">$290.00 </p>
                                     </div>
                                 </div>
                              </li>
                              <li>
                                 <div  class="e-product">
                                     <div  class="pro-img"> <img  src="assets/images/products/digital/12.jpg"  alt="2"> </div>
                                     <div  class="pro-text-outer"> <span>Macbook,  Laptop</span>
                                         <a  href="#">
                                            <h4> Apple Macbook Retina 23’ </h4>
                                         </a>
                                         <p  class="wk-price">$290.00 </p>
                                     </div>
                                 </div>
                              </li>
                          </ul>
                      </div>
                  </div>
               </div>
               <div class="col-sm-9  col-md-9">
                      <div class="col-xs-12  col-sm-12 col-md-12">
                      <!-- search form -->
                      <form id="searchForm"  class="form-inline" method="get"
                          action="index.action">
                          <input  type="hidden" id="pageNum" name="pageNum"
                              value="${pageInfo.pageNum}"> <input  type="hidden"
                              name="pageSize"  value="${pageInfo.pageSize}">
                          <div  class="form-group">
                              <label  for="title">产品名称</label> <input  type="text"
                                 class="form-control" id="title" name="name"
                                 value="${product.name}" placeholder="产品名称">
                          </div>
                          <div  class="form-group">
                              <label  for="category">产品类别</label> <select  class="form-control"
                                 name='category.name'>
                                 <option  value="">全部</option>
                                 <c:forEach  items="${categorys}" var="row">
                                     <option  value="${row.name}"
                                         <c:if test="${row.name ==  product.category.name}">selected</c:if>>
                                         ${row.name}</option>
                                 </c:forEach>
                              </select>
                          </div>
                          <div  class="form-group">
                              <button  type="submit" id="search-btn" class="btn   btn-flat">
                                 <i  class="fa fa-search"></i>
                              </button>
                          </div>
                      </form>
                      <!-- /.search form -->
                      </div>                
                  <div class="grid-spr">
                      <div class="col-sm-6  col-md-6"> <a href="#"  class="grid-view-icon"><i class="fa  fa-th-large" aria-hidden="true"></i></a> <a  href="#" class="list-view-icon"><i class="fa  fa-list" aria-hidden="true"></i></a>
                          <div  class="select-option">
                              <a class="btn  btn-default btn-select options2">
                                 <input  type="hidden" class="btn-select-input"  id="1" name="1" value="" />
                                 <span  class="btn-select-value">Select an  Item</span>
                                 <span  class="btn-select-arrow fa  fa-angle-down"></span>
                                 <ul>
                                     <li  class="selected">综合</li>
                                     <li>价格降序</li>
                                     <li>价格升序</li>
                                     <li>人气</li>
                                     <li>销量</li>
                                 </ul>
                              </a>
                          </div>
                      </div>
                      <div class="col-sm-6  col-md-6 text-right"> <strong>当前显示${pageInfo.total<pageInfo.pageSize?pageInfo.total:pageInfo.pageSize}项产品<span>,共${pageInfo.total}条数据</span></strong> </div>
                  </div>
                  <c:forEach  items="${pageInfo.list}" var="row">
                  <div class="col-xs-12  col-sm-12 col-md-12">
                      <!-- .pro-text -->
                      <div class="pro-text">
                          <div  class="col-xs-12 col-sm-5 col-md-5">
                              <!-- .pro-img  -->
                              <div  class="pro-img"> <img  src="/upload/${row.imgurl}" alt="2">
                                 <sup  class="sale-tag">sale!</sup>
                                 <!--  .hover-icon -->
                                 <div  class="hover-icon"> <a href="#"><span  class="icon icon-Heart"></span></a> <a  href="#"><span class="icon  icon-Search"></span></a> <a href="#"><span  class="icon icon-Restart"></span></a> </div>
                                 <!--  /.hover-icon -->
                              </div>
                              <!-- /.pro-img  -->
                          </div>                   
                          <div  class="col-xs-12 col-sm-7 col-md-7">
                              <div  class="pro-text-outer list-pro-text">
                                 <span>${row.category.name}</span>
                                 <a  href="#">
                                     <h4>  ${row.name}</h4>
                                 </a>
                                 <div  class="star2">
                                     <ul>
                                         <li  class="yellow-color"><i class="fa fa-star"  aria-hidden="true"></i></li>
                                         <li  class="yellow-color"><i class="fa fa-star"  aria-hidden="true"></i></li>
                                         <li  class="yellow-color"><i class="fa fa-star"  aria-hidden="true"></i></li>
                                         <li  class="yellow-color"><i class="fa fa-star"  aria-hidden="true"></i></li>
                                         <li><i class="fa fa-star"  aria-hidden="true"></i></li>
                                         <li><a href="#">10</a></li>
                                         <li><a href="#">收藏</a></li>
                                     </ul>
                                 </div>
                                 <p  class="wk-price">￥${row.price}</p>
                                 <p>库存：${row.pnum}</p>
                                 <a  href="details.action?pid=${row.id}"  class="add-btn">查看详情</a>
                                 <a href="#"  class="add-btn">加入购物车</a>
                                 <a href="#"  class="add-btn2"><span class="icon  icon-Heart"></span></a>                            
                              </div>
                          </div>
                      </div>
                      <!-- /.pro-text -->
                  </div>
                  </c:forEach>
                  <div class="col-xs-12">
                      <div class="grid-spr  pag">
                          <!-- .pagetions  -->
                          <div  class="col-xs-12 col-sm-6 col-md-6  text-left">
                              <ul  class="pagination">
                                 <li  class="${pageInfo.pageNum==(pageInfo.pageNum>2?pageInfo.pageNum-1:1)?'active':''}">
                                 <a  href="#">${pageInfo.pageNum>2?pageInfo.pageNum-1:1}</a></li>
                                 <li  class="${pageInfo.pageNum==(pageInfo.pageNum>2?pageInfo.pageNum:2)?'active':''}"><a  href="#">${pageInfo.pageNum>2?pageInfo.pageNum:2}</a></li>
                                 <li  class="${pageInfo.pageNum==(pageInfo.pageNum>2?pageInfo.pageNum+1:3)?'active':''}"><a  href="#">${pageInfo.pageNum>2?pageInfo.pageNum+1:3}</a></li>
                                 <li><a  href="#">&raquo;</a></li>
                              </ul>
                          </div>
                          <!-- /.pagetions  -->
                          <!-- .Showing -->
                          <div  class="col-xs-12 col-sm-6 col-md-6  text-right">
                              <strong>当前显示${pageInfo.total<pageInfo.pageSize?pageInfo.total:pageInfo.pageSize}项产品<span>,共${pageInfo.total}条数据</span></strong>
                          </div>
                          <!-- /.Showing -->
                      </div>
                  </div>
               </div>
           </div>
       </div>
       <!-- /.grid-shop -->
    </section>
    
    <%@ include file="Footer.jsp"%>
</body>
</html>