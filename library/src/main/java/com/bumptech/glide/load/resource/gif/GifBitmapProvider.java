package com.bumptech.glide.load.resource.gif;


import android.graphics.Bitmap;
import android.support.annotation.NonNull;

import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

/**
 * Implements {@link com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider} by wrapping Glide's
 * {@link com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool}.
 */
public final class GifBitmapProvider implements GifDecoder.BitmapProvider {
  private final BitmapPool bitmapPool;

  public GifBitmapProvider(BitmapPool bitmapPool) {
    this.bitmapPool = bitmapPool;
  }

  @NonNull
  @Override
  public Bitmap obtain(int width, int height, Bitmap.Config config) {
    return bitmapPool.getDirty(width, height, config);
  }

  @Override
  public void release(Bitmap bitmap) {
    bitmapPool.put(bitmap);
  }
}
