package services;

import model.Feedback;
import java.util.ArrayList;

public class FeedbackService {

    private static FeedbackService instance;
    private ArrayList<Feedback<?>> feedbacks;

    private FeedbackService() {
        feedbacks = new ArrayList<>();
    }

    public static FeedbackService getInstance() {
        if (instance == null) {
            instance = new FeedbackService();
        }
        return instance;
    }

    public void addFeedback(Feedback<?> f) {
        feedbacks.add(f);
    }

    public void viewAllFeedback() {
        if (feedbacks.isEmpty()) {
            System.out.println("No feedback available.");
            return;
        }

        for (Feedback<?> f : feedbacks) {
            f.display();
        }
    }
}