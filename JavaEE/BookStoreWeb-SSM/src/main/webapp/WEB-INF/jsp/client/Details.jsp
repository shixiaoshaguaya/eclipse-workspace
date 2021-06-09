<%@ page language="java"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01  Transitional//EN"  "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible"  content="IE=edge">
    <meta name="viewport"  content="width=device-width,  initial-scale=1">
    <!--产品图片预览相关-->
    <link rel="stylesheet"  href="../assets/css/jcarousel.connected-carousels.css" type="text/css">
    <title></title>   
</head>
<body>
    <%@ include file="Header.jsp"%>
    <!-- list-shop -->
    <section class="grid-shop">
       <!-- .grid-shop -->
       <div class="container">
           <div class="row">
               <div class="col-md-12">
                  <ol class="breadcrumb">
                      <li  class="breadcrumb-item"><a  href="index.action">Home</a></li>
                      <li  class="breadcrumb-item active">Shop  Detail.</li>
                  </ol>
                  <div class="row">                    
                      <!-- left side -->
                      <div class="col-sm-5  col-md-5">
                          <!-- product  gallery -->
                          <div  class="connected-carousels">
                              <div  class="stage">
                                 <div  class="carousel carousel-stage">
                                     <ul>
                                         <li><img class="zoom_01"  src="../assets/images/products/fashion/1.jpg"  data-zoom-image="../assets/images/products/fashion/1.jpg" alt="qoute-icon" /> </li>
                                         <li><img class="zoom_01"  src="../assets/images/products/fashion/2.jpg"  data-zoom-image="../assets/images/products/fashion/2.jpg" alt="qoute-icon" /></li>
                                         <li><img class="zoom_01"  src="../assets/images/products/fashion/3.jpg"  data-zoom-image="../assets/images/products/fashion/3.jpg" alt="qoute-icon" /></li>
                                         <li><img class="zoom_01"  src="../assets/images/products/fashion/15.jpg"  data-zoom-image="../assets/images/products/fashion/15.jpg" alt="qoute-icon" /> </li>
                                         <li><img class="zoom_01"  src="../assets/images/products/fashion/8.jpg"  data-zoom-image="../assets/images/products/fashion/8.jpg" alt="qoute-icon" /></li>
                                         <li><img class="zoom_01"  src="../assets/images/products/fashion/12.jpg"  data-zoom-image="../assets/images/products/fashion/12.jpg" alt="qoute-icon" /></li>
                                     </ul>
                                 </div>
                                 <p  class="photo-credits">
                                     Photos  by <a  href="http://www.mw-fotografie.de">Marc  Wiegelmann</a>
                                 </p>
                                 <a href="#"  class="prev  prev-stage"><span>&lsaquo;</span></a>
                                 <a href="#"  class="next  next-stage"><span>&rsaquo;</span></a>
                              </div>
                              <div  class="navigation">
                                 <a href="#"  class="prev prev-navigation">&lsaquo;</a>
                                 <a href="#"  class="next next-navigation">&rsaquo;</a>
                                 <div  class="carousel carousel-navigation">
                                     <ul>
                                         <li><img  src="../assets/images/products/fashion/1.jpg" width="110" height="110" alt=""></li>
                                         <li><img  src="../assets/images/products/fashion/2.jpg" width="110" height="110" alt=""></li>
                                         <li><img  src="../assets/images/products/fashion/3.jpg" width="110" height="110" alt=""></li>
                                         <li><img  src="../assets/images/products/fashion/15.jpg" width="110" height="110" alt=""></li>
                                         <li><img  src="../assets/images/products/fashion/8.jpg" width="110" height="110" alt=""></li>
                                         <li><img  src="../assets/images/products/fashion/12.jpg" width="110" height="110" alt=""></li>
                                     </ul>
                                 </div>
                              </div>
                          </div>
                          <!-- / product  gallery -->
                      </div>
                      <!-- left side -->
                      <!-- right side -->
                      <div class="col-sm-7  col-md-7">
                          <!-- .pro-text -->
                          <div  class="pro-text product-detail">
                              <!-- /.pro-img  -->
                              <span  class="span1">${product.category.name}</span>
                              <a href="#">
                                 <h4>  ${product.name}</h4>
                              </a>
                              <div  class="star2">
                                 <ul>
                                     <li  class="yellow-color"><i class="fa fa-star"  aria-hidden="true"></i></li>
                                     <li  class="yellow-color"><i class="fa fa-star"  aria-hidden="true"></i></li>
                                     <li  class="yellow-color"><i class="fa fa-star"  aria-hidden="true"></i></li>
                                     <li  class="yellow-color"><i class="fa fa-star"  aria-hidden="true"></i></li>
                                     <li><i  class="fa fa-star"  aria-hidden="true"></i></li>
                                     <li><a  href="#">10 review(s)</a></li>
                                     <li><a  href="#"> Add your review</a></li>
                                 </ul>
                              </div>
                              <p><strong>￥${product.price}</strong><span  class="line-through">￥${product.price+100}</span></p>
                              <p  class="in-stock">可用库存:    <span>${product.pnum }</span></p>
                              <p>Duis autem  vel eum iriure dolor in hendrerit in  vulputate velit esse molestie consequat, vel  illum dolore eu feugiat nulla facilisis at  vero eros et accumsan et iusto odio  dignissim qui blandit praesent luptatum  zzril delenit augue duis dolore te feugait  nulla facilisi. </p>                        
                              <ul  class="ul-content">
                                 <li> Light  green crewneck sweatshirt.</li>
                                 <li>Hand  pockets.</li>
                                 <li>Relaxed  fit.</li>
                                 <li>Machine  wash/dry.</li>
                              </ul>
                              <form>
                                 <div  class="numbers-row">
                                     <input  type="text" name="french-hens"  id="french-hens" value="1">
                                 </div>
                              </form>
                              <a onclick="buy('${product.id}',${USER_SESSION.username!=null?true:false})" class="addtocart2">加入购物车</a>
                              <a href="#"  class="hart"><span class="icon  icon-Heart"></span></a>
                              <div  class="share">
                                 <p>Share:</p>
                                 <ul>
                                     <li><a  href="http://www.facebook.com/sharer.php?u=http://zcube.in/platin/platin/products-detail.html" target="_blank"><i class="fa  fa-facebook"  aria-hidden="true"></i></a></li>
                                     <li> <a  href="https://twitter.com/share?url=http://zcube.in/platin/platin/products-detail.html"  target="_blank"><i class="fa fa-twitter"  aria-hidden="true"></i></a></li>
                                     <li><a  href="#"><i class="fa fa-dribbble"  aria-hidden="true"></i></a></li>
                                     <li><a  href="http://www.linkedin.com/shareArticle?mini=true&url=http://zcube.in/platin/platin/products-detail.html" target="_blank"><i  class="fa fa-linkedin"  aria-hidden="true"></i></a></li>
                                 </ul>
                              </div>                           
                          </div>
                          <!-- /.pro-text  -->
                      </div>
                  </div>
                  <div class="row">
                      <div class="tab-bg">
                          <ul>
                              <li  class="active"><a data-toggle="tab"  href="#home">Description</a></li>
                              <li><a  data-toggle="tab" href="#menu1">ADDITIONAL  INFORMATION</a></li>
                              <li><a  data-toggle="tab" href="#menu2">REVIEWS  (4)</a></li>
                          </ul>
                      </div>
                      <div  class="tab-content">
                          <div id="home"  class="tab-pane fade in active">
                              ${product.description}
                          </div>
                          <div id="menu1"  class="tab-pane fade">
                              <p>Lorem Ipsum  is simply dummy text of the printing and  typesetting industry. Lorem Ipsum has been  the industry's standard dummy text ever  since the 1500s, when anunknown printer took  a galley of type and scrambled it to make a  type specimen book. It has survived not only  five centuries, but also the leap into  electronic typesetting, remaining  essentially unchanged. It was popularised in  the 1960s with the release of Letraset  sheets containing Lorem Ipsum passages..</p>
                              <ul>
                                 <li>Claritas est etiam processus  dynamicus.</li>
                                 <li>Qui  sequitur mutationem consuetudium lectorum.  </li>
                                 <li>Claritas est etiam processus  dynamicus.</li>
                                 <li>Qui  sequitur mutationem consuetudium lectorum.  </li>
                                 <li>Claritas est etiam processus  dynamicus.</li>
                                 <li>Qui  sequitur mutationem consuetudium lectorum.  </li>
                              </ul>
                              <p>It has  survived not only five centuries, but also  the leap into electronic typesetting,  remaining essentially unchanged. It was  popularised in the 1960s with the  release.</p>
                          </div>
                          <div id="menu2"  class="tab-pane fade">
                              <p>Lorem Ipsum  is simply dummy text of the printing and  typesetting industry. Lorem Ipsum has been  the industry's standard dummy text ever  since the 1500s, when anunknown printer took  a galley of type and scrambled it to make a  type specimen book. It has survived not only  five centuries, but also the leap into  electronic typesetting, remaining  essentially unchanged. It was popularised in  the 1960s with the release of Letraset  sheets containing Lorem Ipsum passages..</p>
                              <ul>
                                 <li>Claritas est etiam processus  dynamicus.</li>
                                 <li>Qui  sequitur mutationem consuetudium lectorum.  </li>
                                 <li>Claritas est etiam processus  dynamicus.</li>
                                 <li>Qui  sequitur mutationem consuetudium lectorum.  </li>
                                 <li>Claritas est etiam processus  dynamicus.</li>
                                 <li>Qui  sequitur mutationem consuetudium lectorum.  </li>
                              </ul>
                              <p>It has  survived not only five centuries, but also  the leap into electronic typesetting,  remaining essentially unchanged. It was  popularised in the 1960s with the  release.</p>
                          </div>
                      </div>
                  </div>
               </div>
               
               <!-- right side -->
           </div>
       </div>
       <!-- /.grid-shop -->
    </section>
    
    <%@ include file="Footer.jsp"%>
    <!--产品增加 减少相关JS-->
    <script  src="../assets/js/incrementing.js"></script>
    <!--  jcarousel Theme JavaScript 产品图片预览组件  -->
    <script type="text/javascript"  src="../assets/js/jquery.jcarousel.min.js"></script>
    <script type="text/javascript"  src="../assets/js/jcarousel.connected-carousels.js"></script>
    <script type="text/javascript"  src="../assets/js/jquery.elevatezoom.js"></script>
    <script>
       $('.zoom_01').elevateZoom({
           zoomType: "inner",
           cursor: "crosshair",
           zoomWindowFadeIn: 500,
           zoomWindowFadeOut: 750
       });
    </script>
    <script type="text/javascript">
       function buy(productId, isLogined) {
           if(isLogined!=true){
               if(confirm("您还没登录，是否现在登录？")){
                  window.location.href="../user/login.action";
               }
               return false;
           }
           var param = {
               'id' : productId,
               'count': $("#french-hens").val()
           };
           jQuery.ajax({
               url :  '${pageContext.request.contextPath}/cart/buy.action',
               data : param,
               dataType : "JSON",
               type : "POST",
               success : function(data) {
                  if (data == true) {
                      alert("加入购物车成功！");
                  } else {
                      alert("加入购物车失败！");
                  }
               },
               error : function(XMLResponse)  {
                  alert(XMLResponse.responseText)
               }
           });
       }
    </script>
</body>
</html>