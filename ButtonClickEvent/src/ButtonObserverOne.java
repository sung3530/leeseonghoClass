import javax.swing.JButton;

public class ButtonObserverOne extends JButton implements Observer{
	public void flaseEndable(){
		this.setEnabled(false);
	}

	@Override
	public void trueEnable() {
		// TODO Auto-generated method stub
		this.setEnabled(true);
	}
}
