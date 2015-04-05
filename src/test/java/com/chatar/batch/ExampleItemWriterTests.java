package com.chatar.batch;

import java.util.ArrayList;
import java.util.List;

import com.chatar.batch.ExampleItemWriter;

import junit.framework.TestCase;

public class ExampleItemWriterTests extends TestCase {

	private ExampleItemWriter writer = new ExampleItemWriter();
	
	public void testWrite() throws Exception {
		List<String> writeList = new ArrayList<String>();
		writeList.add("One");
		writeList.add("Two");
		writeList.add("Three");
		writeList.add("Four");
		writer.write(writeList); // nothing bad happens
	}

}
