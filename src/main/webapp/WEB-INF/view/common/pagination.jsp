<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% request.setAttribute("root", request.getContextPath()); %>
<link rel="stylesheet" href="${root}/resources/vendor/jquery/pagination/mricode.pagination.css">
<script src="${root}/resources/vendor/jquery/pagination/mricode.pagination.js"></script>
<style>
#jpagination {margin: 8px 0; float: right}
</style>
<div id="jpagination"></div>