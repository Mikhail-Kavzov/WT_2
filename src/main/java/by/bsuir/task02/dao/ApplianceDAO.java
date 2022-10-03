package main.java.by.bsuir.task02.dao;

import main.java.by.bsuir.task02.entity.criteria.Criteria;
import main.java.by.bsuir.task02.entity.Appliance;

import java.util.List;

/**
 * DAO Interface
 */
public interface ApplianceDAO {

	/**
	 * @param criteria - criteria to find
	 * @return
	 */
	List<Appliance> find(Criteria criteria);

	/**
	 * @param appliances - appliances List
	 */
	void save(List<Appliance> appliances);

	/**
	 * @return Appliance List
	 */
	List<Appliance> parseAll();
}
