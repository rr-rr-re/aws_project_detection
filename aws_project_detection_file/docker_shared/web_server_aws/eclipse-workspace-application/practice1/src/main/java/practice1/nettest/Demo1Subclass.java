package practice1.nettest;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.media.multipart.MultiPartFeature;

import practice1.rest.UserDto.UserDto;
import process.ProcessService;

import javax.ws.rs.ApplicationPath;
import java.nio.file.DirectoryStream.Filter;
import java.util.HashSet;
import java.util.Set;



@ApplicationPath("sample")
public class Demo1Subclass extends Application {
	
	@Override
	public Set<Class<?>> getClasses() {

		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(ProofWeb.class);
		classes.add(Demo1ServiceResource.class);
		classes.add(UserDto.class);
		classes.add(ProcessService.class);
		classes.add(MultiPartFeature.class);
	
		
		return classes;
	}

}
