import java.util.ArrayList;

import java.awt.FlowLayout;
import java.awt.Label;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TaskFrame extends JFrame {

    private ArrayList<String> tasks;
    private JScrollPane spTasks;
    private JList<String> lsTasks;
    private JButton btAddTask;
    private JPanel pnAddTask;
    private JPanel pnMain;

    public TaskFrame()
    {
        this.tasks = new ArrayList<>();

        this.lsTasks = new JList<>();

        this.spTasks = new JScrollPane();
        this.spTasks.add(lsTasks);

        this.btAddTask = new JButton();
        this.btAddTask.setText("Adicionar Tarefa");
        this.btAddTask.addActionListener(e -> {
            AddTask addTask = new AddTask(this);
            addTask.setVisible(true);
        });

        this.pnAddTask = new JPanel();
        this.pnAddTask.setLayout(
            new FlowLayout(FlowLayout.CENTER, 5, 5)
        );
        this.pnAddTask.add(btAddTask);

        this.pnMain = new JPanel();
        this.pnMain.setLayout(
            new BoxLayout(this.pnMain, BoxLayout.Y_AXIS)
        );
        this.pnMain.add(this.spTasks);
        this.pnMain.add(this.pnAddTask);

        add(this.pnMain);
        pack();
    }

    void add(String task) {
        this.tasks.add(task);
        this.lsTasks = new JList<>(
            this.tasks.toArray(new String[0])
        );
        this.spTasks.setViewportView(this.lsTasks);
        repaint();
    }
}