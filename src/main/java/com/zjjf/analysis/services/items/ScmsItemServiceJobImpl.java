package com.zjjf.analysis.services.items;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjjf.analysis.beans.analysis.ScmsItem;
import com.zjjf.analysis.beans.local.BaseScmsitem;
import com.zjjf.analysis.mapper.analysis.ScmsItemMapper;
import com.zjjf.analysis.mapper.local.BaseScmsitemMapper;
import com.zjjf.analysis.services.JobBaseService;

@Service
public class ScmsItemServiceJobImpl extends JobBaseService {

	@Autowired
	private ScmsItemMapper scmsItemMapper;

	@Autowired
	private BaseScmsitemMapper baseScmsitemMapper;

	public void excuse() {

		long beginTime = System.currentTimeMillis();
		Integer addTimeIndex = getIndex_from_db("");
		int i = 0;
		while (true) {
			long beginquere = System.currentTimeMillis();
			List<ScmsItem> scmsItemList = scmsItemMapper.selectByIndex(addTimeIndex);
			i++;
			System.out.println("第" + i + "次查询，spent time：" + (System.currentTimeMillis() - beginquere) + "ms!");
			if (scmsItemList.size() == 0) {
				break;
			}
			for (ScmsItem bean : scmsItemList) {
				_process(bean);
				// move list index
				addTimeIndex = bean.getCreateTime();
			}
		}
		System.out.println("总共耗时，spent time：" + (System.currentTimeMillis() - beginTime) + "ms!");
	}

	private void _process(ScmsItem bean) {
		BaseScmsitem recode = new BaseScmsitem();
		this._to_analysis(bean, recode);
	}

	// push orderInfo to BI_analysis
	private void _to_analysis(ScmsItem bean, BaseScmsitem recode) {
		addBaseScmsitem(bean, recode);
	}

	private void addBaseScmsitem(ScmsItem bean, BaseScmsitem record) {

		BeanUtils.copyProperties(bean, record);
		record.setId(null);
		record.setOrg_pk_id(bean.getId() + "");
		record.setCreateTime(new Date().getTime() / 1000L);
		baseScmsitemMapper.insert(record);
	}
}
