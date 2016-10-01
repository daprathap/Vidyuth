package com.vidyuth.controller;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.vidyuth.db.VoltagesDB;

public interface VoltageMongoRepository extends MongoRepository<VoltagesDB, String>{}
