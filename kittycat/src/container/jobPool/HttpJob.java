package container.jobPool;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;

import connector.HttpWrapper;
import container.resources.ServletProcessor;
import container.resources.StaticResourcesProcessor;
import exception.NullHttpWrapperException;
import exception.ObjNotAServletException;
import exception.ServletPathException;

/**
 *  HttpJob 代表一个http请求执行任务
 */
public class HttpJob{
	private HttpWrapper wrapper;
	public HttpJob(HttpWrapper obj)
	{
		this.wrapper=obj;
	}
	public HttpJob(InputStream in,OutputStream out)
	{
		this.wrapper=new HttpWrapper(in,out);
	}
	/**解析http请求头的操作放到这里才真正的执行
	 * 每次HTTP请求都要创建Processor对象，频繁地创建对象开销较大，可以考虑使用对象池
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ServletPathException
	 * @throws ServletException
	 * @throws IOException
	 * @throws ObjNotAServletException
	 * @throws NullHttpWrapperException
	 */
	public void excuteJob() throws ClassNotFoundException, InstantiationException, IllegalAccessException, ServletPathException, ServletException, IOException, ObjNotAServletException, NullHttpWrapperException {
		// TODO Auto-generated method stub
		if(wrapper==null)
			return;
		wrapper.wrap();//这里才真正开始解析request请求头
		
		if(wrapper.getRequest().getUri().contains(("/servlet")))
		{	
			ServletProcessor processor=new ServletProcessor(wrapper);
			processor.process();
		
		}else{
			StaticResourcesProcessor processor=new StaticResourcesProcessor(wrapper);
			processor.process();
		}
	}

}
