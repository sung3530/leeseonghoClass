import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame implements ActionListener {
	private JPanel jp=new JPanel();
	private Factory factory=new Factory();	
	private ButtonSubject subject=new ButtonSubject();
	private ButtonObserverOne one;
	private ButtonObserverTwo two;
	private ButtonObserverThree three;
	private ButtonObserverFour four;
	private ButtonObserverAll all;
	private ButtonObserverAll_X all_x;
	public GUI(){
		
		generateButton();
		generatePanel();
	}

	private void generateButton(){
		one=(ButtonObserverOne)factory.create("1");
		subject.observerAdd(one);
		
		two=(ButtonObserverTwo)factory.create("2");
		subject.observerAdd(two);
		
		three=(ButtonObserverThree)factory.create("3");
		subject.observerAdd(three);
		
		four=(ButtonObserverFour)factory.create("4");
		subject.observerAdd(four);
		
		all=(ButtonObserverAll)factory.create("All");
		subject.observerAdd(all);
		
		all_x=(ButtonObserverAll_X)factory.create("All X");
		subject.observerAdd(all_x);
		
		jp.add(one);
		jp.add(two);
		jp.add(three);
		jp.add(four);
		jp.add(all);
		jp.add(all_x);
	}
	private void generatePanel(){
		add(jp);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(one)){
			one.flaseEndable();
			three.flaseEndable();
		}
		else if(e.getSource().equals(two)){
			two.flaseEndable();
			four.flaseEndable();
		}
		else if(e.getSource().equals(three)){
			three.flaseEndable();
			one.flaseEndable();
		}
		else if(e.getSource().equals(four)){
			four.flaseEndable();
			two.flaseEndable();
		}
		else if(e.getSource().equals(all)){
			subject.observerFalseEnable();
		}
		else if(e.getSource().equals(all_x)){
			subject.observerTrueEnable();	
			}
	}
}
