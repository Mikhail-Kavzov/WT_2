package main.java.by.bsuir.task02.service;

import main.java.by.bsuir.task02.entity.Appliance;
import main.java.by.bsuir.task02.entity.criteria.Criteria;

import java.util.Comparator;
import java.util.List;

/**
 *
 */
public interface ApplianceService {

    /**
     * @param criteria
     * @return
     */
    List<Appliance> find(Criteria criteria);

    /**
     * @param comparator
     * @return
     */
    List<Appliance> getMin(Comparator<Appliance> comparator);

    /**
     * @param comparator
     * @return
     */
    List<Appliance> getSorted(Comparator<Appliance> comparator);

    /**
     * @param appliances
     */
    void save(List<Appliance> appliances);

}
