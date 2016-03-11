package com.zjjf.analysis.services.echarts;

import java.util.List;

import com.github.abel533.echarts.Legend;
import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.Title;
import com.github.abel533.echarts.Toolbox;
import com.github.abel533.echarts.Tooltip;

public interface IEcharts<T> {

	public void setOption(Option option);
	
	public Option getOption();

	public void setTitle2Option(Title title);

	public void setTooltip2Option(Tooltip tooltip);

	public void setLegend2Option(Legend legend);

	public void setToolbox2Option(Toolbox toolbox);

	public void setSeries2Option(List<T> list);
}
