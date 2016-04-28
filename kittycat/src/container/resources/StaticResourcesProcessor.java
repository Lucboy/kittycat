package container.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import connector.HttpWrapper;
import container.AppContext;
import container.http.Response;
import exception.NullHttpWrapperException;

/**
 * 处理对静态资源的请求
 * @author Administrator
 *
 */
public class StaticResourcesProcessor {
	HttpWrapper wrapper;
	public StaticResourcesProcessor(HttpWrapper wap)
	{
		this.wrapper=wap;
	}
	public void process() throws NullHttpWrapperException, IOException
	{ 
		if(wrapper==null)
			throw new NullHttpWrapperException();
		
		String uri=wrapper.getRequest().getUri();
		if(uri.endsWith(".html"))
			processHtml();
		else
			processMedia();
				
	}
	private void processHtml() throws IOException
	{

		String uri=wrapper.getRequest().getUri();
		
		String path=AppContext.WEB_ROOT+File.separator+uri.substring(1);
		File file=new File(path);
		if(!file.exists())
		{
			String errorMassage="HTTP/1.1 404 File Not found\r\n"+
			"Content-Type:text/html\r\n"+
			"Content-Length:23\r\n"+
			"\r\n"+
			"<html><body><h1>File Not Found</h1></body></html>";
			PrintWriter writer=wrapper.getResponse().getWriter();
			writer.write(errorMassage);
		}else{
			
		
		FileInputStream filein=new FileInputStream(file);
		byte[] buff=new byte[4086];
		OutputStream out=wrapper.getResponse().getOutputStream();
		while(filein.read(buff)!=-1)
		{
			out.write(buff);
		}
		filein.close();
		out.flush();
		out.close();
		}
	}
		
	
	
	private void processMedia() throws IOException
	{  
		String uri=wrapper.getRequest().getUri().substring(1);
		String path=AppContext.WEB_ROOT+File.separator+uri;
		File file=new File(path);
		if(!file.exists())
		{
			String errorMassage="HTTP/1.1 404 File Not found\r\n"+
			"Content-Type:text/html\r\n"+
			"Content-Length:23\r\n"+
			"\r\n"+
			"<html><body><h1>File Not Found</h1></body></html>";
			Response resp=wrapper.getResponse();
			if(resp!=null){
				PrintWriter writer=resp.getWriter();
				writer.write(errorMassage);
			}else{
				System.out.println("response is null");
			}
		}else{
			
		FileInputStream filein=new FileInputStream(file);
		byte[] buff=new byte[4086];
		OutputStream out=wrapper.getResponse().outputStream();
		while(filein.read(buff)!=-1)
		{
			out.write(buff);
		}
		filein.close();
		out.flush();
		out.close();
		
	}
	}

}
