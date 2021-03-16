//1.声明变量
var eamilObj
var usernameObj
var passwordObj
var confirmObj
var eamilMsg
var usernameMsg
var passwordMsg
var confirmMsg
//2.页面加载之后，获取页面的对象
window.onload = function () {
  eamilObj = document.getElementById("email");
  usernameObj = document.getElementById("username");
  passwordObj = document.getElementById("password");
  confirmObj = document.getElementById("repassword");
  eamilMsg = document.getElementById("emailMsg");
  usernameMsg = document.getElementById("usernameMsg");
  passwordMsg = document.getElementById("passwordMsg");
  confirmMsg = document.getElementById("confirmMsg");
};
//3.校验整个表单
function checkForm() {
  var bEmail = checkEmail();
  var bUsername = checkUsername();
  var bPassword = checkPassword();
  var bConfirm = checkConfirm();
  // return false后，事件将被取消
  return bUsername && bPassword && bConfirm && bEmail;
}
//4.验证邮箱
function checkEmail() {
  var regex = /^[\w-]+@([\w-]+\.)+[a-zA-Z]{2,4}$/;
  var value = eamilObj.value;
  var msg = "";
  if (!value)
    msg = "邮箱必须填写：";
  else if (!regex.test(value))
    msg = "邮箱格式不合法：";
  eamilMsg.innerHTML = msg;
  eamilObj.parentNode.parentNode.style.color = msg == "" ? "black" : "red";
  return msg == "";
}
//5.验证用户名
function checkUsername() {
  var regex = /^[a-zA-Z_]\w{0,9}$/;
  var value = usernameObj.value;
  var msg = "";
  //
  if (!value)
    msg = "用户名必须填写：";
  else if (!regex.test(value))
    msg = "用户名不合法：";
  usernameMsg.innerHTML = msg;
  usernameObj.parentNode.parentNode.style.color = msg == "" ? "black" : "red";
  return msg == "";
}
//6.验证密码
function checkPassword() {
  var regex = /^.{6,16}$/;
  var value = passwordObj.value;
  var msg = "";
  if (!value)
    msg = "密码必须填写";
  else if (!regex.test(value))
    msg = "密码不合法";
  passwordMsg.innerHTML = msg;
  passwordObj.parentNode.parentNode.style.color = msg == "" ? "black" : "red";
  return msg == "";
}
//7.验证确认密码
function checkConfirm() {
  var passwordValue = passwordObj.value;
  var confirmValue = confirmObj.value;
  var msg = "";
  if (!confirmValue)
    msg = "确认密码必须填写";
  else if (passwordValue != confirmValue)
    msg = "密码必须保持一致";
  confirmMsg.innerHTML = msg;
  confirmObj.parentNode.parentNode.style.color = msg == "" ? "black" : "red";
  return msg == "";
}