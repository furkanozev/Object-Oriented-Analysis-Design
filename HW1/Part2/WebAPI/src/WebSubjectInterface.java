public interface WebSubjectInterface {
    public void addSubscriber(Subscriber sub);
    public void deleteSubscriber(Subscriber sub);
    public void notifySubscriber();
}
