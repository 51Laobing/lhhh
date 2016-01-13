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
		// ҳ�����ʱִ��
		htmlobj = $.ajax({
			url : "gly.jsp",
			async : false
		});
		$("#layout_right_content").html(htmlobj.responseText);
	} else if (page === "wfhdd") {
		// ҳ�����ʱִ��
		htmlobj = $.ajax({
			url : "wfhdd.jsp",
			async : false
		});
		$("#layout_right_content").html(htmlobj.responseText);
	} else if (page === "lp") {
		// ҳ�����ʱִ��
		htmlobj = $.ajax({
			url : "lp.jsp",
			async : false
		});
		$("#layout_right_content").html(htmlobj.responseText);
	} else if (page === "user") {
		// ҳ�����ʱִ��
		htmlobj = $.ajax({
			url : "user.jsp",
			async : false
		});
		$("#layout_right_content").html(htmlobj.responseText);
	} else if (page === "scym") {
		// ҳ�����ʱִ��
		htmlobj = $.ajax({
			url : "ymsz_scym.jsp",
			async : false
		});
		$("#layout_right_content").html(htmlobj.responseText);
	} else {
		// ҳ�����ʱִ��
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
	// ҳ�����ʱִ��
	htmlobj = $.ajax({
		url : "wsh.jsp",
		async : false
	});
	$("#layout_right_content").html(htmlobj.responseText);
});

$("#fptg").click(function() {
	// ҳ�����ʱִ��
	htmlobj = $.ajax({
		url : "tg.jsp",
		async : false
	});
	$("#layout_right_content").html(htmlobj.responseText);
});

$("#fpwtg").click(function() {
	// ҳ�����ʱִ��
	htmlobj = $.ajax({
		url : "wtg.jsp",
		async : false
	});
	$("#layout_right_content").html(htmlobj.responseText);
});

$("#glylb").click(function() {
	// ҳ�����ʱִ��
	htmlobj = $.ajax({
		url : "gly.jsp",
		async : false
	});
	$("#layout_right_content").html(htmlobj.responseText);
});

$("#tjgly").click(function() {
	// ҳ�����ʱִ��
	htmlobj = $.ajax({
		url : "tjgly.jsp",
		async : false
	});
	$("#layout_right_content").html(htmlobj.responseText);
});

$("#yhlb").click(function() {
	// ҳ�����ʱִ��
	htmlobj = $.ajax({
		url : "user.jsp",
		async : false
	});
	$("#layout_right_content").html(htmlobj.responseText);
});

$("#lplb").click(function() {
	// ҳ�����ʱִ��
	htmlobj = $.ajax({
		url : "lp.jsp",
		async : false
	});
	$("#layout_right_content").html(htmlobj.responseText);
});

$("#wfhdd").click(function() {
	// ҳ�����ʱִ��
	htmlobj = $.ajax({
		url : "wfhdd.jsp",
		async : false
	});
	$("#layout_right_content").html(htmlobj.responseText);
});

$("#yfhdd").click(function() {
	// ҳ�����ʱִ��
	htmlobj = $.ajax({
		url : "yfhdd.jsp",
		async : false
	});
	$("#layout_right_content").html(htmlobj.responseText);
});

$("#tjlp").click(function() {
	// ҳ�����ʱִ��
	htmlobj = $.ajax({
		url : "tjlp.jsp",
		async : false
	});
	$("#layout_right_content").html(htmlobj.responseText);
});

$("#scym").click(function() {
	// ҳ�����ʱִ��
	htmlobj = $.ajax({
		url : "ymsz_scym.jsp",
		async : false
	});
	$("#layout_right_content").html(htmlobj.responseText);
});

function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // ����һ������Ŀ�������������ʽ����
	var r = window.location.search.substr(1).match(reg); // ƥ��Ŀ�����
	if (r != null)
		return unescape(r[2]);
	return null; // ���ز���ֵ
}

function editlp(lpbh) {
	// ҳ�����ʱִ��
	htmlobj = $.ajax({
		url : "editlp.jsp?lpbh=" + lpbh,
		async : false
	});
	$("#layout_right_content").html(htmlobj.responseText);
}

function deletelp(lpbh) {
	// ҳ�����ʱִ��
	htmlobj = $.ajax({
		url : "deleteLpServlet?lpbh=" + lpbh,
		async : false
	});
	$("#layout_right_content").html(htmlobj.responseText);
}