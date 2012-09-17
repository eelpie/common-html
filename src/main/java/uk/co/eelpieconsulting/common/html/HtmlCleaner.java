package uk.co.eelpieconsulting.common.html;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringEscapeUtils;

public class HtmlCleaner {

	private Pattern headingEnd = Pattern.compile("</h\\d>");
	private Pattern p = Pattern.compile("</p>");
	private Pattern br = Pattern.compile("<br ?/>");
	private Pattern tags = Pattern.compile("<.*?>");
	
	public String stripHtml(String content) {
		if (content == null) {
			return null;
		}
		
		content = headingEnd.matcher(content).replaceAll("\n\n");
		content = p.matcher(content).replaceAll("\n\n");
		content = br.matcher(content).replaceAll("\n");
		content = content.replaceAll("\n{2,}", "\n\n");		

		content = tags.matcher(content).replaceAll("");		
		content = StringEscapeUtils.unescapeHtml4(content);
		
		return content.trim();
	}

}
