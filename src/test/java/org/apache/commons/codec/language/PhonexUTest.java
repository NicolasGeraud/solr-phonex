package org.apache.commons.codec.language;

import org.junit.Assert;
import org.junit.Test;


/**
 * test des différents sons français
 * @author Nicolas Geraud
 */
public class PhonexUTest {

	@Test
	public void testPhonexQ() {
		String string1 = Phonex.phonex("claude");
		String string2 = Phonex.phonex("klaude");
		Assert.assertTrue(string1.equals(string2));
		string2 = Phonex.phonex("qulaude");
		Assert.assertTrue(string1.equals(string2));
		string2 = Phonex.phonex("qlaude");
		Assert.assertTrue(string1.equals(string2));
	}

	@Test
	public void testPhonexI() {
		String string1 = Phonex.phonex("charlie");
		String string2 = Phonex.phonex("charly");
		Assert.assertTrue(string1.equals(string2));
	}

	@Test
	public void testPhonexH() {
		String string1 = Phonex.phonex("Nicolas");
		String string2 = Phonex.phonex("hNhihcohlhahs");
		Assert.assertTrue(string1.equals(string2));
	}

	@Test
	public void testPhonexCH() {
		String string1 = Phonex.phonex("chocolat");
		String string2 = Phonex.phonex("shocolat");
		Assert.assertTrue(string1.equals(string2));
	}

	@Test
	public void testPhonexF() {
		String string1 = Phonex.phonex("facile");
		String string2 = Phonex.phonex("phacile");
		Assert.assertTrue(string1.equals(string2));
	}

	@Test
	public void testPhonexCasse() {
		String string1 = Phonex.phonex("Nicolas");
		String string2 = Phonex.phonex("nIcOlAs");
		Assert.assertTrue(string1.equals(string2));
	}

	@Test
	public void testPhonexIN() {
		String string1 = Phonex.phonex("lapin");
	
		String string2 = Phonex.phonex("lapyne");
		Assert.assertTrue(string1.equals(string2));
	
		string2 = Phonex.phonex("lapain");
		Assert.assertTrue(string1.equals(string2));
	
		string2 = Phonex.phonex("lapaim");
		Assert.assertTrue(string1.equals(string2));
	
		string2 = Phonex.phonex("lapayn");
		Assert.assertTrue(string1.equals(string2));
	
		string2 = Phonex.phonex("lapein");
		Assert.assertTrue(string1.equals(string2));
	
		string2 = Phonex.phonex("lapeim");
		Assert.assertTrue(string1.equals(string2));
	
		string2 = Phonex.phonex("lapeym");
		Assert.assertTrue(string1.equals(string2));
	}

	@Test
	public void testPhonexO() {
		String string1 = Phonex.phonex("manteau");
		String string2 = Phonex.phonex("manto");
		Assert.assertTrue(string1.equals(string2));
		string2 = Phonex.phonex("mantau");
		Assert.assertTrue(string1.equals(string2));
	}

	@Test
	public void testPhonexEI() {
		String string1 = Phonex.phonex("né");
		String string2 = Phonex.phonex("nei");
		Assert.assertTrue(string1.equals(string2));
		string2 = Phonex.phonex("nè");
		Assert.assertTrue(string1.equals(string2));
		string2 = Phonex.phonex("nê");
		Assert.assertTrue(string1.equals(string2));
		string2 = Phonex.phonex("nai");
		Assert.assertTrue(string1.equals(string2));
	}

	@Test
	public void testPhonexEN() {
		String string1 = Phonex.phonex("dent");
		String string2 = Phonex.phonex("dans");
		Assert.assertTrue(string1.equals(string2));
		string2 = Phonex.phonex("dam");
		Assert.assertTrue(string1.equals(string2));
		string2 = Phonex.phonex("dem");
		Assert.assertTrue(string1.equals(string2));
	}


}