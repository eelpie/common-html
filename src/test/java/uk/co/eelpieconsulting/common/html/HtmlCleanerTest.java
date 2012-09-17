package uk.co.eelpieconsulting.common.html;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class HtmlCleanerTest {
	
	private HtmlCleaner cleaner;

	@Before
	public void setup() {
		cleaner = new HtmlCleaner();		
	}
	
	@Test
	public void shouldStripAllTags() throws Exception {
		assertEquals("Blah blah blah.", cleaner.stripHtml("Blah <i>blah</i> blah."));
	}
	
	@Test
	public void shouldBeCaseInsensitive() throws Exception {
		assertEquals("Blah blah blah.", cleaner.stripHtml("Blah <I>blah</I> blah."));
	}
	
	@Test
	public void paragraphBreaksAreConvertedToLineBreaks() throws Exception {
		assertEquals("Blah.\n\nblah blah.", cleaner.stripHtml("<p>Blah.</p><P>blah blah.</P>"));
	}
	
	@Test
	public void headingEndsAreConvertedToLineBreaks() throws Exception {
		assertEquals("Heading\n\none\n\ntwo", cleaner.stripHtml("Heading\n\none\n\ntwo"));
	}

}
