package main.java.by.bsuir.task02.service;

import main.java.by.bsuir.task02.service.impl.ApplianceServiceImpl;

/**
 *
 */
public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final ApplianceService applianceService = new ApplianceServiceImpl();

    private ServiceFactory() {
    }

    /**
     * @return
     */
    public ApplianceService getApplianceService() {

        return applianceService;
    }

    /**
     * @return
     */
    public static ServiceFactory getInstance() {
        return instance;
    }

}
