package com.github.jakz.evolutionary.gfx;

import com.github.jakz.evolutionary.Canvas;
import com.github.jakz.evolutionary.entities.Entity;

public interface Renderer<T>
{
  public void render(Canvas canvas, T object);
}
