<%@ page import="top.zjp.bookonline.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>个人中心</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
    <style>
        .explore {
            display: flex;
            align-items: center;
            justify-content: space-between;
            background-color: rgb(237, 244, 237);
            height: 80px;
            padding-left: 8%;
            padding-right: 10px;
        }

        .nav {
            display: flex;
            align-items: center;
            list-style: none;
        }

        .nav li {
            color: rgb(61, 133, 73);
            font-size: 18px;
            margin-right: 20px;
        }

        .search-input {
            height: 35px;
            background-color: #fff;
            border: none;
            outline: none;
            border-radius: 3px;
            padding: 0 15px;
            color: #9b9b9b;
            font-size: 14px;
        }

        .info {
            display: flex;
        }

        .profile {
            width: 80px;
            height: 80px;
            border-radius: 5px;
        }

        h2 {
            color: rgb(73, 73, 73);
            margin-left: 15px;
        }

        .info-box {
            padding: 10px 10px 10px 10px;
            width: 90%;
            height: 240px;
            border: 1px solid #eee;
            border-radius: 5px;
            background-color: rgb(237, 244, 237);
            text-align: center;
        }

        .info-box .top {
            height: 80%;
            display: flex;
            border-bottom: 1px solid #e4e6e5;
        }

        .info-box .top img {
            width: 45%;
            height: 85%;
            margin-right: 15px;
            border-radius: 5px;
        }

        .info-box .top + h4 {
            margin-top: 20px;
            margin-left: 10px;
        }

        .info-box .top > div {
            text-align: left;
        }

        p {
            font-size: 13px;
            color: #333;
            padding-top: 5px;
            padding-bottom: 5px;
            margin-top: 5px;
            margin-bottom: 5px;
        }

        .item {
            height: 80px;
            margin-top: 10px;
            margin-bottom: 10px;
            padding-top: 10px;
            padding-bottom: 10px;
        }

        .read {
            border-bottom: 1px solid #eee;
        }

        .read a {
            color: rgb(51, 119, 170);
            text-decoration: none;
        }

        .container {
            width: 85%;
            margin: 0 auto;
            display: flex;
            flex-direction: column;
        }

        .btn {
            width: 120px;
            height: 40px;
            margin-top: 10px;
            border: none;
            outline: none;
            border-radius: 3px;
            background-color: rgb(36, 169, 190);
            color: #fff;
            box-shadow: 2px 5px 10px #aaa;
            cursor: pointer;
        }
    </style>
</head>
<body>
<%
    User user = (User) request.getSession().getAttribute("user");
    request.setAttribute("user", user);
%>

<%--顶部区域，引入共用的top.jsp页面--%>
<div id="top">
    <jsp:include page="top.jsp"/>
</div>

<%--浏览区域--%>
<div class="explore">
    <ul class="nav">
        <li>首页</li>
        <li>浏览发现</li>
        <li>话题广场</li>
        <li>我的豆瓣</li>
    </ul>
    <label>
        <input type="text" placeholder="搜索你感兴趣的内容" class="search-input">
    </label>
</div>
<br>

<%--页面主题区域--%>
<div class="container">
    <div class="row">
        <%--左侧2/3区域--%>
        <div class="col-8">
            <div class="info">
                <img src="${user.avatar}" alt="" class="profile">
                <h2>${user.nickname}</h2>
            </div>
            <br>
            <div class="item">
                <ul class="nav">
                    <li>我的日记</li>
                </ul>
                <p>在豆瓣上写日记，记录自己的生活、想法。</p>
            </div>
            <div class="item">
                <ul class="nav">
                    <li>我的相册</li>
                </ul>
                <p>可以有自己的相册来存放照片了。</p>
            </div>
            <div class="item">
                <ul class="nav">
                    <li>我读</li>
                </ul>
                <p>5本想读</p>
            </div>
            <div class="item">
                <ul class="nav">
                    <li>留言板</li>
                </ul>
                <label>
                    <textarea cols="80" rows="5"></textarea>
                </label>
                <div>
                    <input type="button" value="留言" class="btn">
                </div>
            </div>
        </div>

        <%-- 右侧1/3区域--%>
        <div class="col-4">
            <div class="info-box">
                <div class="top">
                    <img src="${user.avatar}" alt="">
                    <div>
                        <p>常居：${user.address}</p>
                        <p>账号：${user.account}</p>
                        <p>${user.createTime}加入</p>
                    </div>
                </div>
                <h4>${user.nickname}</h4>
            </div>
            <br>
            <div class="item">
                <ul class="nav">
                    <li>我的广播· · · · · · (全部)</li>
                </ul>
                <br>
                <div class="read">
                    <p><a href="">${user.nickname}</a> 想读
                        <a href="">写给大忙人的Java SE 8</a>
                    </p>
                    <p style="color: #9b9b9b;">2023年2月18日</p>
                </div>
                <div class="read">
                    <p><a href="">${user.nickname}</a> 想读
                        <a href="">写给大忙人的Java SE 8</a>
                    </p>
                    <p style="color: #9b9b9b;">2023年2月18日</p>
                </div>
                <div class="read">
                    <p><a href="">${user.nickname}</a> 想读
                        <a href="">写给大忙人的Java SE 8</a>
                    </p>
                    <p style="color: #9b9b9b;">2023年2月18日</p>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>