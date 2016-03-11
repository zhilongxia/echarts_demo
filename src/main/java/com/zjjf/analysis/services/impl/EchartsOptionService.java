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
import com.github.abel533.echarts.axis.SplitArea;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.AxisType;
import com.github.abel533.echarts.code.SeriesType;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.feature.DataView;
import com.github.abel533.echarts.feature.DataZoom;
import com.github.abel533.echarts.feature.MagicType;
import com.github.abel533.echarts.feature.Mark;
import com.github.abel533.echarts.feature.Restore;
import com.github.abel533.echarts.feature.SaveAsImage;
import com.github.abel533.echarts.series.Line;
import com.github.abel533.echarts.series.MarkLine;
import com.github.abel533.echarts.series.MarkPoint;
import com.zjjf.analysis.services.IechartsOptionService;
import com.zjjf.analysis.utils.ZfEcharts;

@Service
public abstract class EchartsOptionService implements IechartsOptionService {

	@Override
	public Option getOption(ZfEcharts type) {

		if (type != ZfEcharts.graph) {
			return null;
		}
		Option option = new Option();
		setTitle2Option(option);
		setTooltip2Option(option);
		setLegend2Option(option);
		setToolbox2Option(option);
		option.setCalculable(true);
		setXAxisbox2Option(option);
		setYAxis2Option(option);
		setSeries2Option(option);
		return option;
	}

	protected void setTitle2Option(Option option) {

		Title title = new Title();
		title.setText("2013年广州降水量与蒸发量统计报表");
		title.setLink("http://www.tqyb.com.cn/weatherLive/climateForecast/2014-01-26/157.html");
		title.setSubtext("www.stepday.com");
		title.setSublink("http://www.stepday.com/myblog/?Echarts");
		title.setX("left");
		title.setY("top");
		option.setTitle(title);
	}

	protected void setTooltip2Option(Option option) {

		Tooltip tooltip = new Tooltip();
		tooltip.setTrigger(Trigger.axis);
		option.setTooltip(tooltip);
	}

	protected void setLegend2Option(Option option) {

		Legend legend = new Legend();
		legend.setShow(true);
		legend.setX("center");
		legend.setY("top");
		legend.data(Arrays.asList("蒸发量", "降水量"));
		option.setLegend(legend);
	}

	protected void setToolbox2Option(Option option) {

		Toolbox toolbox = new Toolbox();
		toolbox.setShow(true);
		toolbox.feature(getMark(), getDataZoom(), getDataView(), getMagicType(), getRestore(), getSaveAsImage());
		option.setToolbox(toolbox);

	}

	private Mark getMark() {
		Mark mark = new Mark();
		mark.setShow(true);
		return mark;
	}

	private DataZoom getDataZoom() {

		DataZoom dataZoom = new DataZoom();
		dataZoom.setShow(true);
		dataZoom.setTitle("{dataZoom: '区域缩放',  dataZoomReset: '区域缩放后退'}");
		return dataZoom;
	}

	private DataView getDataView() {

		DataView dataView = new DataView();
		dataView.setShow(true);
		dataView.setReadOnly(true);
		return dataView;
	}

	private MagicType getMagicType() {

		List<String> _list = new ArrayList<String>();
		_list.add("line");
		_list.add("bar");
		MagicType magicType = new MagicType();
		magicType.setShow(true);
		magicType.setType(_list);
		return magicType;
	}

	private Restore getRestore() {

		Restore restore = new Restore();
		restore.setShow(true);
		return restore;
	}

	private SaveAsImage getSaveAsImage() {

		SaveAsImage saveAsImage = new SaveAsImage();
		saveAsImage.setShow(true);
		return saveAsImage;
	}

	protected void setXAxisbox2Option(Option option) {

		ValueAxis xAxis = new ValueAxis();
		xAxis.setShow(true);
		xAxis.setType(AxisType.category);
		xAxis.data("1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月");
		option.xAxis(xAxis);
	}

	protected void setYAxis2Option(Option option) {

		ValueAxis yAxis = new ValueAxis();
		yAxis.setShow(true);
		yAxis.setType(AxisType.value);
		SplitArea splitArea = new SplitArea();
		splitArea.setShow(true);
		yAxis.splitArea(splitArea);
		option.yAxis(yAxis);
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

	protected <T> void setSeries2Option(Option option) {

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("type", "max");
		map.put("name", "最大值");
		HashMap<String, Object> map2 = new HashMap<String, Object>();
		map2.put("type", "min");
		map2.put("name", "最小值");

		HashMap<String, Object> averageMap = new HashMap<String, Object>();
		averageMap.put("type", "average");
		averageMap.put("name", "平均值");

		Line line = new Line();
		line.setName("蒸发量");
		line.setType(SeriesType.bar);
		line.data(2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3);
		line.markPoint(new MarkPoint().data(map, map2));
		line.markLine(new MarkLine().data(averageMap));

		Line line2 = new Line();
		line2.setName("降水量");
		line2.setType(SeriesType.bar);
		line2.data(2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3);
		line2.markPoint(new MarkPoint().data(map, map2));
		line2.markLine(new MarkLine().data(averageMap));
		option.series(line, line2);
	}

}
