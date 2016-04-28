package container.resources;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import connector.HttpWrapper;
import container.ServletClassLoader;
import exception.ObjNotAServletException;
import exception.ServletPathException;

/**
 * 处理对servlet的请求
 * @author Administrator
 *
 */
public class ServletProcessor {
	private HttpWrapper wrapper=null;
    public ServletProcessor(HttpWrapper wp)
    {
    	this.wrapper=wp;
    }
    /**
     * 处理对servlet的请求，包括加载servlet和执行servlet
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws ServletPathException
     * @throws ServletException
     * @throws IOException
     * @throws ObjNotAServletException
     */
    public void process() throws ClassNotFoundException, InstantiationException, IllegalAccessException, ServletPathException, ServletException, IOException, ObjNotAServletException
    {
    	Object obj=getServletInstance();
    	if(obj instanceof Servlet){
    		Servlet servlet=(Servlet)obj;
    		excuteServlet(servlet);
    	}else{
    		throw new ObjNotAServletException();
    	}
    	
    }
   
	/**
	 * 加载servlet class文件
	 * @return
	 * @throws ServletPathException 
	 * @throws MalformedURLException 
	 * @throws ClassNotFoundException 
	 */
	public Class loadServletClass() throws ServletPathException, ClassNotFoundException, MalformedURLException
	{
		String uri=wrapper.getRequest().getUri();
		//请求url: /app/servlet/servletName
		String[] paths=uri.split("/");
		if(paths.length<2)
			throw new ServletPathException();
		
		String appName=paths[1];    //webapp的名
		String servletName="servlet."+paths[3]; //servlet的名称
		ServletClassLoader servletLoader=new ServletClassLoader();
		return servletLoader.loadServlet(appName,servletName);
	}
	/**
	 * 执行servlet 的service方法
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void excuteServlet(Servlet servlet) throws ServletException, IOException 
	{
		servlet.service(wrapper.getRequest(), wrapper.getResponse());
	}
	/**
	 * 获取servlet的实例
	 * @return
	 * @throws ClassNotFoundException
	 * @throws MalformedURLException
	 * @throws ServletPathException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	private Object getServletInstance() throws ClassNotFoundException, MalformedURLException, ServletPathException, InstantiationException, IllegalAccessException
	{
		Class servletClass=loadServletClass();
		if(servletClass==null)
			throw new ClassNotFoundException();
		
		return servletClass.newInstance();
		
		
	}
}
