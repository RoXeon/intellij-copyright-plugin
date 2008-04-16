package com.maddyhome.idea.copyright.ui;

/*
 * Copyright - Copyright notice updater for IDEA
 * Copyright (C) 2004-2005 Rick Maddy. All Rights Reserved.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import java.awt.Font;
import java.awt.Insets;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class OverviewTab
{
    public OverviewTab()
    {
        setupControls();
    }

    public JComponent getMainComponent()
    {
        return mainPanel;
    }

    private void setupControls()
    {
        try
        {
            InputStream is = getClass().getResourceAsStream("/README");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = reader.readLine()) != null)
            {
                overviewTxt.append(line);
                overviewTxt.append("\n");
            }
        }
        catch (IOException e)
        {
            logger.error(e.getMessage());
        }

        Font font = overviewTxt.getFont();
        Font newFont = new Font("Monospaced", Font.PLAIN, font.getSize());

        overviewTxt.setFont(newFont);
        overviewTxt.setColumns(80);
        overviewTxt.setCaretPosition(0);
        scrollpane.getVerticalScrollBar().setValue(0);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer >>> IMPORTANT!! <<< DO NOT edit this method OR call it in your
     * code!
     */
    private void $$$setupUI$$$()
    {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        scrollpane = new JScrollPane();
        mainPanel.add(scrollpane, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null));
        overviewTxt = new JTextArea();
        overviewTxt.setColumns(80);
        overviewTxt.setEditable(false);
        overviewTxt.setRows(30);
        scrollpane.setViewportView(overviewTxt);
    }

    private JPanel mainPanel;
    private JTextArea overviewTxt;
    private JScrollPane scrollpane;

    private static Logger logger = Logger.getInstance(OverviewTab.class.getName());

}
