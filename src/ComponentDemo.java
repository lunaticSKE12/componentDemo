import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;


public class ComponentDemo extends JFrame{
	private JFrame frame;
	// attributes for components
	private JButton button;
	private JLabel counter, label, name;
	private JTextField message;
	private int count = 0;
	
	public ComponentDemo(){
		super("Demo");
		frame = this;
		
		initComponent();
	}

	private void initComponent() {
		JPanel panel = new JPanel();
		button = new JButton("Press Me");
		ButtonListener listener = new ButtonListener();
		button.addActionListener(listener);
		counter = new JLabel("0");
		message = new JTextField("Make my day.");
		message.setHorizontalAlignment(SwingConstants.CENTER);
		message.setToolTipText("");
		label = new JLabel("Click count: ");
		label.setForeground(Color.MAGENTA);
		name = new JLabel("Deluxe Click Counter");
		name.setHorizontalAlignment(SwingConstants.CENTER);
		button.setForeground(Color.RED);
		button.setBackground(Color.YELLOW);
		message.setBackground(Color.CYAN);
		message.setForeground(Color.BLUE);
		counter.setForeground(Color.GREEN);
		message.setEditable(false);
		
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED));
		panel.add(label);
		panel.add(counter);
		panel.add(button);
		
		LayoutManager layout = new GridLayout(2, 3);
		//LayoutManager layout = new FlowLayout();
		frame.setLayout(layout);
		frame.add(new JLabel("Express Yourself"));
		frame.add(new JTextField(10));
		frame.getContentPane().add(message, BorderLayout.SOUTH);
		frame.getContentPane().add(name, BorderLayout.NORTH);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.pack();

		
	}
	
	public void run(){
		this.setVisible(true);
	}
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			System.out.println("Ouch! Don't press so hard");
			count++;
			counter.setText(String.valueOf(count));
			message.setText("Ouch again!");
		}
		
	}
	
	public static void main(String[] args){
		ComponentDemo demo = new ComponentDemo();
		demo.run();
		System.out.println("Done launching window. Do you see it?");
	}

}
