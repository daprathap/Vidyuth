package com.vidyuth.db;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="Voltages")
public class VoltagesDB {
	@Id
	private String id;
	private String apikey;
	private String deviceId;
	private float voltage;
	private float ampere;
	private float watt;
	private String device;
	private DateTime created;
	private DateTime modified;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getApikey() {
		return apikey;
	}
	public void setApikey(String apikey) {
		this.apikey = apikey;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public float getVoltage() {
		return voltage;
	}
	public void setVoltage(float voltage) {
		this.voltage = voltage;
	}
	public DateTime getCreated() {
		return created;
	}
	public void setCreated(DateTime created) {
		this.created = created;
	}
	public DateTime getModified() {
		return modified;
	}
	public void setModified(DateTime modified) {
		this.modified = modified;
	}
	public float getWatt() {
		return watt;
	}
	public void setWatt(float watt) {
		this.watt = watt;
	}
	
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public float getAmpere() {
		return ampere;
	}
	public void setAmpere(float ampere) {
		this.ampere = ampere;
	}
	@Override
	public String toString() {
		return "VoltagesDB [id=" + id + ", apikey=" + apikey + ", deviceId=" + deviceId + ", voltage=" + voltage
				+ ", ampere=" + ampere + ", watt=" + watt + ", device=" + device + ", created=" + created
				+ ", modified=" + modified + "]";
	}
	
	
}
