import java.util.ArrayList;

public class WebSubscriber implements Subscriber {
    protected ArrayList<WebSubject> subjects = null;
    int[][] photo = null;
    String text = null;
    int[][] audio = null;

    public WebSubscriber(WebSubject newSubject)
    {
        subjects = new ArrayList<WebSubject>();
        newSubject.addSubscriber(this);
        subjects.add(newSubject);
    }

    public WebSubscriber(ArrayList<WebSubject> newSubjects) {
        subjects = newSubjects;

        for(int i = 0; i < subjects.size(); i++)
            subjects.get(i).addSubscriber(this);
    }

    public void update(int[][] newPhoto, String newText, int[][] audio)
    {
        return;
    }

    public void subscribeNewContent(WebSubject newContent)
    {
        newContent.addSubscriber(this);
        subjects.add(newContent);
    }

    public void unSubscribeContent(WebSubject Content)
    {
        Content.deleteSubscriber(this);
        subjects.remove(Content);
    }

}
