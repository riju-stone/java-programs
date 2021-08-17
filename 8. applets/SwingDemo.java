import javax.swing.*;

class SwingDemo {
    SwingDemo() {
        JFrame jfrm = new JFrame("Swing Demo");

        jfrm.setSize(600, 400);

        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel jlab = new JLabel("GUI");

        jfrm.add(jlab);

        jfrm.setVisible(true);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SwingDemo();
            }
        });
    }
}