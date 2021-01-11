import java.util.ArrayList;

public abstract class WebSubject implements WebSubjectInterface{
    protected ArrayList<Subscriber> subscribers;

    public void addSubscriber(Subscriber sub){
        return;
    }

    public void deleteSubscriber(Subscriber sub)
    {
        return;
    }

    public void notifySubscriber()
    {
        return;
    }

    public ArrayList<Subscriber> getSubscribers()
    {
        return subscribers;
    }
}
