package services;

import java.util.ArrayList;
import model.Feedback;

public class FeedbackService {

    private static FeedbackService instance;
    private ArrayList<Feedback> feedbackList;

    private FeedbackService() {
        feedbackList = new ArrayList<>();
    }

    public static FeedbackService getInstance() {
        if (instance == null) {
            instance = new FeedbackService();
        }
        return instance;
    }

    public void addFeedback(Feedback f) {
        feedbackList.add(f);
    }

    // 🔥 ADD THIS
    public ArrayList<Feedback> getAllFeedback() {
        return feedbackList;
    }
}