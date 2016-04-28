package Lock;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import container.http.Request;
import container.http.Response;

public class RequestProcessor {
	private String WEBROOT="kittycat";
	private String basepath=System.getProperty("user.dir").trim()+File.separator+WEBROOT;
	private String projectUrl;
	private Request request;
	private Response response;
	private boolean isStaticResource;//������Ǿ�̬��Դ��
	private boolean isServlet;//�������servlet��
	public RequestProcessor(Request req,Response rep)
	{
		this.request=req;
		this.response=rep;
	}
	public RequestProcessor(InputStream in,OutputStream out)
	{
		this.request=new Request(in);
		this.response=new Response(out);
	}
	public void process() throws ClassNotFoundException, IOException
	{
		System.out.println("��������");
		if(this.request!=null&&this.response!=null)
		{        request.headParse();
				String[] urlsplit=null;
				if(request.getUri().indexOf('?')>0)
					urlsplit=request.getUri().split("\\?");//�Ѳ�����uri�ֿ�
				else 
					urlsplit[0]=request.getUri();
				String[] uri=urlsplit[0].split("/");         // uri: project/servlet/.....
				if(uri.length>0)
				{
					this.projectUrl=uri[1];      //web��Ŀ����
					if("servlet".equals(uri[2]))
					{
						this.isServlet=true;
						loadServlet(uri[3]);    //������Ӧ��servlet
					}else{
						this.isStaticResource=true;
						loadStaticResource(uri[2]);//������Ӧ�ľ�̬��Դ
					}
						
				}
		}
			
	}
	public void loadServlet(String servletName) throws ClassNotFoundException
	{
		String loadurl=basepath+File.separator+projectUrl+File.separator+"servlet"+File.separator+servletName;
		System.out.println("servlet path:"+loadurl);
		Class servletClass=ClassLoader.getSystemClassLoader().loadClass(loadurl);//������Ӧ��servlet

		
	}
	public void loadStaticResource(String resourceName)
	{
		String loadurl=basepath+File.separator+projectUrl+File.separator+"servlet"+File.pathSeparator+resourceName;
		System.out.println("servlet path:"+loadurl);
	}

}
