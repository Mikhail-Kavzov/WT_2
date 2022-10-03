package main.java.by.bsuir.task02.service.impl;

import main.java.by.bsuir.task02.dao.ApplianceDAO;
import main.java.by.bsuir.task02.dao.DAOFactory;
import main.java.by.bsuir.task02.entity.Appliance;
import main.java.by.bsuir.task02.entity.criteria.Criteria;
import main.java.by.bsuir.task02.service.ApplianceService;
import main.java.by.bsuir.task02.service.validation.Validator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ApplianceService implementation
 */
public class ApplianceServiceImpl implements ApplianceService{

	@Override
	public List<Appliance> find(Criteria criteria) {
		if (Validator.validCriteria(criteria)) {
			ApplianceDAO applianceDAO = DAOFactory.getInstance().getApplianceDAO();
			return applianceDAO.find(criteria);
		}
			return null;
	}

	@Override
	public List<Appliance> getMin(Comparator<Appliance> comparator) {
		DAOFactory factory = DAOFactory.getInstance();
		List<Appliance> appliances = factory.getApplianceDAO().parseAll();
		Appliance min = appliances.stream().min(comparator).orElse(null);
		if (min != null) {
			return appliances.stream()
					.filter(p -> comparator.compare(p, min) == 0)
					.collect(Collectors.toList());
		}

		return new ArrayList<>();
	}

	@Override
	public List<Appliance> getSorted(Comparator<Appliance> comparator) {
		DAOFactory factory = DAOFactory.getInstance();
		List<Appliance> appliances = factory.getApplianceDAO().parseAll();
		appliances.sort(comparator);
		return appliances;
	}

	@Override
	public void save(List<Appliance> appliances) {
		DAOFactory factory = DAOFactory.getInstance();
		factory.getApplianceDAO().save(appliances);
	}

}
