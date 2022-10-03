package main.java.by.bsuir.task02.main;

import main.java.by.bsuir.task02.entity.Appliance;
import main.java.by.bsuir.task02.entity.criteria.Criteria;
import main.java.by.bsuir.task02.entity.criteria.SearchCriteria;
import main.java.by.bsuir.task02.service.ServiceFactory;

import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Appliance> appliances;
        ServiceFactory factory = ServiceFactory.getInstance();
        var service = factory.getApplianceService();
        Criteria kettleCriteria = new Criteria(SearchCriteria.Kettle.class.getSimpleName());
        appliances = service.find(kettleCriteria);
        if (appliances != null) {
            System.out.println("All kettles: ");
            PrintApplianceInfo.print(appliances);
        }
        Criteria ovenCriteria = new Criteria(SearchCriteria.Oven.class.getSimpleName());
        ovenCriteria.add("powerConsumption", 100);
        List<Appliance> ovens = service.find(ovenCriteria);
        if (ovens != null) {
            System.out.println("Ovens with a capacity of 100:: ");
            PrintApplianceInfo.print(ovens);
        }
        System.out.println();
        appliances = service.getMin(Comparator.comparing(Appliance::getPrice));
        System.out.println("Appliances with minimal price: ");
        PrintApplianceInfo.print(appliances);
    }
}
