/*
 * Copyright 2005 MH-Software-Entwicklung. All rights reserved.
 * Use is subject to license terms.
 */

package com.jtattoo.plaf.aero;

import com.jtattoo.plaf.*;
import java.awt.*;
import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.border.Border;
import javax.swing.plaf.UIResource;

/**
 * @author Michael Hagen
 */
public class AeroBorders extends BaseBorders {

    //------------------------------------------------------------------------------------
    // Lazy access methods
    //------------------------------------------------------------------------------------
    public static Border getButtonBorder() {
        if (buttonBorder == null) {
            buttonBorder = new ButtonBorder();
        }
        return buttonBorder;
    }
    
    public static Border getToggleButtonBorder() {
        return getButtonBorder();
    }
    
    public static Border getRolloverToolButtonBorder() {
        if (rolloverToolButtonBorder == null) {
            rolloverToolButtonBorder = new RolloverToolButtonBorder();
        }
        return rolloverToolButtonBorder;
    }
    
    public static Border getInternalFrameBorder() {
        if (internalFrameBorder == null) {
            internalFrameBorder = new InternalFrameBorder();
        }
        return internalFrameBorder;
    }
    
    //------------------------------------------------------------------------------------
    // Implementation of border classes
    //------------------------------------------------------------------------------------
    public static class ButtonBorder implements Border, UIResource {

        private static final Insets insets = new Insets(4, 8, 4, 8);
        
        public void paintBorder(Component c, Graphics g, int x, int y, int w, int h) {
            Graphics2D g2D = (Graphics2D) g;
            AbstractButton button = (AbstractButton)c;
            ButtonModel model = button.getModel();
            if (model.isEnabled()) {
                g.setColor(AeroLookAndFeel.getFrameColor());
            } else {
                g.setColor(ColorHelper.brighter(AeroLookAndFeel.getFrameColor(), 30));
            }
            g.drawRect(x, y, w - 2, h - 2);
            Composite composite = g2D.getComposite();
            AlphaComposite alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
            g2D.setComposite(alpha);
            g.setColor(Color.white);
            g.drawLine(x + w - 1, y + 1, x + w - 1, y + h);
            g.drawLine(x + 1, y + h - 1, x + w, y + h - 1);
            g2D.setComposite(composite);
        }
        
        public Insets getBorderInsets(Component c) {
            return new Insets(insets.top, insets.left, insets.bottom, insets.right);
        }

        public Insets getBorderInsets(Component c, Insets borderInsets) {
            borderInsets.left = insets.left;
            borderInsets.top = insets.top;
            borderInsets.right = insets.right;
            borderInsets.bottom = insets.bottom;
            return borderInsets;
        }

        public boolean isBorderOpaque() { 
            return true;
        }
        
    } // class ButtonBorder
    
    public static class RolloverToolButtonBorder implements Border, UIResource {

        private static final Insets insets = new Insets(1, 1, 1, 1);
        
        public void paintBorder(Component c, Graphics g, int x, int y, int w, int h) {
            AbstractButton button = (AbstractButton)c;
            ButtonModel model = button.getModel();
            Color loColor = AeroLookAndFeel.getFrameColor();
            if (model.isEnabled()) {
                if ((model.isPressed() && model.isArmed()) || model.isSelected()) {
                    Graphics2D g2D = (Graphics2D)g;
                    Composite composite = g2D.getComposite();
                    g.setColor(loColor);
                    g.drawRect(x, y, w - 1, h - 1);
                    AlphaComposite alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.15f);
                    g2D.setComposite(alpha);
                    g.setColor(Color.black);
                    g.fillRect(x + 1, y + 1, w - 2, h - 2);
                    g2D.setComposite(composite);
                }
                else if (model.isRollover()) {
                    Graphics2D g2D = (Graphics2D)g;
                    Composite composite = g2D.getComposite();
                    g.setColor(loColor);
                    g.drawRect(x, y, w - 1, h - 1);
                    AlphaComposite alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f);
                    g2D.setComposite(alpha);
                    g.setColor(Color.white);
                    g.fillRect(x + 1, y + 1, w - 2, h - 2);
                    g2D.setComposite(composite);
                }
            }
        }
        
        public Insets getBorderInsets(Component c) {
            return new Insets(insets.top, insets.left, insets.bottom, insets.right);
        }

        public Insets getBorderInsets(Component c, Insets borderInsets) {
            borderInsets.left = insets.left;
            borderInsets.top = insets.top;
            borderInsets.right = insets.right;
            borderInsets.bottom = insets.bottom;
            return borderInsets;
        }

        public boolean isBorderOpaque() { 
            return true;
        }
        
    } // class RolloverToolButtonBorder
    
    public static class InternalFrameBorder extends BaseInternalFrameBorder {
        
        public void paintBorder(Component c, Graphics g, int x, int y, int w, int h) {
            Color borderColor = AeroLookAndFeel.getWindowInactiveBorderColor();
            if (isActive(c)) {
                borderColor = AeroLookAndFeel.getWindowBorderColor();
            }
            if (!isResizable(c)) {
                Color cHi = ColorHelper.brighter(borderColor, 40);
                Color cLo = ColorHelper.darker(borderColor, 40);
                JTattooUtilities.draw3DBorder(g, cHi, cLo, x, y, w, h);
                cHi = ColorHelper.darker(cHi, 20);
                cLo = ColorHelper.brighter(cLo, 20);
                JTattooUtilities.draw3DBorder(g, cHi, cLo, x + 1, y + 1, w - 2, h - 2);
                g.setColor(borderColor);
                for (int i = 2; i < dw; i++) {
                    g.drawRect(i, i, w - (2 * i) - 1, h - (2 * i) - 1);
                }
                return;
            }
            int dt = w / 3;
            int db = w * 2 / 3;
            h--;
            w--;
            
            Color cl = ColorHelper.brighter(borderColor, 10);
            Color cr = AeroLookAndFeel.getWindowInactiveBorderColor();
            g.setColor(cl);
            g.drawLine(x, y, x, y + h);
            g.setColor(ColorHelper.brighter(cl, 60));
            g.drawLine(x + 1, y + 1, x + 1, y + h - 1);
            g.setColor(ColorHelper.brighter(cl, 40));
            g.drawLine(x + 2, y + 2, x + 2, y + h - 2);
            g.setColor(ColorHelper.brighter(cl, 20));
            g.drawLine(x + 3, y + 3, x + 3, y + h - 3);
            g.setColor(cl);
            g.drawLine(x + 4, y + 4, x + 4, y + h - 4);
            
            // rechts
            g.setColor(cr);
            g.drawLine(x + w, y, x + w, y + h);
            g.setColor(ColorHelper.brighter(cr, 30));
            g.drawLine(x + w - 1, y + 1, x + w - 1, y + h - 1);
            g.setColor(ColorHelper.brighter(cr, 60));
            g.drawLine(x + w - 2, y + 2, x + w - 2, y + h - 2);
            g.setColor(ColorHelper.brighter(cr, 90));
            g.drawLine(x + w - 3, y + 3, x + w - 3, y + h - 3);
            g.setColor(cr);
            g.drawLine(x + w - 4, y + 4, x + w - 4, y + h - 4);
            
            g.setColor(cl);
            g.drawLine(x + w, y, x + w, y + trackWidth);
            g.setColor(ColorHelper.brighter(cl, 20));
            g.drawLine(x + w - 1, y + 1, x + w - 1, y + trackWidth);
            g.setColor(ColorHelper.brighter(cl, 40));
            g.drawLine(x + w - 2, y + 2, x + w - 2, y + trackWidth);
            g.setColor(ColorHelper.brighter(cl, 60));
            g.drawLine(x + w - 3, y + 3, x + w - 3, y + trackWidth);
            g.setColor(cl);
            g.drawLine(x + w - 4, y + 4, x + w - 4, y + trackWidth);
            
            g.setColor(cl);
            g.drawLine(x + w, y + h - trackWidth, x + w, y + h);
            g.setColor(ColorHelper.brighter(cl, 20));
            g.drawLine(x + w - 1, y + h - trackWidth, x + w - 1, y + h - 1);
            g.setColor(ColorHelper.brighter(cl, 40));
            g.drawLine(x + w - 2, y + h - trackWidth, x + w - 2, y + h - 2);
            g.setColor(ColorHelper.brighter(cl, 60));
            g.drawLine(x + w - 3, y + h - trackWidth, x + w - 3, y + h - 3);
            g.setColor(cl);
            g.drawLine(x + w - 4, y + h - trackWidth, x + w - 4, y + h - 4);

            // oben
            g.setColor(cl);
            g.drawLine(x, y, x + dt, y);
            g.setColor(ColorHelper.brighter(cl, 60));
            g.drawLine(x + 1, y + 1, x + dt, y + 1);
            g.setColor(ColorHelper.brighter(cl, 40));
            g.drawLine(x + 2, y + 2, x + dt, y + 2);
            g.setColor(ColorHelper.brighter(cl, 20));
            g.drawLine(x + 3, y + 3, x + dt, y + 3);
            g.setColor(cl);
            g.drawLine(x + 4, y + 4, x + dt, y + 4);
            
            g.setColor(cr);
            g.drawLine(x + dt, y, x + w, y);
            g.setColor(ColorHelper.brighter(cr, 90));
            g.drawLine(x + dt, y + 1, x + w - 1, y + 1);
            g.setColor(ColorHelper.brighter(cr, 60));
            g.drawLine(x + dt, y + 2, x + w - 2, y + 2);
            g.setColor(ColorHelper.brighter(cr, 30));
            g.drawLine(x + dt, y + 3, x + w - 3, y + 3);
            if (isActive(c)) {
                g.setColor(ColorHelper.darker(cr, 15));
            } else {
                g.setColor(cr);
            }
            g.drawLine(x + dt, y + 4, x + w - 4, y + 4);
            
            g.setColor(cl);
            g.drawLine(x + w - trackWidth, y, x + w, y);
            g.setColor(ColorHelper.brighter(cl, 60));
            g.drawLine(x + w - trackWidth, y + 1, x + w - 1, y + 1);
            g.setColor(ColorHelper.brighter(cl, 40));
            g.drawLine(x + w - trackWidth, y + 2, x + w - 2, y + 2);
            g.setColor(ColorHelper.brighter(cl, 20));
            g.drawLine(x + w - trackWidth, y + 3, x + w - 3, y + 3);
            g.setColor(cl);
            g.drawLine(x + w - trackWidth, y + 4, x + w - 4, y + 4);
            
            // unten
            g.setColor(cl);
            g.drawLine(x, y + h, x + db, y + h);
            g.setColor(ColorHelper.brighter(cl, 20));
            g.drawLine(x + 1, y + h - 1, x + db, y + h - 1);
            g.setColor(ColorHelper.brighter(cl, 40));
            g.drawLine(x + 2, y + h - 2, x + db, y + h - 2);
            g.setColor(ColorHelper.brighter(cl, 60));
            g.drawLine(x + 3, y + h - 3, x + db, y + h - 3);
            g.setColor(cl);
            g.drawLine(x + 4, y + h - 4, x + db, y + h - 4);
            
            g.setColor(cr);
            g.drawLine(x + db, y + h, x + w, y + h);
            g.setColor(ColorHelper.brighter(cr, 30));
            g.drawLine(x + db, y + h - 1, x + w - 1, y + h - 1);
            g.setColor(ColorHelper.brighter(cr, 60));
            g.drawLine(x + db, y + h - 2, x + w - 2, y + h - 2);
            g.setColor(ColorHelper.brighter(cr, 90));
            g.drawLine(x + db, y + h - 3, x + w - 3, y + h - 3);
            g.setColor(cr);
            g.drawLine(x + db, y + h - 4, x + w - 4, y + h - 4);
            
            g.setColor(cl);
            g.drawLine(x + w - trackWidth, y + h, x + w, y + h);
            g.setColor(ColorHelper.brighter(cl, 20));
            g.drawLine(x + w - trackWidth, y + h - 1, x + w - 1, y + h - 1);
            g.setColor(ColorHelper.brighter(cl, 40));
            g.drawLine(x + w - trackWidth, y + h - 2, x + w - 2, y + h - 2);
            g.setColor(ColorHelper.brighter(cl, 60));
            g.drawLine(x + w - trackWidth, y + h - 3, x + w - 3, y + h - 3);
            g.setColor(cl);
            g.drawLine(x + w - trackWidth, y + h - 4, x + w - 4, y + h - 4);
        } //paintBorder

    } // class InternalFrameBorder
        
} // class AeroBorders

