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
 *  HttpJob ����һ��http����ִ������
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
	/**����http����ͷ�Ĳ����ŵ������������ִ��
	 * ÿ��HTTP����Ҫ����Processor����Ƶ���ش����������ϴ󣬿��Կ���ʹ�ö����
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
		wrapper.wrap();//�����������ʼ����request����ͷ
		
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
