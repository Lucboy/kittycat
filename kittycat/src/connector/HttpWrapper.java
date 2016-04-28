package connector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import container.http.Request;
import container.http.Response;
/**
 * ��װһ��http�����request��response����
 * @author Administrator
 *
 */
public class HttpWrapper {
	private  Request request;
	private  Response response;
	public HttpWrapper(InputStream req,OutputStream rsp)
	{
		this.request=new Request(req);
		this.response=new Response(rsp);
	}
	public Request getRequest() {
		return request;
	}
	
	public Response getResponse() {
		return response;
	}
	public void wrap() throws IOException
	{
		request.headParse();
	}

}
