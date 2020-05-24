package personal.unittest.junit;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;



//this test class only need junit:4.12
public class VersionTest {
	
//	@Before
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	
//	@Ignore
	@Test(expected=IllegalArgumentException.class, timeout=10)
	public void notNullTest(){
		new Version(null);
	}
	
	//Please comment out the org.mockito:mockito-all:1.10.19
	@Test
	public void notNullWithMessageTest(){
		exceptionRule.expect(IllegalArgumentException.class);
	    exceptionRule.expectMessage(Version.notNull);
	    new Version(null);
	}
	
	@Test//this is test means no exception thrown
	public void CorrectTest() {
//		exceptionRule.none();
	new Version("2.3.4");
	}
	
	@Test
	public void getVersiotnTest(){
		Version ver = new Version("1.2.3");
		assertEquals("1.2.3", ver.getVersion());
	}
	
	@Test
	public void getVersionTest2(){
		Version ver = new Version("1.2.3");
		assertThat(ver.getVersion(), is("1.2.3"));
	}

}



