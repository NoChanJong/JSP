<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String fileName = request.getParameter("f");
	
	String fromPath = "D:/ChanJong/ChanJong/temp/upload/" + fileName;
	String toPath = "D:/ChanJong/ChanJong/temp/download/" + fileName;

	/*
		실제웹서버운영시에 관련된 경로
		ServletContext context = getServletContext(); // 현재웹컨테이너의 root폴더 즉, WebContent
		String downPath = context.getRealPath("upload");
		String saveFilepath = "D:/ChanJong/ChanJong/temp/download/" + fileName;
		out.println("<h3>Context = " + context + "</h3>");	
		out.println("<h3>downPath = " + downPath + "</h3>");	
		out.println("<h3>saveFilePath = " + saveFilePath + "</h3>");	
	*/
	
	byte[] b = new byte[4096];
	File f = new File(toPath);
	FileInputStream fis = new FileInputStream(fromPath); // 파일을 읽기 위한 FileInputStream객체를 생성
	
	// 파일의 MIME 타입을 가져옴. MIME타입은 파일의 확장자를 기반으로 결정되며, 
	// 가져오지 못하는 경우 "application/octet-stream"으로 설정
	String sMimeType = getServletContext().getMimeType(fromPath); // mimetype = txt, hwp....
	if(sMimeType == null) sMimeType = "application/octet-stream";
	
	// 파일명을 인코딩하여 헤더에 설정. 파일명이 한글인 경우 utf-8로 인코딩한 후,
	// "8859_1"로 변환하여 설정
	String sEncoding = new String(fileName.getBytes("utf-8"), "8859_1");
	String sEncoding1 = URLEncoder.encode(fileName, "utf-8");
	
	response.setContentType(sMimeType);
	// 응답 헤더에 이진 파일 전송과 파일 다운로드를 위한 헤더를 설정함. 
	// 파일명을 포함하여 첨부 파일로 다운로드 되도록 설정
	response.setHeader("Content-Transfer-Encoding", "binary");
	response.setHeader("Content-Disposition", "attatchment; filename = " + sEncoding1);
	
	ServletOutputStream os = response.getOutputStream();
	int numRead;
	
	// 파일의 내용을 읽어서 ServletOutputStream으로 전송
	// 4096바이트씩 읽고 전송
	while((numRead = fis.read(b, 0, b.length)) != -1) {
		os.write(b, 0, numRead);
	}
	
	os.flush();
	os.close();
	fis.close();
	
%>
<!DOCTYPE html>
<html>
<head>
	 <meta charset="UTF-8">
	 <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">   
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/css/bootstrap.min.css" rel="stylesheet">
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h1>파일다운로드하기</h1>
</body>
</html>
