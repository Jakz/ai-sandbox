package com.github.jakz.evolutionary;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MainFrame extends JFrame implements MouseWheelListener
{
  private static final long serialVersionUID = 1L;
  
  public MainFrame()
  { 
    super("Evolutionary Sandbox");

    setLayout(new BorderLayout());
    Canvas embed = App.canvas;
    add(embed, BorderLayout.CENTER);
    embed.init();
    
    setMinimumSize(new Dimension(800,800));


    this.addComponentListener(componentListener);
    this.addWindowListener(windowListener);
    this.addMouseWheelListener(this);
    
            
    pack();
  }
  
  private final WindowListener windowListener = new WindowAdapter()
  { 
    public void windowClosing(WindowEvent e)
    { 
      
    }
  };
  
  private final ComponentListener componentListener = new ComponentAdapter()
  {
    public void componentResized(ComponentEvent e) {
      App.canvas.onResize();
    }
  };

  public void mouseWheelMoved(MouseWheelEvent e)
  {
    e.consume();
    App.canvas.mouseWheelMoved(e.getWheelRotation());
  }
}