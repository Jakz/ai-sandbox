package com.github.jakz.evolutionary.entities;

import com.github.jakz.evolutionary.geometry.Point;

public interface Entity
{
  Point position();

  boolean isInside(Point point);
}
