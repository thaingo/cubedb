package org.cubedb.core;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.cubedb.core.beans.DataRow;
import org.cubedb.core.beans.Filter;
import org.cubedb.core.beans.GroupedSearchResultRow;

public interface Cube {
	void insert(List<DataRow> data);
	Map<GroupedSearchResultRow, Long> get(
		String fromPartition, String toPartition, List<Filter> filters, String groupBy);
	Map<GroupedSearchResultRow, Long> get(
		int lastRange, List<Filter> filters, String groupBy);
	//int getNumRecords();
	void deletePartition(String partitionName);
	TreeSet<String> getPartitions(String from, String to);
	void save(String saveFileName) throws FileNotFoundException, IOException;
	void load(String saveFileName) throws IOException;
	Map<String, Object> getStats();
	void saveAsJson(String saveFileName, String cubeName);
	public int optimize();
}
