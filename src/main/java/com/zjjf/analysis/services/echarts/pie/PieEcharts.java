package com.zjjf.analysis.services.echarts.pie;

import java.util.List;

import com.github.abel533.echarts.Legend;
import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.Title;
import com.github.abel533.echarts.Toolbox;
import com.github.abel533.echarts.Tooltip;
import com.github.abel533.echarts.series.Pie;
import com.zjjf.analysis.services.echarts.Echarts;

public abstract class PieEcharts extends Echarts<Pie> {

	@Override
	public void setOption(Option option) {
		// TODO Auto-generated method stub
		super.setOption(option);
	}

	@Override
	public void setTitle2Option(Title title) {
		// TODO Auto-generated method stub
		super.setTitle2Option(title);
	}

	@Override
	public void setTooltip2Option(Tooltip tooltip) {
		// TODO Auto-generated method stub
		super.setTooltip2Option(tooltip);
	}

	@Override
	public void setLegend2Option(Legend legend) {
		// TODO Auto-generated method stub
		super.setLegend2Option(legend);
	}

	@Override
	public void setToolbox2Option(Toolbox toolbox) {
		// TODO Auto-generated method stub
		super.setToolbox2Option(toolbox);
	}

	@Override
	public void setSeries2Option(List<Pie> pieList) {
		// TODO Auto-generated method stub
		super.setSeries2Option(pieList);
	}
	
}
