package com.github.jakz.evolutionary.gfx;

import com.github.jakz.evolutionary.Canvas;
import com.github.jakz.evolutionary.entities.Entity;

public interface EntityRenderer<T extends Entity>
{
  public void render(Canvas canvas, T entity);
}
