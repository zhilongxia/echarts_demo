package com.zjjf.analysis.services.impl.datamodle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PieDataService {

	
	public List<HashMap<String, Object>> simulationData() {

		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < 4; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("value", 100 * (i + 1));
			map.put("name", "part" + (i * 1 + 1));
			list.add(map);
		}
		return list;
	}
}
