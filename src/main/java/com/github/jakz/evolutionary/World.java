package com.github.jakz.evolutionary;

import java.util.ArrayList;
import java.util.List;

import com.github.jakz.evolutionary.entities.Creature;
import com.github.jakz.evolutionary.entities.Obstacle;

public class World
{
  private final List<Creature> creatures;
  private final List<Obstacle> objects;
  
  public World()
  {
    creatures = new ArrayList<>();
    objects = new ArrayList();
  }
  
  public void spawn(Creature creature) { creatures.add(creature); }
  public List<Creature> creatures() { return creatures; }
  
  public void spawn(Obstacle obstacle) { objects.add(obstacle); }
  public List<Obstacle> objects() { return objects; }
}

