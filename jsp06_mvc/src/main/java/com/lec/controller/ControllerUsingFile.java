package com.lec.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.command.CommandHandler;
import com.lec.handler.NullHandler;

/*
 	커맨드패턴 기반의 프로그램(MVC Model2)
 	
 	MVC(Model, View, Controller)패턴에서 Controller역할을 수행하는 작업은 사용자가
 	요청한 내용을 분석해서 요청에 맞는 작업(응답)이 무엇인지를 분석하는 역할을 한다.
 	사용자의 요청을 판단하기 위해서 사용하는 방법이 여러가지가 있는데 가장 일반적인
 	방법은 명령어를 사용하는 것이다.
 	
 	예를 들어 사용자가 게시판목록보기, 글쓰기등의 명령을 컨트롤역할을 하는 서블릿에
 	전달하고 컨트롤러 서블릿은 사용자가 요청에 해당하는 기능을 수행하는 View(jsp or html)
 	를 통해 결과를 보여주는 패턴을 커맨드패턴이라고 한다.
 	
 	커맨드패턴에서 파라미터에 명령을 전달하는 방법은 2가지가 있다. 
 	
 	1. 특정 이름의 파라미터에 명령을 전달하는 방법(CotrollerUsingFile.properties)
 	
 	   ... http://localhost:8088/jsp06_mvc/hello
 	
 	2. 요청되는 URI자체를 명령어로 사용하는 방법(ControllerUsingURI.properties)
 	
 	   ... http://localhost:8088/jsp06_mvc/yyy.do
*/
public class ControllerUsingFile extends HttpServlet {
	
	// 커맨드패턴 : key는 요청(hello, board...), value는 실행할 핸들러역할의 객체 
	private Map<String, CommandHandler> handler = new HashMap<>();
	// key는 요청(command)을 나타내고, 값은 해당 요청을 처리할 핸들러 객체
	
	// init()메서드를 오버라이딩하여 서블릿 초기화 시 실행됨
	@Override
	public void init() throws ServletException {
		// getInitParameter("controllerFile")를 통해 web.xml에 등록된
		// controllerFile초기화 매개변수 값을 가져옴
		String controllerFile = getInitParameter("controllerFile");

		// getServletContext().getRealPath(controllerFile)를 호출하여 
		// 컨트롤러 파일의 실제 경로를 얻음
		String controllerFilePath = getServletContext().getRealPath(controllerFile);
		
//		System.out.println(controllerFile);
//		System.out.println(controllerFilePath);
		
		Properties prop = new Properties();
		
		// controllerFilePath를 FileReader로 읽어들여 prop에 로드
		try(FileReader fis = new FileReader(controllerFilePath)) {
			prop.load(fis);
		} catch(Exception e) {
			throw new ServletException();
		}
		
		// prop의 키 값을 순회하면서 각 커맨드와 핸들러 클래스 정보를 가져옴
		Iterator key = prop.keySet().iterator(); 
		while(key.hasNext()) {
			String command = (String) key.next();		  // hello
			String className = prop.getProperty(command); // com.lec.HelloHandler
			System.out.println(command + "=" + className);
			
			try {
				Class<?> handlerClass = Class.forName(className);
				// handlerClass.newInstance()를 호출하여 핸들러 클래스의 인스턴스를 생성
				CommandHandler handlerInstance = (CommandHandler) handlerClass.newInstance();
				// 생성된 핸들러 인스턴스를 handler맵에 커맨드를 키로하여 저장
				handler.put(command, handlerInstance);
				// {hello=com.lec.handler.BoardHandler, ... }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw new ServletException();
			}
		}
	}
	
	// doGet() 및 doPost()메서드를 오버라이딩하여 Get or Post요청이 발생하면
	// process()메서드를 호출함
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		process(req, res);
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		process(req, res);
	}

	// http://localhost:8088/jsp06_mvc/file?cmd=hello
	private void process(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		String view_page = "";
		// cmd : hello, member, board
		// process메서드에서는 요청 파라미터에서 cmd값을 가져와 해당 커맨드에 대응하는
		// 핸들러 객체를 가져옴
		String cmd = req.getParameter("cmd");
		CommandHandler command = handler.get(cmd);
		
		if(command == null) command = new NullHandler();
		
		// 핸들러의 process()메서드를 호출하여 요청을 처리하고, 반환도니 뷰 페이지 경로를 저장
		try {
			view_page = command.process(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 뷰 페이지 경로가 null이 아닌 경우 RequestDispatcher를 사용하여 해당 경로로 포워딩함
		if(view_page != null) {
			RequestDispatcher dispatcher = req.getRequestDispatcher(view_page);
			dispatcher.forward(req, res);
		}
	}
}




