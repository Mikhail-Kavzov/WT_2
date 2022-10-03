package main.java.by.bsuir.task02.service;

import main.java.by.bsuir.task02.entity.Appliance;
import main.java.by.bsuir.task02.entity.criteria.Criteria;

import java.util.Comparator;
import java.util.List;

public interface ApplianceService {

    List<Appliance> find(Criteria criteria);

    List<Appliance> getMin(Comparator<Appliance> comparator);

    List<Appliance> getSorted(Comparator<Appliance> comparator);

    void save(List<Appliance> appliances);

}
