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
 * �����servlet������
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
     * �����servlet�����󣬰�������servlet��ִ��servlet
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
	 * ����servlet class�ļ�
	 * @return
	 * @throws ServletPathException 
	 * @throws MalformedURLException 
	 * @throws ClassNotFoundException 
	 */
	public Class loadServletClass() throws ServletPathException, ClassNotFoundException, MalformedURLException
	{
		String uri=wrapper.getRequest().getUri();
		//����url: /app/servlet/servletName
		String[] paths=uri.split("/");
		if(paths.length<2)
			throw new ServletPathException();
		
		String appName=paths[1];    //webapp����
		String servletName="servlet."+paths[3]; //servlet������
		ServletClassLoader servletLoader=new ServletClassLoader();
		return servletLoader.loadServlet(appName,servletName);
	}
	/**
	 * ִ��servlet ��service����
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void excuteServlet(Servlet servlet) throws ServletException, IOException 
	{
		servlet.service(wrapper.getRequest(), wrapper.getResponse());
	}
	/**
	 * ��ȡservlet��ʵ��
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
