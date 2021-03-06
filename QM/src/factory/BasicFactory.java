package factory;

import java.io.FileReader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Properties;

import dao.Dao;

import annotation.Tran;

import service.Service;
import util.TransactionManager;



public class BasicFactory {
	private static BasicFactory factory = new BasicFactory();
	private static Properties prop = null;
	private BasicFactory(){}
	static{
		try {
			prop = new Properties();
			prop.load(new FileReader(BasicFactory.class.getClassLoader().getResource("config.properties").getPath()));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public static BasicFactory getFactory(){
		return factory;
	}
	
	@SuppressWarnings("unchecked")
	
	public <T extends Service> T getService(Class<T> clazz){
		try{
			
			String infName = clazz.getSimpleName();
			String implName = prop.getProperty(infName);
			final T service = (T) Class.forName(implName).newInstance();
			
			
			T proxyService =  (T) Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces()
				 , new InvocationHandler(){
				
					public Object invoke(Object proxy, Method method,Object[] args) throws Throwable {
						
						if(method.isAnnotationPresent(Tran.class)){
							try{
								TransactionManager.startTran();
								
								Object obj = method.invoke(service, args);
								
								TransactionManager.commit();
								return obj;
							}catch (InvocationTargetException e) {
								TransactionManager.rollback();
								throw new RuntimeException(e.getTargetException());
							} catch (Exception e) {
								TransactionManager.rollback();
								throw new RuntimeException(e);
							}finally{
								TransactionManager.release();
							}
						}else{
							return method.invoke(service, args);
						}
					}
				 
			 });
			 
			return proxyService;
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * ��ȡdao�ķ���
	 */
	public <T extends Dao> T getDao(Class<T> clazz){
		try{
			String infName = clazz.getSimpleName();
			String implName = prop.getProperty(infName);
			return (T) Class.forName(implName).newInstance();
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
//	public <T> T getInstance(Class<T> clazz){
//		try{
//		String infName = clazz.getSimpleName();
//		String implName = prop.getProperty(infName);
//		return (T) Class.forName(implName).newInstance();
//		}catch (Exception e) {
//			e.printStackTrace();
//			throw new RuntimeException(e);
//		}
//	}
	
}
