package com.github.pedrovgs.shadow;

import android.content.Context;
import android.graphics.Color;

/**
 * Created by pedro on 3/10/15.
 */
public class ZDepthParam {

  public int mAlphaTopShadow;
  public int mAlphaBottomShadow;
  public float mOffsetYTopShadowPx;
  public float mOffsetYBottomShadowPx;
  public float mBlurTopShadowPx;
  public float mBlurBottomShadowPx;

  public void initZDepth(Context context, ZDepth zDepth) {
    mAlphaTopShadow = zDepth.getAlphaTopShadow();
    mAlphaBottomShadow = zDepth.getAlphaBottomShadow();
    mOffsetYTopShadowPx = zDepth.getOffsetYTopShadowPx(context);
    mOffsetYBottomShadowPx = zDepth.getOffsetYBottomShadowPx(context);
    mBlurTopShadowPx = zDepth.getBlurTopShadowPx(context);
    mBlurBottomShadowPx = zDepth.getBlurBottomShadowPx(context);
  }
  public int getColorTopShadow() {
    return Color.argb(mAlphaTopShadow, 0, 0, 0);
  }
  public int getColorBottomShadow() {
    return Color.argb(mAlphaBottomShadow, 0, 0, 0);
  }
}
