package com.zq.commons.result;

public class ColorHighChartData extends HighChartData
{
  private String color;

  public ColorHighChartData()
  {
  }

  public ColorHighChartData(HighChartData data)
  {
    setId(data.getId());
    setName(data.getName());
    setY(data.getY());
  }
  public String getColor() {
    return this.color;
  }
  public void setColor(String color) {
    this.color = color;
  }
}