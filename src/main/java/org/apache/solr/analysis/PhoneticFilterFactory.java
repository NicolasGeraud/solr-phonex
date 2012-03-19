package org.apache.solr.analysis;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.Encoder;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.apache.commons.codec.language.Metaphone;
import org.apache.commons.codec.language.RefinedSoundex;
import org.apache.commons.codec.language.Soundex;
import org.apache.lucene.analysis.TokenStream;
import org.apache.solr.analysis.BaseTokenFilterFactory;
import org.apache.solr.analysis.PhoneticFilter;
import org.apache.solr.common.SolrException;

import org.apache.commons.codec.language.Phonex;

public class PhoneticFilterFactory extends BaseTokenFilterFactory {

	public static final String ENCODER = "encoder";
	public static final String INJECT = "inject"; // boolean

	protected boolean inject = true;
	protected String name = null;
	protected Encoder encoder = null;

	private static final Map<String, Class<? extends Encoder>> registry;
	static {
		registry = new HashMap<String, Class<? extends Encoder>>();
		registry.put("DoubleMetaphone".toUpperCase(), DoubleMetaphone.class);
		registry.put("Metaphone".toUpperCase(), Metaphone.class);
		registry.put("Soundex".toUpperCase(), Soundex.class);
		registry.put("RefinedSoundex".toUpperCase(), RefinedSoundex.class);
		registry.put("Phonex".toUpperCase(), Phonex.class);
	}

	@Override
	public void init(Map<String, String> args) {
		super.init( args );
		
		inject = getBoolean(INJECT, true);

		String name = args.get(ENCODER);
		if (name == null) {
			throw new SolrException(SolrException.ErrorCode.SERVER_ERROR,
					"Missing required parameter: " + ENCODER + " ["
							+ registry.keySet() + "]");
		}
		Class<? extends Encoder> clazz = registry.get(name.toUpperCase());
		if (clazz == null) {
			throw new SolrException(SolrException.ErrorCode.SERVER_ERROR,
					"Unknown encoder: " + name + " [" + registry.keySet() + "]");
		}

		try {
			encoder = clazz.newInstance();

			// Try to set the maxCodeLength
			String v = args.get("maxCodeLength");
			if (v != null) {
				Method setter = encoder.getClass().getMethod("setMaxCodeLen",
						int.class);
				setter.invoke(encoder, Integer.parseInt(v));
			}
		} catch (Exception e) {
			throw new SolrException(SolrException.ErrorCode.SERVER_ERROR,
					"Error initializing: " + name + "/" + clazz, e, false);
		}
	}
	
	public PhoneticFilter create(TokenStream input) {
	    return new PhoneticFilter(input,encoder,name,inject);
	  }
}
