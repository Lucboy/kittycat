package connector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.servlet.ServletException;

import container.jobPool.HttpJob;
import exception.NullHttpWrapperException;
import exception.ObjNotAServletException;
import exception.ServletPathException;
import excutor.Excutor;

public class HttpServer {
	
	private  static String basepath; //��·��
	private  static ServerSocket serversock; //�����socket
	private final static int port=8080;//�����Ĭ�ϼ����Ķ˿ں�
	private final static Excutor excutor=new Excutor();
	
	
	public static void start() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, ServletPathException, ServletException, ObjNotAServletException, NullHttpWrapperException
	{
		serversock=new ServerSocket(port);
		Socket client=null;
		//���ϵؽ������Կͻ��˵�����
		while(true){
			InputStream in=null;
			OutputStream out=null;
			while((client=serversock.accept())!=null)
			{
				in=client.getInputStream();
				out=client.getOutputStream();
				
				//ÿ��http���󶼷�װ��һ��HttpJob
				HttpJob job=new HttpJob(in,out);
				excutor.pushJob(job);
				client=null;
				
			}
		}
		
	}
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, ServletPathException, ServletException, ObjNotAServletException, NullHttpWrapperException
	{
		HttpServer server=new HttpServer();
		server.start();
	}
}

 