package com.zjjf.analysis.services.items;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjjf.analysis.beans.analysis.PlantItem;
import com.zjjf.analysis.beans.local.BasePlantitem;
import com.zjjf.analysis.mapper.analysis.PlantItemMapper;
import com.zjjf.analysis.mapper.local.BasePlantitemMapper;
import com.zjjf.analysis.services.tasks.JobBaseService;

@Service
public class PlanItemServiceJobImpl extends JobBaseService {

	@Autowired
	private PlantItemMapper plantItemMapper;

	@Autowired
	private BasePlantitemMapper basePlantitemMapper;

	public void excuse() {

		long beginTime = System.currentTimeMillis();
		String index = this._getIndex_from_db("");
		int i = 0;
		while (true) {
			long beginquere = System.currentTimeMillis();
			List<PlantItem> list = plantItemMapper.selectByIndex(index);
			i++;
			System.out.println("第" + i + "次查询，spent time：" + (System.currentTimeMillis() - beginquere) + "ms!");
			if (list.size() == 0) {
				break;
			}
			for (PlantItem bean : list) {
				_process(bean);
				index = bean.getId();
			}
		}
		System.out.println("总共耗时，spent time：" + (System.currentTimeMillis() - beginTime) + "ms!");
	}

	private void _process(PlantItem bean) {
		BasePlantitem recode = new BasePlantitem();
		this._to_analysis(bean, recode);
	}

	// push orderInfo to BI_analysis
	private void _to_analysis(PlantItem bean, BasePlantitem recode) {
		addBasePlantitem(bean, recode);
	}

	private void addBasePlantitem(PlantItem bean, BasePlantitem record) {

		BeanUtils.copyProperties(bean, record);
		record.setId(null);
		record.setOrg_pk_id(bean.getId() + "");
		record.setCreateTime(new Date().getTime() / 1000L);
		basePlantitemMapper.insert(record);
	}
	
	private String _getIndex_from_db(String key) {
		
		return "0";
	}

}
