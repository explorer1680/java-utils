package test;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Document {
	String name;
	String description;
	String createdBy;
	String lastModifiedBy;
	Long sizeInBytes;
	Long createdTime;
	Long modifiedTime;

	/**
	 * Prints a report of the list of documents in the following format:
	 *
	 * Group by document.createdBy Sort the groups using document.createdBy
	 * ascending, case insensitive Sort each sub list of documents by
	 * document.createdTime ascending Format the output of document.size to be a
	 * more friendly format. Ex. 50 mb, 900 k, 342 bytes, etc... Format the
	 * dates using the format: yyyy-MM-dd Format the output of
	 * document.description such that - no more than the first 25 characters of
	 * the description are displayed - don't truncate any words unless the first
	 * word is longer than 25 characters - display "..." at the end of the
	 * description to indicate that it has been truncated (these three
	 * characters do not count as part of the 25 character limit)
	 *
	 * Example: Andy Andrews "Bobby Timmons Biography","An exhaustive look at
	 * the ...",233 mb,2013-05-09,2013-05-14 "Apple Sauce","Study of apple
	 * sauces.”,87 gb,2013-05-10,2013-05-10 "Zed","All matters, A to Zed”,924
	 * k,2013-05-12,2013-05-12 Janet Smith "Xray","How the Xray shows your
	 * ...",48 mb,2010-10-22,2010-12-02 "Computers","Inventory list of ...",423
	 * bytes,2013-03-01,2013-02-17
	 *
	 *
	 * @param documents
	 *            not null
	 */

	public void printDocumentsReport(List<Document> documents) {

//		Map<String, List<Document>> documentMap = new HashMap<>();

//		 documents.stream().forEach(d -> {
//		 String createdBy = d.getCreatedBy();
//		 if(documentMap.containsKey(createdBy)){
//		 documentMap.get(createdBy).add(d);
//		 }else{
//		 List<Document> tempList = new ArrayList<>();
//		 tempList.add(d);
//		 documentMap.put(createdBy, tempList);
//		 }
//		 });
		
		Map<String, List<Document>> documentMap = documents.stream().collect(Collectors.groupingBy(Document::getCreatedBy));

//		documents.stream().forEach(d -> {
//			String createdBy = d.getCreatedBy();
//			documentMap.computeIfAbsent(createdBy, k -> new ArrayList<>());
//			
//			documentMap.get(createdBy).add(d);
////			documentMap.computeIfPresent(createdBy, (k,v) -> v.add(d));
//		});

		Set<String> keySet = documentMap.keySet();
		keySet.stream().sorted().forEach(e -> {
			System.out.println(e);
			documentMap.get(e).stream().sorted(Comparator.comparing(d -> d.getCreatedTime(), Comparator.reverseOrder()))
					.forEach(System.out::println);
		});

	}

	@Override
	public String toString() {
		return "\t" + "\"" + this.name + "\"" + "," + "\"" + printDescription(this.description) + "\"" + ","
				+ printSize(this.sizeInBytes) + "," + printDate(this.createdTime);
	}

	private String printDate(long time) {
		Date date = new Date(time);
		Format format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}

	private String printSize(Long sizeInBytes) {
		if (sizeInBytes == null) {
			return "0 Byte";
		}
		Long sizeInK = sizeInBytes / 1024;
		Long sizeInB = sizeInBytes % 1024;
		Long sizeInM = sizeInK / 1024;
		sizeInK = sizeInK % 1024;
		Long sizeInG = sizeInM / 1024;
		sizeInM = sizeInM % 1024;
		StringBuilder sb = new StringBuilder();
		if (sizeInG > 0) {
			sb.append(sizeInG);
			sb.append(" GB");
		} else if (sizeInM > 0) {
			sb.append(sizeInM);
			sb.append(" MB");
		} else if (sizeInK > 0) {
			sb.append(sizeInK);
			sb.append(" KB");
		} else {
			sb.append(sizeInB);
			sb.append(" Byte");
		}
		return sb.toString();
	}

	private String printDescription(String description) {
		if (description == null) {
			return description;
		}
		if (description.length() > 25) {
			return description.substring(0, 25) + "...";
		} else {
			return description;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Long getSizeInBytes() {
		return sizeInBytes;
	}

	public void setSizeInBytes(Long sizeInBytes) {
		this.sizeInBytes = sizeInBytes;
	}

	public Long getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Long createdTime) {
		this.createdTime = createdTime;
	}

	public Long getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Long modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
}
