/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sju.ee.eea.module.fra.file.fr;

import edu.sju.ee.eea.core.frequency.response.FrequencyResponseFile;
import edu.sju.ee.eea.core.math.ComplexArray;
import edu.sju.ee.eea.core.math.MetricPrefixFormat;
import java.awt.Color;
import java.awt.Font;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import org.apache.commons.math3.complex.Complex;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.LogAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.netbeans.core.spi.multiview.CloseOperationState;
import org.netbeans.core.spi.multiview.MultiViewElement;
import org.netbeans.core.spi.multiview.MultiViewElementCallback;
import org.openide.awt.UndoRedo;
import org.openide.util.Lookup;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;

@MultiViewElement.Registration(
        displayName = "#LBL_Fr_VISUAL",
        iconBase = "edu/sju/ee/eea/module/fra/file/fr/fr.png",
        mimeType = "application/x-plot",
        persistenceType = TopComponent.PERSISTENCE_NEVER,
        preferredID = "FrVisual",
        position = 2000
)
@Messages("LBL_Fr_VISUAL=Bode Plot")
public final class FrVisualElement extends JPanel implements MultiViewElement {

    private FrDataObject obj;
    private JToolBar toolbar = new JToolBar();
    private transient MultiViewElementCallback callback;

    private FrequencyResponseFile data;
    private JFreeChart chart;
    private ChartPanel chartPanel;

    public FrVisualElement(Lookup lkp) {
        obj = lkp.lookup(FrDataObject.class);
        assert obj != null;
        data = obj.file;
        initChart();
        initComponents();
    }

    private void initChart() {
        Complex[] H = new Complex[data.getConfig().getLength()];
        for (int i = 0; i < H.length; i++) {
            H[i] = data.getOut()[i].divide(data.getIn()[i]);
        }
        Font font = new Font(Font.DIALOG, Font.BOLD, 14);
        Color color1 = Color.RED;
        Color color2 = Color.BLUE;

        chart = ChartFactory.createXYLineChart("Bode Plot", null, "Magnitude(dB)", createXYSeriesCollection("Magnitude", data, toBode(ComplexArray.getAbsolute(H))));
        XYPlot plot = chart.getXYPlot();

        LogAxis domainAxis = new LogAxis("Frequency");
        domainAxis.setLabelFont(font);
        domainAxis.setNumberFormatOverride(new MetricPrefixFormat("0.###"));
        plot.setDomainAxis(domainAxis);

        ValueAxis axis1 = plot.getRangeAxis();
        axis1.setLabelFont(font);
        axis1.setLabelPaint(color1);
        axis1.setTickLabelPaint(color1);

        NumberAxis axis2 = new NumberAxis("Phase(Degrees)");
        axis2.setLabelFont(font);
        axis2.setLabelPaint(color2);
        axis2.setTickLabelPaint(color2);
        plot.setRangeAxis(1, axis2);

        plot.setDataset(1, createXYSeriesCollection("Phase", data, toDegree(ComplexArray.getArgument(H))));
        plot.mapDatasetToRangeAxis(1, 1);
        XYItemRenderer renderer2 = new StandardXYItemRenderer();
        renderer2.setSeriesPaint(0, color2);
        plot.setRenderer(1, renderer2);

        chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(600, 270));
        chartPanel.setDomainZoomable(true);
        chartPanel.setRangeZoomable(true);
    }

    private static XYSeriesCollection createXYSeriesCollection(String name, FrequencyResponseFile file, double[] data) {
        XYSeries series1 = new XYSeries(name);
        for (int i = 0; i < file.getConfig().getLength(); i++) {
            System.out.println(file.getConfig().getFrequency(i));
            series1.add(file.getConfig().getFrequency(i), data[i]);
        }
        XYSeriesCollection collection = new XYSeriesCollection();
        collection.addSeries(series1);
        return collection;
    }

    private double[] toBode(double[] data) {
        double bode[] = new double[data.length];
        for (int i = 0; i < data.length; i++) {
            bode[i] = 20 * Math.log(data[i]);
        }
        return bode;
    }

    private double[] toDegree(double[] data) {
        double degree[] = new double[data.length];
        for (int i = 0; i < data.length; i++) {
            degree[i] = Math.toDegrees(data[i]);
        }
        return degree;
    }

    @Override
    public String getName() {
        return "FrVisualElement";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = chartPanel;

        setPreferredSize(new java.awt.Dimension(640, 480));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public JComponent getVisualRepresentation() {
        return this;
    }

    @Override
    public JComponent getToolbarRepresentation() {
        return toolbar;
    }

    @Override
    public Action[] getActions() {
        return new Action[0];
    }

    @Override
    public Lookup getLookup() {
        return obj.getLookup();
    }

    @Override
    public void componentOpened() {
    }

    @Override
    public void componentClosed() {
    }

    @Override
    public void componentShowing() {
    }

    @Override
    public void componentHidden() {
    }

    @Override
    public void componentActivated() {
    }

    @Override
    public void componentDeactivated() {
    }

    @Override
    public UndoRedo getUndoRedo() {
        return UndoRedo.NONE;
    }

    @Override
    public void setMultiViewCallback(MultiViewElementCallback callback) {
        this.callback = callback;
        callback.getTopComponent().setDisplayName(obj.getPrimaryFile().getName());
    }

    @Override
    public CloseOperationState canCloseElement() {
        return CloseOperationState.STATE_OK;
    }

}
