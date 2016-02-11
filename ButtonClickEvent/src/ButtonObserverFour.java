import javax.swing.JButton;

public class ButtonObserverFour extends JButton implements Observer {

	@Override
	public void flaseEndable() {
		// TODO Auto-generated method stub
		this.setEnabled(false);
	}

	@Override
	public void trueEnable() {
		// TODO Auto-generated method stub
		this.setEnabled(true);
	}

}
