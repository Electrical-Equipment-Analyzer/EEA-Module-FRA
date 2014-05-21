/*
 * Copyright (C) 2014 Leo
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
package tw.edu.sju.ee.eea.module.fra.file.fr.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.WindowManager;
import tw.edu.sju.ee.eea.module.fra.file.fr.FrDataObject;

@ActionID(
        category = "Analyzer",
        id = "tw.edu.sju.ee.eea.module.fra.file.fr.action.FrDiffIECAction"
)
@ActionRegistration(
        displayName = "#CTL_FrDiffIECAction"
)
@ActionReferences({
    @ActionReference(path = "Menu/Analyzers/Frequency Response Analysis", position = 120)
})
@Messages("CTL_FrDiffIECAction=IEC")
public final class FrDiffIECAction implements ActionListener {

    private final List<FrDataObject> context;

    public FrDiffIECAction(List<FrDataObject> context) {
        this.context = context;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        JOptionPane.showMessageDialog(WindowManager.getDefault().getMainWindow(),
                "Not Supported Yet. ^_^", "Oops!", JOptionPane.WARNING_MESSAGE);
    }
}
