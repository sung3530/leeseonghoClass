import javax.swing.JButton;

public class Factory {

	public JButton create(String name){
		switch (name) {
		case "1":
			ButtonObserverOne a=(ButtonObserverOne) new JButton(name);
			return a;
		case "2":
			ButtonObserverTwo b=(ButtonObserverTwo) new JButton(name);
			return b;
		case "3":
			ButtonObserverThree c=(ButtonObserverThree) new JButton(name);
			return c;
		case "4":
			ButtonObserverFour d=(ButtonObserverFour) new JButton(name);
			return d;
		case "All":
			ButtonObserverAll e=(ButtonObserverAll) new JButton(name);
			return e;
		case "All X":
			ButtonObserverAll_X f=(ButtonObserverAll_X) new JButton(name);
			return f;
		}
		return null;
	
	}
	
}
