package com.lec.file;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class UploadServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		// 요청과 응답 객체의 인코딩을 utf-8로 설정, 응답의 콘텐츠 타입을 html형식으로 설정
				
		PrintWriter out = res.getWriter(); 
		// 응답 객체로부터 PrintWriter를 얻어와서 html 출력을 위해 사용
		
		// 요청의 콘텐츠 타입을 확인하여 multipart 타입인지 검사
		String contentType = req.getContentType();
		
		out.println("<html><body>");
		
		if(contentType != null && contentType.toLowerCase().startsWith("multipart/")) {
			printPartInfo(req, out); 
			// multipart타입인 경우 printPartInfo메서드를 호출하여 각 파트의 정보를 출력
		} else {
			out.println("Content Type이 multipart타입이 아닙니다!!");
		}

		out.println("</body></html>");		
	}

	// printPartInfo메서드는 multipart폼 데이터로부터 각 파트의 정보를 출력
	private void printPartInfo(HttpServletRequest req, PrintWriter out) 
			throws IOException, ServletException { 

		String fileName = "dummy";
		int lastIndex = 0;
		
		Collection<Part> parts = req.getParts(); 
		// 요청 객체로부터 모든 파트의 컬렉션을 얻어옴
		
		for(Part part:parts) {
			out.println("<br> name = " + part.getName());
			String contentType = part.getContentType();
			out.println("<br> contentType = " + contentType);
		
			// "Content-Disposition"헤더에서 "filename="을 포함하는 경우 
			// 파일과 관련된 정보를 출력
			if(part.getHeader("Content-Disposition").contains("filename=")) {
				out.println("<br> size = " + part.getSize()); // 파일의 크기를 출력
				// getFileName메서드를 호출하여 파일 이름을 얻어옴
				fileName = getFileName(part); 
				// 파일 이름에서 마지막 경로 구분자를 찾아서 파일 이름만 추출
				lastIndex = fileName.lastIndexOf("\\");
				fileName = fileName.substring(lastIndex+1);
				out.println("<br> fileName = " + fileName);
				
				// 파일이 존재하면 해당 이름으로 파일을 작성하고, 작성한 후에는 해당 파일을 삭제
				if(part.getSize() > 0) { 
					part.write(fileName);
					part.delete();
				}
				// "filename="을 포함하지 않는 경우 파라미터의 값만 출력
			} else {
				String value = req.getParameter(part.getName());
				out.println("<br> value = " + value);
			}
			out.println("<hr>");
		}
	}

	// getFileName메서드는 파트의 "Content-Disposition"헤더에서 파일 이름을 추출
	private String getFileName(Part part) {
		// "Content-Disposition"헤더 값을 세미콜론으로 분리하여 반복
		for(String cd:part.getHeader("Content-Disposition").split(";")) {
			// 각 값에 대해서 "filename="으로 시작하는지 확인
			if(cd.trim().startsWith("filename=")) {
				// "filename="이후의 값에서 따옴표를 제거한 후 반환
				return cd.substring(cd.indexOf('=')+1).trim().replace("\"", "");
			}
		}
		return null;
	}
}