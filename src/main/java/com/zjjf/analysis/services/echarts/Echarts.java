package com.zjjf.analysis.services.echarts;

import java.util.List;

import com.github.abel533.echarts.Legend;
import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.Title;
import com.github.abel533.echarts.Toolbox;
import com.github.abel533.echarts.Tooltip;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.series.Series;

public abstract class Echarts<T> implements IEcharts<T> {

	private Option option = new Option(); 
	
	@Override
	public void setOption(Option option) {
		// TODO Auto-generated method stub
		this.option = option;
	}

	@Override
	public Option getOption() {
		// TODO Auto-generated method stub
		return option;
	}
	
	@Override
	public void setTitle2Option(Title title) {
		// TODO Auto-generated method stub
		option.setTitle(title);
	}

	@Override
	public void setTooltip2Option(Tooltip tooltip) {
		// TODO Auto-generated method stub
		option.setTooltip(tooltip);
	}

	@Override
	public void setLegend2Option(Legend legend) {
		// TODO Auto-generated method stub
		option.setLegend(legend);
	}

	@Override
	public void setToolbox2Option(Toolbox toolbox) {
		// TODO Auto-generated method stub
		option.setToolbox(toolbox);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void setSeries2Option(List<T> list) {
		// TODO Auto-generated method stub
		option.series((List<Series>) list);
	}
	
	public void setXAxis2Option(ValueAxis xAxis) {
		this.option.xAxis(xAxis);
	}

	public void setYAxis2Option(ValueAxis yAxis) {
		this.option.yAxis(yAxis);
	}
}
