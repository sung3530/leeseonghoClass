import java.util.Vector;

public interface subject {
	Vector ButtonObserverList=new Vector();

	public void observerAdd(Observer a);
	public void observerDelete(Observer a);
	public void observerFalseEnable();
	public void observerTrueEnable();
}
