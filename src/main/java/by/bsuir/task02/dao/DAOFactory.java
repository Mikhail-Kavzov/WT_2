package main.java.by.bsuir.task02.dao;

import main.java.by.bsuir.task02.dao.impl.ApplianceDAOImpl;

/**
 * Factory for DAO
 */
public final class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();
	private final ApplianceDAO applianceDAO = new ApplianceDAOImpl();
	private DAOFactory() {}

	/**
	 * @return ApplianceDAO
	 */
	public ApplianceDAO getApplianceDAO() {
		return applianceDAO;
	}

	/**
	 * @return DAOFactory instance
	 */
	public static DAOFactory getInstance() {
		return instance;
	}
}
