package container;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

public class ServletClassLoader extends ClassLoader {
	// kittycat/webapp的根路径
	
	/**
	public Class<?>  loadClass(String path,String name) 
	{
		//首先检查父加载器是否加载过该类
		Class clazz=findLoadedClass(name);
		if(clazz!=null)
			return clazz;
		try{
			//servlet的存放路径
			
			String filename=name+".class";
			InputStream in=getClass().getResourceAsStream(filename);
			if(in==null)
			{
				Path spath=Paths.get(name);
				in=Files.newInputStream(spath);
				
			}
			byte[] b=new byte[in.available()];
			in.read(b);
			return defineClass(name, b, 0, b.length);
		}catch(IOException e)
		{
			
		}
		return null;
	}*/
	/**
	 * 校验是否已经加载过该类
	 */
	public Class findClass(String className)
	{
		return findLoadedClass(className);
	}
	/**
	 * 根据webapp名称和servlet名称加载servlet class
	 * @param appName
	 * @param servletName
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws MalformedURLException 
	 */
	public Class loadServlet(String appName,String servletName) throws ClassNotFoundException, MalformedURLException
	{
		URL[] urls=new URL[1];
		String path=AppContext.WEB_ROOT+File.separator+appName+File.separator+"bin"+File.separator;
		
			
			String repository=(new URL("file",null,path)).toString();
			URLStreamHandler handler=null;
			urls[0]=new URL(null,repository,handler);
			URLClassLoader loader=new URLClassLoader(urls);
			Class clazz=findClass(servletName);
			if(clazz!=null)
				return clazz;
			else{
				for(URL url:loader.getURLs())
					System.out.println(url.getPath());
				return loader.loadClass(servletName);
			}
	
		
	}
  
   
   

}
