/*
 * Copyright 2005 MH-Software-Entwicklung. All rights reserved.
 * Use is subject to license terms.
 */
package com.jtattoo.plaf.mcwin;

import com.jtattoo.plaf.*;
import java.awt.*;
import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.border.Border;
import javax.swing.plaf.UIResource;

/**
 * @author Michael Hagen
 */
public class McWinBorders extends BaseBorders {

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

    public static Border getTabbedPaneBorder() {
        return null;
    }

    //------------------------------------------------------------------------------------
    // Implementation of border classes
    //------------------------------------------------------------------------------------
    public static class ButtonBorder implements Border, UIResource {

        public void paintBorder(Component c, Graphics g, int x, int y, int w, int h) {
        }

        public Insets getBorderInsets(Component c) {
            if (McWinLookAndFeel.getTheme().doDrawSquareButtons()) {
                return new Insets(3, 4, 3, 4);
            } else {
                return new Insets(2, 12, 2, 12);
            }
        }

        public Insets getBorderInsets(Component c, Insets borderInsets) {
            Insets insets = getBorderInsets(c);
            borderInsets.left = insets.left;
            borderInsets.top = insets.top;
            borderInsets.right = insets.right;
            borderInsets.bottom = insets.bottom;
            return borderInsets;
        }

        public boolean isBorderOpaque() {
            return false;
        }
    } // class ButtonBorder

    public static class RolloverToolButtonBorder implements Border, UIResource {

        public void paintBorder(Component c, Graphics g, int x, int y, int w, int h) {
            AbstractButton button = (AbstractButton) c;
            ButtonModel model = button.getModel();
            Color frameColor = ColorHelper.brighter(AbstractLookAndFeel.getTheme().getFrameColor(), 40);
            if ((model.isPressed() && model.isArmed()) || model.isSelected()) {
                frameColor = ColorHelper.brighter(AbstractLookAndFeel.getTheme().getFrameColor(), 20);
            } else if (model.isRollover()) {
                frameColor = AbstractLookAndFeel.getTheme().getRolloverColor();
            }
            g.setColor(frameColor);
            g.drawRect(x, y, w - 2, h - 1);
            g.setColor(AbstractLookAndFeel.getTheme().getToolbarBackgroundColor());
            g.drawLine(w - 1, 0, w - 1, h - 1);
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(1, 1, 1, 1);
        }

        public Insets getBorderInsets(Component c, Insets borderInsets) {
            borderInsets.top = 1;
            borderInsets.left = 1;
            borderInsets.bottom = 1;
            borderInsets.right = 1;
            return borderInsets;
        }

        public boolean isBorderOpaque() {
            return true;
        }
    } // class RolloverToolButtonBorder

    public static class InternalFrameBorder extends BaseInternalFrameBorder {

        public void paintBorder(Component c, Graphics g, int x, int y, int w, int h) {
            boolean active = isActive(c);
            boolean resizable = isResizable(c);
            int th = getTitleHeight(c);
            Color frameColor = McWinLookAndFeel.getWindowInactiveBorderColor();
            Color titleColor = McWinLookAndFeel.getWindowInactiveTitleColorLight();
            Color borderColor = McWinLookAndFeel.getWindowInactiveTitleColorDark();
            if (active) {
                frameColor = McWinLookAndFeel.getWindowBorderColor();
                titleColor = McWinLookAndFeel.getWindowTitleColorLight();
                borderColor = McWinLookAndFeel.getWindowTitleColorDark();
            }
            if (!resizable) {
                Insets borderInsets = getBorderInsets(c);
                g.setColor(frameColor);
                g.drawRect(x, y, w - 1, h - 1);
                if (active) {
                    g.setColor(McWinLookAndFeel.getWindowTitleColorDark());
                } else {
                    g.setColor(McWinLookAndFeel.getWindowInactiveTitleColorDark());
                }
                for (int i = 1; i < borderInsets.left; i++) {
                    g.drawRect(i, i, w - (2 * i) - 1, h - (2 * i) - 1);
                }
                g.setColor(ColorHelper.brighter(frameColor, 20));
                g.drawLine(borderInsets.left - 1, y + th + borderInsets.top, borderInsets.left - 1, y + h - borderInsets.bottom);
                g.drawLine(w - borderInsets.right, y + th + borderInsets.top, w - borderInsets.right, y + h - borderInsets.bottom);
                g.drawLine(borderInsets.left - 1, y + h - borderInsets.bottom, w - borderInsets.right, y + h - borderInsets.bottom);
                return;
            }
            g.setColor(titleColor);
            g.fillRect(x, y + 1, w, dw - 1);
            g.setColor(borderColor);
            g.fillRect(x + 1, y + h - dw, w - 2, dw - 1);
            if (active) {
                JTattooUtilities.fillHorGradient(g, McWinLookAndFeel.getTheme().getWindowTitleColors(), 1, dw, dw, th + 1);
                JTattooUtilities.fillHorGradient(g, McWinLookAndFeel.getTheme().getWindowTitleColors(), w - dw, dw, dw, th + 1);
            } else {
                JTattooUtilities.fillHorGradient(g, McWinLookAndFeel.getTheme().getWindowInactiveTitleColors(), 1, dw, dw, th + 1);
                JTattooUtilities.fillHorGradient(g, McWinLookAndFeel.getTheme().getWindowInactiveTitleColors(), w - dw, dw, dw, th + 1);
            }
            g.setColor(borderColor);
            g.fillRect(1, insets.top + th + 1, dw - 1, h - th - dw);
            g.fillRect(w - dw, insets.top + th + 1, dw - 1, h - th - dw);

            g.setColor(ColorHelper.darker(frameColor, 10));
            g.drawRect(x, y, w - 1, h - 1);
            g.setColor(frameColor);
            g.drawLine(x + dw - 1, y + dw + th, x + dw - 1, y + h - dw);
            g.drawLine(x + w - dw, y + dw + th, x + w - dw, y + h - dw);
            g.drawLine(x + dw - 1, y + h - dw, x + w - dw, y + h - dw);
        }
    } // class InternalFrameBorder
} // class McWinBorders

