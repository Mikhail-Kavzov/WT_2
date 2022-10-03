package main.java.by.bsuir.task02.dao.impl;

import main.java.by.bsuir.task02.dao.ApplianceDAO;
import main.java.by.bsuir.task02.entity.criteria.Criteria;
import main.java.by.bsuir.task02.entity.Appliance;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ApplianceDAOImpl implements ApplianceDAO {

	private static final String path = "src/main/resources/appliances_db.xml";

	@Override
	public List<Appliance> find(Criteria criteria) {
		List<Appliance> foundAppliances = new ArrayList<>();
		Appliance appliance;

		try (XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(path)))) {
			do {
				appliance = (Appliance) decoder.readObject();
				try {
					if (fitsCriteria(appliance, criteria)) {
						foundAppliances.add(appliance);
					}
				} catch (NoSuchFieldException e) {
					System.out.println(e.getMessage());
				}

			} while (true);
		}
		catch (ArrayIndexOutOfBoundsException ignored) {
		}
		catch (FileNotFoundException | IllegalAccessException e) {
			System.out.println(e.getMessage());
		}
		return foundAppliances;
	}

	@Override
	public void save(List<Appliance> appliances) {
		try(XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(path)))){
			for(Appliance appliance : appliances){
				encoder.writeObject(appliance);
			}
		}
		catch (FileNotFoundException e){
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<Appliance> parseAll() {
		List<Appliance> appliances = new ArrayList<>();
		try(XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(path)))){
			Appliance result;
			do{
				result = (Appliance)decoder.readObject();
				appliances.add(result);
			}
			while(result != null);
		}
		catch(FileNotFoundException e){
			System.out.println(e.getMessage());
		}
		return appliances;
	}

	private boolean fitsCriteria(Appliance appliance, Criteria criteria) throws IllegalAccessException, NoSuchFieldException {
		if (!appliance.getClass().getSimpleName().equals(criteria.getGroupSearchName())){
			return false;
		}
		Set<String> properties = criteria.getCriteria().keySet();
		for (String property : properties) {
			Field field = null;
			try {
				field = appliance.getClass().getDeclaredField(property);
			} catch (NoSuchFieldException e) {
				System.out.println(e.getMessage());
			}
			field.setAccessible(true);
				Object fieldValue = field.get(appliance);
				if (!fieldValue.toString().equals(criteria.getCriteria().get(property).toString())) {
					return false;
				}
		}
		for (String property : properties) {
				Field parentField = appliance.getClass().getSuperclass().getDeclaredField(property);
				parentField.setAccessible(true);
				Object parentFieldValue = parentField.get(appliance);
				if (!parentFieldValue.toString().equals(criteria.getCriteria().get(property).toString())) {
					return false;
				}
		}
		return true;
	}

}