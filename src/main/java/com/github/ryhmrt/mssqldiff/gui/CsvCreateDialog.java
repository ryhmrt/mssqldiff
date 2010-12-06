package com.github.ryhmrt.mssqldiff.gui;

import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.github.ryhmrt.mssqldiff.csv.SchemaCsv;
import com.github.ryhmrt.mssqldiff.csv.SchemaCsvReaderMssqlImpl;
import com.github.ryhmrt.mssqldiff.csv.SchemaCsvWriter;

public class CsvCreateDialog extends JDialog {

    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private JPanel filePanel = null;
    private JLabel filePathLabel = null;
    private JButton fileButton = null;
    private JLabel fileLabel = null;
    private JPanel inputPanel = null;
    private JLabel hostLabel = null;
    private JTextField hostField = null;
    private JLabel userLabel = null;
    private JTextField userField = null;
    private JLabel passLabel = null;
    private JPasswordField passField = null;
    private JLabel dbnameLabel = null;
    private JTextField dbnameField = null;
    private JPanel buttonPanel = null;
    private JButton cancelButton = null;
    private JButton loadButton = null;

    private String filePath = null;

    /**
     * @param owner
     */
    public CsvCreateDialog(Frame owner) {
        super(owner);
        initialize();
    }

    /**
     * This method initializes this
     * 
     * @return void
     */
    private void initialize() {
        this.setSize(497, 244);
        this.setModal(true);
        this.setContentPane(getJContentPane());
    }

    /**
     * This method initializes jContentPane
     * 
     * @return javax.swing.JPanel
     */
    private JPanel getJContentPane() {
        if (jContentPane == null) {
            BorderLayout borderLayout = new BorderLayout();
            borderLayout.setHgap(8);
            borderLayout.setVgap(8);
            jContentPane = new JPanel();
            jContentPane.setLayout(borderLayout);
            jContentPane.add(getInputPanel(), BorderLayout.CENTER);
        }
        return jContentPane;
    }

    /**
     * This method initializes filePanel	
     * 	
     * @return javax.swing.JPanel	
     */
    private JPanel getFilePanel() {
        if (filePanel == null) {
            filePathLabel = new JLabel();
            filePathLabel.setText(null);
            filePanel = new JPanel();
            filePanel.setLayout(new BorderLayout());
            filePanel.add(filePathLabel, BorderLayout.CENTER);
            filePanel.add(getFileButton(), BorderLayout.EAST);
        }
        return filePanel;
    }

    /**
     * This method initializes fileButton	
     * 	
     * @return javax.swing.JButton	
     */
    private JButton getFileButton() {
        if (fileButton == null) {
            fileButton = new JButton();
            fileButton.setText("File");
            fileButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    FileDialog fileDialog = new FileDialog(CsvCreateDialog.this, "Select CSV file", FileDialog.SAVE);
                    fileDialog.setFile(null);
                    fileDialog.setVisible(true);
                    filePathLabel.setText(fileDialog.getFile() == null ? null : fileDialog.getDirectory() + fileDialog.getFile());
                    fileDialog.dispose();
                }
            });
        }
        return fileButton;
    }

    /**
     * This method initializes inputPanel	
     * 	
     * @return javax.swing.JPanel	
     */
    private JPanel getInputPanel() {
        if (inputPanel == null) {
            GridBagConstraints gridBagConstraints31 = new GridBagConstraints();
            gridBagConstraints31.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints31.gridx = 1;
            gridBagConstraints31.gridy = 5;
            GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
            gridBagConstraints9.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints9.gridy = 0;
            gridBagConstraints9.gridx = 1;
            GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
            gridBagConstraints8.gridy = 0;
            gridBagConstraints8.gridx = 0;
            GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
            gridBagConstraints7.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints7.gridy = 4;
            gridBagConstraints7.weightx = 1.0;
            gridBagConstraints7.gridx = 1;
            GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
            gridBagConstraints6.gridx = 0;
            gridBagConstraints6.gridy = 4;
            GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
            gridBagConstraints5.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints5.gridy = 3;
            gridBagConstraints5.weightx = 1.0;
            gridBagConstraints5.gridx = 1;
            GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
            gridBagConstraints4.gridx = 0;
            gridBagConstraints4.gridy = 3;
            GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
            gridBagConstraints3.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints3.gridy = 2;
            gridBagConstraints3.weightx = 1.0;
            gridBagConstraints3.gridx = 1;
            GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
            gridBagConstraints2.gridx = 0;
            gridBagConstraints2.gridy = 2;
            GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
            gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints1.gridy = 1;
            gridBagConstraints1.weightx = 1.0;
            gridBagConstraints1.gridx = 1;
            GridBagConstraints gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridwidth = 1;
            gridBagConstraints.gridy = 1;
            fileLabel = new JLabel();
            fileLabel.setText("file:");
            passLabel = new JLabel();
            passLabel.setText("pass:");
            userLabel = new JLabel();
            userLabel.setText("user:");
            hostLabel = new JLabel();
            hostLabel.setText("host:");
            inputPanel = new JPanel();
            inputPanel.setLayout(new GridBagLayout());
            inputPanel.add(hostLabel, gridBagConstraints);
            inputPanel.add(getHostField(), gridBagConstraints1);
            inputPanel.add(userLabel, gridBagConstraints2);
            inputPanel.add(getUserField(), gridBagConstraints3);
            inputPanel.add(passLabel, gridBagConstraints4);
            inputPanel.add(getPassField(), gridBagConstraints5);
            inputPanel.add(getDbnameLabel(), gridBagConstraints6);
            inputPanel.add(getDbnameField(), gridBagConstraints7);
            inputPanel.add(fileLabel, gridBagConstraints8);
            inputPanel.add(getFilePanel(), gridBagConstraints9);
            inputPanel.add(getButtonPanel(), gridBagConstraints31);
        }
        return inputPanel;
    }

    /**
     * This method initializes hostField	
     * 	
     * @return javax.swing.JTextField	
     */
    private JTextField getHostField() {
        if (hostField == null) {
            hostField = new JTextField();
        }
        return hostField;
    }

    /**
     * This method initializes userField	
     * 	
     * @return javax.swing.JTextField	
     */
    private JTextField getUserField() {
        if (userField == null) {
            userField = new JTextField();
        }
        return userField;
    }

    /**
     * This method initializes passField	
     * 	
     * @return javax.swing.JPasswordField
     */
    private JPasswordField getPassField() {
        if (passField == null) {
            passField = new JPasswordField();
        }
        return passField;
    }

    /**
     * This method initializes dbnameLabel	
     * 	
     * @return javax.swing.JLabel	
     */
    private JLabel getDbnameLabel() {
        if (dbnameLabel == null) {
            dbnameLabel = new JLabel();
            dbnameLabel.setText("dbname:");
        }
        return dbnameLabel;
    }

    /**
     * This method initializes dbnameField	
     * 	
     * @return javax.swing.JTextField	
     */
    private JTextField getDbnameField() {
        if (dbnameField == null) {
            dbnameField = new JTextField();
        }
        return dbnameField;
    }

    /**
     * This method initializes buttonPanel	
     * 	
     * @return javax.swing.JPanel	
     */
    private JPanel getButtonPanel() {
        if (buttonPanel == null) {
            GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
            gridBagConstraints10.gridx = 1;
            gridBagConstraints10.gridy = 0;
            buttonPanel = new JPanel();
            buttonPanel.setLayout(new GridBagLayout());
            buttonPanel.add(getCancelButton(), new GridBagConstraints());
            buttonPanel.add(getLoadButton(), gridBagConstraints10);
        }
        return buttonPanel;
    }

    /**
     * This method initializes cancelButton	
     * 	
     * @return javax.swing.JButton	
     */
    private JButton getCancelButton() {
        if (cancelButton == null) {
            cancelButton = new JButton();
            cancelButton.setText("Cancel");
            cancelButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    CsvCreateDialog.this.setVisible(false);
                }
            });
        }
        return cancelButton;
    }

    /**
     * This method initializes loadButton	
     * 	
     * @return javax.swing.JButton	
     */
    private JButton getLoadButton() {
        if (loadButton == null) {
            loadButton = new JButton();
            loadButton.setText("Load");
            loadButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    SchemaCsvReaderMssqlImpl reader = new SchemaCsvReaderMssqlImpl();
                    reader.setHost(hostField.getText());
                    reader.setUser(userField.getText());
                    reader.setPass(new String(passField.getPassword()));
                    reader.setDbname(dbnameField.getText());
                    try {
                        List<SchemaCsv> data = reader.read();
                        SchemaCsvWriter writer = new SchemaCsvWriter(filePathLabel.getText());
                        writer.write(data);
                        filePath = filePathLabel.getText();
                        setVisible(false);
                    } catch (RuntimeException ex) {
                        JOptionPane.showMessageDialog(CsvCreateDialog.this, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
        }
        return loadButton;
    }

    public String getFilePath() {
        return filePath;
    }
}  //  @jve:decl-index=0:visual-constraint="10,10"
