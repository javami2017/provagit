package com.begear.ristorante.model.businessdelegate;

public class BusinessLookUp {

	public BusinessService getBusinessService(ServiceType serviceType) {

		switch (serviceType) {
		case JDBC:
			return new JdbcDao();
		case HIBERNATE:
			return new HibernateDao();
		}
		return null;
	}
}
