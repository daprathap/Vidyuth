package com.vidyuth.dto;

public class VoltageSummary  {
	private String name;

	private float avgWatt;

	public float getAvgWatt() {
		return avgWatt;
	}

	public void setAvgWatt(float avgWatt) {
		this.avgWatt = avgWatt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "VoltageSummary [name=" + name + ", avgWatt=" + avgWatt + "]";
	}

}
