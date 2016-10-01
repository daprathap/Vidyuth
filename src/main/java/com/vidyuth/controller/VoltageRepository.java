package com.vidyuth.controller;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import com.vidyuth.db.VoltagesDB;
import com.vidyuth.dto.VoltageSummary;
import com.vidyuth.utils.DateUtils;


@Repository
public class VoltageRepository  {
	
	private static final String CREATED = "created";
	@Autowired
	MongoTemplate mongoTemplate;
	
	
	public VoltageSummary dailyVoltages(String fromDate,String toDate){
		Criteria criteria = new Criteria();
		criteria.and(CREATED).gte(DateUtils.convertStringToDate(fromDate)).lt(DateUtils.convertStringToDate(toDate));
		Aggregation agg = newAggregation(
				match(criteria),
				group("device").avg("watt").as("avgWatt"));
		AggregationResults<VoltageSummary> groupResults =mongoTemplate.aggregate(agg, VoltagesDB.class, VoltageSummary.class);
		return groupResults.getUniqueMappedResult();
		
	}
	

}
