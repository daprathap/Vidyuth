package com.vidyuth.helper;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.joda.time.DateTime;

import com.vidyuth.db.VoltagesDB;
import com.vidyuth.dto.Voltages;

public class VoltageHelper {
	private static final float MULTIPLIER =10f;
	private static final String DEFAULT = "default";

	public static VoltagesDB createVoltageDB(Voltages volt) throws IllegalAccessException, InvocationTargetException{
		VoltagesDB voltDB = new VoltagesDB();
		BeanUtils.copyProperties(voltDB, volt);
		voltDB.setWatt(volt.getVoltage()*MULTIPLIER);
		voltDB.setCreated(new DateTime());
		voltDB.setModified(new DateTime());
		return voltDB;
	}
	public static VoltagesDB createVoltageDB(float volt,float ampere) throws IllegalAccessException, InvocationTargetException{
		VoltagesDB voltDB = new VoltagesDB();
		voltDB.setVoltage(volt);
		voltDB.setAmpere(ampere);
		//voltDB.setWatt(volt*MULTIPLIER);
		voltDB.setDevice(DEFAULT);
		voltDB.setCreated(new DateTime());
		voltDB.setModified(new DateTime());
		return voltDB;
	}

}
