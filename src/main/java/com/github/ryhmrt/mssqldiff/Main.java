package com.github.ryhmrt.mssqldiff;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeModel;

import com.github.ryhmrt.mssqldiff.convertor.TableListConvertor;
import com.github.ryhmrt.mssqldiff.csv.SchemaCsv;
import com.github.ryhmrt.mssqldiff.csv.SchemaCsvReaderFileImpl;
import com.github.ryhmrt.mssqldiff.data.Diff;
import com.github.ryhmrt.mssqldiff.data.Diff.Type;
import com.github.ryhmrt.mssqldiff.data.Table;
import com.github.ryhmrt.mssqldiff.data.TableDiff;
import com.github.ryhmrt.mssqldiff.differ.ListDiffer;
import com.github.ryhmrt.mssqldiff.differ.TableDiffer;
import com.github.ryhmrt.mssqldiff.gui.CsvFileSelector;
import com.github.ryhmrt.mssqldiff.util.SqlUtil;

public class Main {

    private JFrame jFrame = null;  //  @jve:decl-index=0:visual-constraint="10,10"
    private JPanel jContentPane = null;
    private JMenuBar jJMenuBar = null;
    private JMenu fileMenu = null;
    private JMenu helpMenu = null;
    private JMenuItem exitMenuItem = null;
    private JMenuItem aboutMenuItem = null;
    private JDialog aboutDialog = null;  //  @jve:decl-index=0:visual-constraint="520,10"
    private JPanel aboutContentPane = null;
    private JLabel aboutVersionLabel = null;
    private CsvFileSelector fromCsvFileSelector = null;
    private JPanel csvFilePanel = null;
    private CsvFileSelector toCsvFileSelector = null;
    private JPanel summaryPanel = null;
    private JButton diffButton = null;
    private JTree summaryTree = null;
    private JSplitPane resultPane = null;
    private JTextPane detailPane = null;
    private JLabel fromLabel = null;
    private JLabel toLabel = null;
    private JScrollPane summaryTreeScrollPane = null;
    private JScrollPane detailScrollPane = null;
    private JPanel diffExecutePanel = null;
    private JCheckBox ignorePermissionCheck = null;

    private List<TableDiff> tableDiffs = Collections.emptyList();  //  @jve:decl-index=0:

    /**
     * This method initializes jFrame
     * 
     * @return javax.swing.JFrame
     */
    private JFrame getJFrame() {
        if (jFrame == null) {
            jFrame = new JFrame();
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jFrame.setJMenuBar(getJJMenuBar());
            jFrame.setSize(500, 400);
            jFrame.setContentPane(getJContentPane());
            jFrame.setTitle("MSSQLDIFF");
        }
        return jFrame;
    }

    /**
     * This method initializes jContentPane
     * 
     * @return javax.swing.JPanel
     */
    private JPanel getJContentPane() {
        if (jContentPane == null) {
            jContentPane = new JPanel();
            jContentPane.setLayout(new BorderLayout());
            jContentPane.add(getCsvFilePanel(), BorderLayout.NORTH);
            jContentPane.add(getResultPane(), BorderLayout.CENTER);
        }
        return jContentPane;
    }

    /**
     * This method initializes jJMenuBar	
     * 	
     * @return javax.swing.JMenuBar	
     */
    private JMenuBar getJJMenuBar() {
        if (jJMenuBar == null) {
            jJMenuBar = new JMenuBar();
            jJMenuBar.add(getFileMenu());
            jJMenuBar.add(getHelpMenu());
        }
        return jJMenuBar;
    }

    /**
     * This method initializes jMenu	
     * 	
     * @return javax.swing.JMenu	
     */
    private JMenu getFileMenu() {
        if (fileMenu == null) {
            fileMenu = new JMenu();
            fileMenu.setText("File");
            fileMenu.add(getExitMenuItem());
        }
        return fileMenu;
    }

    /**
     * This method initializes jMenu	
     * 	
     * @return javax.swing.JMenu	
     */
    private JMenu getHelpMenu() {
        if (helpMenu == null) {
            helpMenu = new JMenu();
            helpMenu.setText("Help");
            helpMenu.add(getAboutMenuItem());
        }
        return helpMenu;
    }

    /**
     * This method initializes jMenuItem	
     * 	
     * @return javax.swing.JMenuItem	
     */
    private JMenuItem getExitMenuItem() {
        if (exitMenuItem == null) {
            exitMenuItem = new JMenuItem();
            exitMenuItem.setText("Exit");
            exitMenuItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
        }
        return exitMenuItem;
    }

    /**
     * This method initializes jMenuItem	
     * 	
     * @return javax.swing.JMenuItem	
     */
    private JMenuItem getAboutMenuItem() {
        if (aboutMenuItem == null) {
            aboutMenuItem = new JMenuItem();
            aboutMenuItem.setText("About");
            aboutMenuItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JDialog aboutDialog = getAboutDialog();
                    aboutDialog.pack();
                    Point loc = getJFrame().getLocation();
                    loc.translate(20, 20);
                    aboutDialog.setLocation(loc);
                    aboutDialog.setVisible(true);
                }
            });
        }
        return aboutMenuItem;
    }

    /**
     * This method initializes aboutDialog	
     * 	
     * @return javax.swing.JDialog
     */
    private JDialog getAboutDialog() {
        if (aboutDialog == null) {
            aboutDialog = new JDialog(getJFrame(), true);
            aboutDialog.setTitle("About");
            aboutDialog.setSize(new Dimension(180, 38));
            aboutDialog.setContentPane(getAboutContentPane());
        }
        return aboutDialog;
    }

    /**
     * This method initializes aboutContentPane
     * 
     * @return javax.swing.JPanel
     */
    private JPanel getAboutContentPane() {
        if (aboutContentPane == null) {
            aboutContentPane = new JPanel();
            aboutContentPane.setLayout(new BorderLayout());
            aboutContentPane.add(getAboutVersionLabel(), BorderLayout.CENTER);
        }
        return aboutContentPane;
    }

    /**
     * This method initializes aboutVersionLabel	
     * 	
     * @return javax.swing.JLabel	
     */
    private JLabel getAboutVersionLabel() {
        if (aboutVersionLabel == null) {
            aboutVersionLabel = new JLabel();
            aboutVersionLabel.setText("Version 0.0 SNAPSHOT");
            aboutVersionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        }
        return aboutVersionLabel;
    }

    /**
     * This method initializes fromCsvFileSelector	
     * 	
     * @return com.github.ryhmrt.mssqldiff.gui.CsvFileSelector	
     */
    private CsvFileSelector getFromCsvFileSelector() {
        if (fromCsvFileSelector == null) {
            fromCsvFileSelector = new CsvFileSelector(jFrame);
        }
        return fromCsvFileSelector;
    }

    /**
     * This method initializes csvFilePanel	
     * 	
     * @return javax.swing.JPanel	
     */
    private JPanel getCsvFilePanel() {
        if (csvFilePanel == null) {
            GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
            gridBagConstraints5.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints5.weightx = 1.0;
            gridBagConstraints5.gridx = 1;
            gridBagConstraints5.gridy = 1;
            GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
            gridBagConstraints4.gridx = 0;
            gridBagConstraints4.gridy = 1;
            GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
            gridBagConstraints3.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints3.weightx = 1.0;
            gridBagConstraints3.gridx = 1;
            gridBagConstraints3.gridy = 0;
            GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
            gridBagConstraints2.gridx = 0;
            gridBagConstraints2.gridy = 0;
            fromLabel = new JLabel();
            fromLabel.setText("from:");
            toLabel = new JLabel();
            toLabel.setText("to:");
            csvFilePanel = new JPanel();
            csvFilePanel.setLayout(new GridBagLayout());
            csvFilePanel.add(fromLabel, gridBagConstraints2);
            csvFilePanel.add(getFromCsvFileSelector(), gridBagConstraints3);
            csvFilePanel.add(toLabel, gridBagConstraints4);
            csvFilePanel.add(getToCsvFileSelector(), gridBagConstraints5);
        }
        return csvFilePanel;
    }

    /**
     * This method initializes toCsvFileSelector	
     * 	
     * @return com.github.ryhmrt.mssqldiff.gui.CsvFileSelector	
     */
    private CsvFileSelector getToCsvFileSelector() {
        if (toCsvFileSelector == null) {
            toCsvFileSelector = new CsvFileSelector(jFrame);
        }
        return toCsvFileSelector;
    }

    /**
     * This method initializes summaryPanel	
     * 	
     * @return javax.swing.JPanel	
     */
    private JPanel getSummaryPanel() {
        if (summaryPanel == null) {
            summaryPanel = new JPanel();
            summaryPanel.setLayout(new BorderLayout());
            summaryPanel.setMinimumSize(new Dimension(150, 100));
            summaryPanel.add(getSummaryTreeScrollPane(), BorderLayout.CENTER);
            summaryPanel.add(getDiffExecutePanel(), BorderLayout.NORTH);
        }
        return summaryPanel;
    }

    /**
     * This method initializes diffButton	
     * 	
     * @return javax.swing.JButton	
     */
    private JButton getDiffButton() {
        if (diffButton == null) {
            diffButton = new JButton();
            diffButton.setText("Diff");
            diffButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    diff();
                }
            });
        }
        return diffButton;
    }

    /**
     * This method initializes summaryTree	
     * 	
     * @return javax.swing.JTree	
     */
    private JTree getSummaryTree() {
        if (summaryTree == null) {
            summaryTree = new JTree(new Object[0]);
            summaryTree.addTreeSelectionListener(new TreeSelectionListener() {
                @Override
                public void valueChanged(TreeSelectionEvent e) {
                    detailPane.setText(SqlUtil.WARNING + getSql(e.getPath().getLastPathComponent()));
                }
            });
        }
        return summaryTree;
    }

    private String getSql(Object current) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)current;
        if (node.getUserObject() instanceof TableDiff) {
            return ((TableDiff)node.getUserObject()).toSqlWithoutPermissions();
        } else if (node.getUserObject() instanceof Diff) {
            return ((Diff<?>)node.getUserObject()).toSql();
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < node.getChildCount(); i++) {
                sb.append(getSql(node.getChildAt(i)));
                sb.append("\n");
            }
            return sb.toString();
        }
    }

    /**
     * This method initializes resultPane	
     * 	
     * @return javax.swing.JSplitPane	
     */
    private JSplitPane getResultPane() {
        if (resultPane == null) {
            resultPane = new JSplitPane();
            resultPane.setLeftComponent(getSummaryPanel());
            resultPane.setRightComponent(getDetailScrollPane());
        }
        return resultPane;
    }

    /**
     * This method initializes detailPane	
     * 	
     * @return javax.swing.JTextPane	
     */
    private JTextPane getDetailPane() {
        if (detailPane == null) {
            detailPane = new JTextPane();
            detailPane.setFont(new Font("Monospaced", Font.PLAIN, 14));
        }
        return detailPane;
    }

    private void diff() {
        try {
            List<Table> fromTables = loadTables(fromCsvFileSelector.getFilePath());
            List<Table> toTables = loadTables(toCsvFileSelector.getFilePath());
            ListDiffer<Table, TableDiff, TableDiffer> differ = new ListDiffer<Table, TableDiff, TableDiffer>();
            tableDiffs = differ.diff(new TableDiffer(), fromTables, toTables);
            showDiffTree();
        } catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(jFrame, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showDiffTree() {
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("diff", true);
        for (TableDiff tableDiff : tableDiffs) {
            DefaultMutableTreeNode tableNode = new DefaultMutableTreeNode(tableDiff, true);
            if (!tableDiff.getColumnDiffs().isEmpty()) {
                if (ignorePermissionCheck.isSelected()) {
                    // 権限無視の場合は、テーブルの下に直接カラムを追加
                    for (Object data : tableDiff.getColumnDiffs()) {
                        tableNode.add(new DefaultMutableTreeNode(data, false));
                    }
                } else {
                    tableNode.add(createChildNodes("columns", tableDiff.getColumnDiffs()));
                }
            }
            if (ignorePermissionCheck.isSelected()) {
                // 権限無視の場合、権限のみの変更であればテーブルごとスキップ
                if (tableDiff.getType() == Type.MODIFIED && tableDiff.getColumnDiffs().isEmpty()) {
                    continue;
                }
            } else {
                if (!tableDiff.getPermissionDiffs().isEmpty()) {
                    tableNode.add(createChildNodes("permissions", tableDiff.getPermissionDiffs()));
                }
            }
            rootNode.add(tableNode);
        }
        TreeModel treeModel = new DefaultTreeModel(rootNode);
        summaryTree.setModel(treeModel);
    }

    private MutableTreeNode createChildNodes(String title, List<?> childDataList) {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(title, true);
        for (Object data : childDataList) {
            node.add(new DefaultMutableTreeNode(data, false));
        }
        return node;
    }

    private List<Table> loadTables(String filePath) {
        SchemaCsvReaderFileImpl reader = new SchemaCsvReaderFileImpl(filePath);
        List<SchemaCsv> src = reader.read();
        TableListConvertor conv = new TableListConvertor();
        return conv.convert(src);
    }
    /**
     * This method initializes summaryTreeScrollPane	
     * 	
     * @return javax.swing.JScrollPane	
     */
    private JScrollPane getSummaryTreeScrollPane() {
        if (summaryTreeScrollPane == null) {
            summaryTreeScrollPane = new JScrollPane();
            summaryTreeScrollPane.setViewportView(getSummaryTree());
        }
        return summaryTreeScrollPane;
    }

    /**
     * This method initializes detailScrollPane	
     * 	
     * @return javax.swing.JScrollPane	
     */
    private JScrollPane getDetailScrollPane() {
        if (detailScrollPane == null) {
            detailScrollPane = new JScrollPane();
            detailScrollPane.setViewportView(getDetailPane());
        }
        return detailScrollPane;
    }

    /**
     * This method initializes diffExecutePanel	
     * 	
     * @return javax.swing.JPanel	
     */
    private JPanel getDiffExecutePanel() {
        if (diffExecutePanel == null) {
            GridLayout gridLayout = new GridLayout();
            gridLayout.setRows(2);
            gridLayout.setColumns(1);
            diffExecutePanel = new JPanel();
            diffExecutePanel.setLayout(gridLayout);
            diffExecutePanel.add(getDiffButton(), null);
            diffExecutePanel.add(getIgnorePermissionCheck(), null);
        }
        return diffExecutePanel;
    }

    /**
     * This method initializes ignorePermissionCheck	
     * 	
     * @return javax.swing.JCheckBox	
     */
    private JCheckBox getIgnorePermissionCheck() {
        if (ignorePermissionCheck == null) {
            ignorePermissionCheck = new JCheckBox();
            ignorePermissionCheck.setText("Ignore permissions");
            ignorePermissionCheck.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    showDiffTree();
                }
            });
        }
        return ignorePermissionCheck;
    }

    /**
     * Launches this application
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Main application = new Main();
                application.getJFrame().setVisible(true);
            }
        });
    }

}
