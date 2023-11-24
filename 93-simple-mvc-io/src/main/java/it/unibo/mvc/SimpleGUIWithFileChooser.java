package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final int PROPORTION = 2;
    private final JFrame frame = new JFrame();
    private final Controller controller = new Controller();

    public SimpleGUIWithFileChooser() {
        final JTextArea textArea = new JTextArea();
        final JButton save = new JButton("Save");
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        canvas.add(textArea, BorderLayout.CENTER);
        canvas.add(save, BorderLayout.SOUTH);
        save.addActionListener(e -> controller.save(textArea.getText()));
        final JTextField textField = new JTextField();
        final JButton browse = new JButton("Browse...");
        final JPanel northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());
        northPanel.add(textField, BorderLayout.CENTER);
        northPanel.add(browse, BorderLayout.LINE_END);
        canvas.add(northPanel, BorderLayout.NORTH);
        textField.setEditable(false);
        textField.setText(controller.getFilePath());
        final JFileChooser fileChooser = new JFileChooser();
        browse.addActionListener(e -> {
            int value;
            value = fileChooser.showSaveDialog(fileChooser);
            if (value == JFileChooser.APPROVE_OPTION) {
                controller.setFile(fileChooser.getSelectedFile());
                textField.setText(controller.getFilePath());
            } else {}
            
            JOptionPane.showMessageDialog(frame, "ERRORE ORE OREEE", "ERRORE!!", JOptionPane.ERROR_MESSAGE);
        });

        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
    }

    public void display() {
        frame.setVisible(true);
    }

    public static void main(final String[] args) {
        final SimpleGUIWithFileChooser simple = new SimpleGUIWithFileChooser();
        simple.display();
    }

}
