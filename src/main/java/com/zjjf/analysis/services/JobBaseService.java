package com.zjjf.analysis.services;

import org.springframework.stereotype.Service;

@Service
public class JobBaseService {

	public Integer getIndex_from_db(String key) {

		switch (key) {
		case "itemBase":
			return 0;

		case "scmsItem":
			return 0;
		default:
			break;
		}
		return 0;
	}

}
