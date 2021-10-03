package personal.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionForURL {
	
	
	public static void main(String[] args) {
		String url = "http://localhost:9180/order/resources/";
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

		matcher2.find();

		String protocol = matcher2.group(1);            
		String domain   = matcher2.group(2);
		String port     = matcher2.group(3);
		String uri      = matcher2.group(4);
		
		System.out.println(url);
		System.out.println(protocol);
		System.out.println(domain);
		System.out.println(port);
		System.out.println(uri);
		System.out.println(url);
		
		System.out.println(url.replace(domain, "localhost").replace(port, ":1111"));
		
	}

}