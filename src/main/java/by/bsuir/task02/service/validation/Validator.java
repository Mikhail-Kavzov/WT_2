package main.java.by.bsuir.task02.service.validation;

import main.java.by.bsuir.task02.entity.criteria.Criteria;
import main.java.by.bsuir.task02.entity.criteria.SearchCriteria;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Validator {

    public static boolean validCriteria(Criteria criteria) {
        return switch (criteria.getGroupSearchName()) {
            case "Kettle" -> doesCriteriaExists(criteria, SearchCriteria.Kettle.class);
            case "Laptop" -> doesCriteriaExists(criteria, SearchCriteria.Laptop.class);
            case "Oven" -> doesCriteriaExists(criteria, SearchCriteria.Oven.class);
            case "Refrigerator" -> doesCriteriaExists(criteria, SearchCriteria.Refrigerator.class);
            case "Speakers" -> doesCriteriaExists(criteria, SearchCriteria.Speakers.class);
            case "TabletPC" -> doesCriteriaExists(criteria, SearchCriteria.TabletPC.class);
            case "VacuumCleaner" -> doesCriteriaExists(criteria, SearchCriteria.VacuumCleaner.class);
            default -> false;
        };
    }

    private static boolean doesCriteriaExists(Criteria criteria, Class<? extends Enum<?>> e) {
        Set<String> properties = criteria.getCriteria().keySet();
        String[] arr = Arrays.stream(e.getEnumConstants()).map(Enum::toString).toArray(String[]::new);
        return new HashSet<>(Arrays.asList(arr)).containsAll(properties);
    }

}