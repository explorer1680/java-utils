package personal.unittest.junit;

public class Version {
	
	private String version;
	
	static final String notNull="'version' can not null!";
	
	public Version(String version){
//		System.out.println(version);
		if(version ==null){
			throw new IllegalArgumentException(Version.notNull);
		}
		
		if(version.endsWith("SNAPSHOT")){
			isSnapshot();
		}
		this.version = version;
	}
	
	public void isSnapshot(){
	}
	
	public String getVersion(){
		return this.version;
	}
	

}
