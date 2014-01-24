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

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.IOColorLines;
import org.openide.windows.IOProvider;
import org.openide.windows.InputOutput;
import tw.edu.sju.ee.eea.module.fra.file.fr.FrDataObject;

@ActionID(
        category = "Analyzer",
        id = "tw.edu.sju.ee.eea.module.fra.file.fr.action.FrDiffAction"
)
@ActionRegistration(
        displayName = "#CTL_FrDiffAction"
)
@ActionReferences({
    @ActionReference(path = "Menu/Analyzers", position = 3333, separatorAfter = 3383),
    @ActionReference(path = "Loaders/application/x-plot/Actions", position = 1050, separatorAfter = 1075)
})
@Messages("CTL_FrDiffAction=Diff")
public final class FrDiffAction implements ActionListener {

    private final List<FrDataObject> context;

    public FrDiffAction(List<FrDataObject> context) {
        this.context = context;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        if (context.size() != 2) {
            JOptionPane.showMessageDialog(null, "Must Select 2 File", "Error Selected File", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String title = Bundle.CTL_FrDiffAction();
        title += "(" + context.get(0).getName() + " - " + context.get(1).getName() + ")";
        InputOutput io = IOProvider.getDefault().getIO(title, false);
        try {
            IOColorLines.println(io, "Diff", Color.BLACK);
            IOColorLines.println(io, "Sellected file : " + context.size(), Color.BLACK);

            for (FrDataObject frDataObject : context) {
                IOColorLines.println(io, frDataObject.getName(), Color.BLACK);
                IOColorLines.println(io, frDataObject.getFile().getConfig().toString(), Color.BLACK);

            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }
}
