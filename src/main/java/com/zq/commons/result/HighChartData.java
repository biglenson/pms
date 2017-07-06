package com.zq.commons.result;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class HighChartData {
	  private String id;
	  private String name;
	  private Double y = Double.valueOf(0.0D);

	  private boolean sliced = false;
	  public static final int TYPE_SIZE = 7;
	  public static final int COLUMN_SIZE = 12;
	  public static final int MESSAGE_SIZE = 5;
	  public static final String COLOR_RED = "#EF5350";
	  public static final String COLOR_GREEN = "#1D96F3";
	  public static final String COLOR_LOW_GREEN = "#69D282";
	  public static final String COLOR_HIGHT_GREEN = "#009933";
	  public static final String COLOR_BLUE = "#60D279";
	  public static final String COLOR_YELLOW = "#FDD835";
	  public static final String COLOR_GRAY = "#D8D8D8";
	  public static final String COLOR_PURPLE = "#8064A2";
	  public static final String COLOR_LIGHT_BLUE = "#4F81BD";
	  public static final String COLOR_SERIES_DELAY = "#EF5350";
	  public static final String COLOR_NORMAL = "#46c6f0";
	  public static final String COLOR_LITTLE_DELAY = "#fde485";
	  public static final String COLOR_COMPLETE = "#60D279";
	  public static final String COLOR_SERIES_DELAY_FOR_WEEKLY = "#FACCA8";
	  public static final String COLOR_LITTLE_DELAY_FOR_WEEKLY = "#FFFFCB";
	  public static final int INNER_SIZE = 92;
	  public static final int HighChartTableRows = 5;
	  public static String[] COLORS = { "#058DC7", "#50B432", "#ED561B", "#DDDF00", "#24CBE5", "#64E572", "#FF9655", "#FFF263", "#6AF9C4" };

	  public static final Comparator<HighChartData> HIGHCHARTDATACOMPARATOR = new Comparator<HighChartData>()
	  {
		@Override
	    public int compare(HighChartData o1, HighChartData o2) {
	      Double o1D = Double.valueOf(o1.getY() != null ? o1.getY().doubleValue() : 0.0D);
	      Double o2D = Double.valueOf(o2.getY() != null ? o2.getY().doubleValue() : 0.0D);
	      return 0 - o1D.compareTo(o2D);
	    }
	  };

	  public boolean isSliced()
	  {
	    return this.sliced;
	  }

	  public void setSliced(boolean sliced) {
	    this.sliced = sliced;
	  }

	  public String getId() {
	    return this.id;
	  }

	  public void setId(String id) {
	    this.id = id;
	  }
	  public void setId(Integer id) {
	    this.id = String.valueOf(id);
	  }
	  public String getName() {
	    return this.name;
	  }

	  public void setName(String name) {
	    this.name = name;
	  }

	  public Double getY() {
	    return this.y;
	  }

	  public void setY(Integer y) {
	    this.y = Double.valueOf(y != null ? y.doubleValue() : 0.0D);
	  }
	  public void setY(Double y) {
	    this.y = y;
	  }

	  public void addY(Double y) {
	    this.y = Double.valueOf(this.y.doubleValue() + (y != null ? y.doubleValue() : 0.0D));
	  }

	  public String toString()
	  {
	    return "{ name: " + getName() + " ;value:" + getY() + "}";
	  }

	  public static List<HighChartData> getTopHighChartData(List<HighChartData> list, int size, HighChartData other)
	  {
	    Collections.sort(list, HIGHCHARTDATACOMPARATOR);
	    int cSize = list.size();
	    if (cSize > size) {
	      List<HighChartData> result = new ArrayList<HighChartData>(size);
	      HighChartData temp = null;
	      int i = 0; for (int j = list.size(); i < j; i++) {
	        temp = (HighChartData)list.get(i);
	        if (i < size - 1)
	          result.add(temp);
	        else {
	          other.addY(temp.getY());
	        }
	      }
	      result.add(other);
	      list = result;
	    }

	    return list;
	  }

	  public static Double getTotalValue(List<HighChartData> list)
	  {
	    HighChartData temp = null;
	    Double value = Double.valueOf(0.0D);
	    int i = 0; for (int j = list.size(); i < j; i++) {
	      temp = (HighChartData)list.get(i);
	      value = Double.valueOf(value.doubleValue() + (temp.getY() != null ? temp.getY().doubleValue() : 0.0D));
	    }
	    return value;
	  }

	  public static HighChartData findDataById(List<HighChartData> list, String id) {
	    for (Iterator<HighChartData> localIterator = list.iterator(); localIterator.hasNext(); ) { Object obj = localIterator.next();
	      HighChartData a = (HighChartData)obj;
	      if (id.equals(a.getId())) {
	        return a;
	      }
	    }
	    return null;
	  }

	  public static void setDataColors(List<HighChartData> dataList) {
	    int length = COLORS.length;
	    int i = 0; for (int j = dataList.size(); i < j; i++) {
	      HighChartData data = (HighChartData)dataList.get(i);
	      if ((data instanceof ColorHighChartData)) {
	        ColorHighChartData cd = (ColorHighChartData)data;
	        if ((cd.getColor() == null) || ("".equals(cd.getColor())))
	          cd.setColor(COLORS[(i / length)]);
	      }
	    }
	  }
}
