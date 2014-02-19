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
import org.apache.commons.math3.complex.Complex;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.IOColorLines;
import org.openide.windows.IOProvider;
import org.openide.windows.InputOutput;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
import tw.edu.sju.ee.eea.core.math.ComplexArray;
import tw.edu.sju.ee.eea.core.standard.FRAChina;
import tw.edu.sju.ee.eea.module.fra.file.fr.FrDataObject;

@ActionID(
        category = "Analyzer",
        id = "tw.edu.sju.ee.eea.module.fra.file.fr.action.FrDiffDLAction"
)
@ActionRegistration(
        displayName = "#CTL_FrDiffDLAction"
)
@ActionReferences({
    @ActionReference(path = "Menu/Analyzers/Frequency Response Analysis", position = 110, separatorAfter = 190)
})
@Messages("CTL_FrDiffDLAction=DL/911 (China)")
public final class FrDiffDLAction implements ActionListener {

    private final List<FrDataObject> context;

    public FrDiffDLAction(List<FrDataObject> context) {
        this.context = context;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        if (context.size() < 2) {
            JOptionPane.showMessageDialog(WindowManager.getDefault().getMainWindow(),
                    "Must Select More 2 File", "Error Selected File", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String title = Bundle.CTL_FrDiffDLAction();
        title += "(" + context.get(0).getName() + " - " + context.get(1).getName() + ")";
        InputOutput io = IOProvider.getDefault().getIO(title, false);
        try {
            IOColorLines.println(io, "Diff", Color.BLACK);
            IOColorLines.println(io, "Sellected file : " + context.size(), Color.BLACK);

//            for (FrDataObject frDataObject : context) {
//                IOColorLines.println(io, frDataObject.getName(), Color.BLACK);
//                IOColorLines.println(io, frDataObject.getFile().getConfig().toString(), Color.BLACK);
//            }
            FRAChina fraChinaX = new FRAChina(ComplexArray.getAbsolute(context.get(0).getFile().getGain().values().toArray(new Complex[0])));
            FRAChina fraChinaY = new FRAChina(ComplexArray.getAbsolute(context.get(1).getFile().getGain().values().toArray(new Complex[0])));

            IOColorLines.println(io, "Dx : " + fraChinaX.variance(), Color.BLACK);
            IOColorLines.println(io, "Dy : " + fraChinaY.variance(), Color.BLACK);

            IOColorLines.println(io, "Cxy : " + FRAChina.covariance(fraChinaX, fraChinaY), Color.BLACK);
            IOColorLines.println(io, "LRxy : " + FRAChina.autocovariance(fraChinaX, fraChinaY), Color.BLACK);
            IOColorLines.println(io, "Rxy : " + FRAChina.coefficient(fraChinaX, fraChinaY), Color.BLACK);

            TopComponent tc = new FrDiffTopComponent(context);
            tc.open();
            tc.requestActive();
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }
}
