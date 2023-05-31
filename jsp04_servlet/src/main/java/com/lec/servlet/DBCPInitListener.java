package com.lec.servlet;

import java.io.IOException;
import java.io.StringReader;
import java.sql.DriverManager;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class DBCPInitListener implements ServletContextListener { 
	// ServletContextListener = 웹 애플리케이션이 시작:종료될 때 호출할 메서드를 정의한 인터페이스 

	@Override
	public void contextInitialized(ServletContextEvent sce) { // 웹 애플리케이션을 초기화할 때 호출
		// contextInitialized메서드는 web.xml의 <context-param>태그의 정보를 읽어오는 메서드
		String poolConfig = sce.getServletContext().getInitParameter("dbConnect");
		// getServletContext()메서드를 이용하면 web.xml파일에 설정된 컨텍스트 초기화 파라미터를 구할수 있다.
		System.out.println(poolConfig);
		
		Properties prop = new Properties();
		
		try {
			prop.load(new StringReader(poolConfig));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		loadJDBCDriver(prop);
		initConnectionPool(prop);
	}
	
	private void loadJDBCDriver(Properties prop) {
		String drv = prop.getProperty("jdbcDriver");
		
		System.out.println(drv);
		
		try {
			Class.forName(drv);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("JDBC드라이버 로딩 실패!!!");
		}
		
	}
	
	private void initConnectionPool(Properties prop) {
		
		String url = prop.getProperty("url");
		String usr = prop.getProperty("user");
		String pwd = prop.getProperty("pass");

		ConnectionFactory cf = new DriverManagerConnectionFactory(url, usr, pwd);
		PoolableConnectionFactory pcf = new PoolableConnectionFactory(cf, null);	
		pcf.setValidationQuery("select 1"); 

		GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
		poolConfig.setTimeBetweenEvictionRunsMillis(1000l * 60l * 5l); // 검사주기 5분
		poolConfig.setTestWhileIdle(true);
		poolConfig.setMinIdle(5);
		poolConfig.setMaxIdle(10);
		
		GenericObjectPool<PoolableConnection> cp = new GenericObjectPool<>(pcf, poolConfig);
		pcf.setPool(cp);
		
		try {
			Class.forName("org.apache.commons.dbcp2.PoolingDriver");
			PoolingDriver driver = (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
			String poolName = prop.getProperty("poolName");
			driver.registerPool(poolName, cp);
		} catch (Exception e) {
			throw new RuntimeException("DB 접속 실패!!!");
		}			
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) { // 웹 애플리케이션을 종료할 때 호출
		// dummy
	}
}
