/**
 * Created by Administrator on 14-11-16.
 */
$(document).ready(function() {
	$('#menu').tendina({
		openCallback : function(clickedEl) {
			clickedEl.addClass('opened');
		},
		closeCallback : function(clickedEl) {
			clickedEl.addClass('closed');
		}
	});

	var page = getUrlParam('page');
	if (page === "glylb") {
		// 页面加载时执行
		htmlobj = $.ajax({
			url : "gly.jsp",
			async : false
		});
		$("#layout_right_content").html(htmlobj.responseText);
	} else if (page === "wfhdd") {
		// 页面加载时执行
		htmlobj = $.ajax({
			url : "wfhdd.jsp",
			async : false
		});
		$("#layout_right_content").html(htmlobj.responseText);
	} else if (page === "lp") {
		// 页面加载时执行
		htmlobj = $.ajax({
			url : "lp.jsp",
			async : false
		});
		$("#layout_right_content").html(htmlobj.responseText);
	} else if (page === "user") {
		// 页面加载时执行
		htmlobj = $.ajax({
			url : "user.jsp",
			async : false
		});
		$("#layout_right_content").html(htmlobj.responseText);
	} else if (page === "scym") {
		// 页面加载时执行
		htmlobj = $.ajax({
			url : "ymsz_scym.jsp",
			async : false
		});
		$("#layout_right_content").html(htmlobj.responseText);
	} else {
		// 页面加载时执行
		htmlobj = $.ajax({
			url : "wsh.jsp",
			async : false
		});
		$("#layout_right_content").html(htmlobj.responseText);
	}
});
$(function() {

	$("#ad_setting").click(function() {
		$("#ad_setting_ul").show();
	});
	$("#ad_setting_ul").mouseleave(function() {
		$(this).hide();
	});
	$("#ad_setting_ul li").mouseenter(function() {
		$(this).find("a").attr("class", "ad_setting_ul_li_a");
	});
	$("#ad_setting_ul li").mouseleave(function() {
		$(this).find("a").attr("class", "");
	});
});

$("#fpwsh").click(function() {
	// 页面加载时执行
	htmlobj = $.ajax({
		url : "wsh.jsp",
		async : false
	});
	$("#layout_right_content").html(htmlobj.responseText);
});

$("#fptg").click(function() {
	// 页面加载时执行
	htmlobj = $.ajax({
		url : "tg.jsp",
		async : false
	});
	$("#layout_right_content").html(htmlobj.responseText);
});

$("#fpwtg").click(function() {
	// 页面加载时执行
	htmlobj = $.ajax({
		url : "wtg.jsp",
		async : false
	});
	$("#layout_right_content").html(htmlobj.responseText);
});

$("#glylb").click(function() {
	// 页面加载时执行
	htmlobj = $.ajax({
		url : "gly.jsp",
		async : false
	});
	$("#layout_right_content").html(htmlobj.responseText);
});

$("#tjgly").click(function() {
	// 页面加载时执行
	htmlobj = $.ajax({
		url : "tjgly.jsp",
		async : false
	});
	$("#layout_right_content").html(htmlobj.responseText);
});

$("#yhlb").click(function() {
	// 页面加载时执行
	htmlobj = $.ajax({
		url : "user.jsp",
		async : false
	});
	$("#layout_right_content").html(htmlobj.responseText);
});

$("#lplb").click(function() {
	// 页面加载时执行
	htmlobj = $.ajax({
		url : "lp.jsp",
		async : false
	});
	$("#layout_right_content").html(htmlobj.responseText);
});

$("#wfhdd").click(function() {
	// 页面加载时执行
	htmlobj = $.ajax({
		url : "wfhdd.jsp",
		async : false
	});
	$("#layout_right_content").html(htmlobj.responseText);
});

$("#yfhdd").click(function() {
	// 页面加载时执行
	htmlobj = $.ajax({
		url : "yfhdd.jsp",
		async : false
	});
	$("#layout_right_content").html(htmlobj.responseText);
});

$("#tjlp").click(function() {
	// 页面加载时执行
	htmlobj = $.ajax({
		url : "tjlp.jsp",
		async : false
	});
	$("#layout_right_content").html(htmlobj.responseText);
});

$("#scym").click(function() {
	// 页面加载时执行
	htmlobj = $.ajax({
		url : "ymsz_scym.jsp",
		async : false
	});
	$("#layout_right_content").html(htmlobj.responseText);
});

function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg); // 匹配目标参数
	if (r != null)
		return unescape(r[2]);
	return null; // 返回参数值
}

function editlp(lpbh) {
	// 页面加载时执行
	htmlobj = $.ajax({
		url : "editlp.jsp?lpbh=" + lpbh,
		async : false
	});
	$("#layout_right_content").html(htmlobj.responseText);
}

function deletelp(lpbh) {
	// 页面加载时执行
	htmlobj = $.ajax({
		url : "deleteLpServlet?lpbh=" + lpbh,
		async : false
	});
	$("#layout_right_content").html(htmlobj.responseText);
}