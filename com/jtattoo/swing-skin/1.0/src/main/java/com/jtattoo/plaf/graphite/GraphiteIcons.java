/*
 * Copyright 2005 MH-Software-Entwicklung. All rights reserved.
 * Use is subject to license terms.
 */

package com.jtattoo.plaf.graphite;

import com.jtattoo.plaf.AbstractLookAndFeel;
import com.jtattoo.plaf.BaseIcons;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.Icon;

/**
 * @author Michael Hagen
 */
public class GraphiteIcons extends BaseIcons {

    public static Icon getIconIcon() {
        if (iconIcon == null) {
            Color iconColor = AbstractLookAndFeel.getTheme().getWindowIconColor();
            Color iconShadowColor = AbstractLookAndFeel.getTheme().getWindowIconShadowColor();
            Color iconRolloverColor = AbstractLookAndFeel.getTheme().getWindowIconRolloverColor();
            iconIcon = new BaseIcons.IconSymbol(iconColor, iconShadowColor, iconRolloverColor, new Insets(1, 1, 1, 1));
        }
        return iconIcon;
    }

    public static Icon getMinIcon() {
        if (minIcon == null) {
            Color iconColor = AbstractLookAndFeel.getTheme().getWindowIconColor();
            Color iconShadowColor = AbstractLookAndFeel.getTheme().getWindowIconShadowColor();
            Color iconRolloverColor = AbstractLookAndFeel.getTheme().getWindowIconRolloverColor();
            minIcon = new BaseIcons.MinSymbol(iconColor, iconShadowColor, iconRolloverColor, new Insets(1, 1, 1, 1));
        }
        return minIcon;
    }

    public static Icon getMaxIcon() {
        if (maxIcon == null) {
            Color iconColor = AbstractLookAndFeel.getTheme().getWindowIconColor();
            Color iconShadowColor = AbstractLookAndFeel.getTheme().getWindowIconShadowColor();
            Color iconRolloverColor = AbstractLookAndFeel.getTheme().getWindowIconRolloverColor();
            maxIcon = new BaseIcons.MaxSymbol(iconColor, iconShadowColor, iconRolloverColor, new Insets(1, 1, 1, 1));
        }
        return maxIcon;
    }

    public static Icon getCloseIcon() {
        if (closeIcon == null) {
            Color iconColor = AbstractLookAndFeel.getTheme().getWindowIconColor();
            Color iconShadowColor = AbstractLookAndFeel.getTheme().getWindowIconShadowColor();
            Color iconRolloverColor = AbstractLookAndFeel.getTheme().getWindowIconRolloverColor();
            closeIcon = new BaseIcons.CloseSymbol(iconColor, iconShadowColor, iconRolloverColor, new Insets(1, 1, 1, 1));
        }
        return closeIcon;
    }

    //--------------------------------------------------------------------------------------------------------
}
