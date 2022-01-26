package personal.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionForURL {
	
	
	public static void main(String[] args) {
//		String url = "http://my.domain.url/order/resources/";
//		String url = "jdbc:mysql://dbserver/mxvalues?user=mxims&password=sol2185fi#";
		String url = "mongodb:27017";
//		Pattern pattern = Pattern.compile("^.*?\\/\\/([^/\\/\\s]+)");
//		Matcher matcher = pattern.matcher(url);
//		
//		System.out.println(url);
//		
//		String matchUrl = "";
//		while (matcher.find()) {
//		    System.out.println("Domain: " + matcher.group(1));
//		    matchUrl = matcher.group(1);
//		}
//		
//		String replaced = url.replace(matchUrl, "localhost:1111");
//		System.out.println(replaced);
//		
//		System.out.println(url.replaceAll("^.*?\\/\\/([^/\\/\\s]+)",  "localhost:1111"));
//		
//		System.out.println(Pattern.compile("^.*?\\/\\/([^/\\/\\s]+)").matcher(url).replaceFirst(replaced));
		
		
		System.out.println("--------------------------------------");
		
		Pattern pattern2 = Pattern.compile("(.*://)([^:^/]*)(:\\d*)?(.*)?");
//		Pattern pattern2 = Pattern.compile("(https?://)([^:^/]*)(:\\d*)?(.*)?");
		Matcher matcher2 = pattern2.matcher(url);
		
		if(!matcher2.find()) {
			System.out.println("no matcher found");
			return;
		}
		String protocol = matcher2.group(1);            
		String domain   = matcher2.group(2);
		String port     = matcher2.group(3);
		String uri      = matcher2.group(4);
		
		System.out.println("url: " + url);
		System.out.println("--------------------------------------");
		System.out.println("protocol: " + protocol);
		System.out.println("domain: " + domain);
		System.out.println("port: " + port);
		System.out.println("uri: " + uri);
		System.out.println("--------------------------------------");
		System.out.println("url: " + url);
		
		if(port != null) {
			System.out.println(url.replace(domain, "localhost").replace(port, ":1111"));
		}else {
			System.out.println(url.replace(domain, "localhost" + ":1111"));
		}
		
		
	}

}