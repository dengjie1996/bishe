const CONTENT_PATH = "http://localhost:8201/mall-portal";
const AUTHORIZATION = "Authorization";
const USER_NAME = "userName";
const SHOP_CART_COUNT = "shopcartCount";

$(function () {
    getLogininfo();
    getShopCart();
});

/**
 * 用户信息
 * 购物车信息
 * ***/
function getLogininfo() {
    var token = getCookie(AUTHORIZATION)
    if (token == null || token == undefined || token.length <= 1) return;
    let name = getCookie(USER_NAME);
    $("#userName").text(name);
    $("#logout").show();
    $(".sp-cart").show();
}

//购物车
function getShopCart() {
    $.ajax({
        headers: {
            Authorization: getCookie(AUTHORIZATION)
        },
        type: "get",
        url: CONTENT_PATH + "/cart/list",
        dataType: "json",//返回的
        success: function (data) {
            switch (data.code) {
                case 200:
                    let shopCartCount = data.data.length;
                    setCookie(SHOP_CART_COUNT, shopCartCount);
                    $("#shopcartCount").text(shopCartCount);
                    break;
                // case 401:
                //     toLogin();
                //     break;
            }


        },
        error: function (msg) {
            console.log(msg)
        }
    });
}

//写cookies

function setCookie(name, value) {
    var Days = 30;
    var exp = new Date();
    exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
    document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString();
}

//读取cookies
function getCookie(name) {
    var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");

    if (arr = document.cookie.match(reg))

        return unescape(arr[2]);
    else
        return null;
}

//删除cookies
function delCookie(name) {
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval = getCookie(name);
    if (cval != null)
        document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
}

function clearCookies() {
    delCookie(AUTHORIZATION);
    delCookie(USER_NAME);
}

function toLogin() {
    window.location.href = "login.html"
}