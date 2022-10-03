package main.java.by.bsuir.task02.entity.criteria;

import java.util.HashMap;
import java.util.Map;

/**
 * Criteria class
 */
public class Criteria {

	private final String groupSearchName;
	private final Map<String, Object> criteria = new HashMap<String, Object>();

	public Criteria(String groupSearchName) {
		this.groupSearchName = groupSearchName;
	}

	/**
	 * @return
	 */
	public String getGroupSearchName() {
		return groupSearchName;
	}

	/**
	 * @param searchCriteria - criteria to search
	 * @param value - correspond object
	 */
	public void add(String searchCriteria, Object value) {
		criteria.put(searchCriteria, value);
	}

	/**
	 * @return criteria set
	 */
	public Map<String, Object> getCriteria() {
		return criteria;
	}

}
