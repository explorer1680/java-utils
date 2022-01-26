package personal.unittest.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

//import static org.powermock.api.mockito.PowerMockito.*;
import static org.mockito.Mockito.*;
import personal.unittest.junit.Version;



@RunWith(PowerMockRunner.class)
@PrepareForTest(Version.class)
public class VersionTest {
	
	@Test
	public void constructorCallingMethodTest() throws Exception{
		Version version =Mockito.mock(Version.class, Mockito.withSettings()
				   .useConstructor("1.2.3.SNAPSHOT").defaultAnswer(Mockito.CALLS_REAL_METHODS));
		
//		Version version =mock(Version.class);
//		Mockito.when(version.getVersion()).thenReturn("Hello");
		
		
//		when(new Version).thenReturn(null);
		
//		 verify(version, times(1)).isSnapshot();
		
//		Version original = new Version("abc");
//		
//		Version spy = Mockito.spy(original);
		
//		Version mock =Mockito.mock(Version.class);
		

		
		
//		whenNew(Version.class).withArguments(String.class).thenCallRealMethod();
		
		PowerMockito.whenNew(Version.class).withArguments(String.class).thenReturn(version);
		 Version ver = new Version("1.2.3.SNAPSHOT");
		 Mockito.verify(version).isSnapshot();
		 
		 System.out.println("123");
		 
//		 verifyNew(Version.class).withArguments("1.2.3.SNAPSHOT");
		 
		 
		
		 
//		 PowerMockito.whenNew(Version.class).withAnyArguments().thenCallRealMethod();
		
		 
//		 PowerMockito.spy(Version.class);
	}

}





