
public class ButtonSubject implements subject{

	@Override
	public void observerAdd(Observer a) {
		// TODO Auto-generated method stub
		ButtonObserverList.add(a);
	}

	@Override
	public void observerDelete(Observer a) {
		// TODO Auto-generated method stub
		ButtonObserverList.remove(a);
	}

	@Override
	public void observerFalseEnable() {
		// TODO Auto-generated method stub
		for (int i = 0; i < ButtonObserverList.size(); i++) {
			Observer temp=(Observer)ButtonObserverList.elementAt(i);
			temp.flaseEndable();
		}
	}

	@Override
	public void observerTrueEnable() {
		// TODO Auto-generated method stub
		for (int i = 0; i < ButtonObserverList.size(); i++) {
			Observer temp=(Observer)ButtonObserverList.elementAt(i);
			temp.trueEnable();
		}
	}

}
