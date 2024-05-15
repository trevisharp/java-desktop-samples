import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class AddTask extends JFrame {
    
    private JPanel pnAdd;
    private JButton btAdd;
    private JTextArea taTask;
    private JLabel lbTask;
    private JPanel pnMain;

    public AddTask(TaskFrame taskFrame) {
        this.lbTask = new JLabel();
        this.lbTask.setText("Digite a tarefa:");

        this.taTask = new JTextArea();
        
        this.btAdd = new JButton();
        this.btAdd.setText("Adicionar");
        this.btAdd.addActionListener(e -> {
            taskFrame.add(this.taTask.getText());
        });

        this.pnAdd = new JPanel();
        this.pnAdd.setLayout(
            new FlowLayout(FlowLayout.CENTER, 5, 5)
        );
        this.pnAdd.add(btAdd);

        this.pnMain = new JPanel();
        this.pnMain.setLayout(
            new BoxLayout(pnMain, BoxLayout.Y_AXIS)
        );
        this.pnMain.add(this.lbTask);
        this.pnMain.add(this.taTask);
        this.pnMain.add(this.pnAdd);

        add(this.pnMain);
        pack();
    }
}
