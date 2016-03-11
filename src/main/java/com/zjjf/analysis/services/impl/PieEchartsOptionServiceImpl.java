package com.zjjf.analysis.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.abel533.echarts.Legend;
import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.Title;
import com.github.abel533.echarts.Toolbox;
import com.github.abel533.echarts.Tooltip;
import com.github.abel533.echarts.code.Orient;
import com.github.abel533.echarts.code.SeriesType;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.feature.Restore;
import com.github.abel533.echarts.series.Pie;
import com.zjjf.analysis.services.IechartsOptionService;
import com.zjjf.analysis.utils.ZfEcharts;

@Service
public class PieEchartsOptionServiceImpl implements IechartsOptionService {

	@Override
	public Option getOption(ZfEcharts type) {

		Option option = new Option();
		if (type != ZfEcharts.pie) {
			return option;
		}

		setTitle2Option(option);
		setTooltip2Option(option);
		setLegend2Option(option);
		setToolbox2Option(option);
		option.setCalculable(false);
		setSeries2Option(option);
		return option;
	}

	private void setTitle2Option(Option option) {

		Title title = new Title();
		title.setText("ECharts实例");
		title.setSubtext("饼图（Pie Chart）");
		title.setX("center");
		option.setTitle(title);
	}

	private void setTooltip2Option(Option option) {

		Tooltip tooltip = new Tooltip();
		tooltip.setTrigger(Trigger.item);
		tooltip.setFormatter("{a} <br/>{b} : {c} ({d}%)");
		option.setTooltip(tooltip);
	}

	private void setLegend2Option(Option option) {

		Legend legend = new Legend();
		legend.setOrient(Orient.vertical);
		legend.setX("left");
		legend.data(Arrays.asList("part1", "part2", "part3", "part4"));
		option.setLegend(legend);
	}

	private void setToolbox2Option(Option option) {

		Toolbox toolbox = new Toolbox();
		toolbox.setShow(true);
		toolbox.feature(getRestore());
		option.setToolbox(toolbox);

	}

	private Restore getRestore() {

		Restore restore = new Restore();
		restore.setShow(true);
		return restore;
	}
	
	public static void main(String args[]) {
		List<HashMap<String, Object>> markPoint = new ArrayList<HashMap<String, Object>>();

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("type", "max");
		map.put("name", "最大值");

		HashMap<String, Object> map2 = new HashMap<String, Object>();
		map2.put("type", "min");
		map2.put("name", "最小值");
		markPoint.add(0, map);
		markPoint.add(0, map2);
		System.out.println(markPoint);
	}

	private <T> void setSeries2Option(Option option) {

		Object center[] = {"50%", "60%"};
		Pie  pie = new Pie ();
		pie.setName("饼图实例");
		pie.setType(SeriesType.pie);
		pie.setRadius("55%");
		pie.setCenter(center);
		pie.setData(this.simulationData());
		option.series(pie);
	}
	
	private List<HashMap<String, Object>> simulationData() {
		
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < 4; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("value", 100  * (i + 1));
			map.put("name", "part" + (i * 1 + 1));
			list.add(map);
		}
		return list;
	}

}
