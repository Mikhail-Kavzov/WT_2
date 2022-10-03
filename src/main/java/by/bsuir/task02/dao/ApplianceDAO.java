package main.java.by.bsuir.task02.dao;

import main.java.by.bsuir.task02.entity.criteria.Criteria;
import main.java.by.bsuir.task02.entity.Appliance;

import java.util.List;

public interface ApplianceDAO {

	List<Appliance> find(Criteria criteria);

	void save(List<Appliance> appliances);

	List<Appliance> parseAll();
}
