package it.unibo.mvc;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final static int TEXTLENGHT = 20;
    private final JFrame frame = new JFrame();
    private final Controller controller = new SimpleController();

    public SimpleGUI() {
        final JPanel canvas = new JPanel();
        final JTextField myTextField = new JTextField(TEXTLENGHT);
        canvas.setLayout(new BorderLayout());
        canvas.add(myTextField, BorderLayout.CENTER);
        final JButton print = new JButton("Print");
        final JButton history = new JButton("Show History");
        canvas.add(print, BorderLayout.WEST);
        canvas.add(history, BorderLayout.EAST);
        print.addActionListener(e -> {
            controller.setString(myTextField.getText());
            controller.printCurrentString();
            myTextField.setText("");
        });
        history.addActionListener(e -> {
            final List<String> s = controller.history();
            System.out.println(s);
        });

        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationByPlatform(true);
    }

    void display() {
        frame.setVisible(true);
    }

    public static void main(final String[] args) {
        final SimpleGUI gui = new SimpleGUI();
        gui.display();
    }
}
