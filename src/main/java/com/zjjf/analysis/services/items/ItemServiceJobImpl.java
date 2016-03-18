package com.zjjf.analysis.services.items;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjjf.analysis.beans.analysis.ItemBase;
import com.zjjf.analysis.beans.local.BaseItembase;
import com.zjjf.analysis.mapper.analysis.ItemBaseMapper;
import com.zjjf.analysis.mapper.local.BaseItembaseMapper;
import com.zjjf.analysis.services.JobBaseService;

@Service
public class ItemServiceJobImpl extends JobBaseService {

	@Autowired
	private ItemBaseMapper itembaseMapper;

	@Autowired
	private BaseItembaseMapper baseItembaseMapper;

	public void excuse_item() {

		long beginTime = System.currentTimeMillis();
		Integer addTimeIndex = getIndex_from_db("itemBase");
		int i = 0;
		while (true) {
			long beginquere = System.currentTimeMillis();
			List<ItemBase> itemBaseList = itembaseMapper.selectByIndex(addTimeIndex);
			i++;
			System.out.println("第" + i + "次查询，spent time：" + (System.currentTimeMillis() - beginquere) + "ms!");
			if (itemBaseList.size() == 0) {
				break;
			}
			for (ItemBase itemBase : itemBaseList) {
				itemBaes_process(itemBase);
				// move list index
				addTimeIndex = itemBase.getId();
			}
		}
		System.out.println("总共耗时，spent time：" + (System.currentTimeMillis() - beginTime) + "ms!");
	}

	private void itemBaes_process(ItemBase itemBase) {
		BaseItembase recode = new BaseItembase();
		this.push_itembase_to_analysis(itemBase, recode);
	}

	// push itembase to BI_analysis
	private void push_itembase_to_analysis(ItemBase itemBase, BaseItembase recode) {
		addBaseItembase(itemBase, recode);
	}

	private void addBaseItembase(ItemBase itemBase, BaseItembase recode) {

		// baseItembaseMapper.insert(record);
		BeanUtils.copyProperties(itemBase, recode);
		recode.setId(null);
		recode.setOrg_pk_id(itemBase.getId() + "");
		recode.setCreateTime(new Date().getTime() / 1000L);
		baseItembaseMapper.insert(recode);
	}
}
