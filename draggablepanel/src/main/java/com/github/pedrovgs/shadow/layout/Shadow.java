package com.github.pedrovgs.shadow.layout;

import android.graphics.Canvas;
import com.github.pedrovgs.shadow.ZDepthParam;

public interface Shadow {
  public void setParameter(ZDepthParam parameter, int left, int top, int right, int bottom);
  public void onDraw(Canvas canvas);
}