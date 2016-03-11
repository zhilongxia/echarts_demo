package com.zjjf.analysis.services.impl.datamodle;

import org.springframework.stereotype.Service;

@Service
public class GraphDataService {

	public Object[] getDataModleOne(){
		
		Double[] d = {2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3};
		return d ;
	}
	
	public Object[]  getDataModleTwo(){
		
		Double[] d = {2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3};
		return d ;
	}
}
