/*
 * Copyright (C) 2014 Pedro Vicente Gómez Sánchez.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.pedrovgs.transformer;

import android.view.View;
import android.widget.RelativeLayout;
import com.nineoldandroids.view.ViewHelper;

/**
 * Abstract class created to be implemented by different classes are going to change the size of a
 * view. The most basic one is going to scale the view and the most complex used with VideoView is
 * going to change the size of the view.
 * <p/>
 * The view used in this class has to be contained by a RelativeLayout.
 * <p/>
 * This class also provide information about the size of the view and the position because
 * different Transformer implementations could change the size of the view but not the position,
 * like ScaleTransformer does.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public abstract class Transformer {

  public static final float DEFAULT_DRAG_LIMIT = 0.5f;

  public static final int LEFT = 0;
  public static final int CENTER = 1;
  public static final int RIGHT = 2;

  private final View view;
  private final View parent;

  private int marginLeft;
  private int marginRight;
  private int marginTop;
  private int marginBottom;

  private float xScaleFactor;
  private float yScaleFactor;

  private int originalHeight;
  private int originalWidth;

  private int position;
  private float dragLimit;

  public Transformer(View view, View parent) {
    this.view = view;
    this.parent = parent;
  }

  public int getViewPosition() {
    return position;
  }

  public void setViewPosition(int position) {
    this.position = position;
  }

  public float getXScaleFactor() {
    return xScaleFactor;
  }

  public void setXScaleFactor(float xScaleFactor) {
    this.xScaleFactor = xScaleFactor;
  }

  public float getYScaleFactor() {
    return yScaleFactor;
  }

  public void setYScaleFactor(float yScaleFactor) {
    this.yScaleFactor = yScaleFactor;
  }

  public int getMarginLeft() {
    return marginLeft;
  }

  public void setMarginLeft(int marginLeft) {
    this.marginLeft = Math.round(marginLeft);
  }

  public int getMarginRight() {
    return marginRight;
  }

  public void setMarginRight(int marginRight) {
    this.marginRight = Math.round(marginRight);
  }

  public int getMarginTop() {
    return marginTop;
  }

  public void setMarginTop(int marginTop) {
    this.marginTop = Math.round(marginTop);
  }

  public int getMarginBottom() {
    return marginBottom;
  }

  public void setMarginBottom(int marginBottom) {
    this.marginBottom = Math.round(marginBottom);
  }

  public float getDragLimit() {
    return dragLimit;
  }

  public void setDragLimit(float dragLimit) {
    this.dragLimit = dragLimit;
  }

  /**
   * Change view height using the LayoutParams of the view.
   *
   * @param newHeight to change..
   */
  public void setViewHeight(int newHeight) {
    if (newHeight > 0) {
      originalHeight = newHeight;
      RelativeLayout.LayoutParams layoutParams =
          (RelativeLayout.LayoutParams) view.getLayoutParams();
      layoutParams.height = newHeight;
      view.setLayoutParams(layoutParams);
    }
  }

  protected View getView() {
    return view;
  }

  protected View getParentView() {
    return parent;
  }

  public abstract void updatePosition(float verticalDragOffset);

  public abstract void updateScale(float verticalDragOffset);

  /**
   * @return height of the view before it has change the size.
   */
  public int getOriginalHeight() {
    if (originalHeight == 0) {
      originalHeight = view.getMeasuredHeight();
    }
    return originalHeight;
  }

  /**
   * @return width of the view before it has change the size.
   */
  public int getOriginalWidth() {
    if (originalWidth == 0) {
      originalWidth = view.getMeasuredWidth();
    }
    return originalWidth;
  }

  public boolean isViewAtTop() {
    return view.getTop() == 0;
  }

  public boolean isAboveTheMiddle() {
    int parentHeight = parent.getHeight();
    float viewYPosition = ViewHelper.getY(view) + (view.getHeight() * getDragLimit());
    return viewYPosition < (parentHeight * getDragLimit());
  }

  public abstract boolean isViewAtLeft();

  public abstract boolean isViewAtRight();

  public abstract boolean isViewAtBottom();

  public abstract boolean isNextToRightBound();

  public abstract boolean isNextToLeftBound();

  /**
   * @return min possible height, after apply the transformation, plus the margin right and left.
   */
  public abstract int getMinHeightPlusVerticalSides();

  /**
   * @return min possible width, after apply the transformation, plus the margin top and bottom.
   */
  public abstract int getMinWidthPlusMarginHorizontalSides();
}
