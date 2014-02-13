/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.edu.sju.ee.eea.module.fra.file.fr;

import tw.edu.sju.ee.eea.core.frequency.response.FrequencyResponseFile;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.cookies.OpenCookie;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.MIMEResolver;
import org.openide.loaders.DataNode;
import org.openide.loaders.DataObject;
import org.openide.loaders.DataObjectExistsException;
import org.openide.loaders.MultiDataObject;
import org.openide.loaders.MultiFileLoader;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.nodes.PropertySupport;
import org.openide.nodes.Sheet;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;
import org.openide.util.NbBundle.Messages;

@Messages({
    "LBL_Fr_LOADER=Files of Fr"
})
@MIMEResolver.ExtensionRegistration(
        displayName = "#LBL_Fr_LOADER",
        mimeType = "application/x-plot",
        extension = {"fr"}
)
@DataObject.Registration(
        mimeType = "application/x-plot",
        iconBase = "tw/edu/sju/ee/eea/module/fra/file/fr/fr.png",
        displayName = "#LBL_Fr_LOADER",
        position = 300
)
@ActionReferences({
    @ActionReference(
            path = "Loaders/application/x-plot/Actions",
            id = @ActionID(category = "System", id = "org.openide.actions.OpenAction"),
            position = 100,
            separatorAfter = 200
    ),
    @ActionReference(
            path = "Loaders/application/x-plot/Actions",
            id = @ActionID(category = "Edit", id = "org.openide.actions.CutAction"),
            position = 300
    ),
    @ActionReference(
            path = "Loaders/application/x-plot/Actions",
            id = @ActionID(category = "Edit", id = "org.openide.actions.CopyAction"),
            position = 400,
            separatorAfter = 500
    ),
    @ActionReference(
            path = "Loaders/application/x-plot/Actions",
            id = @ActionID(category = "Edit", id = "org.openide.actions.DeleteAction"),
            position = 600
    ),
    @ActionReference(
            path = "Loaders/application/x-plot/Actions",
            id = @ActionID(category = "System", id = "org.openide.actions.RenameAction"),
            position = 700,
            separatorAfter = 800
    ),
    @ActionReference(
            path = "Loaders/application/x-plot/Actions",
            id = @ActionID(category = "System", id = "org.openide.actions.SaveAsTemplateAction"),
            position = 900,
            separatorAfter = 1000
    ),
    @ActionReference(
            path = "Loaders/application/x-plot/Actions",
            id = @ActionID(category = "System", id = "org.openide.actions.FileSystemAction"),
            position = 1100,
            separatorAfter = 1200
    ),
    @ActionReference(
            path = "Loaders/application/x-plot/Actions",
            id = @ActionID(category = "System", id = "org.openide.actions.ToolsAction"),
            position = 1300
    ),
    @ActionReference(
            path = "Loaders/application/x-plot/Actions",
            id = @ActionID(category = "System", id = "org.openide.actions.PropertiesAction"),
            position = 1400
    )
})
public class FrDataObject extends MultiDataObject implements OpenCookie {

    private FrequencyResponseFile file;

    public FrDataObject(FileObject pf, MultiFileLoader loader) throws DataObjectExistsException, IOException {
        super(pf, loader);
        registerEditor("application/x-plot", true);
        open();
    }

    @Override
    public void open() {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(getPrimaryFile().getInputStream());
            Object read = objectInputStream.readObject();
            if (read instanceof FrequencyResponseFile) {
                file = (FrequencyResponseFile) read;
            }
        } catch (FileNotFoundException ex) {
            Exceptions.printStackTrace(ex);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        } catch (ClassNotFoundException ex) {
            Exceptions.printStackTrace(ex);
        } finally {
            try {
                objectInputStream.close();
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
    }
    
    public FrequencyResponseFile getFile() {
        return this.file;
    }

    @Override
    protected int associateLookup() {
        return 1;
    }

    @Override
    protected Node createNodeDelegate() {
        return new ConfigurationNode(
                this,
                Children.LEAF,
                getLookup());
    }

    private class ConfigurationNode extends DataNode {

        public ConfigurationNode(FrDataObject aThis, Children kids, Lookup lookup) {
            super(aThis, kids, lookup);
        }

        @Override
        protected Sheet createSheet() {
            Sheet.Set set = new Sheet.Set();
            set.setName("Configuration");
            set.put(new PropertySupport.ReadOnly("generateChannel", String.class, "generateChannel", "generateChannel") {

                @Override
                public String getValue() throws IllegalAccessException, InvocationTargetException {
                    return file.getConfig().getGenerateDevice();
                }
            });
            set.put(new PropertySupport.ReadOnly("responseChannel", String.class, "responseChannel", "responseChannel") {

                @Override
                public String getValue() throws IllegalAccessException, InvocationTargetException {
                    return file.getConfig().getResponseDevice();
                }
            });
            set.put(new PropertySupport.ReadOnly("voltage", Double.class, "voltage", "voltage") {

                @Override
                public Double getValue() throws IllegalAccessException, InvocationTargetException {
                    return file.getConfig().getVoltage();
                }
            });
            set.put(new PropertySupport.ReadOnly("minFrequency", Double.class, "minFrequency", "minFrequency") {

                @Override
                public Double getValue() throws IllegalAccessException, InvocationTargetException {
                    return file.getConfig().getMinFrequency();
                }
            });
            set.put(new PropertySupport.ReadOnly("maxFrequrncy", Double.class, "maxFrequrncy", "maxFrequrncy") {

                @Override
                public Double getValue() throws IllegalAccessException, InvocationTargetException {
                    return file.getConfig().getMaxFrequrncy();
                }
            });
            set.put(new PropertySupport.ReadOnly("length", Integer.class, "length", "length") {

                @Override
                public Integer getValue() throws IllegalAccessException, InvocationTargetException {
                    return file.getConfig().getLength();
                }
            });
            Sheet sheet = super.createSheet();
            sheet.put(set);
            return sheet;
        }
    }

//    @MultiViewElement.Registration(
//        displayName = "#LBL_Fr_EDITOR",
//        iconBase = "tw/edu/sju/ee/eea/module/fra/file/fr/fr.png",
//        mimeType = "application/x-plot",
//        persistenceType = TopComponent.PERSISTENCE_ONLY_OPENED,
//        preferredID = "Fr",
//        position = 1000
//    )
//    @Messages("LBL_Fr_EDITOR=Source")
//    public static MultiViewEditorElement createEditor(Lookup lkp) {
//        return new MultiViewEditorElement(lkp);
//    }
}
