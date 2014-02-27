/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.edu.sju.ee.eea.module.fra.file.fr;

import java.util.ArrayList;
import java.util.List;
import tw.edu.sju.ee.eea.core.frequency.response.FrequencyResponseConfig;
import javax.swing.JPanel;
import org.openide.util.NbBundle.Messages;
import tw.edu.sju.ee.eea.jni.modinst.NIModinstUtils;

@Messages({
    "FrVisualPanel1_displayName=Frequency Response Configuration"
})
public final class FrConfigVisualPanel extends JPanel {

    /**
     * Creates new form FrVisualPanel1
     */
    public FrConfigVisualPanel() {
        initComponents();
    }

    @Override
    public String getName() {
        return Bundle.FrVisualPanel1_displayName();
    }

    public FrequencyResponseConfig getConfig() {
        return new FrequencyResponseConfig(
                ((Device) cmbGenerateDevice.getSelectedItem()).name, txtGenerateChannel.getText(),
                ((Device) cmbResponseDevice.getSelectedItem()).name, txtResponseChanel.getText(),
                Double.parseDouble(txtVoltage.getText()),
                Double.parseDouble(txtStartFrequency.getText()), Double.parseDouble(txtStopFrequency.getText()),
                Integer.parseInt(txtPoints.getText()), Integer.parseInt(txtRatePerHz.getText()),
                txaDescription.getText());
    }

    private Object[] getDevice(String driver) {
        List<NIModinstUtils.Device> devices = NIModinstUtils.list(driver);
        List<Device> list = new ArrayList();
        for (int i = 0; i < devices.size(); i++) {
            list.add(new Device(devices.get(i)));
        }
        return list.toArray();
    }

    private class Device {

        private String name;
        private String model;

        public Device(NIModinstUtils.Device device) {
            name = device.getDeviceName();
            model = device.getDeviceModel();
        }

        @Override
        public String toString() {
            return name + " - " + model;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblGenerateDevice = new javax.swing.JLabel();
        lblGenerateChannel = new javax.swing.JLabel();
        lblResponseDevice = new javax.swing.JLabel();
        lblResponseChannel = new javax.swing.JLabel();
        lblVoltage = new javax.swing.JLabel();
        lblStartFrequency = new javax.swing.JLabel();
        lblStopFrequrncy = new javax.swing.JLabel();
        lblPoints = new javax.swing.JLabel();
        lblRatePerHz = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        cmbGenerateDevice = new javax.swing.JComboBox();
        txtGenerateChannel = new javax.swing.JTextField();
        cmbResponseDevice = new javax.swing.JComboBox();
        txtResponseChanel = new javax.swing.JTextField();
        txtVoltage = new javax.swing.JTextField();
        txtStartFrequency = new javax.swing.JTextField();
        txtStopFrequency = new javax.swing.JTextField();
        txtPoints = new javax.swing.JTextField();
        txtRatePerHz = new javax.swing.JTextField();
        scrDescription = new javax.swing.JScrollPane();
        txaDescription = new javax.swing.JTextArea();

        setPreferredSize(new java.awt.Dimension(500, 350));

        org.openide.awt.Mnemonics.setLocalizedText(lblGenerateDevice, org.openide.util.NbBundle.getMessage(FrConfigVisualPanel.class, "FrConfigVisualPanel.lblGenerateDevice.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(lblGenerateChannel, org.openide.util.NbBundle.getMessage(FrConfigVisualPanel.class, "FrConfigVisualPanel.lblGenerateChannel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(lblResponseDevice, org.openide.util.NbBundle.getMessage(FrConfigVisualPanel.class, "FrConfigVisualPanel.lblResponseDevice.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(lblResponseChannel, org.openide.util.NbBundle.getMessage(FrConfigVisualPanel.class, "FrConfigVisualPanel.lblResponseChannel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(lblVoltage, org.openide.util.NbBundle.getMessage(FrConfigVisualPanel.class, "FrConfigVisualPanel.lblVoltage.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(lblStartFrequency, org.openide.util.NbBundle.getMessage(FrConfigVisualPanel.class, "FrConfigVisualPanel.lblStartFrequency.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(lblStopFrequrncy, org.openide.util.NbBundle.getMessage(FrConfigVisualPanel.class, "FrConfigVisualPanel.lblStopFrequrncy.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(lblPoints, org.openide.util.NbBundle.getMessage(FrConfigVisualPanel.class, "FrConfigVisualPanel.lblPoints.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(lblRatePerHz, org.openide.util.NbBundle.getMessage(FrConfigVisualPanel.class, "FrConfigVisualPanel.lblRatePerHz.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(lblDescription, org.openide.util.NbBundle.getMessage(FrConfigVisualPanel.class, "FrConfigVisualPanel.lblDescription.text")); // NOI18N

        cmbGenerateDevice.setModel(new javax.swing.DefaultComboBoxModel(getDevice("niFgen")));
        cmbGenerateDevice.setMaximumSize(new java.awt.Dimension(201, 21));
        cmbGenerateDevice.setMinimumSize(new java.awt.Dimension(101, 21));
        cmbGenerateDevice.setPreferredSize(new java.awt.Dimension(151, 21));

        txtGenerateChannel.setText(org.openide.util.NbBundle.getMessage(FrConfigVisualPanel.class, "FrConfigVisualPanel.txtGenerateChannel.text")); // NOI18N
        txtGenerateChannel.setMaximumSize(new java.awt.Dimension(101, 21));
        txtGenerateChannel.setMinimumSize(new java.awt.Dimension(31, 21));
        txtGenerateChannel.setPreferredSize(new java.awt.Dimension(51, 21));

        cmbResponseDevice.setModel(new javax.swing.DefaultComboBoxModel(getDevice("niScope")));
        cmbResponseDevice.setMaximumSize(new java.awt.Dimension(201, 21));
        cmbResponseDevice.setMinimumSize(new java.awt.Dimension(101, 21));
        cmbResponseDevice.setPreferredSize(new java.awt.Dimension(151, 21));

        txtResponseChanel.setText(org.openide.util.NbBundle.getMessage(FrConfigVisualPanel.class, "FrConfigVisualPanel.txtResponseChanel.text")); // NOI18N
        txtResponseChanel.setMaximumSize(new java.awt.Dimension(101, 21));
        txtResponseChanel.setMinimumSize(new java.awt.Dimension(31, 21));
        txtResponseChanel.setPreferredSize(new java.awt.Dimension(51, 21));

        txtVoltage.setText(org.openide.util.NbBundle.getMessage(FrConfigVisualPanel.class, "FrConfigVisualPanel.txtVoltage.text")); // NOI18N
        txtVoltage.setMaximumSize(new java.awt.Dimension(201, 21));
        txtVoltage.setMinimumSize(new java.awt.Dimension(101, 21));
        txtVoltage.setPreferredSize(new java.awt.Dimension(151, 21));

        txtStartFrequency.setText(org.openide.util.NbBundle.getMessage(FrConfigVisualPanel.class, "FrConfigVisualPanel.txtStartFrequency.text")); // NOI18N
        txtStartFrequency.setMaximumSize(new java.awt.Dimension(201, 21));
        txtStartFrequency.setMinimumSize(new java.awt.Dimension(101, 21));
        txtStartFrequency.setPreferredSize(new java.awt.Dimension(151, 21));

        txtStopFrequency.setText(org.openide.util.NbBundle.getMessage(FrConfigVisualPanel.class, "FrConfigVisualPanel.txtStopFrequency.text")); // NOI18N
        txtStopFrequency.setMaximumSize(new java.awt.Dimension(201, 21));
        txtStopFrequency.setMinimumSize(new java.awt.Dimension(101, 21));
        txtStopFrequency.setPreferredSize(new java.awt.Dimension(151, 21));

        txtPoints.setText(org.openide.util.NbBundle.getMessage(FrConfigVisualPanel.class, "FrConfigVisualPanel.txtPoints.text")); // NOI18N
        txtPoints.setMaximumSize(new java.awt.Dimension(101, 21));
        txtPoints.setMinimumSize(new java.awt.Dimension(31, 21));
        txtPoints.setPreferredSize(new java.awt.Dimension(51, 21));

        txtRatePerHz.setText(org.openide.util.NbBundle.getMessage(FrConfigVisualPanel.class, "FrConfigVisualPanel.txtRatePerHz.text")); // NOI18N
        txtRatePerHz.setMaximumSize(new java.awt.Dimension(101, 21));
        txtRatePerHz.setMinimumSize(new java.awt.Dimension(31, 21));
        txtRatePerHz.setPreferredSize(new java.awt.Dimension(51, 21));

        txaDescription.setColumns(20);
        txaDescription.setRows(5);
        txaDescription.setText(org.openide.util.NbBundle.getMessage(FrConfigVisualPanel.class, "FrConfigVisualPanel.txaDescription.text")); // NOI18N
        scrDescription.setViewportView(txaDescription);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblResponseDevice)
                    .addComponent(lblGenerateDevice)
                    .addComponent(lblStartFrequency)
                    .addComponent(lblVoltage)
                    .addComponent(lblDescription)
                    .addComponent(lblStopFrequrncy))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbGenerateDevice, 0, 155, Short.MAX_VALUE)
                            .addComponent(cmbResponseDevice, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtVoltage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtStartFrequency, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtStopFrequency, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGenerateChannel)
                            .addComponent(lblResponseChannel)
                            .addComponent(lblRatePerHz)
                            .addComponent(lblPoints))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPoints, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtRatePerHz, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                            .addComponent(txtResponseChanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtGenerateChannel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(scrDescription))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblGenerateDevice)
                    .addComponent(cmbGenerateDevice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGenerateChannel)
                    .addComponent(txtGenerateChannel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblResponseDevice)
                    .addComponent(cmbResponseDevice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblResponseChannel)
                    .addComponent(txtResponseChanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblVoltage)
                    .addComponent(txtVoltage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblStartFrequency)
                    .addComponent(txtStartFrequency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPoints, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPoints, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblStopFrequrncy)
                    .addComponent(txtStopFrequency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRatePerHz)
                    .addComponent(txtRatePerHz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbGenerateDevice;
    private javax.swing.JComboBox cmbResponseDevice;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblGenerateChannel;
    private javax.swing.JLabel lblGenerateDevice;
    private javax.swing.JLabel lblPoints;
    private javax.swing.JLabel lblRatePerHz;
    private javax.swing.JLabel lblResponseChannel;
    private javax.swing.JLabel lblResponseDevice;
    private javax.swing.JLabel lblStartFrequency;
    private javax.swing.JLabel lblStopFrequrncy;
    private javax.swing.JLabel lblVoltage;
    private javax.swing.JScrollPane scrDescription;
    private javax.swing.JTextArea txaDescription;
    private javax.swing.JTextField txtGenerateChannel;
    private javax.swing.JTextField txtPoints;
    private javax.swing.JTextField txtRatePerHz;
    private javax.swing.JTextField txtResponseChanel;
    private javax.swing.JTextField txtStartFrequency;
    private javax.swing.JTextField txtStopFrequency;
    private javax.swing.JTextField txtVoltage;
    // End of variables declaration//GEN-END:variables
}
