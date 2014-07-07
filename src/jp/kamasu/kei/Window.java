package jp.kamasu.kei;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Window extends JFrame implements MouseListener {

	JPanel panel = new JPanel();

	JButton btn = new JButton("reflect");
	JButton add = new JButton("+");

	JLabel l[] = new JLabel[Matrix.getSize()];

	JTextField x = new JTextField("");
	JTextField y = new JTextField("");

	boolean isFirst = true;

	Window() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(240, 300);
		setLocationRelativeTo(null);
		setLayout(null);

		panel = (JPanel) this.getContentPane();
		panel.setBounds(0, 0, 240, 300);
		panel.setBackground(Color.WHITE);

		// debug
		System.out.println("" + Matrix.getSize() + " , "
				+ Matrix.getLineSize(1) + ".");

		setButton();

		setVisible(true);

		showData();

	}

	public void showData() {
		String str = "";

		if (isFirst) {
			for (int i = 0; i < Matrix.getSize(); i++) {
				l[i] = new JLabel(str);
				l[i].setBounds(30, 15 * (i + 1), 270, 30);
				panel.add(l[i]);
			}

			isFirst = false;
		}

		for (int i = 0; i < Matrix.getSize(); i++) {
			for (int j = 0; j < Matrix.getLineSize(i); j++) {
				str += String.valueOf(Matrix.getSeq(i, j));
				str += "  ";
			}
			System.out.println(str);
			l[i].setText(str);
			str = "";
		}

		panel.revalidate();
		validate();
	}

	public void setButton() {

		btn.setBounds(10, 240, 100, 20);
		btn.addMouseListener(this);

		add.setBounds(180, 240, 50, 20);
		add.addMouseListener(this);

		x.setBounds(120, 240, 20, 20);
		y.setBounds(150, 240, 20, 20);

		panel.add(x);
		panel.add(y);
		panel.add(btn);
		panel.add(add);

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		int x0,y0;
		
		if (arg0.getSource() == btn) {
			System.out.println("click event");
			Matrix.retrans();
			showData();
		} else if (arg0.getSource() == add) {
			
			if(x.getText() == "" || y.getText() == ""){
				x0 = -1;
				y0 = -1;
			}
			else {
				x0 = Integer.parseInt(x.getText());
				y0 = Integer.parseInt(y.getText());
			}
			
			if(x0 >= 0 && y0 >= 0 && x0 < Matrix.getLineSize(0) && y0 < Matrix.getLineSize(0) )
				Matrix.changeSeq(x0, y0, 1);
			
			showData();
			x.setText("");
			y.setText("");
		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
