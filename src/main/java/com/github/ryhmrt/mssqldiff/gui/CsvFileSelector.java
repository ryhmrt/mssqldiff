package com.github.ryhmrt.mssqldiff.gui;

import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CsvFileSelector extends JPanel {

    private static final long serialVersionUID = 1L;
    private JButton csvSelectButton = null;
    private JButton csvCreateButton = null;
    private JLabel filePathLabel = null;
    private JPanel buttonPanel = null;
    private JFrame parentFrame = null;

    /**
     * This is the default constructor
     */
    public CsvFileSelector(JFrame parentFrame) {
        super();
        this.parentFrame = parentFrame;
        initialize();
    }

    /**
     * This method initializes this
     * 
     * @return void
     */
    private void initialize() {
        filePathLabel = new JLabel();
        filePathLabel.setText(null);
        this.setSize(343, 35);
        this.setLayout(new BorderLayout());
        this.add(filePathLabel, BorderLayout.CENTER);
        this.add(getButtonPanel(), BorderLayout.EAST);
    }

    /**
     * This method initializes fileSelectButton	
     * 	
     * @return javax.swing.JButton	
     */
    private JButton getCsvSelectButton() {
        if (csvSelectButton == null) {
            csvSelectButton = new JButton();
            csvSelectButton.setText("File");
            csvSelectButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    FileDialog fileDialog = new FileDialog(parentFrame, "Select CSV file", FileDialog.LOAD);
                    fileDialog.setFile(null);
                    fileDialog.setVisible(true);
                    filePathLabel.setText(fileDialog.getFile() == null ? null : fileDialog.getDirectory() + fileDialog.getFile());
                    fileDialog.dispose();
                }
            });
        }
        return csvSelectButton;
    }

    /**
     * This method initializes csvCreateButton	
     * 	
     * @return javax.swing.JButton	
     */
    private JButton getCsvCreateButton() {
        if (csvCreateButton == null) {
            csvCreateButton = new JButton();
            csvCreateButton.setText("BD");
            csvCreateButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    CsvCreateDialog dialog = new CsvCreateDialog(parentFrame);
                    dialog.setVisible(true);
                    if (dialog.getFilePath() != null) {
                        filePathLabel.setText(dialog.getFilePath());
                    }
                }
            });
        }
        return csvCreateButton;
    }

    /**
     * This method initializes buttonPanel	
     * 	
     * @return javax.swing.JPanel	
     */
    private JPanel getButtonPanel() {
        if (buttonPanel == null) {
            GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
            gridBagConstraints1.gridx = -1;
            gridBagConstraints1.gridy = -1;
            GridBagConstraints gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = -1;
            gridBagConstraints.gridy = -1;
            buttonPanel = new JPanel();
            buttonPanel.setLayout(new GridBagLayout());
            buttonPanel.add(getCsvSelectButton(), gridBagConstraints);
            buttonPanel.add(getCsvCreateButton(), gridBagConstraints1);
        }
        return buttonPanel;
    }

    public String getFilePath() {
        return filePathLabel.getText();
    }

}  //  @jve:decl-index=0:visual-constraint="10,10"
